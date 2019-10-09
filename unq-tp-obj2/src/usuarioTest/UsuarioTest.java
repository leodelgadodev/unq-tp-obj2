package usuarioTest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioTest {

	Usuario user1 = new UsuarioInquilino("Aaa", "a@email.com", 1111);
	Usuario user2 = new UsuarioPropietario("Aaa", "a@email.com", 1111);
	
	@Test
	public void testConstructorUsuarioInquilino() {
		
		
		assertNotNull(user1.getNombre());
		assertNotNull(user1.getEmail());
		assertNotNull(user1.getTelefono());
	}
	
	@Test
	public void testConstructorUsuarioPropietario() {
		
		
		assertNotNull(user2.getNombre());
		assertNotNull(user2.getEmail());
		assertNotNull(user2.getTelefono());
	}
	
	@Test
	public void testSettersUsuarioInquilino() {
		user1.setNombre("bbb");
		user1.setEmail("b@email.com");
		user1.setTelefono(2222);
		
		assertNotNull(user1.getNombre());
		assertNotNull(user1.getEmail());
		assertNotNull(user1.getTelefono());
	}
	
	@Test
	public void testSettersUsuarioPropietario() {
		user2.setNombre("bbb");
		user2.setEmail("b@email.com");
		user2.setTelefono(2222);
		
		assertNotNull(user2.getNombre());
		assertNotNull(user2.getEmail());
		assertNotNull(user2.getTelefono());
	}
	
	
}
