package main;

import java.util.ArrayList;
import java.util.Set;

import clases.Administrador;
import clases.SitioWeb;
import usuario.Usuario;
import usuario.UsuarioPropietario;

public class Main {
	
	public static void main(String args[]) {
		
		// --- CONFIG
		
		SitioWeb web = new SitioWeb();
		Administrador admin = new Administrador();
		
		Usuario u = new Usuario("raul", "castillo", "rcasti@gmail", 88889999);
		Usuario prop = new UsuarioPropietario("raula", "castilla", "rcasta@mail", 99998888);

		ArrayList<String> servicios = new ArrayList<>();
		ArrayList<String> tipoInmueble = new ArrayList<>();

		servicios.add("Agua potable");
		servicios.add("Gas");
		servicios.add("Wifi");
		servicios.add("Media pension");
		servicios.add("Pension completa");
		servicios.add("Piscina");
		servicios.add("Caja fuerte");
		
		tipoInmueble.add("Casa");
		tipoInmueble.add("Quincho");
		tipoInmueble.add("Habitacion");
		tipoInmueble.add("Departamento");
		tipoInmueble.add("Camping");
		tipoInmueble.add("Hostel");
	
		for(String s : servicios) {
			admin.darDeAltaServicioDeInmuebles(s);
		}
		
		for(String t : tipoInmueble) {
			admin.darDeAltaTipoDeInmueble(t);
		}
		
		// -- CREAR Y PUBLICAR PROPIEDADES
		
		prop.publicarInmueble();
		prop.publicarInmueble();
		
		// -- LISTAR PROPIEDADES DISPONIBLES ENTRE DOS FECHAS
		
		u.buscarInmuebles("BsAs", "2020-01-01", "202-01-20");
		
		// -- CONCRETAR UNA RESERVA
		
		u.reservarInmueble(i);
		prop.aceptarReserva(u,i);
	}
	
}