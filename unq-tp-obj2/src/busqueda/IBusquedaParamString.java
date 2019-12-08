package busqueda;

import java.util.Set;

import clases.Inmueble;

public interface IBusquedaParamString {

	public Set<Inmueble> buscar(String ciudad, Set<Inmueble> inmueblesEnAlquiler);
}
