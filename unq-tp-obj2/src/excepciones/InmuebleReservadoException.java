package excepciones;

public class InmuebleReservadoException extends Exception {

	private static final long serialVersionUID = 5816713505681384704L;

	public InmuebleReservadoException() {
		super("Esta inmueble ya esta reservado.");
	}
}