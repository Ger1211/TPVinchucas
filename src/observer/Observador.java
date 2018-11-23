package observer;

import muestra.Muestra;
import ubicacion.ZonaDeCobertura;

public interface Observador {
		
		public void actualizar(ZonaDeCobertura zonaDeCobertura,Muestra muestra);
}
