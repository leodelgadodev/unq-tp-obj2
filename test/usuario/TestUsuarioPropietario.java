package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;

class TestUsuarioPropietario {

	private SitioWeb web = new SitioWeb();
	private Set<String> servicios = new HashSet<String>();
	
	UsuarioPropietario prop1 = new UsuarioPropietario(web,"Fer","Santacruz", "fer@email.com", 8001111);
	UsuarioPropietario prop2 = new UsuarioPropietario(web,"Gonza","Torrez", "gonza@email.com", 8002222);
	UsuarioPropietario prop3 = new UsuarioPropietario(web,"Leo","Delgado", "leo@email.com", 8003333);
	
	Usuario inquilino1 = new Usuario(web,"Alguien3", "Lopez", "al@gmail.com", 42245225);
	
	Inmueble casa1 = new Inmueble(prop1, "casa1", "BsAs", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "08:30", "17:00", 2500.0);
	Inmueble casa2 = new Inmueble(prop2, "casa2", "Cordoba", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "09:30", "19:00", 3500.0);
	Inmueble casa3 = new Inmueble(prop3, "casa3", "BsAs", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "10:30", "18:00", 4000.0);
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
		
		 prop1 = new UsuarioPropietario(web,"Fer","Santacruz", "fer@email.com", 8001111);
		 prop2 = new UsuarioPropietario(web,"Gonza","Torrez", "gonza@email.com", 8002222);
		 prop3 = new UsuarioPropietario(web,"Leo","Delgado", "leo@email.com", 8003333);
		
		servicios.add("Gas");
		servicios.add("Agua potable");
		servicios.add("Wifi");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	

	
	@Test
	public void testDatosUsuarioPropietario() {
	
		
		assertEquals("Fer",prop1.getNombre());
		assertEquals("Santacruz",prop1.getApellido());
		assertEquals("fer@email.com",prop1.getEmail());
		assertEquals(8001111,prop1.getTelefono().intValue());
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
	
	@Test
	public void testPropietarioNoRegistradoNoPuedePublicar() {
		
		Assert.assertEquals(0, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioRegistradoPuedePublicarInmuebleValido() throws UsuarioNoRegistradoException, InmuebleInvalidoException {

		prop1.registrarse(web);
		prop1.publicarInmueble("Depto", "BsAs", "Argentina", "CABA 240", servicios, 3, "","","12:00", "10:00", 5000.00);
		
		
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
