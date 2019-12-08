package busqueda;

import java.time.LocalDate;
import java.util.Set;

import clases.Inmueble;

public interface IBusquedaParamDate {

	public Set<Inmueble> buscar(LocalDate fecha, Set<Inmueble> inmueblesEnAlquiler);
}
