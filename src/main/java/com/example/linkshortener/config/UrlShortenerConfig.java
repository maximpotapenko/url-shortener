package com.example.linkshortener.config;

import com.example.linkshortener.util.RandomStringGenerator;
import com.example.linkshortener.util.StringGenerator;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlShortenerConfig {
    @Bean
    public UrlValidator urlValidator() {
        String[] schemes = {"http","https"};
        return new UrlValidator(schemes);
    }

    @Bean
    public StringGenerator stringGenerator() {
        return new RandomStringGenerator();
    }
}
