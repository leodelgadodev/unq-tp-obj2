package usuario;

import java.util.ArrayList;

import clases.Inmueble;
import clases.SitioWeb;

public class UsuarioPropietario extends Usuario {

	private ArrayList<Inmueble> inmuebles;
	
	public UsuarioPropietario(String nombre, String email, Integer telefono) {
		super(nombre, email, telefono);
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
		sitioWeb.darDeAltaNuevoInmueble(nvoInmueble);		
	}

	@Override
	public void registrarse() {
		// TODO Auto-generated method stub
		
	}
	
}
