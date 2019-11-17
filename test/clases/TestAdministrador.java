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

	
	SitioWeb web = new SitioWeb();
	Administrador admin = new Administrador(web);
		
	@BeforeEach
	void setUp() throws Exception {
		
	}

	
	@Test
	public void darDeAltaTipoDeInmuebles() {
		Set<String> esperado = new HashSet<String>();
		esperado.add("Quincho");
		admin.darDeAltaTipoDeInmueble("Quincho");
		assertEquals(esperado, web.getTiposInmueble());
	}
	
	@Test
	public void darDeAltaServicioDeInmuebles() {
		admin.darDeAltaServicioDeInmuebles("Wifi");
		assertEquals(1, web.getServiciosInmuebles().size());	
	}

}
