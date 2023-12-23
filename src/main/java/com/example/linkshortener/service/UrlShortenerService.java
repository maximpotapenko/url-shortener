package com.example.linkshortener.service;

import com.example.linkshortener.dto.UrlDto;
import com.example.linkshortener.dto.PathDto;

public interface UrlShortenerService {
    PathDto shorten(UrlDto dto);

    String findUrl(String path);
}
