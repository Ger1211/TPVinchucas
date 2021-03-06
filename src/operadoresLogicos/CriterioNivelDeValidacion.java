package operadoresLogicos;

import java.util.List;
import java.util.stream.Collectors;

import muestra.Muestra;
import muestra.NivelDeVerificacion;

public class CriterioNivelDeValidacion extends CriterioBusqueda {

		private NivelDeVerificacion criterio;
		
		public CriterioNivelDeValidacion(NivelDeVerificacion criterio) {
			this.criterio = criterio;
		}
	
	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		return muestras.stream().filter(muestra -> muestra.getNivelDeVerificacion().equals(this.criterio)).collect(Collectors.toList());
	}

}
