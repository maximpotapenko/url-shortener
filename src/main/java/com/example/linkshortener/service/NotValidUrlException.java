package com.example.linkshortener.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotValidUrlException extends RuntimeException {
    public NotValidUrlException(String message) {
        super(message);
    }
}
