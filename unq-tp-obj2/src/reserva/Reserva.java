package reserva;

import java.time.LocalDate;
import java.time.LocalTime;

import clases.Inmueble;
import usuario.Usuario;

public class Reserva {
	
	private Boolean estatus = false;
	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	private Inmueble inmueble;
	private Usuario inquilino;
	private Usuario propietario;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

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
		// TODO Auto-generated method stub
		return inquilino;
	}

	public Usuario getPropietario() {
		// TODO Auto-generated method stub
		return propietario;
	}

	public LocalDate getFechaInicio() {
		// TODO Auto-generated method stub
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		// TODO Auto-generated method stub
		return fechaFin;
	}

	public void setPropietario(Usuario p_) {
		// TODO Auto-generated method stub
		this.propietario = p_;
	}

	public void setFechaInicio(String inicio) {
		// TODO Auto-generated method stub
		this.fechaInicio = LocalDate.parse(inicio);
	}
	
	public void setFechaFin(String fin) {
		// TODO Auto-generated method stub
		this.fechaFin = LocalDate.parse(fin);
	}
	
}
