package reserva;

import java.time.LocalDate;

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
	
	public Reserva(Inmueble unInmueble, Usuario unInquilino) {
		super();
		this.setInmueble(unInmueble);
		this.setInquilino(unInquilino);
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
		this.fechaInicio = conversorDeStringEnFechas(inicio);
	}
	
	public void setFechaFin(String fin) {
		// TODO Auto-generated method stub
		this.fechaInicio = conversorDeStringEnFechas(fin);
	}

	private LocalDate conversorDeStringEnFechas(String fecha) {
		String[] parts = fecha.split("/");
		String part1 = parts[0]; 
		String part2 = parts[1];
		String part3 = parts[2];
		
		LocalDate ret = LocalDate.of(Integer.parseInt(part3), Integer.parseInt(part2), Integer.parseInt(part1));
		
		return ret;
	}
	
	
}
