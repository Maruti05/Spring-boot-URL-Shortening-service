package com.maruti.urlshortener.service.impl;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.maruti.urlshortener.dto.UrlDto;
import com.maruti.urlshortener.exception.ServiceException;
import com.maruti.urlshortener.exception.custom.InvalidUrlException;
import com.maruti.urlshortener.exception.custom.ProcessingException;
import com.maruti.urlshortener.exception.custom.UrlNotFoundException;
import com.maruti.urlshortener.model.Url;
import com.maruti.urlshortener.repo.UrlShorteningRepo;
import com.maruti.urlshortener.service.UrlShorteningService;

@Service
public class UrlShorteningServiceImpl implements UrlShorteningService{
	
	@Autowired
	private UrlShorteningRepo urlShorteningRepo;

	@Override
	public Url generateShortLink(UrlDto urlDto) throws ServiceException {
		Url shortUrl=null;
	    if(StringUtils.isNotEmpty(urlDto.getUrl())){
	    	String encodedUrl=encodeUrl(urlDto.getUrl());
	    	Url url = new Url();
	    	url.setCreationDate(LocalDateTime.now());
	    	url.setOriginalUrl(urlDto.getUrl());
	    	url.setShortLink(encodedUrl);
	    	url.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(),url.getCreationDate()));
	    	shortUrl = saveShortLink(url);
	    	if(!Optional.of(shortUrl).isPresent()) {
	    		throw new ProcessingException("There was an error processing your request. please try again.");
	    	}
	    }
		return shortUrl;
	}

	private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
		if(StringUtils.isBlank(expirationDate)) {
			return creationDate.plusSeconds(60);
		}
		return LocalDateTime.parse(expirationDate);
	}

	private String encodeUrl(String url) {
		String encodedUrl="";
		 LocalDateTime time = LocalDateTime.now();
	        encodedUrl = Hashing.murmur3_128()
	                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
	                .toString();
		return encodedUrl;
	}

	@Override
	public Url saveShortLink(Url url) {
		return urlShorteningRepo.save(url);
	}

	@Override
	public Url getEncodedUrl(String url) throws ServiceException {
		if(StringUtils.isEmpty(url))
        {
		 throw new InvalidUrlException("Invalid Url");
        }
		Url urlToRet=urlShorteningRepo.findByShortLink(url).orElseThrow(()->new UrlNotFoundException("Url does not exist or it might have expired!"));
		if(urlToRet.getExpirationDate().isBefore(LocalDateTime.now()))
        {
			urlShorteningRepo.delete(urlToRet);
			throw new InvalidUrlException("Url Expired. Please try generating a fresh one.");
        }
		return urlToRet;
		
	}

	@Override
	public String deleteShortLink(Url url) {
		urlShorteningRepo.delete(url);
		return "Succssfully deleted "+url.getShortLink();
	}

}
