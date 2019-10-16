package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import reserva.Reserva;
import usuario.Usuario;

public class SitioWeb {
	//Esto deberia ser un Singleton - Leo
	private static SitioWeb web;
	
	private List<Usuario> usuariosRegistrados;
	private List<Inmueble> inmuebles;
	private List<Reserva> reservasPendientes; //No hace falta para este hito - L
	private List<Reserva> reservasConcretadas; // No hace falta para este hito - L
	
	private ArrayList<String> catRankProp; // No hace falta para este hito - L
	private ArrayList<String> catRankInqui; // No hace falta para este hito - L
	private ArrayList<String> catRankInmu; // No hace falta para este hito - L
	
	private ArrayList<String> tiposInmueble;
	private ArrayList<String> serviciosInmuebles;
	
	private SitioWeb() {
		
		this.usuariosRegistrados = new ArrayList<Usuario>();
		this.inmuebles = new ArrayList<Inmueble>();
		
		this.catRankInmu = new ArrayList<String>();
		this.catRankInqui = new ArrayList<String>();
		this.catRankProp = new ArrayList<String>();
		
		this.tiposInmueble = new ArrayList<String>();
		this.serviciosInmuebles = new ArrayList<String>();
	}
	
	public static SitioWeb getInstancia() {
		if(web == null) {
			web = new SitioWeb();
		}
		return web;
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

	public void ponerEnAlquiler(Inmueble nvoInmueble) { 
		// seria el metodo ponerEnAlquiler en el UML. GT
		inmuebles.add(nvoInmueble);
	}
	
	// ---------------------------------------------
	
	// RESERVAS // No hace falta para este hito - L
	
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

	/**
	 * Es llamado por el Usuario al intentar publicar un inmueble.
	 * Un inmueble es válido si su tipo y la lista de servicios ofrecidos
	 * coincide con los datos dados de alta por el administrador en el
	 * sitio web.
	 * @param tipo - String representando un tipo de inmueble (Casa, Quincho,
	 * Habitacion, etc).
	 * @param servicios - Set<String> representando servicios ofrecidos (Agua, Gas,
	 * Wifi, etc).
	 * @return resultado booleano.
	 */
	public boolean esUnInmuebleValido(String tipo, Set<String> servicios) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Es llamado por el Usuario al intentar publicar un inmueble.
	 * Agrega el inmueble a la lista de inmuebles del sitio.
	 * @param i - Inmueble
	 */
	//public void registrarInmueble(Inmueble i) { // ya hay un metodo que hace esto -> ponerEnAlquiler(Inmueble nvoInmueble) GT
	//	inmuebles.add(i);
	//}

	public void darDeBajaUsuario(Usuario u) {
		usuariosRegistrados.remove(u);
	}

	public Exception avisoUsuarioNoRegistrado() throws UsuarioNoRegistradoException {
		throw new UsuarioNoRegistradoException();
	}
	
	public Exception avisoInmuebleInvalido() throws InmuebleInvalidoException {
		throw new InmuebleInvalidoException();
	}
	
	

	
	
}
