package excepciones;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestExcepciones {

	Exception inmuebleInvalido = new InmuebleInvalidoException();
	Exception noRegistrado = new UsuarioNoRegistradoException();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testInmuebleInvalidoE() {
		fail("Not yet implemented");
	}
	
	@Test
	void testNoRegistradoE() {
		fail("Not yet implemented");
	}

}
