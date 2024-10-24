package ejercicio04.services;

public class UserServiceException extends Exception {

	private static final long serialVersionUID = 8099103803440747694L;

	public UserServiceException() {
	}

	public UserServiceException(String message) {
		super(message);

	}

	public UserServiceException(Throwable cause) {
		super(cause);

	}

	public UserServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
