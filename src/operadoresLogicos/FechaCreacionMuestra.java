package operadoresLogicos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import muestra.Muestra;

public class FechaCreacionMuestra extends CriterioBusqueda {
	
		private LocalDate criterio;
		
		public FechaCreacionMuestra(LocalDate criterio) {
			this.criterio = criterio;
		}

	public List<Muestra> filtrarPorCriterio( List<Muestra> muestras) {
		// TODO Auto-generated method stub
		
		return muestras.stream().filter(muestra -> muestra.getFechaCreacion().equals(this.criterio)).collect(Collectors.toList());
	}
	
}
