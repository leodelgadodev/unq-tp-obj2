package usuarioTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import clases.SitioWeb;
import usuario.Usuario;

public class UsuarioTest {
	
	private Usuario user1 = new Usuario("Aaa", "Aaa", "a@email.com", 1111);
	private SitioWeb web = new SitioWeb();
	
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
}
