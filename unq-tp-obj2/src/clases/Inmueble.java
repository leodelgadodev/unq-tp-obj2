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

	private Usuario propietario;
	private String tipoDeInmueble;
	private String ciudad;
	private String pais;
	private String direccion;
	private Set<String> servicios; 
	private int capacidad; 
	private LocalDate fechaDeInicio; // disponibilidad del inmueble formato en el string "2019-10-19"
	private LocalDate fechaFinal; 
	private LocalTime horaCheckIn; // check-in formato en string "10:30"
	private LocalTime horaCheckOut; 
	private double precio; 
	private Boolean reservado;

	public Inmueble(Usuario prop, String tipo, String ciudad, 
			String pais, String direccion, Set<String> servicios, 
			int capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, String horaCheckOut,
			Double precio) {
		this.setPropietario(prop);
		this.setTipoDeInmueble(tipo);
		this.setCiudad(ciudad);
		this.setPais(pais);
		this.setDireccion(direccion);
		this.servicios = new HashSet<String>(); 
		this.setCapacidad(capacidad);
		this.setFechaDeInicio(fechaInicio);
		this.setFechaFinal(fechaFinal);
		this.setHoraCheckIn(horaCheckIn); 
		this.setHoraCheckOut(horaCheckOut);
		this.setPrecio(precio);
		this.reservado = false;
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
	
	public void agregarServicio(String servicio) {
		this.servicios.add(servicio);
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

	public void reservar() {
		this.reservado = true;
	}
	
	public Boolean estaReservado() {
		return this.reservado;
	}
	
}
