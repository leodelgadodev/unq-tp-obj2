package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import clases.Inmueble;
import clases.SitioWeb;

public class Usuario {
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Integer telefono;
	//protected LocalDate fechaDeCreacion; // para que??? - Leo // se necesitara para conocer hace cuanto que es usuario del sitio.Todavia no para este hito GT
	//protected List<String>comentarios; No hace falta para este hito - Leo
	protected SitioWeb web;


	public Usuario(String nombre, String apellido, String email, Integer telefono, SitioWeb web) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		
		this.registrarse(web);
		//this.fechaDeCreacion = LocalDate.now(); // todavia no para este hito GT
		//this.comentarios = new ArrayList<String>(); // No hace falta para este hito - L
	}

	//public LocalDate getFechaDeCreacion() { // todavia no para este hito GT
	//	return fechaDeCreacion;
	//}

	//public List<String> getComentarios() {
		//return comentarios; // No hace falta para este hito - L
	//}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void registrarse(SitioWeb sitioweb) {
		this.web = sitioweb;
		web.registrarUsuario(this);
	}

}
