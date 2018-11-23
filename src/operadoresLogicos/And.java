package operadoresLogicos;

import java.util.List;

import muestra.Muestra;

public class And extends OperadorLogico {
	
	public And(List<Filtro> operadores) {
		super(operadores);
	}

	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		List<Muestra> listaFiltro1 = this.operadores.get(0).filtrarPorCriterio(muestras);
		List<Muestra> listaFiltro2 = this.operadores.get(1).filtrarPorCriterio(listaFiltro1);
		return listaFiltro2;
	}

}
