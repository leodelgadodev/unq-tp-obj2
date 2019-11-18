package reserva;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

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
	
	Reserva r = new Reserva(u,prop, i);
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	void testConstructorReserva() {
		assertEquals(u, r.getSolicitante());
		assertEquals(i, r.getInmueble());
		
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
	
}