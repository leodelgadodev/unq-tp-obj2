package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import usuario.Usuario;

class TestSitioWeb {

	SitioWeb web = new SitioWeb();
	Administrador adm = new Administrador();
	ArrayList<String> a = new ArrayList<>();
	Set<String> servicios = new HashSet<String>(); 
	
	Inmueble casa1 = new Inmueble(mock(Usuario.class), "Casa", "BsAs", "Argentina","calle 123" , 
			servicios, 5,"2019-01-01","2019-01-30", "08:30", "17:00", 2500.0);
	
	Inmueble casa2 = new Inmueble(mock(Usuario.class), "Casa", "Cordoba", "Argentina","calle 53" , 
			servicios, 10,"2019-06-01","2019-06-20", "09:30", "19:00", 3500.0);
	
	Inmueble casa3 = new Inmueble(mock(Usuario.class), "Casa", "BsAs", "Argentina","calle 18" , 
			servicios, 3,"2019-01-01","2019-01-20", "10:30", "18:00", 4000.0);
	
	Inmueble casa4 = new Inmueble(mock(Usuario.class), "Casa", "BsAs", "Argentina","calle 18" , 
			servicios, 3,"2019-05-13","2019-05-25", "10:30", "18:00", 4000.0);
	
	@BeforeEach
	void setUp() throws Exception {
		adm.setSitioWeb(web);
		adm.darDeAltaServicioDeInmuebles("Agua");
		adm.darDeAltaTipoDeInmueble("Casa");
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
		web.ponerEnAlquiler(casa4);
	}

	@Test
	public void registrarUsuario() {
		web.darDeAlta(mock(Usuario.class));
		web.darDeAlta(mock(Usuario.class));
		assertEquals(2,web.getUsuariosRegistrados().size());
	}
	
	@Test
	public void darDeBajaUsuario() {
		Usuario u1 = mock(Usuario.class);
		
		web.darDeAlta(u1);
		web.darDeBajaUsuario(u1);
		
		assertEquals(0,web.getUsuariosRegistrados().size());
	}
	
	@Test
	public void testCantidadDeInmueblesEnAlquiler() {
	
		assertEquals(4,web.getInmuebles().size());
	}

	@Test
	public void agregarTipoDeInmueble() {
		
		web.agregarTipoDeInmueble("Casa");
		assertFalse(web.getTiposInmueble().isEmpty());
	}
	
	@Test
	public void getTiposDeInmueble() {
		
		Set<String> inmueblesEsperados = new HashSet<String>();
		inmueblesEsperados.add("Casa");
		
		assertEquals(inmueblesEsperados,web.getTiposInmueble());
	}
	
	@Test
	public void agregarServiciosDeInmuebles() {
		
		web.agregarServiciosDeInmuebles("Agua");
		assertFalse(web.getServiciosInmuebles().isEmpty());
	}
	
	@Test
	public void getServiciosDeInmueble() {
		adm.darDeAltaServicioDeInmuebles("Luz");
		Set<String> serviciosEsperados = new HashSet<String>();
		serviciosEsperados.add("Agua");
		serviciosEsperados.add("Luz");
		
		assertEquals(serviciosEsperados,web.getServiciosInmuebles());
	}
	
	@Test
	public void testCantidadInmuebles() { 
		
		assertEquals(2,web.buscarInmuebles("BsAs","2019-01-01", "2019-01-14").size());
	
		assertEquals(1,web.buscarInmuebles("BsAs","2019-01-01", "2019-01-30").size());
	}
	
	@Test
	public void testCiudadDeInmueble() {
		
		assertEquals("Cordoba",casa2.getCiudad());
	}
	
	@Test
	public void testGetInmueblesDe() {
		
		assertEquals(3,web.getInmueblesDe("BsAs").size());
	}
	 
	@Test
	public void testBuscarInmueblesPorCiudadYFechas() {
		
		List<Inmueble> resultado = new ArrayList<Inmueble>();
		
		resultado.add(casa2);
		
		assertEquals(resultado,web.buscarInmuebles("Cordoba", "2019-06-10", "2019-06-18"));
	}
	
	@Test 
	public void testBuscarInmueblesPorCiudadYFechas2() {
		
		List<Inmueble> resultado = new ArrayList<Inmueble>();
		resultado.add(casa3);
		resultado.add(casa1);
		
		assertEquals(resultado,web.buscarInmuebles("BsAs", "2019-01-10", "2019-01-14"));
	}
	
	@Test 
	public void testBuscarInmueblesPorCiudadYFechas3() {
		
		List<Inmueble> resultado = new ArrayList<Inmueble>();
		resultado.add(casa4);
		//resultado.add(casa1);
		//resultado.add(casa3);
		
		assertEquals(resultado,web.buscarInmuebles("BsAs", "2019-05-13", "2019-01-25"));
	}
	

	@Test
	public void testInmuebleValido() {
		Set<String> serviciosTest = new HashSet<String>();
		serviciosTest.add("Agua");

		assertTrue(web.esUnInmuebleValido("Casa", serviciosTest));
	}
	
	@Test
	public void testInmuebleInvalido() {
		Set<String> serviciosTest = new HashSet<String>();
		serviciosTest.add("Agua");

		assertTrue(web.esUnInmuebleValido("Casa", serviciosTest));
		
		serviciosTest.add("Spa");
		
		assertFalse(web.esUnInmuebleValido("Casa", serviciosTest));
	}
	

	@Test
	public void testAvisoInmuebleInvalidoException() {
		assertThrows(InmuebleInvalidoException.class, () -> {web.avisoInmuebleInvalido();});
	}
}




