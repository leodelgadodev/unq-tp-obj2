package excepciones;

public class ForbiddenException extends Exception {

	private static final long serialVersionUID = -42155876434310178L;

	public ForbiddenException() {
		super("Solo los usuarios propietarios tienen permiso de realizar esta accion.");
		}
}
