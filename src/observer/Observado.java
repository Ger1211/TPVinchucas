package observer;

public interface Observado {
		
		public void agregarObservador(Observador observador);
		public void eliminarObservador(Observador observador);
		public void notificar();
}
