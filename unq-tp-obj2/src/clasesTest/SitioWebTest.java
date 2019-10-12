package clasesTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import clases.SitioWeb;

public class SitioWebTest {
		
	SitioWeb web = new SitioWeb();
	String s = "StringTest"; // Debería ser un Mock y no strings así a lo bruto, cambiar - Leo
	
	ArrayList<String> a = new ArrayList<>();
	
	@Before
	public void setup() {
		a.add("ArrayTest1");
		a.add("ArrayTest2");		
	}
	
	
	@Test
	public void registrarUsuario() {
		
	}
	
	@Test
	public void registrarInmueble() {
		
	}
	
	@Test
	public void agregarCategoriaDeRankingPropietario() {
		
		web.agregarCategoriaDeRankingPropietario(s);
		assertFalse(web.getCategoriasRankingPropietario().isEmpty());
	}
	
	@Test
	public void getCategoriasDeRankingPropietario() {
		assertNotNull(web.getCategoriasRankingPropietario());
		assertTrue(web.getCategoriasRankingPropietario().isEmpty());
	}
	
	@Test
	public void agregarCategoriaDeRankingInquilino() {
		
		web.agregarCategoriaDeRankingInquilino(s);
		assertFalse(web.getCategoriasRankingInquilino().isEmpty());
	}
	
	@Test
	public void getCategoriasDeRankingInquilino() {
		assertNotNull(web.getCategoriasRankingInquilino());
		assertTrue(web.getCategoriasRankingInquilino().isEmpty());
	}
	
	@Test
	public void agregarCategoriaDeRankingInmueble() {
		
		web.agregarCategoriaDeRankingInnmueble(s);
		assertFalse(web.getCategoriasRankingInmueble().isEmpty());
	}
	
	@Test
	public void getCategoriasDeRankingInmueble() {
		assertNotNull(web.getCategoriasRankingInmueble());
		assertTrue(web.getCategoriasRankingInmueble().isEmpty());
	}
	
	@Test
	public void agregarTipoDeInmueble() {
		
		web.agregarTipoDeInmueble(s);
		assertFalse(web.getTiposInmueble().isEmpty());
	}
	
	@Test
	public void getTiposDeInmueble() {
		assertNotNull(web.getTiposInmueble());
		assertTrue(web.getTiposInmueble().isEmpty());
	}
	
	@Test
	public void agregarServiciosDeInmuebles() {
		
		web.agregarServiciosDeInmuebles(s);
		assertFalse(web.getServiciosInmuebles().isEmpty());
	}
	
	@Test
	public void getServiciosDeInmueble() {
		assertNotNull(web.getServiciosInmuebles());
		assertTrue(web.getServiciosInmuebles().isEmpty());
	}
	
	@Test
	public void agregarReservaConcretada() {
		
	}
	
	@Test
	public void agregarReservaPendiente() {
		
	}
}
