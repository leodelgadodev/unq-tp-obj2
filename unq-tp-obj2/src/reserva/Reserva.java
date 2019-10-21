package reserva;

import java.time.LocalDate;
import java.time.LocalTime;

import clases.Inmueble;
import usuario.Usuario;

public class Reserva {
	
	private Inmueble inmueble;
	private Usuario inquilino;
	private Usuario propietario;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	private Boolean estatus = false;
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public Reserva(Usuario inquilino, Usuario propietario, Inmueble i, String fechaInicio, String fechaFin) {
		this.setInquilino(inquilino);
		this.setPropietario(propietario);
		this.setInmueble(i);
		this.setFechaInicio(fechaInicio);
		this.setFechaFin(fechaFin);
	}

	public void setInquilino(Usuario unInquilino) {
		this.inquilino = unInquilino;
		
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Usuario getInquilino() {
		return this.inquilino;
	}

	public Usuario getPropietario() {
		return this.propietario;
	}

	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}

	public LocalDate getFechaFin() {
		return this.fechaFin;
	}

	public void setPropietario(Usuario p_) {
		this.propietario = p_;
	}

	public void setFechaInicio(String inicio) {
		this.fechaInicio = LocalDate.parse(inicio);
	}
	
	public void setFechaFin(String fin) {
		this.fechaFin = LocalDate.parse(fin);
	}
	
}
