package operadoresLogicos;

import java.util.List;
import java.util.stream.Collectors;

import muestra.Muestra;

public class TipoDeMuestraDetectado extends CriterioBusqueda {
		
		private String criterio;
		
		public TipoDeMuestraDetectado(String criterio) {
			this.criterio = criterio;
		}
	
	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return muestras.stream().filter(muestra -> muestra.verificar().equals(this.criterio)).collect(Collectors.toList());
	}

}
