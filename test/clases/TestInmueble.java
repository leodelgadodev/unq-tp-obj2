package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usuario.Usuario;
import usuario.UsuarioPropietario;

class TestInmueble {

	Set<String> servicios = new HashSet<>();
	Set<String> serviciosTest = new HashSet<>();
	Usuario prop = new UsuarioPropietario(null, null, null, null);
	Inmueble i = new Inmueble(
			prop,
			"Casa",
			"BsAs",
			"Argentina",
			"Roque Sáenz Peña 352",
			servicios,
			4,
			"2020-01-01",
			"2020-01-30",
			"08:00",
			"22:00",
			7000.00
			);
	
	@BeforeEach
	void setUp() throws Exception {
		servicios.add("Gas");
		servicios.add("Agua");
		servicios.add("Wifi");
		
		serviciosTest.add("Agua");

	}

	@Test
	public void testGettersInmueble() {

		assertEquals(prop,i.getPropietario());
		assertNotNull(i.getTipoDeInmueble());
		assertNotNull(i.getCiudad());
		assertNotNull(i.getPais());
		assertNotNull(i.getDireccion());
		assertNotNull(i.getServicios());
		assertNotNull(i.getCapacidad());
		assertNotNull(i.getFechaDeInicio());
		assertNotNull(i.getFechaFinal());
		assertNotNull(i.getHoraCheckIn());
		assertNotNull(i.getHoraCheckOut());
		assertNotNull(i.getPrecio());
	}
	
	@Test
	public void testSettersInmueble() {
		
		i.setPropietario(mock(UsuarioPropietario.class));
		i.setTipoDeInmueble("Habitacion");
		i.setCiudad("Santiago");
		i.setPais("Chile");
		i.setDireccion("Grove Street");
		i.setServicios(serviciosTest);
		i.setCapacidad(80);
		i.setFechaDeInicio("2020-02-01");
		i.setFechaFinal("2020-02-02");
		i.setHoraCheckIn("06:00");
		i.setHoraCheckOut("21:00");
		i.setPrecio(2000.00);
		
		assertNotEquals(prop, i.getPropietario());
		assertEquals( "Habitacion", i.getTipoDeInmueble());
		assertEquals( "Santiago", i.getCiudad());
		assertEquals( "Chile", i.getPais());
		assertEquals( "Grove Street", i.getDireccion());
		assertEquals(1, i.getServicios().size());
		assertEquals( 80, i.getCapacidad());
		assertEquals( LocalDate.of(2020, 02, 01), i.getFechaDeInicio());
		assertEquals( LocalDate.of(2020, 02, 02), i.getFechaFinal());
		assertEquals( LocalTime.of(06, 00), i.getHoraCheckIn());
		assertEquals( LocalTime.of(21, 00), i.getHoraCheckOut());
		assertEquals( 2000.00, i.getPrecio(), 0);
	}
	
	@Test
	public void testAgregarServicio() {
		i.agregarServicio("Gas");
		i.agregarServicio("Wifi");
		i.agregarServicio("Agua");
		assertEquals(servicios,i.getServicios());
	}
	
	@Test
	public void testReservar() {
		assertFalse(i.estaReservado());
		
		i.reservar();
		assertTrue(i.estaReservado());
	}

}
