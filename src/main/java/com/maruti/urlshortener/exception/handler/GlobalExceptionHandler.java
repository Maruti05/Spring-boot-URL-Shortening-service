package com.maruti.urlshortener.exception.handler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maruti.urlshortener.dto.ErrorDto;
import com.maruti.urlshortener.exception.AppException;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> handleException(AppException ex,HttpServletRequest req){
		ErrorDto error=new ErrorDto();
		error.setError(ex.getLocalizedMessage());
		error.setHttpStatus(HttpStatus.NOT_FOUND);
		error.setTime_stamp(LocalDateTime.now());
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setPath(req.getRequestURI());
		return new ResponseEntity<ErrorDto>(error,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
}
