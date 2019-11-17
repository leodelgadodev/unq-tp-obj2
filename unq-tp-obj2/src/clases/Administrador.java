package clases;

public class Administrador {
	private SitioWeb web;
	
	public Administrador(SitioWeb web) {
		this.web = web;
	}
	

	public void darDeAltaTipoDeInmueble(String tipo) {
		web.agregarTipoDeInmueble(tipo);
	}

	public void darDeAltaServicioDeInmuebles(String servicio) {
		web.agregarServiciosDeInmuebles(servicio);
	}
}
