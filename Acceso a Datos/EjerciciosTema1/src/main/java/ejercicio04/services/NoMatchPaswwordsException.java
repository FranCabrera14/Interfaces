package ejercicio04.services;

public class NoMatchPaswwordsException extends Exception {

	private static final long serialVersionUID = -3757325022543811356L;

	public NoMatchPaswwordsException() {
	}

	public NoMatchPaswwordsException(String message) {
		super(message);

	}

	public NoMatchPaswwordsException(Throwable cause) {
		super(cause);

	}

	public NoMatchPaswwordsException(String message, Throwable cause) {
		super(message, cause);

	}

	public NoMatchPaswwordsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
