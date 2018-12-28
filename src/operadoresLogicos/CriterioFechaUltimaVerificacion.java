package operadoresLogicos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import muestra.Muestra;

public class CriterioFechaUltimaVerificacion extends CriterioBusqueda {
		
		private LocalDate criterio;
		
	public CriterioFechaUltimaVerificacion(LocalDate criterio) {
		this.criterio = criterio;
	}
	
	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		return muestras.stream().filter(muestra -> (muestra.getFechaUltimaVerificacion().isBefore(this.criterio))).collect(Collectors.toList());
	}

}
