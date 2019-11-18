package reserva;

import clases.Inmueble;
import usuario.Usuario;

public class Reserva {
	
	private Inmueble inmueble;
	private Usuario solicitante;
	private Usuario propietario;

	public Reserva(Usuario solicitante, Usuario propietario, Inmueble i) {
		this.setSolicitante(solicitante);
		this.setPropietario(propietario);
		this.setInmueble(i);
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

	public void setPropietario(Usuario p_) {
		this.propietario = p_;
	}

}
