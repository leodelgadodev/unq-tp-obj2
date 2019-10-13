package excepciones;

public class InmuebleInvalidoException extends Exception {

	private static final long serialVersionUID = 1619792044245103629L;

	public InmuebleInvalidoException() {
		super("No pudimos registrar su inmueble. Por favor,"
				+ "verifique que sea un tipo de inmueble posible y que"
				+ "los servicios ofrecidos coincidan con los servicios"
				+ "posibles. ");
	}
}
