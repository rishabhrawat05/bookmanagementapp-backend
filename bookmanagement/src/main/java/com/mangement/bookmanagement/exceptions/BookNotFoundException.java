package com.mangement.bookmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6799274168223509568L;

	public BookNotFoundException(String message) {
		super(message);
	}
}
