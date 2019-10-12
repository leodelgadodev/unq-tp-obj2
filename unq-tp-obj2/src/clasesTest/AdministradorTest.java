package clasesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import clases.Administrador;
import clases.SitioWeb;

public class AdministradorTest {

	// "Dar de alta" siginifca agregar nuevos
	
	Administrador admin = new Administrador();
	SitioWeb web = new SitioWeb();
	
	@Test
	public void administradorConoceAlSitioWeb() {
		admin.setSitioWeb(web);
		
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
		
		admin.crearCategoriaDeRankingInquilino(a);
		
		assertEquals(3, web.getCategoriasRankingInquilino().size());
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
