package clasesTest;

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
		
		assertEquals(1, web.categoriasRankingPropietario().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Cordialidad");
		a.add("Solvencia ante problemas");
		
		admin.crearCategoriaDeRankingPropietario(a);
	
		assertEquals(3, web.categoriasRankingPropietario().size());
		
	}
	
	@Test
	public void darDeAltaCategoriasUtilizadasParaRankearInquilinos() {
		admin.crearCategoriaDeRankingInquilino("Cordialidad");
		
		assertEquals(1, web.categoriasRankingInquilino().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Puntualidad");
		a.add("Disponibilidad");
		
		admin.crearCategoriaDeRankingInquilino(a);
		
		assertEquals(3, web.categoriasRankingInquilino().size());
	}
	
	@Test
	public void darDeAltaCategoriasUtilizadasParaRankearInmuebles() {
		admin.crearCategoriaDeRankingInmueble("Ubicación");
		
		assertEquals(1, web.categoriasRankingInmueble().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Limpieza");
		a.add("Servicios");
		
		admin.crearCategoriaDeRankingInmueble(a);
		
		assertEquals(3, web.categoriasRankingInmueble().size());
	}
	
	@Test
	public void darDeAltaTiposDeInmuebles() {
		admin.darDeAltaTipoDeInmueble("Quincho");
		
		assertEquals(1, web.tiposDeInmueble().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Habitacion");
		a.add("Departamento");
		a.add("Casa");
		
		admin.darDeAltaTipoDeInmueble(a);
		
		assertEquals(4, web.tiposDeInmueble().size());
	}
	
	@Test
	public void darDeAltaServiciosDeInmuebles() {
		admin.darDeAltaServicioDeInmuebles("Wifi");
		
		assertEquals(1, web.serviciosDeInmuebles().size());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Agua potable");
		a.add("Gas");
		a.add("Pensión completa");
		
		admin.darDeAltaServicioDeInmuebles(a);
		
		assertEquals(4, web.serviciosDeInmuebles().size());
		
		
	}
}
