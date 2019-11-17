package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import excepciones.InmuebleInvalidoException;
import reserva.Reserva;
import usuario.Usuario;

import static org.mockito.Mockito.*;

class TestSitioWeb {

	SitioWeb web = new SitioWeb();
	
	ArrayList<String> a = new ArrayList<>();
	Set<String> servicios = new HashSet<String>(); 
	
	Inmueble casa = mock(Inmueble.class);
	
	Inmueble departamento = mock(Inmueble.class);
	
	Inmueble quincho = mock(Inmueble.class);
	
	@BeforeEach
	void setUp() throws Exception {
		
		web.ponerEnAlquiler(casa);
		web.ponerEnAlquiler(departamento);
		web.ponerEnAlquiler(quincho);
		
		when(casa.getCiudad()).thenReturn("BsAs");
		when(departamento.getCiudad()).thenReturn("BsAs");
		when(quincho.getCiudad()).thenReturn("Cordoba");
		
		when(casa.getFechaDeInicio()).thenReturn(LocalDate.parse("2019-01-01"));
		when(casa.getFechaFinal()).thenReturn(LocalDate.parse("2019-01-30"));
		when(casa.getHoraCheckIn()).thenReturn(LocalTime.parse("08:30"));
		when(casa.getHoraCheckOut()).thenReturn(LocalTime.parse("17:00"));
		
		when(departamento.getFechaDeInicio()).thenReturn(LocalDate.parse("2019-01-01"));
		when(departamento.getFechaFinal()).thenReturn(LocalDate.parse("2019-01-20"));
		when(departamento.getHoraCheckIn()).thenReturn(LocalTime.parse("10:30"));
		when(departamento.getHoraCheckOut()).thenReturn(LocalTime.parse("18:00"));
		
		when(quincho.getFechaDeInicio()).thenReturn(LocalDate.parse("2019-06-01"));
		when(quincho.getFechaFinal()).thenReturn(LocalDate.parse("2019-06-20"));
		when(quincho.getHoraCheckIn()).thenReturn(LocalTime.parse("09:30"));
		when(quincho.getHoraCheckOut()).thenReturn(LocalTime.parse("19:00"));
		
		when(casa.getTipoDeInmueble()).thenReturn("Casa");
		
	}


	@Test
	public void testCantidadDeInmueblesEnAlquiler() {
	
		assertEquals(3,web.getInmuebles().size());
	}

	
	@Test
	public void getTiposDeInmueble() {
		
		Set<String> inmueblesEsperados = new HashSet<String>();
		inmueblesEsperados.add("Casa");
		
		web.agregarTipoDeInmueble("Casa");
		
		assertEquals(inmueblesEsperados,web.getTiposInmueble());
	}
	
	@Test
	public void agregarServiciosDeInmuebles() {//
		
		web.agregarServiciosDeInmuebles("Agua");
		assertFalse(web.getServiciosInmuebles().isEmpty());
	}
	
	@Test
	public void getServiciosDeInmueble() {
		Set<String> serviciosEsperados = new HashSet<String>();
		serviciosEsperados.add("Agua");
		serviciosEsperados.add("Luz");
		
		web.agregarServiciosDeInmuebles("Agua");
		web.agregarServiciosDeInmuebles("Luz");
		
		assertEquals(serviciosEsperados,web.getServiciosInmuebles());
	}
	
	@Test
	public void testCantidadInmuebles() { 
		
		assertEquals(2,web.buscarInmuebles("BsAs","2019-01-01", "2019-01-14").size());
	
		assertEquals(1,web.buscarInmuebles("BsAs","2019-01-01", "2019-01-30").size());
	}
	
	
	@Test
	public void testGetInmueblesDe() {
		when(departamento.getCiudad()).thenReturn("BsAs");
		assertEquals(2,web.getInmueblesDe("BsAs").size());
	}
	 
	@Test
	public void testBuscarInmueblesPorCiudadYFechas() {
		
		List<Inmueble> resultado = new ArrayList<Inmueble>();
		
		resultado.add(quincho);
		
		assertEquals(resultado,web.buscarInmuebles("Cordoba", "2019-06-10", "2019-06-18"));
	}
	
	@Test 
	public void testBuscarInmueblesPorCiudadYFechas2() {
		
		List<Inmueble> resultado = new ArrayList<Inmueble>();
		resultado.add(departamento);
		resultado.add(casa);
		
		assertEquals(resultado,web.buscarInmuebles("BsAs", "2019-01-10", "2019-01-14"));
	}

	
	@Test
	public void agregarReservaConcretada() { ////
		web.agregarReserva(mock(Reserva.class));
		assertEquals(1,web.getReservas().size());
	}
	
	@Test
	public void getReservasConcretadas() { /////
		assertEquals(0,web.getReservas().size());
		web.agregarReserva(mock(Reserva.class));
		assertEquals(1,web.getReservas().size());
	}
}




