package com.maruti.urlshortener.dto;

import lombok.Data;

@Data
public class UrlDto {
	private String url;
    private String expirationDate;
}
