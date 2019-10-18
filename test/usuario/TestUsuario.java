package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;

class TestUsuario {

	SitioWeb web = new SitioWeb();
	private Set<String> servicios = new HashSet<String>();
	
	Usuario prop1 = new Usuario(web,"Leo","Delgado", "leo@email.com", 1526248982);
	Usuario prop2 = new Usuario(web,"Gonza","Torrez", "gonza@email.com", 1585248596);
	
	Inmueble casa1 = new Inmueble(prop1, "casa1", "BsAs", "Argentina","calle 123" , servicios, 5,"2019-10-17","2019-10-25", "08:30", "17:00", 2500.0);
	Inmueble casa2 = new Inmueble(prop1, "casa2", "Cordoba", "Argentina","calle 123" , servicios, 5,"2019-10-17","2019-10-25", "09:30", "19:00", 3500.0);
	Inmueble casa3 = new Inmueble(prop2, "casa3", "BsAs", "Argentina","calle 123" , servicios, 5,"2019-10-17","2019-10-25", "10:30", "18:00", 4000.0);
	
	@BeforeEach
	void setUp() throws Exception {
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
		
		servicios.add("Gas");
		servicios.add("Agua potable");
		servicios.add("Wifi");
	}
	
	@Test
	public void testGetNombre() {
		
		assertEquals("Leo",prop1.getNombre());
	}
	
	@Test
	public void testGetApellido() {
		
		assertEquals("Delgado",prop1.getApellido());
	}
	
	@Test
	public void testGetEmail() {
		
		assertEquals("leo@email.com",prop1.getEmail());
	}
	
	@Test
	public void testGetTelefono() {
		
		assertEquals(1526248982,prop1.getTelefono().intValue());
	}
	
	@Test
	public void testSettersUsuario() {
		
		prop2.setNombre("Daniel");
		prop2.setApellido("Cross");
		prop2.setEmail("cross@email.com");
		prop2.setTelefono(1541258763);
		
		assertEquals("Daniel",prop2.getNombre());
		assertEquals("Cross",prop2.getApellido());
		assertEquals("cross@email.com",prop2.getEmail());
		assertEquals(1541258763,prop2.getTelefono().intValue());
	}
	
	
	@Test
	public void testUsuarioNoRegistradoNoPuedeReservar() {
		
		assertFalse(web.getUsuariosRegistrados().contains(prop2));
	}
	
	@Test
	public void testUsuarioRegistradoPuedeReservar() {
		prop1.registrarse(web);
		
		assertTrue(web.getUsuariosRegistrados().contains(prop1));
	}
	

	
	@Test
	public void testCuandoUsuarioPublicaInmuebleSeConvierteEnPropietario() {
		// no   seeee
		assertTrue(false);
	}
	

	
}
