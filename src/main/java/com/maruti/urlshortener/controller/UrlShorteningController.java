package com.maruti.urlshortener.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maruti.urlshortener.dto.UrlDto;
import com.maruti.urlshortener.exception.AppException;
import com.maruti.urlshortener.model.Url;
import com.maruti.urlshortener.service.UrlShorteningService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UrlShorteningController {

	@Autowired
	private UrlShorteningService urlShorteningService;

	@PostMapping("/generate")
	public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto) throws AppException {
		return new ResponseEntity<Url>(urlShorteningService.generateShortLink(urlDto), HttpStatus.OK);
	}

	@GetMapping("/{redirect}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable("redirect") String shortLink, HttpServletResponse response)
			throws IOException, AppException {
		Url encodedUrl = urlShorteningService.getEncodedUrl(shortLink);
		response.sendRedirect(encodedUrl.getOriginalUrl());
		return null;

	}
}
