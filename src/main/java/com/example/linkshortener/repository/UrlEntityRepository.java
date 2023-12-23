package com.example.linkshortener.repository;

import com.example.linkshortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlEntityRepository extends JpaRepository<UrlEntity, String> {
    Optional<UrlEntity> findByUrl(String url);

    boolean existsByUrl(String url);
}
