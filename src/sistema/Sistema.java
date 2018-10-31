package sistema;

import java.util.ArrayList;
import java.util.List;

import muestra.Muestra;
import usuario.Usuario;

public class Sistema {
	private List<Muestra> muestras;
	private List<Usuario> usuarios; 
	
	public Sistema(List<Usuario>usuarios) {
		this.muestras = new ArrayList<>();
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

	public void modificarRangoUsuarios() {
		// TODO Auto-generated method stub
		for(Usuario usuario :usuarios) {
			if(usuario.cantidadDeEnvios()>10 && usuario.cantidadDeRevisiones()>20) {
				usuario.ascenderUsuario();
			}
			else  {
				usuario.descenderUsuario();
			}
		}
		
	}

}
