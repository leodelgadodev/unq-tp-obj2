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
	private Reserva reservaPendiente;
	
	public UsuarioPropietario(String nombre, String apellido, String email, Integer telefono) {
		super(nombre, apellido, email, telefono);
		this.inmuebles = new ArrayList<Inmueble>();
	}

	public void publicarInmueble(
			String tipo, String ciudad, String pais, 
			String direccion, Set<String> servicios, 
			Integer capacidad, String horaCheckIn, 
			String horaCheckOut, Double precio
			) throws UsuarioNoRegistradoException, InmuebleInvalidoException {
		
		if(SitioWeb.web.getUsuariosRegistrados().contains(this)) {
			this._publicarInmueble(tipo, ciudad, pais, direccion, 
					servicios, capacidad, horaCheckIn, horaCheckOut, precio);
		} else SitioWeb.web.avisoUsuarioNoRegistrado();
	}
	
	
	public void _publicarInmueble(
			String tipo, String ciudad, String pais, 
			String direccion, Set<String> servicios, 
			Integer capacidad, String horaCheckIn, 
			String horaCheckOut, Double precio
			) throws InmuebleInvalidoException {
		
		if(SitioWeb.web.esUnInmuebleValido(tipo, servicios)) {
		
		Inmueble i = new Inmueble(
				this, tipo, ciudad, pais, direccion, servicios,
				capacidad, horaCheckIn, horaCheckOut, precio);
		
		//Usuario userP = new UsuarioPropietario(  // no seria necesario ya que al crear el inmueble le estas pasando el propietario. GT
			//	this.getNombre(), this.getApellido(),
				//this.getEmail(), this.getTelefono(),
				//this.web);
		
		//web.registrarUsuario(userP); ya deberia estar registrado, para ello lo hace desde el contructor de usuario. GT
		SitioWeb.web.ponerEnAlquiler(i);
		
		//web.darDeBajaUsuario(this); // ?? GT
		
		} else SitioWeb.web.avisoInmuebleInvalido();
	}

	public void aceptarReserva(Reserva reservaPendiente) {
		SitioWeb.web.eliminarReservaPendiente(reservaPendiente);
		SitioWeb.web.agregarReservaConcretada(reservaPendiente);
		this.enviarMailA(reservaPendiente.getUsuario());
	}
	
}
