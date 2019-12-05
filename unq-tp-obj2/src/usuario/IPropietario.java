package usuario;

import java.util.List;

import clases.Inmueble;
import clases.SitioWeb;
import reserva.Reserva;

public interface IPropietario {

	
	public void addReservaPendiente(Reserva r);
	public void aceptarReserva(Reserva reservaPendiente,SitioWeb web);
	public List<Reserva> getReservasPendientes();
	public void publicarInmueble(Inmueble i);
}
