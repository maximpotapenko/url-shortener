package com.example.linkshortener.controller;

import com.example.linkshortener.service.UrlShortenerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    @GetMapping
    public String index() {
        return "index.html";
    }

    @GetMapping("/{path}")
    public RedirectView redirect(@PathVariable(required = true) String path) {
        String url = urlShortenerService.findUrl(path);

        return new RedirectView(url);
    }
}
