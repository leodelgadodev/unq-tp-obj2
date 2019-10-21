package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import excepciones.ForbiddenException;
import excepciones.UsuarioNoRegistradoException;
import reserva.Reserva;

class TestUsuario {

	SitioWeb web = new SitioWeb();
	private Set<String> servicios = new HashSet<String>();
	
	Usuario prop1 = new UsuarioPropietario("Leo","Delgado", "leo@email.com", 1526248982);
	Usuario prop2 = new UsuarioPropietario("Gonza","Torrez", "gonza@email.com", 1585248596);
	Usuario inquilino = new Usuario("Daniel", "Cross","cross@gmail.com",1553986574);
	
	Inmueble casa1 = new Inmueble(prop1, "Casa", "BsAs", "Argentina","calle 123" , 
			servicios, 5,"2019-01-01","2019-01-30", "08:30", "17:00", 2500.0);
	
	Inmueble casa2 = new Inmueble(prop1, "Casa", "Cordoba", "Argentina","calle 53" , 
			servicios, 10,"2019-06-01","2019-06-20", "09:30", "19:00", 3500.0);
	
	Inmueble casa3 = new Inmueble(prop2, "Casa", "BsAs", "Argentina","calle 18" , 
			servicios, 3,"2019-01-01","2019-01-20", "10:30", "18:00", 4000.0);
	
	@BeforeEach
	void setUp() throws Exception {
		
		casa1.agregarServicio("Desayuno");
		casa2.agregarServicio("Wifi");
		casa3.agregarServicio("Agua");
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);
		
	}
	
	@Test
	public void testGettersUsuario() {
		
		assertEquals("Leo",prop1.getNombre());
		assertEquals("Delgado",prop1.getApellido());
		assertEquals("leo@email.com",prop1.getEmail());
		assertEquals(1526248982,prop1.getTelefono().intValue());
	}
	
	@Test
	public void testSettersUsuario() {
		
		prop2.setNombre("Daniel");
		prop2.setApellido("Cross");
		prop2.setEmail("cross@email.com");
		prop2.setTelefono(1541258763);
		prop2.setMailRecibido(true);
		
		assertEquals("Daniel",prop2.getNombre());
		assertEquals("Cross",prop2.getApellido());
		assertEquals("cross@email.com",prop2.getEmail());
		assertEquals(1541258763,prop2.getTelefono().intValue());
		assertTrue(prop2.mailRecibido());
	}
	
	
	@Test
	public void testUsuarioNoRegistradoNoPuedeReservar() {
		
		assertFalse(web.getUsuariosRegistrados().contains(prop2));
		
		assertThrows(UsuarioNoRegistradoException.class, () -> {
			prop2.reservarInmueble(casa3, "2020-01-01", "2020-01-02");
		});
	}

	@Test
	public void testUsuarioRegistradoPuedeReservar() throws ForbiddenException {
		
		web.darDeAlta(prop1);
		assertTrue(web.getUsuariosRegistrados().contains(prop1));
		
		prop1.reservarInmueble(casa3, "2019-01-01", "2019-01-02");
		
		assertEquals(1, prop2.getReservasPendientesDeAprobacion().size());
	}
	
	
	@Test
	public void testSeleccionarInmueble() {
		List<Inmueble> busqueda = web.buscarInmuebles("BsAs", "2019-01-04", "2019-01-14");
		
		assertEquals(2, busqueda.size());
		
		Inmueble inmuebleSeleccionado = inquilino.seleccionarInmueble("BsAs", "2019-01-04", "2019-01-14", 1);
		assertNotNull(inmuebleSeleccionado);
		assertEquals(prop1, inmuebleSeleccionado.getPropietario());
	}
	
	@Test
	public void testAddReserva() {
		assertThrows(ForbiddenException.class, () -> {inquilino.addReserva(mock(Reserva.class));});
	}
	
	@Test
	public void testAceptarReservaDe() {
		assertThrows(ForbiddenException.class, () -> {inquilino.aceptarReservaDe(mock(Usuario.class));});
	}
	
	@Test
	public void testThrowsExceptionGetReservasPendientesDeAprobacion() {
		assertThrows(ForbiddenException.class, () -> {inquilino.getReservasPendientesDeAprobacion();});
	}
	
	@Test
	public void testMailRecibido() {
		assertFalse(prop1.mailRecibido());
	}
}
