package usuario;

import java.util.ArrayList;
import java.util.List;

import clases.Inmueble;
import clases.SitioWeb;
import reserva.Reserva;

public class UsuarioPropietario extends Usuario {

	private List<Inmueble> inmuebles;
	private Reserva reservaPendiente;
	private SitioWeb sitioWeb;
	
	public UsuarioPropietario(String nombre, String apellido, String email, Integer telefono) {
		super(nombre, apellido, email, telefono);
		this.inmuebles = new ArrayList<Inmueble>();
	}

	/**
	 * Publica un nuevo inmueble al sitio web
	 * @param String tipo - Habitacion, Depto, Casa, Quincho
	 * @param String pais
	 * @param String ciudad
	 * @param String servicios - agua, gas, electricidad, baño privado/ compartido,
		calefacción, aire acondicionado, wi-fi
	 * @param Integer capacidad
	 * @param Integer checkIn - Horario expresado con 4 digitos
	 * @param Integer checkOut - Horario expresado con 4 digitos
	 */

	@Override
	public void publicarInmueble(Inmueble nvoInmueble, SitioWeb sitioWeb) {
		sitioWeb.ponerEnAlquiler(nvoInmueble);		
	}

	@Override
	public void registrarse(SitioWeb sitioWeb) {
		sitioWeb.registrarUsuario(this);
	}
	
	public void aceptarReserva(Reserva reservaPendiente) {
		this.sitioWeb.eliminarReservaPendiente(reservaPendiente);
		this.sitioWeb.agregarReservaConcretada(reservaPendiente);
	}
	
}
