package reserva;

import java.time.LocalDate;

import clases.Inmueble;
import usuario.Usuario;

public class Reserva {
	
	private Inmueble inmueble;
	private Usuario solicitante;
	private Usuario propietario;
	private LocalDate fechaDeInicio;
	private LocalDate fechaFinal;

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
	
	public void setPropietario(Usuario p_) {
		this.propietario = p_;
	}

	public Usuario getPropietario() {
		return this.propietario;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaDeInicio;
	}

	public void setFechaDeInicio(String fechaDeInicio) {
		this.fechaDeInicio = LocalDate.parse(fechaDeInicio);
	}
	
	public LocalDate getFechaFinal() {
		return this.fechaFinal;
	}

	
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = LocalDate.parse(fechaFinal);
	}


}
