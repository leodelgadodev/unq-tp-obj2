package busqueda;

import java.util.Set;
import java.util.stream.Collectors;

import clases.Inmueble;

public class BCiudad implements IBusquedaParamString {

	@Override
	public Set<Inmueble> buscar(String ciudad, Set<Inmueble> inmuebles) {
		
		return inmuebles.stream().filter((i) -> i.getCiudad() == ciudad).collect(Collectors.toSet());
	}

}
