package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import clases.Inmueble;
import clases.SitioWeb;
import excepciones.ForbiddenException;
import excepciones.InmuebleInvalidoException;
import excepciones.InmuebleReservadoException;
import reserva.Reserva;

class TestUsuarioPropietario {

	private SitioWeb web = new SitioWeb();
	//private Administrador adm = new Administrador(web);
	private Set<String> servicios = new HashSet<String>();
	
	Usuario prop1 = new Usuario("Fer","Santacruz", "fer@email.com", 8001111);
	Usuario prop2 = new Usuario("Gonza","Torrez", "gonza@email.com", 8002222);
	Usuario prop3 = new Usuario("Leo","Delgado", "leo@email.com", 8003333);
	
	Usuario inquilino1 = new Usuario("Alguien3", "Lopez", "al@gmail.com", 42245225);
	
	Inmueble casa1 = new Inmueble( "Casa", "BsAs", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "08:30", "17:00", 2500.0);
	Inmueble casa2 = new Inmueble( "Casa", "Cordoba", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "09:30", "19:00", 3500.0);
	Inmueble casa3 = new Inmueble("Casa", "BsAs", "Argentina","calle 123" , null, 5,"2019-10-17","2019-10-25", "10:30", "18:00", 4000.0);
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
		
		prop1 = new Usuario("Fer","Santacruz", "fer@email.com", 8001111);
		prop2 = new Usuario("Gonza","Torrez", "gonza@email.com", 8002222);
		prop3 = new Usuario("Leo","Delgado", "leo@email.com", 8003333);
		
		servicios.add("Gas");
		servicios.add("Agua potable");
		servicios.add("Wifi");
		
		//adm.darDeAltaServicioDeInmuebles("Gas");
		//adm.darDeAltaServicioDeInmuebles("Agua potable");
		//adm.darDeAltaServicioDeInmuebles("Wifi");
		
		//adm.darDeAltaTipoDeInmueble("Casa");
		//adm.darDeAltaTipoDeInmueble("Habitacion");

		
	}

	@Test
	public void testUsuarioPropietarioHeredaMetodosDeUsuario() {

		assertEquals("Fer",prop1.getNombre());
		assertEquals("Santacruz",prop1.getApellido());
		assertEquals("fer@email.com",prop1.getEmail());
		assertEquals(8001111,prop1.getTelefono().intValue());
	}

	
	@Test
	public void testPropietarioRegistradoPuedePublicarInmuebleValido() throws InmuebleInvalidoException {
		
		
		prop1.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		
		Assert.assertEquals(4, web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioNoPuedePublicarInmuebleInvalidoPorServicio() throws InmuebleInvalidoException {
		servicios.add("Spa");
		
		assertThrows( InmuebleInvalidoException.class, () -> {
			prop2.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		});
		
		//adm.darDeAltaServicioDeInmuebles("Spa");
		prop2.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		assertEquals(4,web.getInmuebles().size());
	}
	
	@Test
	public void testPropietarioNoPuedePublicarInmuebleInvalidoPorTipo() throws  InmuebleInvalidoException {
		assertThrows( InmuebleInvalidoException.class, () -> {
			prop2.publicarInmueble("Penthouse", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		});
		
		//adm.darDeAltaTipoDeInmueble("Penthouse");
		prop2.publicarInmueble("Penthouse", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		assertEquals(4,web.getInmuebles().size());
	}

	/*@Test
	public void testUsuarioPropietarioAceptaReserva() throws UsuarioNoRegistradoException, InmuebleInvalidoException, ForbiddenException, InmuebleReservadoException {
		// Aceptar significa:
		// - registrar en sitio web (agregar reserva concretada)
		// - sitio web manda mail a usuario que se acepto la reserva
		// - se deben borrar todas las otras reservas que se intentaron hacer para ese inmueble
		// - propietario conoce reserva concretada de su inmueble
		web.darDeAlta(prop1);
		web.darDeAlta(prop2);
		web.darDeAlta(inquilino1);
		
		
		prop1.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		Inmueble i = inquilino1.seleccionarInmueble("BsAs", "2021-01-01", "2021-01-14",0);
		
		inquilino1.reservarInmueble(i , "2021-01-01", "2021-01-14");
		prop2.reservarInmueble(i, "2021-01-01", "2021-01-15");
		
		Reserva r = prop1.getReservasPendientesDeAprobacion().get(0);
		prop1.aceptarReserva(r);
		
		assertEquals(0,prop1.getReservasPendientesDeAprobacion().size());
	}*/
	
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
	
	@Test
	public void testSetReservas() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(mock(Reserva.class));
		
		prop1.setReservasPendientesDeAprobacion(reservas);
		
		assertEquals(reservas, prop1.getReservasPendientesDeAprobacion());
	}

}
