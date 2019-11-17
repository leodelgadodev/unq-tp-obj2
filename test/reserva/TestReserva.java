package reserva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import excepciones.ForbiddenException;
import excepciones.InmuebleReservadoException;
import usuario.Usuario;

class TestReserva {

	private Set<String> servicios = new HashSet<String>();
	
	SitioWeb web = new SitioWeb();

	Usuario u = new Usuario("a","a","a@mail",11111111);
	Usuario prop = new Usuario("b","b","b@mail",22222222);
	
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
	
	Reserva r = new Reserva(u,prop,i,"2020-01-01","2020-01-14");
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void testConstructorReserva() {

		assertFalse(r.getEstatus());
		assertEquals(u, r.getInquilino());
		assertEquals(prop, r.getPropietario());
		assertEquals(i, r.getInmueble());
		assertEquals(LocalDate.of(2020, 1, 1), r.getFechaInicio());
		assertEquals(LocalDate.of(2020, 1, 14), r.getFechaFin());
	}
	
	@Test
	void testSettersReserva() {
		Usuario u_ = mock(Usuario.class);
		Usuario p_ = mock(Usuario.class);
		Inmueble i_ = mock(Inmueble.class);
		String inicio = "2020-01-02";
		String fin = "2020-01-15";
		
		r.setInquilino(u_);
		assertEquals(u_, r.getInquilino());
		
		r.setPropietario(p_);
		assertEquals(p_, r.getPropietario());
		
		
		r.setInmueble(i_);
		assertEquals(i_, r.getInmueble());
		
		r.setFechaInicio(inicio);
		assertEquals(LocalDate.of(2020, 1, 2),r.getFechaInicio());
		
		r.setFechaFin(fin);
		assertEquals(LocalDate.of(2020, 1, 15), r.getFechaFin());
		
		r.setEstatus(false);
		assertFalse(r.getEstatus());
	}
	
	@Test
	void testUsuarioIniciaReserva() throws ForbiddenException, InmuebleReservadoException {
		
		web.buscarInmuebles("BsAs","2020-01-01","2020-01-30");
		
		assertNotNull(i.getPropietario());
		u.reservarInmueble(i, "2020-01-01", "2020-01-25");
		
		assertEquals(1, i.getPropietario().getReservasPendientesDeAprobacion().size());	
	}
	
	@Test
	void testPropietarioAceptaReserva() throws ForbiddenException, InmuebleReservadoException {
		
		u.reservarInmueble(i, "2020-01-01", "2020-01-02");
		assertEquals(1, prop.getReservasPendientesDeAprobacion().size());
		
		
		prop.aceptarReserva(r);
		
		assertTrue(r.getEstatus());
		assertEquals(1, web.getReservasConcretadas().size());
		
		assertEquals(0, prop.getReservasPendientesDeAprobacion().size());
		
	}
	
	
}