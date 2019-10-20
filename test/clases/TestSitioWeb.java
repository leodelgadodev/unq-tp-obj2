package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import usuario.Usuario;

class TestSitioWeb {

	SitioWeb web = new SitioWeb();
	Administrador adm = new Administrador();
	ArrayList<String> a = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		adm.setSitioWeb(web);
		adm.darDeAltaServicioDeInmuebles("Agua");
		adm.darDeAltaTipoDeInmueble("Casa");
	}

	@Test
	public void registrarUsuario() {
		web.registrarUsuario(mock(Usuario.class));
		web.registrarUsuario(mock(Usuario.class));
		assertEquals(2,web.getUsuariosRegistrados().size());
	}
	
	@Test
	public void testPonerEnAlquiler() {
		web.ponerEnAlquiler(mock(Inmueble.class));
		web.ponerEnAlquiler(mock(Inmueble.class));
		assertEquals(2,web.getInmuebles().size());
	}

	@Test
	public void agregarTipoDeInmueble() {
		
		web.agregarTipoDeInmueble("Casa");
		assertFalse(web.getTiposInmueble().isEmpty());
	}
	
	@Test
	public void getTiposDeInmueble() {
		assertNotNull(web.getTiposInmueble());
		assertTrue(web.getTiposInmueble().isEmpty());
	}
	
	@Test
	public void agregarServiciosDeInmuebles() {
		
		web.agregarServiciosDeInmuebles("Agua");
		assertFalse(web.getServiciosInmuebles().isEmpty());
	}
	
	@Test
	public void getServiciosDeInmueble() {
		assertNotNull(web.getServiciosInmuebles());
		assertTrue(web.getServiciosInmuebles().isEmpty());
	}
	
	@Test
	public void agregarReservaConcretada() {
		fail("Not yet implemented");
	}
	
	@Test
	public void agregarReservaPendiente() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetInmueblesDe() {
		
		Inmueble i1 = mock(Inmueble.class); 
		Inmueble i2 = mock(Inmueble.class); 
		when(i1.getCiudad()).thenReturn("BsAs");
		when(i2.getCiudad()).thenReturn("BsAs");
		
		assertEquals("BsAs",i1.getCiudad());
		assertEquals("BsAs",i2.getCiudad());
		
		web.ponerEnAlquiler(i1);
		web.ponerEnAlquiler(i2);
		
		assertEquals(2,web.getInmueblesDe("BsAs").size());
	}
	
	@Test
	public void testAvisoUsuarioNoRegistradoException() {
		assertThrows(UsuarioNoRegistradoException.class, () -> {web.avisoUsuarioNoRegistrado();});
	}

	@Test
	public void testAvisoInmuebleInvalidoException() {
		assertThrows(InmuebleInvalidoException.class, () -> {web.avisoInmuebleInvalido();});
	}

	@Test
	public void testInmuebleValido() {
		Set<String> serviciosTest = new HashSet<String>();
		serviciosTest.add("Agua");

		assertTrue(web.esUnInmuebleValido("Casa", serviciosTest));
		
		serviciosTest.add("Spa");
		
		assertThrows(InmuebleInvalidoException.class, () -> {web.esUnInmuebleValido("Casa", serviciosTest);});
	}
}




