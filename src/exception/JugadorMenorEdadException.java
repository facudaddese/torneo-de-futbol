package exception;

public class JugadorMenorEdadException extends Exception {

	private static final long serialVersionUID = 1L;

	public JugadorMenorEdadException(String mensaje) {
		super(mensaje);
	}
}
