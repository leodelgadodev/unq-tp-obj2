package usuario;

import java.util.ArrayList;

import clases.Inmueble;
import clases.SitioWeb;

public class UsuarioInquilino extends Usuario {

	public UsuarioInquilino(String nombre, String apellido, String email, Integer telefono) {
		super(nombre,apellido, email, telefono);
	}

//	@Override //En teoria un inquilino tambien podria realizar esto.
//	public void publicarInmueble(String string, String string2, String string3, ArrayList<String> servicios, int i,
//			int j, int k) {
			
//	}

	@Override
	public void registrarse(SitioWeb sitioWeb) {
		sitioWeb.registrarUsuario(this);
	}

	@Override
	public void publicarInmueble(Inmueble nvoInmueble, SitioWeb sitioWeb) { //GT: En teoria un inquilino tambien podria realizar esto. evaluar mas tarde.
		// TODO Auto-generated method stub
		
	}

}
