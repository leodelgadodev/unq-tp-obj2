package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.Inmueble;
import clases.SitioWeb;

public abstract class Usuario {
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Integer telefono;
	protected LocalDate fechaDeCreacion; 
	protected List<String>comentarios;

	public Usuario(String nombre, String apellido, String email, Integer telefono) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaDeCreacion = LocalDate.now(); // Podria ser asi o fijarle una fecha en concreto ? GT
		this.comentarios = new ArrayList<String>();
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public List<String> getComentarios() {
		return comentarios;
	}

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

	public abstract void publicarInmueble(Inmueble nvoInmueble, SitioWeb sitioWeb);

	public abstract void registrarse(SitioWeb sitioweb);


}
