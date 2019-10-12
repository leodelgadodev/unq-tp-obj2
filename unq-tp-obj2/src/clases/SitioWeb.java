package clases;

import java.util.ArrayList;
import java.util.List;

import reserva.Reserva;
import usuario.Usuario;

public class SitioWeb {
	
	private List<Usuario> usuariosRegistrados;
	private List<Inmueble> inmuebles;
	private List<Reserva> reservasPendientes;
	private List<Reserva> reservasConcretadas;
	
	private ArrayList<String> catRankProp;
	private ArrayList<String> catRankInqui;
	private ArrayList<String> catRankInmu;
	
	private ArrayList<String> tiposInmueble;
	private ArrayList<String> serviciosInmuebles;
	
	public SitioWeb() {
		
		this.usuariosRegistrados = new ArrayList<Usuario>();
		this.inmuebles = new ArrayList<Inmueble>();
		
		this.catRankInmu = new ArrayList<String>();
		this.catRankInqui = new ArrayList<String>();
		this.catRankProp = new ArrayList<String>();
		
		this.tiposInmueble = new ArrayList<String>();
		this.serviciosInmuebles = new ArrayList<String>();
	}

	public List<Reserva> getReservasPendientes() {
		return reservasPendientes;
	}

	public List<Reserva> getReservasConcretadas() {
		return reservasConcretadas;
	}

	public ArrayList<String> getCatRankProp() {
		return catRankProp;
	}

	public ArrayList<String> getCatRankInqui() {
		return catRankInqui;
	}

	public ArrayList<String> getCatRankInmu() {
		return catRankInmu;
	}
	


	public List<Usuario> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void registrarUsuario(Usuario usuario) {
		this.usuariosRegistrados.add(usuario);
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void ponerEnAlquiler(Inmueble nvoInmueble) { // seria el metodo ponerEnAlquiler en el UML. GT
		inmuebles.add(nvoInmueble);
	}
	
	// ---------------------------------------------
	
	// RESERVAS
	
	// ---------------------------------------------
	
	public void agregarReservaConcretada(Reserva unaReserva) {
		this.reservasPendientes.add(unaReserva);
	}

	public void agregarReservaPendiente(Reserva unaReserva) {
		this.reservasPendientes.add(unaReserva);
	}

	public void eliminarReservaPendiente(Reserva unaReserva) {
		this.reservasPendientes.remove(unaReserva);
	}
	
	public void eliminarReservaConcretada(Reserva unaReserva) {
		this.reservasConcretadas.remove(unaReserva);
	}

	// ---------------------------------------------
	
	// CATEGORIAS DE RANKINGS
	
	// ---------------------------------------------
	
	public void agregarCategoriaDeRankingPropietario(String categoria) {
		this.catRankProp.add(categoria);
	}

	public ArrayList<String> getCategoriasRankingPropietario() {
		return this.catRankProp;
	}
	
	public void agregarCategoriaDeRankingInquilino(String categoria) {
		this.catRankInqui.add(categoria);
	}

	public ArrayList<String> getCategoriasRankingInquilino() {
		return this.catRankInqui;
	}
	
	public ArrayList<String> getCategoriasRankingInmueble() {
		return this.catRankInmu;
	}

	public void agregarCategoriaDeRankingInnmueble(String categoria) {
		this.catRankInmu.add(categoria);
	}

	// ---------------------------------------------
	
	// TIPOS Y SERVICIOS DE INMUEBLES
		
	// ---------------------------------------------
	
	public void agregarTipoDeInmueble(String tipo) {
		
		this.tiposInmueble.add(tipo);
	}
	
	public void agregarServiciosDeInmuebles(String servicio) {
		
		this.serviciosInmuebles.add(servicio);
	}
	
	public ArrayList<String> getTiposInmueble() {
		return tiposInmueble;
	}

	public ArrayList<String> getServiciosInmuebles() {
		return serviciosInmuebles;
	}
	
	
	

	
	
}
