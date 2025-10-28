package exception;

public class InformacionExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public InformacionExistenteException(String mensaje) {
		super(mensaje);
	}
}
