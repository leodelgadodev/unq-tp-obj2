package reserva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import usuario.Usuario;

class TestReserva {
	
	SitioWeb web = new SitioWeb();

	Usuario u = mock (Usuario.class);
	Usuario prop = mock (Usuario.class);
	Inmueble i = mock(Inmueble.class);
	
	Reserva r = new Reserva(u,prop, i,"2020-01-01","2020-01-14");
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void testConstructorReserva() {

		assertFalse(r.getEstatus());
		assertEquals(u, r.getSolicitante());
		assertEquals(i, r.getInmueble());
		
	}
	
	@Test
	void testSettersReserva() {
		Usuario u_ = mock(Usuario.class);
		Usuario p_ = mock(Usuario.class);
		Inmueble i_ = mock(Inmueble.class);
		String inicio = "2020-01-02";
		String fin = "2020-01-15";
		
		r.setSolicitante(u_);
		assertEquals(u_, r.getSolicitante());
		
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
	
}