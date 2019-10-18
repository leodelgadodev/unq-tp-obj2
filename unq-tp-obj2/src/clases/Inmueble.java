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
	
	// horaCheckIn y horaCheckOut reciben Strings con el formato "nn:nn"
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
	private LocalDate fechaDeInicio; // disponibilidad del inmueble
	private LocalDate fechaFinal; 
	private LocalTime horaCheckIn; 
	private LocalTime horaCheckOut;
	private double precio; 
	//private List<String> comentarios;

	public Inmueble(Usuario prop, String tipo, String ciudad, 
			String pais, String direccion, Set<String> servicios, 
			Integer capacidad,String fechaInicio,String FechaFinal, String horaCheckIn, String horaCheckOut,
			Double precio) {
		this.setPropietario(prop);
		this.setTipoDeInmueble(tipo);
		this.setCiudad(ciudad);
		this.setPais(pais);
		this.setDireccion(direccion);
		this.servicios = new HashSet<String>(); 
		this.setCapacidad(capacidad);
		this.setHoraCheckIn(horaCheckIn);
		this.setHoraCheckOut(horaCheckOut);
		this.setPrecio(precio);
		this.setFechaDeInicio(fechaDeInicio);
		this.setFechaFinal(fechaFinal);
		//this.comentarios = new ArrayList<String>(); //  todavia no para este hito GT
		
	}

	
	public LocalDate getFechaDeInicio() {
		return fechaDeInicio;
	}

	public void setFechaDeInicio(LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
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
		
		this.horaCheckIn = this.conversorDeStringEnHoras(horaCheckIn);
	}
	
	public LocalTime getHoraCheckOut() {
		return horaCheckOut;
	}


	public void setHoraCheckOut(String horaCheckOut) {
	
		this.horaCheckOut = this.conversorDeStringEnHoras(horaCheckOut);
		
	}
	
	private LocalTime conversorDeStringEnHoras(String horaCheck) {
		String[] parts = horaCheck.split(":");
		String part1 = parts[0]; 
		String part2 = parts[1];
		
		LocalTime hora = LocalTime.of(Integer.parseInt(part1),Integer.parseInt(part2));
		
		return  hora;
	}
	
	protected LocalDate conversorDeStringEnFechas(String fecha) {
		String[] parts = fecha.split("/");
		String part1 = parts[0]; 
		String part2 = parts[1];
		String part3 = parts[2];
		
		LocalDate ret = LocalDate.of(Integer.parseInt(part3), Integer.parseInt(part2), Integer.parseInt(part1));
		
		return  ret;
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
	
}
