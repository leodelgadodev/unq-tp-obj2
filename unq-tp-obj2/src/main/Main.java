package main;

import java.util.ArrayList;
import java.util.Set;

import clases.Administrador;
import clases.SitioWeb;

public class Main {
	
	public static void main(String args[]) {
		
		SitioWeb web = new SitioWeb();
		Administrador admin = new Administrador();
		
		ArrayList<String> cRankProp = new ArrayList<>();
		ArrayList<String> cRankInmueble = new ArrayList<>();
		ArrayList<String> cRankInquilino = new ArrayList<>();
		ArrayList<String> servicios = new ArrayList<>();
		ArrayList<String> tipoInmueble = new ArrayList<>();
		
		cRankProp.add("Disponibilidad");
		cRankProp.add("Cordialidad");
		cRankProp.add("Honestidad");
		
		cRankInmueble.add("Ubicacion");
		cRankInmueble.add("Servicios");
		cRankInmueble.add("Limpieza");
		
		cRankInquilino.add("Higiene");
		cRankInquilino.add("Cordialidad");
		cRankInquilino.add("Puntualidad");
		
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
		
		admin.crearCategoriaDeRankingPropietario(cRankProp);
		admin.crearCategoriaDeRankingInmueble(cRankInmueble);
		admin.crearCategoriaDeRankingInquilino(cRankInquilino);
		
		admin.darDeAltaServiciosDeInmuebles(servicios);
		admin.darDeAltaTipoDeInmueble(tipoInmueble);
		
	}
	
}