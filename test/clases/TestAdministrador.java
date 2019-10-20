package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
		Set<String> esperado = new HashSet<String>();
		esperado.add("ncho");
		admin.darDeAltaTipoDeInmueble("Quincho");
		assertEquals(esperado, web.getTiposInmueble());
	}
	
	@Test
	public void darDeAltaServicioDeInmuebles() {
		admin.darDeAltaServicioDeInmuebles("Wifi");
		assertEquals(1, web.getServiciosInmuebles().size());	
	}

}
