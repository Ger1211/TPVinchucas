package observer;

import java.util.ArrayList;
import java.util.List;

import muestra.Muestra;

public abstract class Observado {
		protected List<Observador> observadores = new ArrayList<>();
		
		public void agregarObservador(Observador observador) {
			this.observadores.add(observador);
		}


		public void eliminarObservador(Observador observador) {
			this.observadores.remove(observador);
		}


		public abstract void notificar(Muestra muestra);
}
