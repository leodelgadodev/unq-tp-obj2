package excepciones;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestExcepciones {

	Exception inmuebleInvalido = new InmuebleInvalidoException();
	Exception error403 = new ForbiddenException();
	Exception yaReservado = new InmuebleReservadoException();

	@Test
	void testInmuebleInvalidoE() {
		assertThrows(InmuebleInvalidoException.class, () -> {throw inmuebleInvalido;});
	}
	
	@Test
	void testForbiddenE() {
		assertThrows(ForbiddenException.class, () -> {throw error403;});
	}
	
	@Test
	void testReservadoE() {
		assertThrows(InmuebleReservadoException.class, () -> {throw yaReservado;});
	}

}
