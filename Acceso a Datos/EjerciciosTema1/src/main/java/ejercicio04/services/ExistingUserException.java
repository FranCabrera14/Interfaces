package ejercicio04.services;

public class ExistingUserException extends Exception {

	private static final long serialVersionUID = 1401851832809260877L;

	public ExistingUserException() {
	}

	public ExistingUserException(String message) {
		super(message);

	}

	public ExistingUserException(Throwable cause) {
		super(cause);

	}

	public ExistingUserException(String message, Throwable cause) {
		super(message, cause);

	}

	public ExistingUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
