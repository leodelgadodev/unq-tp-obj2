package usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import clases.Inmueble;
import clases.SitioWeb;
import excepciones.*;
import reserva.Reserva;

public class Usuario {
	
	protected SitioWeb web;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Integer telefono;
	protected Boolean mailRecibido;
	
	public Usuario(String nombre, String apellido, String email, Integer telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}


	public void setSitioWeb(SitioWeb w) {
		this.web = w;
	}
	
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void reservarInmueble(Inmueble i, String fechaInicio, String fechaFin) throws ForbiddenException, InmuebleReservadoException {
		
		if( !i.estaReservado() ) {
			Reserva r = new Reserva(this, i.getPropietario(), i, fechaInicio, fechaFin);
			i.getPropietario().addReserva(r);
		} else throw new InmuebleReservadoException();
	}

	// Overwrited por UsuarioPropietario
	public List<Reserva> getReservasPendientesDeAprobacion() throws ForbiddenException {
			throw new ForbiddenException();
	}
	
	// Overwrited por UsuarioPropietario
	public void addReserva(Reserva r) throws ForbiddenException {
		throw new ForbiddenException();
	}

	// Overwrited por UsuarioPropietario
	public void aceptarReservaDe(Usuario user) throws ForbiddenException { 
		throw new ForbiddenException();
	}

	public Inmueble seleccionarInmueble(String ciudad, String fechaEntrada, String fechaSalida, Integer index) {
		return web.buscarInmuebles(ciudad, fechaEntrada, fechaSalida).get(index); 
	}
	
	public boolean mailRecibido() {
		return this.mailRecibido;
	}


	public void setMailRecibido(boolean b) {
		this.mailRecibido = b;
	}

	

}
