package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;


public class Inmueble { 

	private String tipoDeInmueble;
	private String ciudad;
	private String pais;
	private String direccion;
	private Set<String> servicios; 
	private int capacidad; 
	private LocalDate fechaInicio; 
	private LocalDate fechaFinal; 
	private LocalTime horaCheckIn; 
	private LocalTime horaCheckOut; 
	private double precio; 
	

	public Inmueble(String tipo, String ciudad, String pais, String direccion, Set<String> servicios,
			int capacidad,LocalDate fechaInicio,LocalDate fechaFinal, LocalTime horaCheckIn, LocalTime horaCheckOut, Double precio) {
		
		this.tipoDeInmueble = tipo;
		this.ciudad = ciudad;
		this.pais = pais;
		this.direccion = direccion;
		this.precio = precio;
		this.servicios = servicios;
		this.capacidad = capacidad;
		this.setFechaInicio(fechaInicio); 
		this.setFechaFinal(fechaFinal);
		this.setHoraCheckIn(horaCheckIn); 
		this.setHoraCheckOut(horaCheckOut);
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public String getTipoDeInmueble() {
		return tipoDeInmueble;
	}


	public String getCiudad() {
		return ciudad;
	}


	public String getPais() {
		return pais;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setServicios(Set<String> servicios){
		this.servicios= servicios;
	}
	
	public Set<String> getServicios(){
		return servicios;
	}

	public LocalTime getHoraCheckIn() {
		return horaCheckIn;
	}
	
	public void setHoraCheckIn(LocalTime horaCheckIn_) {
		
		this.horaCheckIn = horaCheckIn_;
	}
	
	public LocalTime getHoraCheckOut() {
		return horaCheckOut;
	}

	public void setHoraCheckOut(LocalTime horaCheckOut) {
	
		this.horaCheckOut = horaCheckOut;
	}

	public double getPrecio() {
		return precio;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
}
