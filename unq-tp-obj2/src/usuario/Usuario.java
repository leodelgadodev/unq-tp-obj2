package usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Inmueble;
import clases.SitioWeb;
import reserva.Reserva;

public class Usuario {
	
	protected SitioWeb web;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected Integer telefono;
	protected boolean mailRecibido;
	protected List<String>comentarios;
	private Inmueble inmuebleSeleccionado; //para visualizar o reservar
	private List<Inmueble> inmueblesAlquilados;
	private Reserva reserva;


	public Usuario(SitioWeb web, String nombre, String apellido, String email, Integer telefono) {
		this.web = web;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void registrarse(SitioWeb sitioweb) {
		
		web.registrarUsuario(this);
	}
	
	public List<Inmueble> buscarInmuebles(String ciudad, String fechaEntrada, String fechaSalida){ 
		List<Inmueble> inmuebles = web.getInmuebles();
		LocalDate fEntrada = conversorDeStringEnFechas(fechaEntrada);
		LocalDate fSalida = conversorDeStringEnFechas(fechaSalida);
		
		//OP 1
		inmuebles = inmuebles.stream().filter(x -> x.getCiudad() == ciudad).collect(Collectors.toList());
		inmuebles = inmuebles.stream().filter(x -> (x.getFechaDeInicio().isAfter(fEntrada) || x.getFechaDeInicio().equals(fEntrada))  && (x.getFechaFinal().isBefore(fSalida) || x.getFechaFinal().equals(fSalida))).collect(Collectors.toList());

		return inmuebles;
	}
	
	
	protected LocalDate conversorDeStringEnFechas(String fecha) {
		String[] parts = fecha.split("/");
		String part1 = parts[0]; 
		String part2 = parts[1];
		String part3 = parts[2];
		
		LocalDate ret = LocalDate.of(Integer.parseInt(part3), Integer.parseInt(part2), Integer.parseInt(part1));
		
		return  ret;
	}
	
	public Inmueble seleccionarInmueble(ArrayList<Inmueble> listaInmuebles, int index) {
		
		return listaInmuebles.get(index);
	}
	
	public Inmueble visualizarInmueble(Inmueble i) {
		
		return i;
	}
	
	public Usuario visualizarPropietario(Inmueble i) {
		
		return i.getPropietario(); 
	}
	
	
	public void reservarInmueble() {
		this.reserva = new Reserva(inmuebleSeleccionado, this);
		web.agregarReservaPendiente(reserva); 
		this.enviarMailA(inmuebleSeleccionado.getPropietario());
	}

	public void enviarMailA(Usuario unUsuario) {
		inmuebleSeleccionado.getPropietario().mailRecibido = true;
	}

}
