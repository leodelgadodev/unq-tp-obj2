package clases;

import java.util.ArrayList;
import java.util.List;

import reserva.Reserva;
import usuario.Usuario;

public class SitioWeb {
	
	private List<Usuario> usuariosRegistrados;
	private List<Inmueble> inmuebles;
	private List<Reserva> reservasPendientes;
	private List<Reserva> reservasConcretadas;
	
	
	public SitioWeb() {
		
		this.usuariosRegistrados = new ArrayList<Usuario>();
		this.inmuebles = new ArrayList<Inmueble>();
	}

	public List<Usuario> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void registrarUsuario(Usuario usuario) {
		this.usuariosRegistrados.add(usuario);
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void ponerEnAlquiler(Inmueble nvoInmueble) { // seria el metodo ponerEnAlquiler en el UML. GT
		inmuebles.add(nvoInmueble);
	}
	
	public void agregarReservaConcretada(Reserva unaReserva) {
		this.reservasPendientes.add(unaReserva);
	}

	public void agregarReservaPendiente(Reserva unaReserva) {
		this.reservasPendientes.add(unaReserva);
	}

	public void eliminarReservaPendiente(Reserva unaReserva) {
		this.reservasPendientes.remove(unaReserva);
	}
	
	public void eliminarReservaConcretada(Reserva unaReserva) {
		this.reservasConcretadas.remove(unaReserva);
	}
}
