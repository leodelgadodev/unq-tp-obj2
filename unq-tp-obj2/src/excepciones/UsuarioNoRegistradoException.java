package excepciones;

public class UsuarioNoRegistradoException extends Exception {

	private static final long serialVersionUID = 1246064252820502365L;

	public UsuarioNoRegistradoException() {
	super("Por favor, registrese para completar esta accion.");
	}
}
