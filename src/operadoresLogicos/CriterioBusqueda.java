package operadoresLogicos;

import java.util.List;

import muestra.Muestra;

public abstract class CriterioBusqueda extends Filtro {

	public abstract List<Muestra> filtrarPorCriterio(List<Muestra> muestras);
}
