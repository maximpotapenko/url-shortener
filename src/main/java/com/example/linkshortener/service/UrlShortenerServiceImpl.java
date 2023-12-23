package com.example.linkshortener.service;

import com.example.linkshortener.dto.UrlDto;
import com.example.linkshortener.dto.PathDto;
import com.example.linkshortener.entity.UrlEntity;
import com.example.linkshortener.repository.UrlEntityRepository;
import com.example.linkshortener.util.StringGenerator;
import lombok.AllArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlShortenerServiceImpl implements UrlShortenerService {
    private final UrlEntityRepository repository;

    private final UrlValidator urlValidator;

    private final StringGenerator generator;

    @Override
    public PathDto shorten(UrlDto dto) {
        if(!urlValidator.isValid(dto.getUrl()))
            throw new NotValidUrlException("URL is not valid");

        if(repository.existsByUrl(dto.getUrl())) {
            UrlEntity urlEntity = repository.findByUrl(dto.getUrl()).orElseThrow();

            return new PathDto(urlEntity.getId());
        }

        String id;

        do {
            id = generator.generate(9);
        } while(repository.existsById(id));

        UrlEntity urlEntity = UrlEntity.builder()
                .id(id)
                .url(dto.getUrl())
                .build();

        repository.saveAndFlush(urlEntity);

        return new PathDto(id);
    }

    @Override
    public String findUrl(String path) {
        return repository.findById(path)
                .orElseThrow()
                .getUrl();
    }
}
