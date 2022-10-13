package com.maruti.urlshortener.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maruti.urlshortener.model.Url;

@Repository
public interface UrlShorteningRepo extends JpaRepository<Url,Long>{
	 public Optional<Url> findByShortLink(String shortLink);
}
