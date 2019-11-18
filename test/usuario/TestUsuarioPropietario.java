package usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import clases.Inmueble;
import clases.SitioWeb;
import reserva.Reserva;

class TestUsuarioPropietario {

	SitioWeb web = new SitioWeb();
	
	Usuario prop = new Usuario("Leo","Delgado", "leo@email.com", 8003333);
	Usuario inquilino1 = new Usuario("Gonza", "Torrez", "gonza@mail.com",8004444);
	Usuario prop2 = new Usuario("Gonza","Delgado", "gd@email.com", 8005555);
	
	Set<String> servicios = new HashSet<String>();
	
	Inmueble casa1 = mock(Inmueble.class);
	Inmueble casa2 = mock(Inmueble.class);
	Inmueble casa3 = mock(Inmueble.class);
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		web.ponerEnAlquiler(casa1);
		web.ponerEnAlquiler(casa2);
		web.ponerEnAlquiler(casa3);	
	}

	@Test
	public void testUsuarioPropietarioHeredaMetodosDeUsuario() {

		assertEquals("Leo",prop.getNombre());
		assertEquals("Delgado",prop.getApellido());
		assertEquals("leo@email.com",prop.getEmail());
		assertEquals(8003333,prop.getTelefono().intValue());
	}


}
