package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
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
	Usuario inquilino = new Usuario(web,"Daniel", "Cross","cross@gmail.com",1553986574);
	
	Inmueble casa1 = new Inmueble(prop1, "Casa", "BsAs", "Argentina","calle 123" , 
			servicios, 5,"2019-03-03","2019-03-15", "08:30", "17:00", 2500.0);
	
	Inmueble casa2 = new Inmueble(prop1, "Casa", "Cordoba", "Argentina","calle 53" , 
			servicios, 10,"2019-06-01","2019-06-20", "09:30", "19:00", 3500.0);
	
	Inmueble casa3 = new Inmueble(prop2, "Casa", "BsAs", "Argentina","calle 18" , 
			servicios, 3,"2019-04-03","2019-04-25", "10:30", "18:00", 4000.0);
	
	@BeforeEach
	void setUp() throws Exception {
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
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
	public void testBuscarInmuebles() { 
		
		Set<Inmueble> resultante = new HashSet<Inmueble>();
		resultante.add(casa1);
		//resultante.add(casa2);
		resultante.add(casa3);
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
		
		assertEquals(resultante,inquilino.buscarInmuebles("BsAs","2019-03-04", "2019-03-14"));
	}
	
	@Test // borralo despues de verlo.
	public void testConversor() { // somos idiotas! don java ya tenia metodos conversores 
		LocalDate l = LocalDate.parse("2017-03-03");
		LocalTime h = LocalTime.parse("18:30");
		assertEquals(LocalTime.of(18, 30),h);
		assertEquals(LocalDate.of(2017, 03, 03),l);
	}
	
//	@Test
//	public void testCuandoUsuarioPublicaInmuebleSeConvierteEnPropietario() {
		// no   seeee
//		assertTrue(false);
//	}
	

	
}
