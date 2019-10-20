package clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import excepciones.InmuebleInvalidoException;
import excepciones.UsuarioNoRegistradoException;
import reserva.Reserva;
import usuario.Usuario;

public class SitioWeb {
	// Esto deberia ser un Singleton - Leo

	private Set<Usuario> usuariosRegistrados;
	private Set<Inmueble> inmuebles;

	private Set<String> tiposInmueble;
	private Set<String> serviciosInmuebles;

	public SitioWeb() {

		this.usuariosRegistrados = new HashSet<Usuario>();
		this.inmuebles = new HashSet<Inmueble>();

		this.tiposInmueble = new HashSet<String>();
		this.serviciosInmuebles = new HashSet<String>();
	}

	public Set<Usuario> getUsuariosRegistrados() {
		return this.usuariosRegistrados;
	}

	public void registrarUsuario(Usuario usuario) {
		this.usuariosRegistrados.add(usuario);
	}

	public Set<Inmueble> getInmuebles() {
		return this.inmuebles;
	}

	public void ponerEnAlquiler(Inmueble nvoInmueble) {
		inmuebles.add(nvoInmueble);
	}

	// ---------------------------------------------

	// TIPOS Y SERVICIOS DE INMUEBLES

	// ---------------------------------------------

	public void agregarTipoDeInmueble(String tipo) {
		
		this.tiposInmueble.add(tipo);
	}

	public void agregarServiciosDeInmuebles(String servicio) {

		this.serviciosInmuebles.add(servicio);
	}

	public Set<String> getTiposInmueble() {
		return this.tiposInmueble;
	}

	public Set<String> getServiciosInmuebles() {
		return this.serviciosInmuebles;
	}

	/**
	 * Es llamado por el Usuario al intentar publicar un inmueble. Un inmueble es
	 * válido si su tipo y la lista de servicios ofrecidos coincide con los datos
	 * dados de alta por el administrador en el sitio web.
	 * 
	 * @param tipo      - String representando un tipo de inmueble (Casa, Quincho,
	 *                  Habitacion, etc).
	 * @param servicios - Set<String> representando servicios ofrecidos (Agua, Gas,
	 *                  Wifi, etc).
	 * @return resultado booleano.
	 */
	public boolean esUnInmuebleValido(String tipo, Set<String> servicios) {
		return this.getTiposInmueble().contains(tipo) && this.getServiciosInmuebles().containsAll(servicios);
	}

	public void darDeBajaUsuario(Usuario u) {
		usuariosRegistrados.remove(u);
	}

	public Exception avisoUsuarioNoRegistrado() throws UsuarioNoRegistradoException {
		throw new UsuarioNoRegistradoException();
	}

	public Exception avisoInmuebleInvalido() throws InmuebleInvalidoException {
		throw new InmuebleInvalidoException();
	}

	public List<Inmueble> getInmueblesDe(String ciudad) {
		return this.inmuebles.stream().filter(i -> i.getCiudad() == ciudad).collect(Collectors.toList());
	}

}
