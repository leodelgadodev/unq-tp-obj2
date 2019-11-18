package usuario;

import clases.Inmueble;

public interface IInquilino {

	public void reservarInmueble(Inmueble i,Usuario solicitante,Usuario propietario,String fechaInicio,String fechaFinal);
	
}
