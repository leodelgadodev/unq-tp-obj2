package excepciones;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestExcepciones {

	Exception inmuebleInvalido = new InmuebleInvalidoException();
	Exception noRegistrado = new UsuarioNoRegistradoException();
	Exception error403 = new ForbiddenException();

	@Test
	void testInmuebleInvalidoE() {
		assertThrows(InmuebleInvalidoException.class, () -> {throw inmuebleInvalido;});
	}
	
	@Test
	void testNoRegistradoE() {
		assertThrows(UsuarioNoRegistradoException.class, () -> {throw noRegistrado;});
	}
	
	@Test
	void testForbiddenE() {
		assertThrows(ForbiddenException.class, () -> {throw error403;});
	}

}
