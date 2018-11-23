package operadoresLogicos;

import java.util.List;
import java.util.stream.Collectors;

import muestra.Muestra;
import muestra.NivelDeVerificacion;

public class NivelDeValidacion extends CriterioBusqueda {

		private NivelDeVerificacion criterio;
		
		public NivelDeValidacion(NivelDeVerificacion criterio) {
			this.criterio = criterio;
		}
	
	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return muestras.stream().filter(muestra -> muestra.getNivelDeVerificacion().equals(this.criterio)).collect(Collectors.toList());
	}

}
