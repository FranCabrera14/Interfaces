package ejercicio04.services;

public class UserDoesntExistException extends Exception {

	private static final long serialVersionUID = -375891799660940966L;

	public UserDoesntExistException() {
	}

	public UserDoesntExistException(String message) {
		super(message);

	}

	public UserDoesntExistException(Throwable cause) {
		super(cause);

	}

	public UserDoesntExistException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserDoesntExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
