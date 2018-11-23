package operadoresLogicos;

import java.util.List;

import muestra.Muestra;

public abstract class Filtro {
	
	public abstract List<Muestra> filtrarPorCriterio(List<Muestra> muestras);
}
