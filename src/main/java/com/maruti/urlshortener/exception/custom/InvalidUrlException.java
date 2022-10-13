package com.maruti.urlshortener.exception.custom;

import com.maruti.urlshortener.exception.ServiceException;

public class InvalidUrlException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUrlException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidUrlException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidUrlException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidUrlException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
