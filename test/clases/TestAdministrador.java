package clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdministrador {

	// "Dar de alta" siginifca agregar nuevos
	
		// Tests dan Null y no se por que, arreglar - Leo
		
		Administrador admin = new Administrador();
		SitioWeb web = new SitioWeb();
		
	@BeforeEach
	void setUp() throws Exception {
		admin.setSitioWeb(web);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void administradorConoceAlSitioWeb() {
		
		
		assertNotNull(admin.getSitioWeb());
	}
	
	@Test
	public void darDeAltaCategoriasUtilizadasParaRankearPropietarios() {
		

		admin.crearCategoriaDeRankingPropietario("Disponibilidad");
		
		assertEquals(1, web.getCategoriasRankingPropietario().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Cordialidad");
		a.add("Solvencia ante problemas");
		
		admin.crearCategoriaDeRankingPropietario(a);
	
		assertEquals(3, web.getCategoriasRankingPropietario().size());
		
	}
	
	@Test
	public void darDeAltaCategoriasUtilizadasParaRankearInquilinos() {
		
		
		admin.crearCategoriaDeRankingInquilino("Cordialidad");
		
		assertEquals(1, web.getCategoriasRankingInquilino().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Puntualidad");
		a.add("Disponibilidad");
		
		admin.crearCategoriaDeRankingInquilino("hospitalidad");
		
		assertEquals(2, web.getCategoriasRankingInquilino().size());
		
		admin.crearCategoriaDeRankingInquilino(a);
		
		assertEquals(4, web.getCategoriasRankingInquilino().size());
	}
	
	@Test
	public void darDeAltaCategoriasUtilizadasParaRankearInmuebles() {
		
		
		admin.crearCategoriaDeRankingInmueble("Ubicación");
		
		assertEquals(1, web.getCategoriasRankingInmueble().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Limpieza");
		a.add("Servicios");
		
		admin.crearCategoriaDeRankingInmueble(a);
		
		assertEquals(3, web.getCategoriasRankingInmueble().size());
	}
	
	@Test
	public void darDeAltaTipoDeInmuebles() {
		
		
		admin.darDeAltaTipoDeInmueble("Quincho");
		
		assertEquals(1, web.getTiposInmueble().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Habitacion");
		a.add("Departamento");
		a.add("Casa");
		
		admin.darDeAltaTipoDeInmueble(a);
		
		assertEquals(4, web.getTiposInmueble().size());
	}
	
	@Test
	public void darDeAltaServiciosDeInmuebles() {
		
		
		admin.darDeAltaServiciosDeInmuebles("Wifi");
		
		assertEquals(1, web.getServiciosInmuebles().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Agua potable");
		a.add("Gas");
		a.add("Pensión completa");
		
		admin.darDeAltaServiciosDeInmuebles(a);
		
		assertEquals(4, web.getServiciosInmuebles().size());
		
	}

}
