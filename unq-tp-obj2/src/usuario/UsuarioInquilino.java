package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.Inmueble;
import clases.SitioWeb;
import ranking.Ranking;
import reserva.Reserva;

public class UsuarioInquilino extends Usuario {
	
	private Ranking rankingInquilino;
	private Inmueble inmuebleSeleccionado; //para visualizar o reservar
	private List<Inmueble> inmueblesAlquilados;
	private Inmueble inmuebleVisualizado;
	private ArrayList<Inmueble> inmueblesEncontrados;
	private SitioWeb sitioWeb;
	private Reserva reserva;

	public UsuarioInquilino(String nombre, String apellido, String email, Integer telefono) {
		super(nombre,apellido, email, telefono);
	}

	@Override
	public void registrarse(SitioWeb sitioWeb) {
		sitioWeb.registrarUsuario(this);
	}

	@Override
	public void publicarInmueble(Inmueble nvoInmueble, SitioWeb sitioWeb) { //GT: En teoria un inquilino tambien podria realizar esto. evaluar mas tarde.
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Inmueble> buscarInmueble(String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida){
		//codear, teniendo en cuenta que esto se lo pide al SitioWeb.
		
		return inmueblesEncontrados;
	}
	
	public Inmueble seleccionarInmueble(ArrayList<Inmueble> listaInmuebles) {
		//codear
		
		return inmuebleSeleccionado;
	}
	
	public void visualizarInmueble() {
		System.out.println(inmuebleSeleccionado); //Esto esta bien asi?
	}
	
	public void visualizarPropietario() {
		System.out.println(inmuebleSeleccionado.getPropietario()); //Esto esta bien asi?
	}
	
	public void reservarInmueble() {
		this.reserva = new Reserva(inmuebleSeleccionado, this); //No estoy seguro.
		this.sitioWeb.agregarReservaPendiente(reserva); //ustedes que dicen?
	}

}
