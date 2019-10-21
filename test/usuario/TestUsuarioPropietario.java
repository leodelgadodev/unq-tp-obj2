package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Administrador;
import clases.Inmueble;
import clases.SitioWeb;
import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import reserva.Reserva;

class TestUsuarioPropietario {

	private SitioWeb web = new SitioWeb();
	private Administrador adm = new Administrador();
	private Set<String> servicios = new HashSet<String>();
	
	UsuarioPropietario prop1 = new UsuarioPropietario("Fer","Santacruz", "fer@email.com", 8001111);
	UsuarioPropietario prop2 = new UsuarioPropietario("Gonza","Torrez", "gonza@email.com", 8002222);
	UsuarioPropietario prop3 = new UsuarioPropietario("Leo","Delgado", "leo@email.com", 8003333);
	
	Usuario inquilino1 = new Usuario("Alguien3", "Lopez", "al@gmail.com", 42245225);
	
	Inmueble casa1 = new Inmueble(prop1, "Casa", "BsAs", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "08:30", "17:00", 2500.0);
	Inmueble casa2 = new Inmueble(prop2, "Casa", "Cordoba", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "09:30", "19:00", 3500.0);
	Inmueble casa3 = new Inmueble(prop3, "Casa", "BsAs", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "10:30", "18:00", 4000.0);
	
	
	@BeforeEach
	void setUp() throws Exception {
		adm.setSitioWeb(web);
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
		
		prop1 = new UsuarioPropietario("Fer","Santacruz", "fer@email.com", 8001111);
		prop2 = new UsuarioPropietario("Gonza","Torrez", "gonza@email.com", 8002222);
		prop3 = new UsuarioPropietario("Leo","Delgado", "leo@email.com", 8003333);
		
		servicios.add("Gas");
		servicios.add("Agua potable");
		servicios.add("Wifi");
		
		adm.darDeAltaServicioDeInmuebles("Gas");
		adm.darDeAltaServicioDeInmuebles("Agua potable");
		adm.darDeAltaServicioDeInmuebles("Wifi");
		
		adm.darDeAltaTipoDeInmueble("Casa");
		adm.darDeAltaTipoDeInmueble("Habitacion");

		web.darDeAlta(prop2);
	}

	@Test
	public void testUsuarioPropietarioHeredaMetodosDeUsuario() {

		assertEquals("Fer",prop1.getNombre());
		assertEquals("Santacruz",prop1.getApellido());
		assertEquals("fer@email.com",prop1.getEmail());
		assertEquals(8001111,prop1.getTelefono().intValue());
	}

	@Test
	public void testPropietarioNoRegistradoNoPuedePublicar() {

		assertThrows( UsuarioNoRegistradoException.class, () -> {
			prop1.publicarInmueble("Habitacion","Cordoba", "Argentina", "principal 1", servicios, 2, "2020-01-01", "2020-01-30", "10:30", "18:00", 8000.00);
		});
		
		Assert.assertEquals(3, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioRegistradoPuedePublicarInmuebleValido() throws UsuarioNoRegistradoException, InmuebleInvalidoException {
		
		web.darDeAlta(prop1);
		prop1.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		
		Assert.assertEquals(4, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioNoPuedePublicarInmuebleInvalidoPorServicio() throws UsuarioNoRegistradoException, InmuebleInvalidoException {
		servicios.add("Spa");
		
		assertThrows( InmuebleInvalidoException.class, () -> {
			prop2.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		});
		
		adm.darDeAltaServicioDeInmuebles("Spa");
		prop2.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		assertEquals(4,web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioNoPuedePublicarInmuebleInvalidoPorTipo() throws UsuarioNoRegistradoException, InmuebleInvalidoException {
		assertThrows( InmuebleInvalidoException.class, () -> {
			prop2.publicarInmueble("Penthouse", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		});
		
		adm.darDeAltaTipoDeInmueble("Penthouse");
		prop2.publicarInmueble("Penthouse", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		assertEquals(4,web.getInmuebles().size());
	}

	@Test
	public void testUsuarioPropietarioAceptaReserva() {
		// Aceptar significa:
		// - registrar en sitio web (agregar reserva concretada)
		// - sitio web manda mail a usuario que se acepto la reserva
		// - se deben borrar todas las otras reservas que se intentaron hacer para ese inmueble
		// - propietario conoce reserva concretada de su inmueble
		web.darDeAlta(prop1);
		
	}
	
	@Test
	public void testPropietarioEnviarMailA() {
		
		prop1.enviarMailA(inquilino1);
		
		assertTrue(inquilino1.mailRecibido());
	}
	
	@Test
	public void testGetReservasPendientesDeAprobacion() {
		assertEquals(0,prop1.getReservasPendientesDeAprobacion().size());
	}
	
	@Test
	public void testAddRemoveReserva() {
		Reserva r = mock(Reserva.class);
		
		prop1.addReserva(r);
		assertEquals(1,prop1.getReservasPendientesDeAprobacion().size());
		
		prop1.removeReserva(r);
		assertEquals(0,prop1.getReservasPendientesDeAprobacion().size());
	}

}
