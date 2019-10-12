package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

	public void ponerEnAlquiler(Inmueble nvoInmueble) { 
		// seria el metodo ponerEnAlquiler en el UML. GT
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
	public void registrarInmueble(Inmueble i) {
		inmuebles.add(i);
	}

	public static String br = System.getProperty("line.separator");
	
	/**
	 * Es llamado por el Usuario al intentar publicar un inmueble.
	 * Si falla el intento de registrar de inmueble, denota un msj
	 * de error por consola, avisando que para registrar el inmueble
	 * necesita que el tipo o los servicios ofrecidos coincidan con
	 * alguno de los tipos y servicios dados de alta en el sitio web.
	 */
	public void avisoInmuebleInvalido() {
		System.out.println("No pudimos registrar su inmueble. Por favor,"
				+ "verifique que sea un tipo de inmueble posible y que"
				+ "los servicios ofrecidos coincidan con los servicios"
				+ "posibles. "
				+ "Los tipos de inmuebles posibles son: "
				+ this.listarTiposDeInmueblesPosibles()
				+ "Los servicios que puede ofrecer su inmueble son: "
				+ this.listarServiciosDeInmueblesPosibles());
	}
	
	public String listarTiposDeInmueblesPosibles() {
		ArrayList<String> tipos = new ArrayList<>();
		String lista = "";
		for (String t : tipos) {
			lista = lista + "- " + t + ". " + br;
		}
		
		return lista;
	}
	
	public String listarServiciosDeInmueblesPosibles() {
		ArrayList<String> servicios = new ArrayList<>();
		String lista = "";
		for (String s : servicios) {
			lista = lista + "- " + s + ". " + br;
		}
		
		return lista;
	}

	public void darDeBajaUsuario(Usuario u) {
		usuariosRegistrados.remove(u);
	}
	
	

	
	
}
