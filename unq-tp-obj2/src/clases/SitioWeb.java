package clases;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import busqueda.BCiudad;
import busqueda.BFechaEntrada;
import busqueda.BFechaSalida;
import busqueda.IBusquedaParamDate;
import busqueda.IBusquedaParamString;
import reserva.Reserva;
import usuario.Usuario;

public class SitioWeb {

	private Set<Usuario> usuarios;
	private Set<Inmueble> inmueblesEnAlquiler;
	private Set<String> tiposInmueble;
	private Set<String> serviciosInmuebles;
	private Set<Reserva> reservas;
	private IBusquedaParamString bCiudad;
	private IBusquedaParamDate bFechaEntrada;
	private IBusquedaParamDate bFechaSalida;
	
	public SitioWeb() {
		this.usuarios = new HashSet<Usuario>();
		this.inmueblesEnAlquiler = new HashSet<Inmueble>();
		this.tiposInmueble = new HashSet<String>();
		this.serviciosInmuebles = new HashSet<String>();
		this.reservas = new HashSet<Reserva>();
		this.bCiudad = new BCiudad();
		this.bFechaEntrada = new BFechaEntrada();
		this.bFechaSalida = new BFechaSalida();
	}

	public Set<Usuario> getUsuarios() { 
		return this.usuarios;
	}
	
	public void setUsuarios(Set<Usuario> u) {
		this.usuarios = u;
	}

	public Set<Inmueble> obtenerInmueblesEnAlquiler() {
		Set<Inmueble> inmueblesEnAlquiler = new HashSet<Inmueble>();
		this.usuarios.stream().forEach(u-> inmueblesEnAlquiler.addAll(u.getInmuebles()));
		return inmueblesEnAlquiler;
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

	public void agregarServicioDeInmuebles(String servicio) {

		this.serviciosInmuebles.add(servicio);
	}

	public Set<String> getTiposInmueble() {
		return this.tiposInmueble;
	}

	public Set<String> getServiciosInmuebles() {
		return this.serviciosInmuebles;
	}
	
	public Set<Inmueble> buscar(IBusquedaParamString busquedaStrategy, String ciudad) {
		
		return busquedaStrategy.buscar(ciudad, this.inmueblesEnAlquiler);
	}
	
	public Set<Inmueble> buscar(IBusquedaParamDate busquedaStrategy, LocalDate fecha) {
		
		return busquedaStrategy.buscar(fecha, this.inmueblesEnAlquiler);
	}
	
	public Set<Inmueble> buscarY(Set<Inmueble> busqueda1, Set<Inmueble> busqueda2) {
		
		return busqueda1.stream().filter((i) -> busqueda2.contains(i)).collect(Collectors.toSet());
	}
	
	public IBusquedaParamString porCiudad() {
		return this.bCiudad;
	}
	
	public IBusquedaParamDate porEntrada() {
		return this.bFechaEntrada;
	}
	
	public IBusquedaParamDate porSalida() {
		return this.bFechaSalida;
	}
	

}
