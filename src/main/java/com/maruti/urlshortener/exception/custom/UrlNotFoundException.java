package com.maruti.urlshortener.exception.custom;

import com.maruti.urlshortener.exception.ServiceException;

public class UrlNotFoundException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UrlNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public UrlNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UrlNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UrlNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UrlNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
