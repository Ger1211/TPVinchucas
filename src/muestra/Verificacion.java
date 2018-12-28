package muestra;

import java.time.LocalDate;

import usuario.Usuario;

public class Verificacion {

	private String tipoDeMuestra;
	private Usuario usuario;
	private LocalDate fechaVerificacion;

	public Verificacion(String tipoDeMuestra, Usuario usuario, LocalDate fechaVerificacion) {
		this.tipoDeMuestra = tipoDeMuestra;
		this.usuario = usuario;
		this.fechaVerificacion  = fechaVerificacion;
	}
	
	public String getTipoMuestra() {
		return this.tipoDeMuestra;
	}

	public Usuario getUsuarioVerificacion() {
		return this.usuario;
	}


	public LocalDate getFechaVerificacion() {
		return this.fechaVerificacion;
	}

	public Boolean verificadorEsEspecialista() {
		return this.usuario.getTipoDeUsuario().esUsuarioEspecialista();
	}

	public Boolean verificadorEsExperto() {
		return this.usuario.getTipoDeUsuario().esUsuarioExperto();
	}

	public Boolean votoAFavor(Verificacion verificacion) {
		return this.getTipoMuestra().equals(verificacion.getTipoMuestra());
	}

	public Boolean votoEnContra(Verificacion verificacion) {
		return !this.getTipoMuestra().equals(verificacion.getTipoMuestra());
	}

}
