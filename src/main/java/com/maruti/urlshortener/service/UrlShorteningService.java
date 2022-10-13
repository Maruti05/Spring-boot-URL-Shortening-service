package com.maruti.urlshortener.service;

import com.maruti.urlshortener.dto.UrlDto;
import com.maruti.urlshortener.exception.ServiceException;
import com.maruti.urlshortener.model.Url;

public interface UrlShorteningService {
	public Url generateShortLink(UrlDto urlDto) throws ServiceException;
    public Url saveShortLink(Url url);
    public Url getEncodedUrl(String url) throws ServiceException;
    public String  deleteShortLink(Url url);
}
