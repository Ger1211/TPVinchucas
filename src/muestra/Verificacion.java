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

	public Integer puntosDeVerificacion() {
		// TODO Auto-generated method stub
		return this.getUsuarioVerificacion().puntosDeUsuario();
	}

	public LocalDate getFechaVerificacion() {
		// TODO Auto-generated method stub
		return this.fechaVerificacion;
	}

}
