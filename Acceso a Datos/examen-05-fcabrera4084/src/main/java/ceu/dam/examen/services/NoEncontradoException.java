package ceu.dam.examen.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7675445216103933601L;

	public NoEncontradoException() {
	}

	public NoEncontradoException(String message) {
		super(message);
	}

	public NoEncontradoException(Throwable cause) {
		super(cause);
	}

	public NoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
