package sistema;

import java.util.List;

import muestra.Muestra;
import usuario.Usuario;

public class Sistema {
	private List<Muestra> muestras;
	private List<Usuario> usuarios; 
	
	public Sistema(List<Usuario>usuarios, List<Muestra> muestras) {
		this.muestras = muestras;
		this.usuarios = usuarios;
	}

	public void enviarMuestraAlSistema(Muestra muestra) {
		// TODO Auto-generated method stub
		this.muestras.add(muestra);
	}

	public List<Muestra> getMuestras() {
		// TODO Auto-generated method stub
		return this.muestras;
	}



}
