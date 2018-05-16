package dominio.excepcion;

public class ParquearException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ParquearException (String message) {
		super(message);
	}
}
