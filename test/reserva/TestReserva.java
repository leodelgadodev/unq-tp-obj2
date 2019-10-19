package reserva;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Inmueble;
import clases.SitioWeb;
import usuario.Usuario;

class TestReserva {

	//private Set<String> servicios = mock(HashSet.class); EJEMPLO DE MOCK
	private Set<String> servicios = new HashSet<String>();
	
	SitioWeb web = new SitioWeb();
	Usuario user = new Usuario(web,"u","us","u@mail",12345678);
	Usuario propietario = new Usuario(web,"p","pr","p@mail",87654321);
	Inmueble i = new Inmueble(
			propietario,
			"Casa",
			"BsAs",
			"Argentina",
			"Roque Sáenz Peña 352",
			servicios,
			4,
			"01/01/2020",
			"30/01/2020",
			"08:00",
			"22:00",
			7000.00
			);
	
	Reserva r = new Reserva(user,propietario,i,"01/01/2020","14/01/2020");
	
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testConstructorReserva() {

		assertFalse(r.getEstatus());
		assertEquals(user, r.getInquilino());
		assertEquals(propietario, r.getPropietario());
		assertEquals(i, r.getInmueble());
		assertEquals(LocalDate.of(2020, 1, 1), r.getFechaInicio());
		assertEquals(LocalDate.of(2020, 1, 14), r.getFechaFin());
	}
	
	@Test
	void testSettersReserva() {
		Usuario u_ = mock(Usuario.class);
		Usuario p_ = mock(Usuario.class);
		Inmueble i_ = mock(Inmueble.class);
		String inicio = "2/1/2020";
		String fin = "15/1/2020";
		
		r.setInquilino(u_);
		assertEquals(u_, r.getInquilino());
		
		r.setPropietario(p_);
		assertEquals(p_, r.getPropietario());
		
		
		r.setInmueble(i_);
		assertEquals(i_, r.getInmueble());
		
		r.setFechaInicio(inicio);
		assertEquals(LocalDate.of(2020, 1, 15),r.getFechaInicio());
		
		r.setFechaFin(fin);
		assertEquals(LocalDate.of(2020, 1, 15), r.getFechaFin());
	}
	
	@Test
	void testUsuarioIniciaReserva() {
		
		user.buscarInmuebles("BsAs","1/1/2020","1/30/2020");
		user.reservarInmueble(i);
		
		assertEquals(1, i.getPropietario().getReservasPendientesDeAprobacion().size());
		
		
	}
	
	@Test
	void testPropietarioAceptaReserva() {
		
		assertEquals(1, propietario.getReservasPendientesDeAprobacion().size());
		assertFalse(i.estaReservado());
		
		propietario.aceptarReservaDe(user);
		
		assertTrue(r.getEstatus());
		assertEquals(1, user.getReservasConcretadas().size());
		assertEquals(1, web.getReservasConcretadas().size());
		
		assertEquals(0, propietario.getReservasPendientesDeAprobacion().size());
		
		assertTrue(i.estaReservado());
	}

	@Test
	void testConcretarReserva() {
		// 1) Usuario Busca inmuebles
		
		// 2) visualizar inmueble
		// - ver comentarios
		// - ver puntaje que le dio c/usuario (junto con el comentario)
		// - ver promedio total del inmueble y promedios de categorias de puntajes
		// - ver propietario (puntaje promedio total y puntaje que le dieron c/usuario)
		
		// 3) usuario reservar
		
		// 4) dueño puede visualizar usuario
		
		// 5) propietario aceptar reserva
		
		// 6) reserva queda registrada en el sistema
		
		// 2) y 4) NO entran para este hito
		
		web.ponerEnAlquiler(i); //
		
		
		
		
		propietario.aceptarReservaDe(user);
		
	}

}
