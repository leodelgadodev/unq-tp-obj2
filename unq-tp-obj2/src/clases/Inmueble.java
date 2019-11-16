package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
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
	private LocalDate fechaDeInicio; 
	private LocalDate fechaFinal; 
	private LocalTime horaCheckIn; 
	private LocalTime horaCheckOut; 
	private double precio; 
	private Boolean reservado;

	public Inmueble(Usuario prop, String tipo, String ciudad, 
			String pais, String direccion, Set<String> servicios, 
			int capacidad,String fechaInicio,String fechaFinal, String horaCheckIn, String horaCheckOut,
			Double precio) {
		this.propietario = prop;
		this.tipoDeInmueble = tipo;
		this.ciudad = ciudad;
		this.pais = pais;
		this.direccion = direccion;
		this.precio = precio;
		this.servicios = new HashSet<String>(); 
		this.capacidad = capacidad;
		this.setFechaDeInicio(fechaInicio);
		this.setFechaFinal(fechaFinal);
		this.setHoraCheckIn(horaCheckIn); 
		this.setHoraCheckOut(horaCheckOut);
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
	
	
	public Usuario getPropietario() {
		return propietario;
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


	public Set<String> getServicios(){
		return servicios;
	}
	
	/*public void setServicios(Set<String> servicios) {
		
		this.servicios = servicios;
	}*/
	
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
	
	public void reservar() {
		this.reservado = true;
	}
	
	public Boolean estaReservado() {
		return this.reservado;
	}
	
}
