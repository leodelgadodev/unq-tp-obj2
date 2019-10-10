package clases;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Inmueble {
	
	private String tipo;
	private String locacion; //Tendria que ser una clase.
	private List<String> servicios;
	private int capacidad; //cantidad de personas
	private int horaCheckIn; //Creo que deberiamos usar LocalDateTime.
	private int horaCheckOut;
	private double precio; //Por dia

	public Inmueble(String tipo, String locacion, List<String> servicios,
					int capacidad, int horaCheckIn, int horaCheckOut, double precio) {
		super();
		this.tipo = tipo;
		this.locacion = locacion;
		this.servicios = new ArrayList<String>();
		this.capacidad = capacidad;
		this.horaCheckIn = horaCheckIn;
		this.horaCheckOut = horaCheckOut;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getLocacion() {
		return locacion;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public int getHoraCheckIn() {
		return horaCheckIn;
	}
	
	public int getHoraCheckOut() {
		return horaCheckOut;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public List<String> getServicios(){
		return servicios;
	}
	
}
