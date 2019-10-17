package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.SitioWeb;
import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;

class TestUsuarioPropietario {

	private SitioWeb web = new SitioWeb();
	private Set<String> servicios = new HashSet<String>();
	private UsuarioPropietario prop1,prop2,prop3;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		 prop1 = new UsuarioPropietario("Fer","Santacruz", "fer@email.com", 8001111);
		 prop2 = new UsuarioPropietario("Gonza","Torrez", "gonza@email.com", 8002222);
		 prop3 = new UsuarioPropietario("Leo","Delgado", "leo@email.com", 8003333);
		

		
		servicios.add("Gas");
		servicios.add("Agua potable");
		servicios.add("Wifi");
	}

	@Test
	void test() {
		fail("Not yet implemented");
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
	public void testDatosUsuarioPropietario() {
	
		
		assertEquals("Fer",prop1.getNombre());
		assertEquals("Santacruz",prop1.getApellido());
		assertEquals("fer@email.com",prop1.getEmail());
		// assertEquals(8001111,prop1.getTelefono()); -> tirar error???GT
	}
	
	@Test
	public void testPropietarioNoRegistradoNoPuedePublicar() {
		
		Assert.assertEquals(0, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioRegistradoPuedePublicarInmuebleValido() throws UsuarioNoRegistradoException, InmuebleInvalidoException {

		prop1.registrarse(web);
		prop1.publicarInmueble("Depto", "BsAs", "Argentina", "CABA 240", servicios, 3, "12:00", "10:00", 5000.00);
		
		
		Assert.assertEquals(1, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioNoPuedePublicarInmuebleInvalidoPorServicio() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPropietarioNoPuedePublicarInmuebleInvalidoPorTipo() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUsuarioAlPublicarUnInmuebleSeConvierteEnUsuarioPropietario() {
		fail("Not yet implemented");
	}


}
