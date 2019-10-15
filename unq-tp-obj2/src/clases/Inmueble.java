package clases;

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
	private Set<String> servicios; // tal vez deberia ser una clase. GT
	//Debe ser un Set, porque sino despues al hacer los tests trata de comparar
	//listas en un orden especifico, o puede pasar que se le agregue "Agua"
	//dos veces a un inmueble y no corresponde - Leo
	private Integer capacidad; //cantidad de personas
	private LocalTime horaCheckIn; //Creo que deberiamos usar LocalDateTime.
	private LocalTime horaCheckOut;
	private double precio; //Por dia
	//private List<String> comentarios; // todavia no para este hito GT 

	public Inmueble(Usuario prop, String tipo, String ciudad, 
			String pais, String direccion, Set<String> servicios, 
			Integer capacidad, String horaCheckIn, String horaCheckOut,
			Double precio) {
		this.setPropietario(prop);
		this.setTipoDeInmueble(tipo);
		this.setCiudad(ciudad);
		this.setPais(pais);
		this.setDireccion(direccion);
		this.servicios = new HashSet<String>(); // tal vez deberia ser una clase. GT
		this.setCapacidad(capacidad);
		this.setHoraCheckIn(horaCheckIn);
		this.setHoraCheckOut(horaCheckOut);
		this.setPrecio(precio);
		
		//this.comentarios = new ArrayList<String>(); //  todavia no para este hito GT
		// Mejor acá, inicializarlo pero al crearlo no tiene comentarios. Despues los
		// inquilinos le van a ir agregando comentarios - Leo
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

	//public List<String> getComentarios() { // todavia no para este hito GT
	//	return comentarios;
	//}

	//public void setComentarios(List<String> comentarios) { // todavia no para este hito GT
	//	this.comentarios = comentarios;
	//}

	public Set<String> getServicios(){
		return servicios;
	}
	
	public void setServicios(Set<String> servicios) {
		
		this.servicios = servicios;

	}

	public LocalTime getHoraCheckIn() {
		return horaCheckIn;
	}
	
	public void setHoraCheckIn(String horaCheckIn2) {
		
		String[] parts = horaCheckIn2.split(":");
		String part1 = parts[0]; 
		String part2 = parts[1];
		
		this.horaCheckIn = LocalTime.of(
				Integer.parseInt(part1), 
				Integer.parseInt(part2));
	}
	
	public LocalTime getHoraCheckOut() {
		return horaCheckOut;
	}


	public void setHoraCheckOut(String horaCheckOut2) {
		
		String[] parts = horaCheckOut2.split(":");
		String part1 = parts[0]; 
		String part2 = parts[1];
		
		this.horaCheckOut = LocalTime.of(
				Integer.parseInt(part1), 
				Integer.parseInt(part2));
		
		// aqui tambien deberian ir los metodos pertinentes a ranking tal vez? GT
		// NO. Setters solo setean valores. Cualquier otro comportamiento va en otros
		// metodos - Leo
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
