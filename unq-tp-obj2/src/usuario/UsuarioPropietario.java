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
		
		if(web != null && web.getUsuariosRegistrados().contains(this)) {
			this._publicarInmueble(tipo, ciudad, pais, direccion, 
					servicios, capacidad,fechaInicio,fechaFinal, horaCheckIn, horaCheckOut, precio);
		} else throw new UsuarioNoRegistradoException();
	}

	/**
	 * Implementación parcial de publicarInmueble().
	 * @param tipo
	 * @param ciudad
	 * @param pais
	 * @param direccion
	 * @param servicios
	 * @param capacidad
	 * @param fechaInicio
	 * @param fechaFinal
	 * @param horaCheckIn
	 * @param horaCheckOut
	 * @param precio
	 * @throws InmuebleInvalidoException
	 */
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
			
			web.ponerEnAlquiler(i);
		
		} else web.avisoInmuebleInvalido();
	}
	
	public void addReserva(Reserva r) {
		this.reservasPendientesDeAprobacion.add(r);
	}

	public void aceptarReserva(Reserva reservaPendiente) {
		web.agregarReservaConcretada(reservaPendiente);
		this.enviarMailA(reservaPendiente.getInquilino()); //No aplica para este hito - Leo
	}
	
	public void enviarMailA(Usuario inquilino) {
		inquilino.setMailRecibido(true);
	}

	@Override
	public List<Reserva> getReservasPendientesDeAprobacion() { 
		return this.reservasPendientesDeAprobacion;
	}
	
}
