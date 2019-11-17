package clases;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestInmueble {

 
	Set<String> servicios = new HashSet<>();
	
	Inmueble i = new Inmueble("Casa","BsAs","Argentina","Roque Saenz Peña 352", servicios, 4,"2020-01-01","2020-01-30","08:00","22:00",7000.00);
	
	@BeforeEach
	void setUp() throws Exception {
		
		servicios.add("Wifi");
		servicios.add("Agua");
		i.setServicios(servicios);
	}
	
	@Test
	public void testTipoPrecioYCapacidadDelInmueble() {
					
		assertEquals( "Casa", i.getTipoDeInmueble());
		assertEquals( 4, i.getCapacidad());
		assertEquals( 7000.00, i.getPrecio(), 0);
	}
	
	@Test
	public void testLocacionDeInmueble() {
				
		assertEquals( "BsAs", i.getCiudad());
		assertEquals( "Argentina", i.getPais());
		assertEquals( "Roque Saenz Peña 352", i.getDireccion());
	}
	
	@Test
	public void testFechasInmueble() {
				
		assertEquals( LocalDate.of(2020, 01, 01), i.getFechaDeInicio());
		assertEquals( LocalDate.of(2020, 01, 30), i.getFechaFinal());
	}
	
	@Test
	public void testHorariosCheckInmueble() {
				
		assertEquals( LocalTime.of(8, 00), i.getHoraCheckIn());
		assertEquals( LocalTime.of(22, 00), i.getHoraCheckOut());
		
	}
	
	@Test
	public void testAgregarServicios() {
		Set<String> serviciosEsperados = new HashSet<>();
		serviciosEsperados.add("Wifi");
		serviciosEsperados.add("Agua");
		
		assertEquals(serviciosEsperados,i.getServicios());
	}
}
