package operadoresLogicos;

import java.util.List;

import muestra.Muestra;

public class And extends OperadorLogico {
	
	public And(Filtro filtro1,Filtro filtro2) {
		super(filtro1,filtro2);
	}

	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		List<Muestra> listaFiltro1 = this.filtro1.filtrarPorCriterio(muestras);
		List<Muestra> listaFiltro2 = this.filtro2.filtrarPorCriterio(listaFiltro1);
		return listaFiltro2;
	}

}
