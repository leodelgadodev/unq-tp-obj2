package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import usuario.Usuario;
import usuario.UsuarioInquilino;
import usuario.UsuarioPropietario;

public class UsuarioPropietarioTest extends UsuarioTest {

	private SitioWeb web = new SitioWeb();
	private Set<String> servicios = new HashSet<String>();
	private UsuarioPropietario prop1,prop2,prop3;
	private UsuarioInquilino inquilino1,inquilino2,inquilino3;
	
	// si no diferencio, por ahora, los tipos de usuarios no reconoce alguno de los metodos en los test. 
	
	@Before
	public void setUp() {
		
	 prop1 = new UsuarioPropietario("Fer","Santacruz", "fer@email.com", 8001111,web);
	 prop2 = new UsuarioPropietario("Gonza","Torrez", "gonza@email.com", 8002222,web);
	 prop3 = new UsuarioPropietario("Leo","Delgado", "leo@email.com", 8003333,web);
	
	 inquilino1 = new UsuarioInquilino("Diego","Cano", "diegotorres@email.com", 8004444,web);
	 inquilino2 = new UsuarioInquilino("Diego","Torres", "diegocano@email.com", 8005555,web);
	 inquilino3 = new UsuarioInquilino("Martin","Rosenfeld", "martinrosenfeld@email.com", 8006666,web);
	
	servicios.add("Gas");
	servicios.add("Agua potable");
	servicios.add("Wifi");
	

	}
	
	@Test
	public void testSettersUsuarioPropietario() {
		Usuario user = new UsuarioPropietario(null, null, null, null,null);
		
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
	public void testDatosUsuarioPropietario() {
	
		
		assertEquals("Fer",prop1.getNombre());
		assertEquals("Santacruz",prop1.getApellido());
		assertEquals("fer@email.com",prop1.getEmail());
		// assertEquals(8001111,prop1.getTelefono()); -> tirar error???GT
	}
	
	@Test
	public void testPropietarioNoRegistradoNoPuedePublicar() {
		this.setUp();
		
		Assert.assertEquals(0, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioRegistradoPuedePublicarInmuebleValido() throws UsuarioNoRegistradoException, InmuebleInvalidoException {
		this.setUp();
		
		prop1.registrarse(web);
		prop1.publicarInmueble("Depto", "BsAs", "Argentina", "CABA 240", servicios, 3, "12:00", "10:00", 5000.00);
		
		
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
