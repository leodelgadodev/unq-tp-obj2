package main;

import clases.Administrador;
import clases.SitioWeb;

public class Main {
	
	public static void main(String args[]) {
		
		SitioWeb web = new SitioWeb();
		Administrador admin = new Administrador();
		
		admin.crearCategoriaDeRankingInmueble(categorias);
		admin.crearCategoriaDeRankingPropietario(categorias);
		admin.crearCategoriaDeRankingInquilino(categorias);
		
		admin.darDeAltaServiciosDeInmuebles(servicios);
		admin.darDeAltaTipoDeInmueble(tipos);
		
	}
	
}