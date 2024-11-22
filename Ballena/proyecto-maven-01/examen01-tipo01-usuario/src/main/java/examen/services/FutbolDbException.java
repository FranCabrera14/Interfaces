package examen.services;

public class FutbolDbException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7277597782799385880L;

	public FutbolDbException() {
	}

	public FutbolDbException(String message) {
		super(message);
	}

	public FutbolDbException(Throwable cause) {
		super(cause);
	}

	public FutbolDbException(String message, Throwable cause) {
		super(message, cause);
	}

	public FutbolDbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
