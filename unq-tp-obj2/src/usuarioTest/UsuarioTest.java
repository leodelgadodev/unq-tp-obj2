package usuarioTest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioTest {


	@Test
	public void testConstructorUsuarioInquilino() {
		Usuario user1 = new UsuarioInquilino("Aaa", "Aaa", "a@email.com", 1111);
		
		assertNotNull(user1.getNombre());
		assertNotNull(user1.getApellido());
		assertNotNull(user1.getEmail());
		assertNotNull(user1.getTelefono());
	}
	
	@Test
	public void testConstructorUsuarioPropietario() {
		Usuario user2 = new UsuarioPropietario("Aaa", "Aaa", "a@email.com", 1111);
		
		assertNotNull(user2.getNombre());
		assertNotNull(user2.getApellido());
		assertNotNull(user2.getEmail());
		assertNotNull(user2.getTelefono());
	}
	
	@Test
	public void testSettersUsuarioInquilino() {
		Usuario user = new UsuarioInquilino(null, null, null, null);
		
		user.setNombre("bbb");
		user.setApellido("bbb");
		user.setEmail("b@email.com");
		user.setTelefono(2222);
		
		assertNotNull(user.getNombre());
		assertNotNull(user.getApellido());
		assertNotNull(user.getEmail());
		assertNotNull(user.getTelefono());
	}
	
	@Test
	public void testSettersUsuarioPropietario() {
		Usuario user = new UsuarioPropietario(null, null, null, null);
		
		user.setNombre("bbb");
		user.setApellido("bbb");
		user.setEmail("b@email.com");
		user.setTelefono(2222);
		
		assertNotNull(user.getNombre());
		assertNotNull(user.getApellido());
		assertNotNull(user.getEmail());
		assertNotNull(user.getTelefono());
	}
	
	
}
