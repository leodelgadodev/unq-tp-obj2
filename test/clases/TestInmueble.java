package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import usuario.Usuario;
import usuario.UsuarioPropietario;

class TestInmueble {

	Set<String> servicios = new HashSet<>();
	Set<String> serviciosTest = new HashSet<>();
	Usuario prop = new UsuarioPropietario(null,null, null, null, null);
	Inmueble i = new Inmueble(
			prop,
			"Casa",
			"BsAs",
			"Argentina",
			"Roque Sáenz Peña 352",
			servicios,
			4,
			"08:00",
			"22:00",
			7000.00
			);
	
	@BeforeEach
	void setUp() throws Exception {
		servicios.add("Gas");
		servicios.add("Agua");
		servicios.add("Wifi");
		
		serviciosTest.add("Agua");
		serviciosTest.add("Gas");
		serviciosTest.add("Wifi");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void inmuebleConstructor() {

		assertNotNull(i);
	}
	
	@Test
	public void setPropietario() {
		i.setPropietario(null);
		assertEquals(null, i.getPropietario());
	}
	
	@Test
	public void setTipoDeInmueble() {
		// Que pasa si trato de setear un tipo de inmueble que no fue
		// dado de alta por el admin? - Leo
		i.setTipoDeInmueble("Quincho");
		assertEquals("Quincho", i.getTipoDeInmueble());
	}
	
	@Test
	public void setCiudad() {
		i.setCiudad("Bernal");
		assertEquals("Bernal",i.getCiudad());
	}
	
	@Test
	public void setPais() {
		i.setPais("Uruguay");
		assertEquals("Uruguay",i.getPais());
	}
	
	@Test
	public void setDireccion() {
		i.setDireccion("calle falsa");
		assertEquals("calle falsa", i.getDireccion());
	}
	
	@Test
	public void setServicios() {
		// Que pasa al intentar setear un servicio
		// que no fue dado de alta por el admin?
		
		i.setServicios(serviciosTest);
		assertEquals(serviciosTest,i.getServicios());
	}
	
	@Test
	public void agregarServicio() {
		i.agregarServicio("Desayuno");
		serviciosTest.add("Desayuno");
		assertEquals(serviciosTest,i.getServicios());
	}
	
	@Test
	public void setCapacidad() {
		i.setCapacidad(3);
		assertEquals(3, i.getCapacidad());
	}
	
	
	
	@Test
	public void setHorarioCheckIn() {
		
		i.setHoraCheckIn("00:00");
		assertEquals(LocalTime.of(00, 00),i.getHoraCheckIn());
	}
	
	@Test
	public void setHorarioCheckOut() {
		
		i.setHoraCheckOut("23:59");
		assertEquals(LocalTime.of(23, 59),i.getHoraCheckOut());
	}
	
	@Test
	public void setPrecio() {
		i.setPrecio(6500.00);
		assertEquals(6500.00, i.getPrecio(),0);
	}
	
	/*@Test
	public void setComentarios() {
		List<String> c = new ArrayList<>();
		c.add("Es bellísimo.");
		
		assertTrue(i.getComentarios().isEmpty());
		i.setComentarios(c);
		assertEquals(c,i.getComentarios());
	}*/
	
}
