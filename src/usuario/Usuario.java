package usuario;

import java.util.List;

import muestra.Muestra;
import muestra.Verificacion;
import sistema.Sistema;


public class Usuario {

	private String alias;
	private TipoDeUsuario tipoDeUsuario;

	public Usuario(String alias, TipoDeUsuario tipoDeUsuario) {
		// TODO Auto-generated constructor stub
		this.alias = alias;
		this.tipoDeUsuario = tipoDeUsuario;
	
	}

	public String getAlias() {
		// TODO Auto-generated method stub
		return this.alias;
	}

	public TipoDeUsuario getTipoDeUsuario() {
		// TODO Auto-generated method stub
		return this.tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
		// TODO Auto-generated method stub
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public void enviarMuestra(Muestra muestra,Sistema sistema) {
		// TODO Auto-generated method stub
		sistema.enviarMuestraAlSistema(muestra);
		this.tipoDeUsuario.verificacionAscensoODescensoDeRango(this,sistema.getMuestras());
	}

	

	public void verificarMuestra(Verificacion verificacion,Muestra muestra,List<Muestra> muestras) {
		// TODO Auto-generated method stub
		if(muestra.usuarioNoVerifico(this)) {
		this.tipoDeUsuario.verificarMuestra(verificacion,muestra,this,muestras);
		}
	}

	public Integer puntosDeUsuario() {
		// TODO Auto-generated method stub
		return this.tipoDeUsuario.puntosDeUsuario();
	}

	public Integer cantidadDeEnvios(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return this.tipoDeUsuario.cantidadDeEnvios(this,muestras);
	}

	public Integer cantidadDeRevisiones(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return this.tipoDeUsuario.cantidadDeRevisiones(this, muestras);
	}

	public void ascenderUsuario() {
		// TODO Auto-generated method stub
		this.tipoDeUsuario.ascenderUsuario(this);
	}

	public void descenderUsuario() {
		// TODO Auto-generated method stub
		this.tipoDeUsuario.descenderUsuario(this);
	}

	public Boolean verificacionEnvios(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return this.cantidadDeEnvios(muestras)>10;
	}

	public Boolean verificacionRevisiones(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return this.cantidadDeRevisiones(muestras)>20;
	}

	

	

}
