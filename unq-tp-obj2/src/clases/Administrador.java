package clases;

public class Administrador {

	SitioWeb web;
	
	public Administrador(SitioWeb web) {
		this.web = web;
	}
	
	public void darDeAltaTipoDeInmueble(String tipo) {
		
		this.web.agregarTipoDeInmueble(tipo); 
	}

	public void darDeAltaServicioDeInmuebles(String servicio) {

		this.web.agregarServicioDeInmuebles(servicio);
	}
}
