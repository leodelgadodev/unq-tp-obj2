package usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import clases.Inmueble;
import clases.SitioWeb;
import excepciones.ForbiddenException;
import reserva.Reserva;

public class Usuario {
	
	protected SitioWeb web;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Integer telefono;
	protected boolean mailRecibido;

	public Usuario(SitioWeb web, String nombre, String apellido, String email, Integer telefono) {
		this.web = web;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
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

	public void registrarse(SitioWeb sitioweb) {
		
		web.registrarUsuario(this);
	}
	
	
	public List<Inmueble> buscarInmuebles(String ciudad, String fechaEntrada, String fechaSalida){ 
		List<Inmueble> inmuebles = web.getInmueblesDe(ciudad);
		LocalDate fEntrada = LocalDate.parse(fechaEntrada);
		LocalDate fSalida = LocalDate.parse(fechaSalida);

		return inmuebles.stream()
		.filter(x -> (fEntrada.isAfter(x.getFechaDeInicio()) || fEntrada.equals(x.getFechaDeInicio()))  
				&& (fSalida.isBefore(x.getFechaFinal()) || fSalida.equals(x.getFechaFinal()))
				&& x.getCiudad() == ciudad)
		.collect(Collectors.toList());
	}

	public void reservarInmueble(Inmueble i, String fechaInicio, String fechaFin) {
		Reserva r = new Reserva(this, i.getPropietario(), i, fechaInicio, fechaFin);
		i.getPropietario().addReserva(r);
	}

	// Overwrited por UsuarioPropietario
	public List<Reserva> getReservasPendientesDeAprobacion() throws ForbiddenException {

			throw new ForbiddenException();
	}
	
	// Overwrited por UsuarioPropietario
	public void addReserva(Reserva r) { }

	// Overwrited por UsuarioPropietario
	public void aceptarReservaDe(Usuario user) { }

	// Overwrited por UsuarioPropietario
	public List<Reserva> getReservasConcretadas() throws ForbiddenException {
		// TODO Auto-generated method stub
		throw new ForbiddenException();
	}

	public Inmueble seleccionarInmueble(String ciudad, String fechaEntrada, String fechaSalida, Integer index) {

		return this.buscarInmuebles(ciudad, fechaEntrada, fechaSalida).get(index); 
	}

	

}
