package operadoresLogicos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import muestra.Muestra;

public class Or extends OperadorLogico {
	
	public Or(List<Filtro> operadores) {
		super(operadores);
	}

	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		Set<Muestra> set = new  HashSet<>();
		List<Muestra> listaFiltro1 = this.operadores.get(0).filtrarPorCriterio(muestras);
		List<Muestra> listaFiltro2 = this.operadores.get(1).filtrarPorCriterio(listaFiltro1);
		set.addAll(listaFiltro1);
		set.addAll(listaFiltro2);
		return new ArrayList<Muestra>(set);
	}

}
