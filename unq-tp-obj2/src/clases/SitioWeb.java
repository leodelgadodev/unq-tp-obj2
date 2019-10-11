package clases;

import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class SitioWeb {
	
	private List<Usuario> usuariosRegistrados;
	private List<Inmueble> inmuebles;
	
	
	public SitioWeb() {
		
		this.usuariosRegistrados = new ArrayList<Usuario>();
		this.inmuebles = new ArrayList<Inmueble>();
	}

	public List<Usuario> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void registrarUsuario(Usuario usuario) {
		this.usuariosRegistrados.add(usuario);
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void darDeAltaNuevoInmueble(Inmueble nvoInmueble) { // seria el metodo ponerEnAlquiler en el UML. GT
		inmuebles.add(nvoInmueble);
	}

}
