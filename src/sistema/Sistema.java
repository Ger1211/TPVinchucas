package sistema;

import java.util.ArrayList;
import java.util.List;

import muestra.Muestra;

public class Sistema {
	private List<Muestra> muestras; 
	
	public Sistema() {
		this.muestras = new ArrayList<>();
	}

	public void enviarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		this.muestras.add(muestra);
	}

}
