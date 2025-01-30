package ceu.dam.ad.spring.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CocheNotFoundException extends Exception {

	private static final long serialVersionUID = -7493729181172093894L;

	public CocheNotFoundException() {
	}

	public CocheNotFoundException(String message) {
		super(message);

	}

	public CocheNotFoundException(Throwable cause) {
		super(cause);

	}

	public CocheNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CocheNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
