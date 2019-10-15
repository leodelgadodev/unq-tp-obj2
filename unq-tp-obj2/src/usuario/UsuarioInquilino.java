package usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Inmueble;
import clases.SitioWeb;
import ranking.Ranking;
import reserva.Reserva;

public class UsuarioInquilino extends Usuario {
	
	//private Ranking rankingInquilino; // todavia no para este hito GT
	private Inmueble inmuebleSeleccionado; //para visualizar o reservar
	private List<Inmueble> inmueblesAlquilados;
	//private Inmueble inmuebleVisualizado;
	//private ArrayList<Inmueble> inmueblesEncontrados;
	private Reserva reserva;

	public UsuarioInquilino(String nombre, String apellido, String email, Integer telefono,SitioWeb web) {
		super(nombre,apellido, email, telefono,web);
	}

	
	public List<Inmueble> buscarInmueble(String ciudad, LocalTime fechaEntrada, LocalTime fechaSalida){ // revisar GT
		List<Inmueble> inmuebles = web.getInmuebles();
		inmuebles = inmuebles.stream().filter(x -> x.getCiudad() == ciudad).collect(Collectors.toList());
		inmuebles = inmuebles.stream().filter(x-> x.getHoraCheckIn().isBefore(fechaEntrada) && x.getHoraCheckOut().isAfter(fechaSalida)).collect(Collectors.toList());
		
		return inmuebles;
	}
	
	public Inmueble seleccionarInmueble(ArrayList<Inmueble> listaInmuebles, int index) { // podria ser asi? GT
		
		
		return listaInmuebles.get(index);
	}
	
	public Inmueble visualizarInmueble(Inmueble i) {
		//System.out.println(inmuebleSeleccionado); //Esto esta bien asi? // digo que no. GT
		return i; // algo asi veo que seria. GT
	}
	
	public Usuario visualizarPropietario(Inmueble i) {
		//System.out.println(inmuebleSeleccionado.getPropietario()); //Esto esta bien asi? // digo que no. GT
		return i.getPropietario(); // algo asi veo que seria. GT
	}
	
	
	public void reservarInmueble() {
		this.reserva = new Reserva(inmuebleSeleccionado, this); //No estoy seguro.
		this.web.agregarReservaPendiente(reserva); //ustedes que dicen?
	}

}
