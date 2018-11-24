package operadoresLogicos;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import muestra.Muestra;

public class Or extends OperadorLogico {
	
	public Or(List<Filtro> operadores) {
		super(operadores);
	}

	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		List<Muestra> listaFiltro1 = this.operadores.get(0).filtrarPorCriterio(muestras);
		List<Muestra> listaFiltro2 = this.operadores.get(1).filtrarPorCriterio(muestras);
		listaFiltro1.addAll(listaFiltro2);
		listaFiltro2.clear();
		listaFiltro2.addAll(new ArrayList<Muestra>(new LinkedHashSet<Muestra>(listaFiltro1)));
		return listaFiltro2;
	}

}
