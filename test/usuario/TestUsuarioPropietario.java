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
import reserva.Reserva;

class TestUsuarioPropietario {

	SitioWeb web = new SitioWeb();
	
	Usuario prop = new Usuario("Leo","Delgado", "leo@email.com", 8003333);
	
	Set<String> servicios = new HashSet<String>();
	
	Inmueble casa1 = mock(Inmueble.class);
	Inmueble casa2 = mock(Inmueble.class);
	Inmueble casa3 = mock(Inmueble.class);
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
		
		prop = new Usuario("Leo","Delgado", "leo@email.com", 8003333);
		
	}

	@Test
	public void testUsuarioPropietarioHeredaMetodosDeUsuario() {

		assertEquals("Leo",prop.getNombre());
		assertEquals("Delgado",prop.getApellido());
		assertEquals("leo@email.com",prop.getEmail());
		assertEquals(8003333,prop.getTelefono().intValue());
	}

	
	@Test
	public void testPropietarioRegistradoPuedePublicarInmuebleValido(){
		
		
		prop.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		
		Assert.assertEquals(4, web.getInmuebles().size());
	}

	@Test
	public void testUsuarioPropietarioAceptaReserva(){
		// Aceptar significa:
		// - registrar en sitio web (agregar reserva concretada)
		// - sitio web manda mail a usuario que se acepto la reserva
		// - se deben borrar todas las otras reservas que se intentaron hacer para ese inmueble
		// - propietario conoce reserva concretada de su inmueble
		
		
		prop1.publicarInmueble("Casa", "BsAs", "Argentina", "CABA 240", servicios, 3, "2021-01-01","2021-12-31","12:00", "10:00", 5000.00);
		Inmueble i = inquilino1.seleccionarInmueble("BsAs", "2021-01-01", "2021-01-14",0);
		
		inquilino1.reservarInmueble(i , "2021-01-01", "2021-01-14");
		prop2.reservarInmueble(i, "2021-01-01", "2021-01-15");
		
		Reserva r = prop1.getReservasPendientesDeAprobacion().get(0);
		prop1.aceptarReserva(r);
		
		assertEquals(0,prop1.getReservasPendientesDeAprobacion().size());
	}
	
	@Test
	public void testPropietarioEnviarMailA() {
		
		prop1.enviarMailA(inquilino1);
		
		assertTrue(inquilino1.mailRecibido());
	}
	
	@Test
	public void testGetReservasPendientesDeAprobacion() {
		assertEquals(0,prop1.getReservasPendientes().size());
	}
	
	@Test
	public void testAddRemoveReserva() {
		Reserva r = mock(Reserva.class);
		
		prop1.addReserva(r);
		assertEquals(1,prop1.getReservasPendientes().size());
		
		prop1.removeReserva(r);
		assertEquals(0,prop1.getReservasPendientes().size());
	}
	
	@Test
	public void testSetReservas() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(mock(Reserva.class));
		
		prop1.setReservasPendientesDeAprobacion(reservas);
		
		assertEquals(reservas, prop1.getReservasPendientes());
	}

}
