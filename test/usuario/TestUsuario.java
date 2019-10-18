package usuario;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;

class TestUsuario {

	SitioWeb web = new SitioWeb(); 
	
	Usuario prop1 = new Usuario(web,"Fer","Santacruz", "fer@email.com", 8001111);
	Usuario prop2 = new Usuario(web,"Gonza","Torrez", "gonza@email.com", 8002222);
	Usuario prop3 = new Usuario(web,"Leo","Delgado", "leo@email.com", 8003333);
	
	Usuario inquilino1 = new Usuario(web,"Alguien3", "Lopez", "al@gmail.com", 42245225);
	
	Inmueble casa1 = new Inmueble(prop1, "casa1", "BsAs", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "08:30", "17:00", 2500.0);
	Inmueble casa2 = new Inmueble(prop2, "casa2", "Cordoba", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "09:30", "19:00", 3500.0);
	Inmueble casa3 = new Inmueble(prop3, "casa3", "BsAs", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "10:30", "18:00", 4000.0);
	
	@BeforeEach
	void setUp() throws Exception {
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
	}

	@Test
	void testBusquedaInmueblesConCiudadYFechas() {
		List<Inmueble> test = new ArrayList<Inmueble>();
		test.add(casa1);
		test.add(casa3);
		
		assertEquals(test, inquilino1.buscarInmuebles("BsAs","2019-10-17","2019-10-25"));
	}
	
	@Test
	void testBusquedaInmueblesConCiudadYFechas2() { // analizar y revisar  porque devuelve dos objetos, sera el Static que duplica?GT
		List<Inmueble> test = new ArrayList<Inmueble>();
		test.add(casa2);
		
		assertEquals(test, inquilino1.buscarInmuebles("Cordoba","2019-10-17","2019-10-25"));
	}
	
	/*
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
		assertTrue(true);
	}
	
	@Test
	public void testUsuarioRegistradoPuedeReservar() {
		prop1.registrarse(web);
		//Falta...
		assertTrue(true);
	}
	
	@Test
	public void testGetNombre() {
		
		assertEquals("Alguien3", inquilino1.getNombre());
	}
	
	@Test
	public void testGetApellido() {
		
		assertEquals("Lopez", inquilino1.getApellido());
	}
	
	@Test
	public void testGetEmail() {
		
		assertEquals("al@gmail.com", inquilino1.getEmail());
	}
	
	@Test
	public void testGetEdad() {
		
		assertEquals(42245225, inquilino1.getTelefono().intValue());
	}
	
	@Test
	public void testCuandoUsuarioPublicaInmuebleSeConvierteEnPropietario() {
		//Falta...
		assertTrue(true);
	}
	
	@Test
	public void testInquilinoNoRegistradoNoPuedeAlquilar() {
		assertTrue(true);
	}
	
	@Test
	public void testInquilinoRegistradoPuedeAlquilar() {
		assertTrue(true);
	}
	*/
}
