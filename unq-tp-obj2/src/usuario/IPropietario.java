package usuario;

import java.util.List;
import java.util.Set;

import reserva.Reserva;

public interface IPropietario {

	
	public void addReservasPendientes(Reserva r);
	public void aceptarReserva(Reserva reservaPendiente);
	public List<Reserva> getReservasPendientes();
	public void publicarInmueble(String tipo, String ciudad, String pais, String direccion, Set<String> servicios, 
			int capacidad,String fechaInicio,String fechaFinal, String horaCheckIn,String horaCheckOut, double precio);
}
