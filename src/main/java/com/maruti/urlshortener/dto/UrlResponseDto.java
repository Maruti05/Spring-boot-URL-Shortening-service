package com.maruti.urlshortener.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class UrlResponseDto {
	     private String originalUrl;
	    private String shortLink;
	    private LocalDateTime expirationDate;
}
