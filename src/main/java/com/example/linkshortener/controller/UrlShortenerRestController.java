package com.example.linkshortener.controller;

import com.example.linkshortener.dto.UrlDto;
import com.example.linkshortener.dto.PathDto;
import com.example.linkshortener.service.UrlShortenerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UrlShortenerRestController {
    private final UrlShortenerService urlShortenerService;

    @PostMapping("/v1/shorten-url")
    public PathDto shorten(@RequestBody UrlDto dto) {
        return urlShortenerService.shorten(dto);
    }
}
