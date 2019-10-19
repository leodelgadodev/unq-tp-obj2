package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import clases.Inmueble;
import clases.SitioWeb;
import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import reserva.Reserva;

public class UsuarioPropietario extends Usuario {

	private List<Inmueble> inmuebles;
	private List<Reserva> reservasPendientesDeAprobacion;
	
	public UsuarioPropietario(SitioWeb web,String nombre, String apellido, String email, Integer telefono) {
		super(web, nombre, apellido, email, telefono);
		this.inmuebles = new ArrayList<Inmueble>();
	}

	public void publicarInmueble(
			String tipo, String ciudad, String pais, 
			String direccion, Set<String> servicios, 
			Integer capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, 
			String horaCheckOut, Double precio
			) throws UsuarioNoRegistradoException, InmuebleInvalidoException {
		
		if(web.getUsuariosRegistrados().contains(this)) {
			this._publicarInmueble(tipo, ciudad, pais, direccion, 
					servicios, capacidad,fechaInicio,fechaFinal, horaCheckIn, horaCheckOut, precio);
		} else web.avisoUsuarioNoRegistrado();
	}
	
	
	public void _publicarInmueble(
			String tipo, String ciudad, String pais, 
			String direccion, Set<String> servicios, 
			Integer capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, 
			String horaCheckOut, Double precio
			) throws InmuebleInvalidoException {
		
		if(web.esUnInmuebleValido(tipo, servicios)) {
		
		Inmueble i = new Inmueble(
				this, tipo, ciudad, pais, direccion, servicios,
				capacidad,fechaInicio,fechaFinal, horaCheckIn, horaCheckOut, precio);
		
		//Usuario userP = new UsuarioPropietario(  // no seria necesario ya que al crear el inmueble le estas pasando el propietario. GT
			//	this.getNombre(), this.getApellido(),
				//this.getEmail(), this.getTelefono(),
				//this.web);
		
		//web.registrarUsuario(userP); ya deberia estar registrado, para ello lo hace desde el contructor de usuario. GT
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
		// TODO Auto-generated method stub
		return this.reservasPendientesDeAprobacion;
	}
	
	@Override
	public void aceptarReservaDe(Usuario inquilino) {
		Reserva r = this.getReservasPendientesDeAprobacion().filter( reserva => reserva.getInquilino() == inquilino );
		// Pseudo codigo, arreglar
		r.setEstatus(true);
		web.agregarReservaConcretada(r);
	}
	
}
