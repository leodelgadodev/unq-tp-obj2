package clasesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.Administrador;
import clases.SitioWeb;

public class AdministradorTest {

	// "Dar de alta" siginifca agregar nuevos
	
	// Tests dan Null y no se por que, arreglar - Leo
	
	Administrador admin = new Administrador();
	SitioWeb web = new SitioWeb();
	
	@Before
	public void setup() {
		admin.setSitioWeb(web);
	}
	
	
	@Test
	public void administradorConoceAlSitioWeb() {
		this.setup();
		
		assertNotNull(admin.getSitioWeb());
	}
	
	@Test
	public void darDeAltaCategoriasUtilizadasParaRankearPropietarios() {
		this.setup();

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
		this.setup();
		
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
		this.setup();
		
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
		this.setup();
		
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
		this.setup();
		
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
