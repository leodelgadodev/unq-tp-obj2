package reserva;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import usuario.Usuario;

class TestReserva {
	
	SitioWeb web = new SitioWeb();

	Usuario solicitante = mock (Usuario.class);
	Usuario propietario = mock (Usuario.class);
	Inmueble i = mock(Inmueble.class);
	
	Reserva r = new Reserva();
	
	
	@BeforeEach
	void setUp() throws Exception {
		r.setSolicitante(solicitante);
		r.setPropietario(propietario);
		r.setInmueble(i);
	}
	
	@Test
	void testConstructorReserva() {
		assertEquals(solicitante, r.getSolicitante());
		assertEquals(i, r.getInmueble());
		assertEquals(propietario, r.getPropietario());
	}
	
	@Test
	void testSettersReserva() {
		Usuario u_ = mock(Usuario.class);
		Usuario p_ = mock(Usuario.class);
		Inmueble i_ = mock(Inmueble.class);
		
		r.setSolicitante(u_);
		assertEquals(u_, r.getSolicitante());
		
		r.setPropietario(p_);
		assertEquals(p_, r.getPropietario());
		
		
		r.setInmueble(i_);
		assertEquals(i_, r.getInmueble());
	}
	
	@Test
	void testDeSetterDeFechas() {
		r.setFechaDeInicio("2019-05-10");
		r.setFechaFinal("2019-05-20");
		
		assertEquals(LocalDate.parse("2019-05-10"),r.getFechaInicio());
		assertEquals(LocalDate.parse("2019-05-20"),r.getFechaFinal());
	}
	
}