package examen.services;

public class EquipoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7834460619761012113L;

	public EquipoNotFoundException() {
	}

	public EquipoNotFoundException(String message) {
		super(message);
	}

	public EquipoNotFoundException(Throwable cause) {
		super(cause);
	}

	public EquipoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EquipoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
