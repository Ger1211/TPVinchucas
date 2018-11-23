package operadoresLogicos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import muestra.Muestra;

public class FechaUltimaVerificacion extends CriterioBusqueda {
		
		private LocalDate criterio;
		
	public FechaUltimaVerificacion(LocalDate criterio) {
		this.criterio = criterio;
	}
	
	@Override
	public List<Muestra> filtrarPorCriterio(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return muestras.stream().filter(muestra -> (muestra.getFechaUltimaVerificacion().isBefore(this.criterio))).collect(Collectors.toList());
	}

}
