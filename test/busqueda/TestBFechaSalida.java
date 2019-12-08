package busqueda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import clases.Inmueble;

class TestBFechaSalida {

	@BeforeEach
	void setUp() throws Exception {
		
	}
	
	@Test
	public void buscar() {
		IBusquedaParamDate bFechaSalida = new BFechaSalida();
		
		Set<Inmueble> iSet = new HashSet<>();
		Inmueble i1 = mock(Inmueble.class);
		Inmueble i2 = mock(Inmueble.class);
		
		when(i1.getFechaFinal()).thenReturn(LocalDate.parse("2019-01-30"));
		when(i2.getFechaFinal()).thenReturn(LocalDate.parse("2019-01-01"));
		iSet.add(i1);
		iSet.add(i2);
		
		assertTrue(bFechaSalida.buscar(LocalDate.of(2020, 01, 30), null).isEmpty());
		assertEquals(1, bFechaSalida.buscar(LocalDate.of(2019, 01, 29), iSet).size());
	}
}
