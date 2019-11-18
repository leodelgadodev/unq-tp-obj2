package usuario;

import java.util.List;
import java.util.Set;

import clases.SitioWeb;
import reserva.Reserva;

public interface IPropietario {

	
	public void addReservasPendientes(Reserva r);
	public void aceptarReserva(Reserva reservaPendiente,SitioWeb web);
	public List<Reserva> getReservasPendientes();
	public void publicarInmueble(String tipo, String ciudad, String pais, String direccion, Set<String> servicios, 
			int capacidad,String fechaInicio,String fechaFinal, String horaCheckIn,String horaCheckOut, double precio);
}
