package operadoresLogicos;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import muestra.Muestra;

public class Or extends OperadorLogico {
	
	public Or(Filtro filtro1,Filtro filtro2) {
		super(filtro1,filtro2);
	}

	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		List<Muestra> listaFiltro1 = this.filtro1.filtrarPorCriterio(muestras);
		List<Muestra> listaFiltro2 = this.filtro2.filtrarPorCriterio(muestras);
		listaFiltro1.addAll(listaFiltro2);
		listaFiltro2.clear();
		listaFiltro2.addAll(new ArrayList<Muestra>(new LinkedHashSet<Muestra>(listaFiltro1)));
		return listaFiltro2;
	}

}
