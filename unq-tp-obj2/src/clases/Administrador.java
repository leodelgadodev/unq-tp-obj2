package clases;

public class Administrador {
	private SitioWeb web;
	
	public SitioWeb getSitioWeb() {
		return web;
	}

	public void setSitioWeb(SitioWeb sitioWeb) {
		web = sitioWeb;
	}

	public void darDeAltaTipoDeInmueble(String tipo) {
		web.agregarTipoDeInmueble(tipo);
	}

	public void darDeAltaServicioDeInmuebles(String servicio) {
		web.agregarServiciosDeInmuebles(servicio);
	}
}
