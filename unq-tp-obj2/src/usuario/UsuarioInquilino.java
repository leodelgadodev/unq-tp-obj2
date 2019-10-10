package usuario;

import java.util.ArrayList;

public class UsuarioInquilino extends Usuario {

	public UsuarioInquilino(String nombre, String email, Integer telefono) {
		super(nombre, email, telefono);
	}

	@Override //En teoria un inquilino tambien podria realizar esto.
	public void publicarInmueble(String string, String string2, String string3, ArrayList<String> servicios, int i,
			int j, int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarse() {
		
	}

}
