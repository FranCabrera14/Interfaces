package ceu.dam.examen.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicadosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5267962279176857411L;

	public DuplicadosException() {
	}

	public DuplicadosException(String message) {
		super(message);
	}

	public DuplicadosException(Throwable cause) {
		super(cause);
	}

	public DuplicadosException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicadosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
