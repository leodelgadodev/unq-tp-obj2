package reserva;

import java.time.LocalDate;

import clases.Inmueble;
import usuario.Usuario;

public class Reserva {
	
	private Inmueble inmueble;
	private Usuario solicitante;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Boolean concretada = false;
	
	
	public Boolean getEstatus() {
		return concretada;
	}

	public void setEstatus(Boolean estatus) {
		this.concretada = estatus;
	}

	public Reserva(Usuario solicitante, Inmueble i, String fechaInicio, String fechaFin) {
		
		this.solicitante = solicitante;
		this.inmueble = i;
		this.setFechaInicio(fechaInicio);
		this.setFechaFin(fechaFin);
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public Usuario getSolicitante() {
		return this.solicitante;
	}


	public void setFechaInicio(String inicio) {
		this.fechaInicio = LocalDate.parse(inicio);
	}
	
	public void setFechaFin(String fin) {
		this.fechaFin = LocalDate.parse(fin);
	}
	
}
