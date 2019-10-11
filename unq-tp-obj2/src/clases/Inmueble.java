package clases;

import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class Inmueble {
	
	private Usuario propietario; // deberia estar para luego obtener la info del mismo a partir de los inmuebles en el sitio. GT
	private String tipoDeInmueble;
	//private String locacion; //Tendria que ser una clase.
	private String ciudad;
	private String pais;
	private String direccion;
	private List<String> servicios; // tal vez deberia ser una clase. GT
	private int capacidad; //cantidad de personas
	private LocalDate horaCheckIn; //Creo que deberiamos usar LocalDateTime.
	private LocalDate horaCheckOut;
	private double precio; //Por dia
	private List<String> comentarios; 

	public Inmueble(Usuario prop,String tipo, String ciudad, String pais, String direccion,
					int capacidad, LocalDate horaCheckIn, LocalDate horaCheckOut, double precio) {
		this.setPropietario(prop);
		this.setTipoDeInmueble(tipo);
		this.setCiudad(ciudad);
		this.setPais(pais);
		this.setDireccion(direccion);
		this.servicios = new ArrayList<String>(); // tal vez deberia ser una clase. GT
		this.setCapacidad(capacidad);
		this.setHoraCheckIn(horaCheckIn);
		this.setHoraCheckOut(horaCheckOut);
		this.setPrecio(precio);
		this.comentarios = new ArrayList<String>(); // podria estar en otro lado o aqui?? GT
	}
	
	
	//public String getLocacion() {
		//return locacion;
	//}
	
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

	public List<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}

	public List<String> getServicios(){
		return servicios;
	}
	
	public void setServicios(String servicios) {
		this.servicios.add(servicios);
	}

	public LocalDate getHoraCheckIn() {
		return horaCheckIn;
	}
	
	public void setHoraCheckIn(LocalDate horaCheckIn) {
		this.horaCheckIn = horaCheckIn;
	}
	
	public LocalDate getHoraCheckOut() {
		return horaCheckOut;
	}


	public void setHoraCheckOut(LocalDate horaCheckOut) {
		this.horaCheckOut = horaCheckOut;
		
		// aqui tambien deberian ir los metodos pertinentes a ranking tal vez? GT
	}

	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
