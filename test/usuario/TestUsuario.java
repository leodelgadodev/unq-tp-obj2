package usuario;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;

class TestUsuario {

	private SitioWeb web = new SitioWeb(); 
	private Usuario user1 = new Usuario("Aaa", "Aaa", "a@email.com", 1111);
	
	@BeforeEach
	void setUp() throws Exception {
		
		SitioWeb web = new SitioWeb();
		
		Usuario prop1 = new UsuarioPropietario(null, null, null, null);
		Usuario prop2 = new Usuario(null, null, null, null);
		
		Usuario inquilino1 = new Usuario(null, null, null, null);
		Usuario inquilino2 = new Usuario(null, null, null, null);
		
		Inmueble casa1 = new Inmueble(null, null, null, null, null, null, null, null, null, null);
		Inmueble casa2 = new Inmueble(null, null, null, null, null, null, null, null, null, null);
		Inmueble casa3 = new Inmueble(null, null, null, null, null, null, null, null, null, null);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testConstructorUsuario() {
		Usuario user2 = new Usuario("Aaa", "Aaa", "a@email.com", 1111);
		
		assertNotNull(user2.getNombre());
		assertNotNull(user2.getApellido());
		assertNotNull(user2.getEmail());
		assertNotNull(user2.getTelefono());
	}
	
	@Test
	public void testUsuarioNoRegistradoNoPuedeReservar() {
		
		assertTrue(false);
	}
	
	@Test
	public void testUsuarioRegistradoPuedeReservar() {
		user1.registrarse(web);
		//Falta...
		assertTrue(false);
	}
	
	@Test
	public void testCuandoUsuarioPublicaInmuebleSeConvierteEnPropietario() {
		//Falta...
		assertTrue(false);
	}
	
	@Test
	public void testInquilinoNoRegistradoNoPuedeAlquilar() {
		
	}
	
	@Test
	public void testInquilinoRegistradoPuedeAlquilar() {
		
	}

}
