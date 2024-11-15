package ejercicio04.services;

public class PedidoServiceException extends Exception {

	private static final long serialVersionUID = -7078194373409222795L;

	public PedidoServiceException() {
	}

	public PedidoServiceException(String message) {
		super(message);

	}

	public PedidoServiceException(Throwable cause) {
		super(cause);

	}

	public PedidoServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public PedidoServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
