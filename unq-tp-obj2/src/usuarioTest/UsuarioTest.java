package usuarioTest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioTest {


	
	
	@Test
	public void testConstructorUsuario() {
		Usuario user2 = new Usuario("Aaa", "Aaa", "a@email.com", 1111);
		
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
