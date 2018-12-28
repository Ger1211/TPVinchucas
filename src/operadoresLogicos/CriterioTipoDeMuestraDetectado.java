package operadoresLogicos;

import java.util.List;
import java.util.stream.Collectors;

import muestra.Muestra;

public class CriterioTipoDeMuestraDetectado extends CriterioBusqueda {
		
		private String criterio;
		
		public CriterioTipoDeMuestraDetectado(String criterio) {
			this.criterio = criterio;
		}
	
	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		return muestras.stream().filter(muestra -> muestra.verificar().equals(this.criterio)).collect(Collectors.toList());
	}

}
