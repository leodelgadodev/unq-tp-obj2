package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import clases.Inmueble;
import clases.SitioWeb;
import reserva.Reserva;

public class Usuario implements IPropietario, IInquilino{
	
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Integer telefono;
	private Set<Inmueble> inmuebles;
	private List<Reserva> reservasPendientes;
	
	
	public Usuario(String nombre, String apellido, String email, Integer telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	

	public void publicarInmueble(
			String tipo, String ciudad, String pais, String direccion, Set<String> servicios, 
			int capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, String horaCheckOut, double precio){
		
			Inmueble i = new Inmueble(tipo, ciudad, pais, direccion, servicios,capacidad,fechaInicio,fechaFinal, horaCheckIn, horaCheckOut, precio);
			this.inmuebles.add(i);
		}
		
	public void reservarInmueble(Inmueble i,Usuario solicitante,Usuario propietario,String fechaInicio,String fechaFinal) {
		
		Reserva r = new Reserva(solicitante,propietario, i); 
		propietario.addReservaPendiente(r); 
	}
	
	public void addReservaPendiente(Reserva r) {
		this.reservasPendientes.add(r);
	}

	
	public void aceptarReserva(Reserva reservaPendiente,SitioWeb web) {
		web.agregarReserva(reservaPendiente);
		this.removeReservaPendiente(reservaPendiente);
		this.eliminarReservasDeInmuebleReservado(reservaPendiente);
	}
	
	private void eliminarReservasDeInmuebleReservado(Reserva reserva) {
		List<Reserva> reservas = this.getReservasPendientes();
		List<Reserva> resultado = new ArrayList<>();
		
		for(Reserva r : reservas) {
			if( r.getInmueble() != reserva.getInmueble()) {
				resultado.add(r);
			}
		}
		this.setReservasPendientesDeAprobacion(resultado);
	}
	
	private void setReservasPendientesDeAprobacion(List<Reserva> reservas) {
		this.reservasPendientes = reservas;
	}

	public List<Reserva> getReservasPendientes() { 
		return this.reservasPendientes;
	}
	
	private void removeReservaPendiente(Reserva r) {
		this.reservasPendientes.remove(r);
	}
}
