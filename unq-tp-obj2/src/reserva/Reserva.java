package reserva;

import java.time.LocalDate;


import clases.Inmueble;
import usuario.Usuario;

public class Reserva {
	
	private Inmueble inmueble;
	private Usuario solicitante;
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

	public Reserva(Usuario solicitante, Usuario propietario, Inmueble i, String fechaInicio, String fechaFin) {
		this.setSolicitante(solicitante);
		this.setPropietario(propietario);
		this.setInmueble(i);
		this.setFechaInicio(fechaInicio);
		this.setFechaFin(fechaFin);
	}

	public void setSolicitante(Usuario unInquilino) {
		this.solicitante = unInquilino;
		
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Usuario getSolicitante() {
		return this.solicitante;
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
