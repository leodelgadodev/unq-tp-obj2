package clases;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import reserva.Reserva;
import usuario.Usuario;
import usuario.UsuarioPropietario;

public class SitioWeb {

	private Set<Usuario> usuarios;
	private Set<Inmueble> inmueblesPublicados;
	private Set<String> tiposInmueble;
	private Set<String> serviciosInmuebles;

	private Set<Reserva> reservasPendientes;
	
	public SitioWeb() {

		this.usuarios = new HashSet<Usuario>();
		this.inmueblesPublicados = new HashSet<Inmueble>();
		this.tiposInmueble = new HashSet<String>();
		this.serviciosInmuebles = new HashSet<String>();
		this.reservasPendientes = new HashSet<Reserva>();
	}

	public Set<Usuario> getUsuariosRegistrados() {
		return this.usuarios;
	}


	public Set<Inmueble> getInmuebles() {
		return this.inmueblesPublicados;
	}

	public void ponerEnAlquiler(Inmueble nvoInmueble) {
		inmueblesPublicados.add(nvoInmueble);
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


	public boolean esUnInmuebleValido(String tipo, Set<String> servicios) {
		return this.getTiposInmueble().contains(tipo) && this.getServiciosInmuebles().containsAll(servicios);
	}


	public Exception avisoInmuebleInvalido() throws InmuebleInvalidoException {
		throw new InmuebleInvalidoException();
	}

	public List<Inmueble> getInmueblesDe(String ciudad) {
		return this.inmueblesPublicados.stream().filter(i -> i.getCiudad() == ciudad).collect(Collectors.toList());
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


	public void agregarReservaConcretada(Reserva reservaPendiente) {
		this.reservasPendientes.add(reservaPendiente);
	}

	public Set<Reserva> getReservasConcretadas() {
		return this.reservasPendientes;
	}
}
