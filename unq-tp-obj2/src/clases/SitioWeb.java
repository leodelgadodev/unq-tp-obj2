package clases;

import java.util.ArrayList;

import usuario.Usuario;

public class SitioWeb {
	
	private ArrayList<Usuario> usuariosRegistrados;
	private ArrayList<Inmueble> inmuebles;
	
	public ArrayList<Usuario> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void setUsuariosRegistrados(ArrayList<Usuario> usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}

	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(ArrayList<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	

}
