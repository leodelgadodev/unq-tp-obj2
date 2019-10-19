package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdministrador {

	Administrador admin = new Administrador();
	SitioWeb web = new SitioWeb();
		
	@BeforeEach
	void setUp() throws Exception {
		admin.setSitioWeb(web);
	}

	@Test
	void testAdminConoceAlSitioWeb() {
		assertEquals(web, admin.getSitioWeb());
	}
	
	@Test
	void testAdminSetSitioWeb() {
		admin.setSitioWeb(mock(SitioWeb.class));
		assertNotEquals(web, admin.getSitioWeb());
	}

	public void darDeAltaTipoDeInmuebles() {
		admin.darDeAltaTipoDeInmueble("Quincho");
		assertEquals(1, web.getTiposInmueble().size());
	}
	
	@Test
	public void darDeAltaServicioDeInmuebles() {
		admin.darDeAltaServicioDeInmuebles("Wifi");
		assertEquals(1, web.getServiciosInmuebles().size());	
	}

}
