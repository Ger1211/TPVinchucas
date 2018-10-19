package muestra;

import ubicacion.Ubicacion;
import usuario.Usuario;

public class Muestra {

	private String tipoMuestra;
	private Ubicacion ubicacion;
	private Usuario usuario;

	public Muestra(String tipoMuestra, Ubicacion ubicacion, Usuario usuario) {
		// TODO Auto-generated constructor stub
		this.tipoMuestra = tipoMuestra;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
	}

	public String getTipoMuestra() {
		// TODO Auto-generated method stub
		return this.tipoMuestra;
	}

	public Ubicacion getUbicacion() {
		// TODO Auto-generated method stub
		return this.ubicacion;
	}

	public Usuario getUsuarioMuestra() {
		// TODO Auto-generated method stub
		return this.usuario;
	}

}
