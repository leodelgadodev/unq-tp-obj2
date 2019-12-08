package busqueda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import clases.Inmueble;

public class TestBFechaEntrada {
	
	@Test
	public void buscar() {
		IBusquedaParamDate bFechaEntrada = new BFechaEntrada();
		
		Set<Inmueble> iSet = new HashSet<>();
		Inmueble i1 = mock(Inmueble.class);
		Inmueble i2 = mock(Inmueble.class);
		
		when(i1.getFechaInicio()).thenReturn(LocalDate.parse("2020-01-25"));
		when(i2.getFechaInicio()).thenReturn(LocalDate.parse("2020-01-26"));
		iSet.add(i1);
		iSet.add(i2);
		
		assertTrue(bFechaEntrada.buscar(LocalDate.of(2020, 01, 27), iSet).isEmpty());
		assertEquals(2, bFechaEntrada.buscar(LocalDate.of(2019, 01, 24), iSet).size());
	}
}
