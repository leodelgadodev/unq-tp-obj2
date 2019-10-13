package usuarioTest;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioPropietarioTest extends UsuarioTest {

	private SitioWeb web = new SitioWeb();
	private Set<String> servicios = new HashSet<String>();
	private Usuario prop1,prop2,prop3,inquilino1,inquilino2,inquilino3;
	
	@Before
	public void setUp() {
		
	Usuario prop1 = new UsuarioPropietario("Fer","Santacruz", "fer@email.com", 8001111);
	Usuario prop2 = new Usuario("Gonza","Torrez", "gonza@email.com", 8002222);
	Usuario prop3 = new Usuario("Leo","Delgado", "leo@email.com", 8003333);
	
	Usuario inquilino1 = new Usuario("Diego","Cano", "diegotorres@email.com", 8004444);
	Usuario inquilino2 = new Usuario("Diego","Torres", "diegocano@email.com", 8005555);
	Usuario inquilino3 = new Usuario("Martin","Rosenfeld", "martinrosenfeld@email.com", 8006666);
	
	servicios.add("Gas");
	servicios.add("Agua potable");
	servicios.add("Wifi");
	

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
	
	@Test
	public void testPropietarioNoRegistradoNoPuedePublicar() {
		this.setUp();
		
		Assert.assertEquals(0, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioRegistradoPuedePublicarInmuebleValido() {
		this.setUp();
		
		prop1.registrarse(web);
		prop1.publicarInmueble("Depto",
				"BsAs","Argentina",
				"CABA 240",servicios,
				3,"12:00","10:00",5000.00);
		
		Assert.assertEquals(1, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioNoPuedePublicarInmuebleInvalidoPorServicio() {
		
	}
	
	@Test
	public void testPropietarioNoPuedePublicarInmuebleInvalidoPorTipo() {
		
	}
	
	@Test
	public void testUsuarioAlPublicarUnInmuebleSeConvierteEnUsuarioPropietario() {
		this.setUp();
	}

}
