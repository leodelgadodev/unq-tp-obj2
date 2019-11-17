package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import clases.Inmueble;
import clases.SitioWeb;
import reserva.Reserva;

public class Usuario implements IPropietario, IInquilino{
	
	protected SitioWeb web;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Integer telefono;
	protected Boolean mailRecibido;
	
	private Set<Inmueble> inmuebles;
	private List<Reserva> reservasPendientes;
	
	
	public Usuario(String nombre, String apellido, String email, Integer telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.mailRecibido = false;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void reservarInmueble(Inmueble i, String fechaInicio, String fechaFin) {
		
		Reserva r = new Reserva(this, i, fechaInicio, fechaFin);
		this.reservasPendientes.add(r);
	}

	public void setMailRecibido(boolean b) { 
		this.mailRecibido = b;
	}
	

	public void publicarInmueble(
			String tipo, String ciudad, String pais, String direccion, Set<String> servicios, 
			int capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, String horaCheckOut, double precio){
		
			Inmueble i = new Inmueble(tipo, ciudad, pais, direccion, servicios,capacidad,fechaInicio,fechaFinal, horaCheckIn, horaCheckOut, precio);
			this.inmuebles.add(i);
			web.ponerEnAlquiler(i);
		}
		
	
	public void addReservasPendientes(Reserva r) {
		this.reservasPendientes.add(r);
	}

	
	public void aceptarReserva(Reserva reservaPendiente) {
		web.agregarReserva(reservaPendiente);
		this.enviarMailA(reservaPendiente.getSolicitante());
		this.removeReserva(reservaPendiente);
		this.eliminarReservasDeInmuebleReservado(reservaPendiente);
	}
	
	public void eliminarReservasDeInmuebleReservado(Reserva reserva) {
		List<Reserva> reservas = this.getReservasPendientesDeAprobacion();
		List<Reserva> resultado = new ArrayList<>();
		
		for(Reserva r : reservas) {
			if( r.getInmueble() != reserva.getInmueble()) {
				resultado.add(r);
			}
		}
		this.setReservasPendientesDeAprobacion(resultado);
	}
	
	public void setReservasPendientesDeAprobacion(List<Reserva> reservas) {
		this.reservasPendientes = reservas;
	}

	public void enviarMailA(Usuario inquilino) {
		inquilino.setMailRecibido(true);
	}

	public List<Reserva> getReservasPendientesDeAprobacion() { 
		return this.reservasPendientes;
	}
	
	public void removeReserva(Reserva r) {
		this.reservasPendientes.remove(r);
	}
}
