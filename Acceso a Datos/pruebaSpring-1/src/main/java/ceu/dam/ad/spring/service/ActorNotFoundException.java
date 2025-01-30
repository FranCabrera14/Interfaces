package ceu.dam.ad.spring.service;

public class ActorNotFoundException extends Exception {

	private static final long serialVersionUID = -8734741102483013430L;

	public ActorNotFoundException() {
	}

	public ActorNotFoundException(String message) {
		super(message);

	}

	public ActorNotFoundException(Throwable cause) {
		super(cause);

	}

	public ActorNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public ActorNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
