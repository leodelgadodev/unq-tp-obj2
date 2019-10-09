package usuario;

import java.util.ArrayList;

import clases.Inmueble;

public class UsuarioPropietario extends Usuario {

	private ArrayList<Inmueble> inmuebles;
	
	public UsuarioPropietario(String nombre, String email, Integer telefono) {
		super(nombre, email, telefono);
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
	public void publicarInmueble(String tipo, String pais, String ciudad, 
			ArrayList<String> servicios, Integer capacidad, Integer checkIn, Integer checkOut) {
		
		
	}
	
}
