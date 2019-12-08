package busqueda;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import clases.Inmueble;

public class BFechaSalida implements IBusquedaParamDate {

	@Override
	public Set<Inmueble> buscar(LocalDate fecha, Set<Inmueble> inmuebles) {
		
		return inmuebles.stream().filter((i) -> i.getFechaFinal().isBefore(fecha)).collect(Collectors.toSet());
	}
}
