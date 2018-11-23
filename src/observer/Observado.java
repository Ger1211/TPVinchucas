package observer;

import muestra.Muestra;

public interface Observado {
		
		public void agregarObservador(Observador observador);
		public void eliminarObservador(Observador observador);
		public void notificar(Muestra muestra);
}
