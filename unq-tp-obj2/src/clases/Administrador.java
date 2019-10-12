package clases;

import java.util.ArrayList;

public class Administrador {
	private SitioWeb web;
	
	public SitioWeb getSitioWeb() {
		return web;
	}

	public void setSitioWeb(SitioWeb sitioWeb) {
		web = sitioWeb;
	}

	public void crearCategoriaDeRankingPropietario(String categoria) {
		web.agregarCategoriaDeRankingPropietario(categoria);
		
	}

	public void crearCategoriaDeRankingPropietario(ArrayList<String> categorias) {

		for (String c : categorias) {
			web.agregarCategoriaDeRankingPropietario(c);
		}
	}

	public void crearCategoriaDeRankingInquilino(String categoria) {
		web.agregarCategoriaDeRankingInquilino(categoria);		
	}
	
	public void crearCategoriaDeRankingInquilino(ArrayList<String> categorias) {

		for (String c : categorias) {
			web.agregarCategoriaDeRankingInquilino(c);
		}
	}
	
	public void crearCategoriaDeRankingInmueble(String categoria) {
		web.agregarCategoriaDeRankingInnmueble(categoria);		
	}
	
	public void crearCategoriaDeRankingInmueble(ArrayList<String> categorias) {

		for (String c : categorias) {
			web.agregarCategoriaDeRankingInnmueble(c);
		}
	}

	public void darDeAltaTipoDeInmueble(String tipo) {
		web.agregarTipoDeInmueble(tipo);
	}
	
	public void darDeAltaTipoDeInmueble(ArrayList<String> tipos) {

		for (String t : tipos) {
			web.agregarTipoDeInmueble(t);
		}
	}

	public void darDeAltaServiciosDeInmuebles(String servicio) {
		
		web.agregarServiciosDeInmuebles(servicio);
	}
	
	public void darDeAltaServiciosDeInmuebles(ArrayList<String> servicios) {

		for (String s : servicios) {
			web.agregarServiciosDeInmuebles(s);
		}
	}
	

}
