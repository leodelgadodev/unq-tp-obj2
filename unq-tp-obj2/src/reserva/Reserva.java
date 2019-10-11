package reserva;

import clases.Inmueble;
import usuario.Usuario;

public class Reserva {
	
	private Inmueble inmueble;
	private Usuario usuario;
	
	public Reserva(Inmueble unInmueble, Usuario unInquilino) {
		super();
		this.setInmueble(unInmueble);
		this.setUsuario(unInquilino);
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
