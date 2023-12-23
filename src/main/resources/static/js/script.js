let origin = window.location.host;

$(document).ready(function () {
    $("#shorten-btn").click(async function() {
        let originalUrl = $("#original-url").val();

        $("#original-url").val('');

        if(originalUrl == '') return;

        await shortenUrl(originalUrl);
    })

    $("#result-copy-button").click(function() {
        navigator.clipboard.writeText($("#result-url").text());
    })
})

async function shortenUrl(full_url) {
    let response = await fetch("/v1/shorten-url", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(
            {
                url: full_url
            }
        )
    });

    if(response.status == 400) {
        showError('not valid url');
        return;
    }

    if(response.status != 200) {
        showError('server error');
        return;
    }

    let json = await response.json();

    showResult(origin + "/" + json.path);
}

function showResult(message) {
    $("#result-url").addClass("green").removeClass("red").css("visibility", "visible").text(message);

    $("#result-copy-button").css("visibility", "visible");
}

function showError(message) {
    $("#result-url").addClass("red").removeClass("green").css("visibility", "visible").text(message);

    $("#result-copy-button").css("visibility", "hidden");
}