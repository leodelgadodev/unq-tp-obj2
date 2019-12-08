package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import busqueda.IBusquedaParamDate;
import busqueda.IBusquedaParamString;
import reserva.Reserva;
import usuario.Usuario;

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
		
		when(casa.getFechaInicio()).thenReturn(LocalDate.parse("2019-01-01"));
		when(casa.getFechaFinal()).thenReturn(LocalDate.parse("2019-01-30"));
		when(casa.getHoraCheckIn()).thenReturn(LocalTime.parse("08:30"));
		when(casa.getHoraCheckOut()).thenReturn(LocalTime.parse("17:00"));
		
		when(departamento.getFechaInicio()).thenReturn(LocalDate.parse("2019-01-01"));
		when(departamento.getFechaFinal()).thenReturn(LocalDate.parse("2019-01-20"));
		when(departamento.getHoraCheckIn()).thenReturn(LocalTime.parse("10:30"));
		when(departamento.getHoraCheckOut()).thenReturn(LocalTime.parse("18:00"));
		
		when(quincho.getFechaInicio()).thenReturn(LocalDate.parse("2019-06-01"));
		when(quincho.getFechaFinal()).thenReturn(LocalDate.parse("2019-06-20"));
		when(quincho.getHoraCheckIn()).thenReturn(LocalTime.parse("09:30"));
		when(quincho.getHoraCheckOut()).thenReturn(LocalTime.parse("19:00"));
		
		when(casa.getTipoDeInmueble()).thenReturn("Casa");
		
	}


	@Test
	public void testCantidadDeInmueblesEnAlquiler() {
		
		Usuario a = spy(new Usuario("Leo","Delgado", "leo@email.com", 8003333));
		Usuario b = spy(new Usuario("Gonza","Delgado", "gd@email.com", 8005555));
		
		a.publicarInmueble(mock(Inmueble.class));
		a.publicarInmueble(mock(Inmueble.class));
		
		b.publicarInmueble(mock(Inmueble.class));
		b.publicarInmueble(mock(Inmueble.class));
		b.publicarInmueble(mock(Inmueble.class));
		
		Set<Usuario> ls = new HashSet<Usuario>();
		ls.add(a);
		ls.add(b);
		web.setUsuarios(ls);
		
		
		assertEquals(5,web.obtenerInmueblesEnAlquiler().size());
	}

	
	@Test
	public void getTiposDeInmueble() {
		
		Set<String> inmueblesEsperados = new HashSet<String>();
		inmueblesEsperados.add("Casa");
		
		web.agregarTipoDeInmueble("Casa");
		
		assertEquals(inmueblesEsperados,web.getTiposInmueble());
	}
	
	@Test
	public void agregarServicioDeInmuebles() {
		
		web.agregarServicioDeInmuebles("Agua");
		assertFalse(web.getServiciosInmuebles().isEmpty());
	}
	
	@Test
	public void getServiciosDeInmueble() {
		Set<String> serviciosEsperados = new HashSet<String>();
		serviciosEsperados.add("Agua");
		serviciosEsperados.add("Luz");
		
		web.agregarServicioDeInmuebles("Agua");
		web.agregarServicioDeInmuebles("Luz");
		
		assertEquals(serviciosEsperados,web.getServiciosInmuebles());
	}

	@Test
	public void agregarReservaConcretada() { 
		web.agregarReserva(mock(Reserva.class));
		assertEquals(1,web.getReservas().size());
	}
	
	@Test
	public void getReservasConcretadas() { 
		assertEquals(0,web.getReservas().size());
		web.agregarReserva(mock(Reserva.class));
		assertEquals(1,web.getReservas().size());
	}
	
	@Test
	public void getEstrategiasDeBusqueda() {
		
		assertTrue(web.porCiudad() instanceof IBusquedaParamString);
		assertTrue(web.porEntrada() instanceof IBusquedaParamDate);
		assertTrue(web.porSalida() instanceof IBusquedaParamDate);
	}
	
	@Test
	public void buscar() {
		assertEquals(0, web.buscar(web.porCiudad(), "Bariloche").size());
		assertEquals(1, web.buscar(web.porCiudad(), "Cordoba").size());
		assertEquals(2, web.buscar(web.porCiudad(), "BsAs").size());
	}
	
	@Test
	public void buscarY() {
		Set<Inmueble> busqueda1 = web.buscar(web.porCiudad(), "BsAs");
		Set<Inmueble> busqueda2 = web.buscar(web.porSalida(), LocalDate.of(2019, 01, 29));
		Set<Inmueble> busqueda3 = web.buscar(web.porEntrada(), LocalDate.of(2019, 01, 01));
		
		assertEquals(3,busqueda3.size());
		assertEquals(1, web.buscarY(busqueda1, busqueda2).size());
	}
	
	@Test
	public void buscarCiudadEntreDosFechas() {
		LocalDate fEntrada = LocalDate.of(2019, 01, 01);
		LocalDate fSalida = LocalDate.of(2019, 01, 25);
		assertEquals(1,
				web.buscarY(
						web.buscarY(
								web.buscar(web.porEntrada(), fEntrada), web.buscar(web.porSalida(), fSalida)), 
				web.buscar(web.porCiudad(), "BsAs")).size());
	}
}




