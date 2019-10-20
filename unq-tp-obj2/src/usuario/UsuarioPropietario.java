 package usuario;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import clases.Inmueble;
import clases.SitioWeb;
import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import reserva.Reserva;

public class UsuarioPropietario extends Usuario {

	private Set<Inmueble> inmuebles; // ???
	private Set<Reserva> reservasPendientesDeAprobacion;
	
	public UsuarioPropietario(String nombre, String apellido, String email, Integer telefono) {
		super(nombre, apellido, email, telefono);
		this.inmuebles = new HashSet<Inmueble>();
	}

	public void publicarInmueble(
			String tipo, String ciudad, String pais, 
			String direccion, Set<String> servicios, 
			int capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, 
			String horaCheckOut, double precio
			) throws UsuarioNoRegistradoException, InmuebleInvalidoException {
		
		if(web.getUsuariosRegistrados().contains(this)) {
			this._publicarInmueble(tipo, ciudad, pais, direccion, 
					servicios, capacidad,fechaInicio,fechaFinal, horaCheckIn, horaCheckOut, precio);
		} else web.avisoUsuarioNoRegistrado();
	}
	
	public void publicarInmueble(Inmueble i) throws UsuarioNoRegistradoException, InmuebleInvalidoException {
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
		
		this.publicarInmueble(i.getTipoDeInmueble(), i.getCiudad(), i.getPais(), i.getDireccion(), 
					i.getServicios(), i.getCapacidad(), i.getFechaDeInicio().format(formatDate), i.getFechaFinal().format(formatDate), i.getHoraCheckIn().format(formatTime), i.getHoraCheckOut().format(formatTime), i.getPrecio());
	}
	
	
	public void _publicarInmueble(
			String tipo, String ciudad, String pais, 
			String direccion, Set<String> servicios, 
			int capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, 
			String horaCheckOut, double precio
			) throws InmuebleInvalidoException {
		
		if(web.esUnInmuebleValido(tipo, servicios)) {
			Inmueble i = new Inmueble(
					this, tipo, ciudad, pais, direccion, servicios,
					capacidad,fechaInicio,fechaFinal, horaCheckIn, horaCheckOut, precio);
			
			web.registrarUsuario(this);
			web.ponerEnAlquiler(i);
			//web.darDeBajaUsuario(this); // ?? GT
		
		} else web.avisoInmuebleInvalido();
	}
	
	public void addReserva(Reserva r) {
		this.reservasPendientesDeAprobacion.add(r);
	}
	
	public void removeReserva(Reserva r) {
		this.reservasPendientesDeAprobacion.remove(r);
	}

	public void aceptarReserva(Reserva reservaPendiente) {
		web.eliminarReservaPendiente(reservaPendiente); //Por que necesitaria la web conocer reservas pendientes?
		web.agregarReservaConcretada(reservaPendiente);
		this.enviarMailA(reservaPendiente.getUsuario()); //No aplica para este hito - Leo
	}
	
	@Override
	public List<Reserva> getReservasPendientesDeAprobacion() { 
		return this.reservasPendientesDeAprobacion;
	}
	
	@Override
	public void aceptarReservaDe(Usuario inquilino) {
		Reserva r = this.getReservasPendientesDeAprobacion().filter( reserva -> reserva.getInquilino() == inquilino );
		// Pseudo codigo, arreglar
		r.setEstatus(true);
		web.agregarReservaConcretada(r);
	}
	
}
