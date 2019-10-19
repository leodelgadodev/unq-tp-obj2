package usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import clases.Inmueble;
import clases.SitioWeb;
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
	
	
	public Set<Inmueble> buscarInmuebles(String ciudad, String fechaEntrada, String fechaSalida){ 
		List<Inmueble> inmuebles = web.getInmueblesDe(ciudad);
		LocalDate fEntrada = LocalDate.parse(fechaEntrada);
		LocalDate fSalida = LocalDate.parse(fechaSalida);

		return inmuebles.stream()
		.filter(x -> (fEntrada.isAfter(x.getFechaDeInicio()) || fEntrada.equals(x.getFechaDeInicio()))  
				&& (fSalida.isBefore(x.getFechaFinal()) || fSalida.equals(x.getFechaFinal()))
				&& x.getCiudad() == ciudad) // agregado esta linea que faltaba, testear
		.collect(Collectors.toSet());
	}
	
	
	/*public Inmueble seleccionarInmueble(String ciudad, String fechaEntrada, String fechaSalida, Integer index) {
		
		return this.buscarInmuebles(ciudad, fechaEntrada, fechaSalida).get(index);
	}*/
	
	public void reservarInmueble(Inmueble i, String fechaInicio, String fechaFin) {
		Reserva r = new Reserva(this, i.getPropietario(), i, fechaInicio, fechaFin);
		i.getPropietario().addReserva(r);
	}

	public List<Reserva> getReservasPendientesDeAprobacion() {
		// Overwrited por el UsuarioPropietario
		// Deberia tirar excepcion? onda no tiene permiso de hacer esto, es un metodo de
		// UsuarioPropietario
		// Igual este ya podria ser un motivo para implementar UsuarioInquilino - Leo
		return null;
	}
	
	private void addReserva(Reserva r) {
		// Overwrited por el UsuarioPropietario
		// Deberia tirar excepcion? onda no tiene permiso de hacer esto, es un metodo de
		// UsuarioPropietario
		// Igual este ya podria ser un motivo para implementar UsuarioInquilino - Leo // claro se estaria rompiendo el primer principio SOLID
		
	}


	public void reservarInmueble(Inmueble i) {
		// TODO Auto-generated method stub
		
	}


	public void aceptarReservaDe(Usuario user) {
		// Overwrited por el UsuarioPropietario
				// Deberia tirar excepcion? onda no tiene permiso de hacer esto, es un metodo de
				// UsuarioPropietario
				// Igual este ya podria ser un motivo para implementar UsuarioInquilino - Leo
		
	}


	public List<Reserva> getReservasConcretadas() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
