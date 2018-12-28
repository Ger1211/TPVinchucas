package usuario;

import java.util.List;

import muestra.Muestra;
import muestra.Verificacion;
import sistema.Sistema;


public class Usuario {

	private String alias;
	private TipoDeUsuario tipoDeUsuario;

	public Usuario(String alias, TipoDeUsuario tipoDeUsuario) {
		this.alias = alias;
		this.tipoDeUsuario = tipoDeUsuario;
	
	}

	public String getAlias() {
		return this.alias;
	}

	public TipoDeUsuario getTipoDeUsuario() {
		return this.tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public void enviarMuestra(Muestra muestra,Sistema sistema) {
		sistema.enviarMuestraAlSistema(muestra);
		this.tipoDeUsuario.verificacionAscensoODescensoDeRango(this,sistema.getMuestras());
	}

	

	public void verificarMuestra(Verificacion verificacion,Muestra muestra,List<Muestra> muestras) {
		if(muestra.usuarioNoVerifico(this)) {
		muestra.agregarVerificacion(verificacion);
		this.tipoDeUsuario.verificacionAscensoODescensoDeRango(this,muestras);;
		}
	}
	

	public Integer cantidadDeEnvios(List<Muestra> muestras) {
		return this.tipoDeUsuario.cantidadDeEnvios(this,muestras);
	}

	public Integer cantidadDeRevisiones(List<Muestra> muestras) {
		return this.tipoDeUsuario.cantidadDeRevisiones(this, muestras);
	}

	public void ascenderUsuario() {
		this.tipoDeUsuario.ascenderUsuario(this);
	}

	public void descenderUsuario() {
		this.tipoDeUsuario.descenderUsuario(this);
	}

	public Boolean verificacionEnvios(List<Muestra> muestras) {
		return this.cantidadDeEnvios(muestras)>10;
	}

	public Boolean verificacionRevisiones(List<Muestra> muestras) {
		return this.cantidadDeRevisiones(muestras)>20;
	}

	

	

}
