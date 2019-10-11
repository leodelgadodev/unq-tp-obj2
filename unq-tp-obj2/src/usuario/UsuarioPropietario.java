package usuario;

import java.util.ArrayList;
import java.util.List;

import clases.Inmueble;
import clases.SitioWeb;

public class UsuarioPropietario extends Usuario {

	private List<Inmueble> inmuebles;
	
	public UsuarioPropietario(String nombre, String apellido, String email, Integer telefono) {
		super(nombre, apellido, email, telefono);
		this.inmuebles = new ArrayList<Inmueble>();
	}

	/**
	 * Publica un nuevo inmueble al sitio web
	 * @param String tipo - Habitacion, Depto, Casa, Quincho
	 * @param String pais
	 * @param String ciudad
	 * @param String servicios - agua, gas, electricidad, ba�o privado/ compartido,
		calefacci�n, aire acondicionado, wi-fi
	 * @param Integer capacidad
	 * @param Integer checkIn - Horario expresado con 4 digitos
	 * @param Integer checkOut - Horario expresado con 4 digitos
	 */

	@Override
	public void publicarInmueble(Inmueble nvoInmueble, SitioWeb sitioWeb) {
		sitioWeb.darDeAltaNuevoInmueble(nvoInmueble);		
	}

	@Override
	public void registrarse(SitioWeb sitioWeb) {
		sitioWeb.registrarUsuario(this);
	}
	
}
