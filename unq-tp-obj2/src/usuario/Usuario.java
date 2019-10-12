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
	protected LocalDate fechaDeCreacion; 
	protected List<String>comentarios;
	protected SitioWeb web;

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

	public void registrarse(SitioWeb sitioweb) {
		this.web = sitioweb;
		web.registrarUsuario(this);
	}
	
	public void publicarInmueble(
			String tipo, String ciudad, String pais, 
			String direccion, Set<String> servicios, 
			Integer capacidad, String horaCheckIn, 
			String horaCheckOut, Double precio
			) {
		
		if(web.esUnInmuebleValido(tipo, servicios)) {
		
		Inmueble i = new Inmueble(
				this, tipo, ciudad, pais, direccion, servicios,
				capacidad, horaCheckIn, horaCheckOut, precio);
		
		Usuario userP = new UsuarioPropietario(
				this.getNombre(), this.getApellido(),
				this.getEmail(), this.getTelefono()
				);
		
		web.registrarUsuario(userP);
		web.registrarInmueble(i);
		
		web.darDeBajaUsuario(this);
		
		} else {
			web.avisoInmuebleInvalido();
		}
	}


}
