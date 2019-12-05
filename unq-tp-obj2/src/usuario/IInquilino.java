package usuario;

import clases.Inmueble;
import reserva.Reserva;

public interface IInquilino {

	public void reservarInmueble(Reserva r, Inmueble i,Usuario solicitante,String fechaInicio,String fechaFinal);
	
}
