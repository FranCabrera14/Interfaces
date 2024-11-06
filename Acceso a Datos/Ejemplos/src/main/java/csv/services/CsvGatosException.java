package csv.services;

public class CsvGatosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4441175616212427074L;

	public CsvGatosException() {
	}

	public CsvGatosException(String message) {
		super(message);
	}

	public CsvGatosException(Throwable cause) {
		super(cause);
	}

	public CsvGatosException(String message, Throwable cause) {
		super(message, cause);
	}

	public CsvGatosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
