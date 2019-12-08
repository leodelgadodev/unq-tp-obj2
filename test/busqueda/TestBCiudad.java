package busqueda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import clases.Inmueble;

public class TestBCiudad {

	
	@Test
	public void buscar() {
		
		IBusquedaParamString bCiudad = new BCiudad();
		
		Set<Inmueble> iSet = new HashSet<>();
		Inmueble i1 = mock(Inmueble.class);
		Inmueble i2 = mock(Inmueble.class);
		
		when(i1.getCiudad()).thenReturn("BsAs");
		when(i2.getCiudad()).thenReturn("Cordoba");
		iSet.add(i1);
		iSet.add(i2);
		
		assertTrue(bCiudad.buscar("Bariloche", iSet).isEmpty());
		assertEquals(1, bCiudad.buscar("BsAs", iSet).size());
	}
}
