package clases;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import usuario.Usuario;

public class Inmueble {
	
	// horaCheckIn y horaCheckOut reciben Strings con el formato "hh:mm"
	// y los convierten en LocalTime al setearlos.
	// Ej setHoraCheckIn("14:00") -> LocalTime.of(14, 00)
	// Ej setHoraCheckOut("08:00") -> LocalTime.of(08, 00)
	
	private Usuario propietario; // deberia estar para luego obtener la info del mismo a partir de los inmuebles en el sitio. GT
	private String tipoDeInmueble;
	private String ciudad;
	private String pais;
	private String direccion;
	private Set<String> servicios; 
	private Integer capacidad; 
	private LocalDate fechaDeInicio; // disponibilidad del inmueble formato en el string "2019-10-19"
	private LocalDate fechaFinal; 
	private LocalTime horaCheckIn; 
	private LocalTime horaCheckOut;
	private double precio; 
	//private List<String> comentarios;

	public Inmueble(Usuario prop, String tipo, String ciudad, 
			String pais, String direccion, Set<String> servicios, 
			Integer capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, String horaCheckOut,
			Double precio) {
		this.setPropietario(prop);
		this.setTipoDeInmueble(tipo);
		this.setCiudad(ciudad);
		this.setPais(pais);
		this.setDireccion(direccion);
		this.servicios = new HashSet<String>(); 
		this.setCapacidad(capacidad);
		this.setFechaDeInicio(fechaInicio); // POR QUEEEEE NO FUNCIONAAA!!!???? ESTE ERROR PROVOCA EL NULL POINTER EXCEPTION EN USUARIO???
		this.setFechaFinal(fechaFinal);
		this.setHoraCheckIn(horaCheckIn); // POR QUE CON ESTE SIIIII?????
		this.setHoraCheckOut(horaCheckOut);
		this.setPrecio(precio);
	}

	
	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(String fechaDeInicio) {
		this.fechaDeInicio = LocalDate.parse(fechaDeInicio);
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = LocalDate.parse(fechaFinal);
	}

	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public String getTipoDeInmueble() {
		return tipoDeInmueble;
	}

	public void setTipoDeInmueble(String tipoDeInmueble) {
		this.tipoDeInmueble = tipoDeInmueble;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<String> getServicios(){
		return servicios;
	}
	
	public void setServicios(Set<String> servicios) {
		
		this.servicios = servicios;

	}

	public LocalTime getHoraCheckIn() {
		return horaCheckIn;
	}
	
	public void setHoraCheckIn(String horaCheckIn) {
		
		this.horaCheckIn = LocalTime.parse(horaCheckIn);
	}
	
	public LocalTime getHoraCheckOut() {
		return horaCheckOut;
	}


	public void setHoraCheckOut(String horaCheckOut) {
	
		this.horaCheckOut = LocalTime.parse(horaCheckOut);
		
	}

	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void agregarServicio(String servicio) {
		this.servicios.add(servicio);
	}


	//comentado para que no muestre error, descomentar y seguir
	/*public boolean estaReservado() {
		// TODO Auto-generated method stub
		return i.getPropietario().getReservasPendientesDeAprobacion()
				.filter( (reserva) -> reserva.getInmueble() == i ).estaReservado());
				//Pseudo codigo, arreglar bien el Stream
	}*/
	
}
