package muestra;

import usuario.Usuario;

public class Verificacion {

	private String tipoDeMuestra;
	private Usuario usuario;

	public Verificacion(String tipoDeMuestra, Usuario usuario) {
		// TODO Auto-generated constructor stub
		this.tipoDeMuestra = tipoDeMuestra;
		this.usuario = usuario;
	}
	
	public Boolean esIgual(Verificacion verificacion) {
		return this.tipoDeMuestra.equals(verificacion.getTipoMuestra()) && verificacion.getUsuarioVerificacion() == this.usuario ;
	}
	
	public String getTipoMuestra() {
		return this.tipoDeMuestra;
	}

	public Usuario getUsuarioVerificacion() {
		// TODO Auto-generated method stub
		return this.usuario;
	}

}
