package com.maruti.urlshortener.dto;

import lombok.Data;

@Data
public class UrlErrorResponseDto {
	private String status;
    private String error;
}
