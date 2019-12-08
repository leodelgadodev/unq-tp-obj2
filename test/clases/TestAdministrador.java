package clases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAdministrador {

	SitioWeb web = new SitioWeb();
	Administrador a = new Administrador(web);
	
	@Test
	public void darDeAltaTipoDeInmueble() {
		a.darDeAltaTipoDeInmueble("Rascacielos");
		assertEquals(1,web.getTiposInmueble().size());
	}
	
	@Test
	public void darDeAltaServicioDeInmuebles() {
		a.darDeAltaServicioDeInmuebles("Masajes");
		assertEquals(1,web.getServiciosInmuebles().size());
	}
}
