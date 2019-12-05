package usuario;

import java.util.ArrayList;
import java.util.HashSet;
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
		this.inmuebles = new HashSet<Inmueble>();
		this.reservasPendientes = new ArrayList<Reserva>();
	}

	public Set<Inmueble> getInmuebles(){
		
		return this.inmuebles;
	}

	public void publicarInmueble(Inmueble i){
			
			this.inmuebles.add(i);
		}
		
	
	public void reservarInmueble(Reserva r,Inmueble i,Usuario propietario,String fechaInicio,String fechaFinal) {
		
		r.setSolicitante(this);
		r.setInmueble(i);
		r.setPropietario(propietario);
		r.setFechaDeInicio(fechaInicio);
		r.setFechaFinal(fechaFinal);
		propietario.addReservaPendiente(r); 
	}
	
	public void addReservaPendiente(Reserva r) {
		this.reservasPendientes.add(r);
	}

	
	public void aceptarReserva(Reserva reservaPendiente,SitioWeb web) {
		web.agregarReserva(reservaPendiente);
		this.removeReservaPendiente(reservaPendiente);
	}
	

	public List<Reserva> getReservasPendientes() { 
		return this.reservasPendientes;
	}
	
	private void removeReservaPendiente(Reserva r) {
		this.reservasPendientes.remove(r);
	}
}
