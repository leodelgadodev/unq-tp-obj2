package usuario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import clases.Inmueble;
import clases.SitioWeb;
import reserva.Reserva;

class TestUsuario {

	SitioWeb web = mock(SitioWeb.class);
	
	Usuario prop = new Usuario("Leo","Delgado", "leo@email.com", 8003333);
	Usuario inq = new Usuario("Gonza", "Torrez", "gonza@mail.com",8004444);

	
	Inmueble casa1 = mock(Inmueble.class);
	Inmueble casa2 = mock(Inmueble.class);
	Inmueble casa3 = mock(Inmueble.class);
	
	
	@BeforeEach
	void setUp() throws Exception { 
			
	}

	@Test
	public void propietarioPublicaInmueblesSuCantidadEsDos() {
		prop.publicarInmueble(casa1);
		prop.publicarInmueble(casa2);
		
		assertEquals(2,prop.getInmuebles().size());
	}
	
	@Test
	public void inquilinoReservaUnInmuebleElPropietarioObtieneUnaReserva() {
		Reserva r = mock(Reserva.class);
		
		inq.reservarInmueble(r, casa3, prop, "2019-03-10", "2019-03-20");
		
		assertEquals(1,prop.getReservasPendientes().size());
	}
	
	@Test
	public void propietarioAceptaUnaReservaSuReservasQuedanEnCero() {
		prop.publicarInmueble(casa1);
		prop.publicarInmueble(casa2);
		
		Reserva r = mock(Reserva.class);
		prop.addReservaPendiente(r);
		
		assertEquals(1,prop.getReservasPendientes().size());
		
		prop.aceptarReserva(r, web);
		
		assertEquals(0,prop.getReservasPendientes().size());
	}

}
