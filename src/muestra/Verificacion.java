package muestra;

import java.time.LocalDate;

import usuario.Usuario;

public class Verificacion {

	private String tipoDeMuestra;
	private Usuario usuario;
	private LocalDate fechaVerificacion;

	public Verificacion(String tipoDeMuestra, Usuario usuario, LocalDate fechaVerificacion) {
		// TODO Auto-generated constructor stub
		this.tipoDeMuestra = tipoDeMuestra;
		this.usuario = usuario;
		this.fechaVerificacion  = fechaVerificacion;
	}
	
	public String getTipoMuestra() {
		return this.tipoDeMuestra;
	}

	public Usuario getUsuarioVerificacion() {
		// TODO Auto-generated method stub
		return this.usuario;
	}


	public LocalDate getFechaVerificacion() {
		// TODO Auto-generated method stub
		return this.fechaVerificacion;
	}

	public Boolean verificadorEsEspecialista() {
		// TODO Auto-generated method stub
		return this.usuario.getTipoDeUsuario().esUsuarioEspecialista();
	}

	public Boolean verificadorEsExperto() {
		// TODO Auto-generated method stub
		return this.usuario.getTipoDeUsuario().esUsuarioExperto();
	}

	public Boolean votoAFavor(Verificacion verificacion) {
		// TODO Auto-generated method stub
		return this.getTipoMuestra().equals(verificacion.getTipoMuestra());
	}

	public Boolean votoEnContra(Verificacion verificacion) {
		// TODO Auto-generated method stub
		return !this.getTipoMuestra().equals(verificacion.getTipoMuestra());
	}

}
