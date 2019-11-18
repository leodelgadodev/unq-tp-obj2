package clases;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import reserva.Reserva;
import usuario.Usuario;

public class SitioWeb {

	private Set<Usuario> usuarios;
	private Set<Inmueble> inmueblesEnAlquiler;
	private Set<String> tiposInmueble;
	private Set<String> serviciosInmuebles;
	private Set<Reserva> reservas;
	
	public SitioWeb() {
		this.usuarios = new HashSet<Usuario>();
		this.inmueblesEnAlquiler = new HashSet<Inmueble>();
		this.tiposInmueble = new HashSet<String>();
		this.serviciosInmuebles = new HashSet<String>();
		this.reservas = new HashSet<Reserva>();
	}

	public Set<Usuario> getUsuarios() { 
		return this.usuarios;
	}

	public Set<Inmueble> getInmuebles() {
		return this.inmueblesEnAlquiler;
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void ponerEnAlquiler(Inmueble nvoInmueble) {
		inmueblesEnAlquiler.add(nvoInmueble);
	}

	public void agregarTipoDeInmueble(String tipo) {
		
		this.tiposInmueble.add(tipo); 
	}

	public void agregarServiciosDeInmuebles(String servicio) {

		this.serviciosInmuebles.add(servicio);
	}

	public Set<String> getTiposInmueble() {
		return this.tiposInmueble;
	}

	public Set<String> getServiciosInmuebles() {
		return this.serviciosInmuebles;
	}


	public List<Inmueble> getInmueblesDe(String ciudad) {
		return this.inmueblesEnAlquiler.stream().filter(i -> i.getCiudad() == ciudad).collect(Collectors.toList());
	}
	
	public List<Inmueble> buscarInmuebles(String ciudad, String fechaEntrada, String fechaSalida){ 
		List<Inmueble> inmuebles = this.getInmueblesDe(ciudad);
		LocalDate fEntrada = LocalDate.parse(fechaEntrada);
		LocalDate fSalida = LocalDate.parse(fechaSalida);

		return inmuebles.stream()
		.filter(x -> ( fEntrada.equals(x.getFechaDeInicio()) || fEntrada.isAfter(x.getFechaDeInicio()))  
				&& (fSalida.equals(x.getFechaFinal()) || fSalida.isBefore(x.getFechaFinal()))) 
		.collect(Collectors.toList());
	}

}
