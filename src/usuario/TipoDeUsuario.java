package usuario;

import java.util.List;

import muestra.Muestra;
import muestra.Verificacion;
import sistema.Sistema;

public abstract class TipoDeUsuario {
	
	protected Sistema sistema;

	public TipoDeUsuario(Sistema sistema) {
		this.sistema = sistema;
	}

	public void verificarMuestra(Verificacion verificacion, Muestra muestra) {
		// TODO Auto-generated method stub
		muestra.agregarVerificacion(verificacion);
		
	}

	public void enviarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		sistema.enviarMuestraAlSistema(muestra);
	}

	public abstract Integer puntosDeUsuario();

	public Integer cantidadDeEnvios(Usuario usuario, List<Muestra> muestras) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
			for(Muestra muestra : muestras) {
				if(this.usuarioEnvioMuestra(usuario,muestra)) {
					resultado += 1;
				}
			}
	
		return resultado;
	}

	private Boolean usuarioEnvioMuestra(Usuario usuario, Muestra muestra) {
		// TODO Auto-generated method stub
		return muestra.usuarioEnvioMuestra(usuario);
	}

	public Integer cantidadDeRevisiones(Usuario usuario, List<Muestra> muestras) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		for(Muestra muestra : muestras) {
			if(this.usuarioVerificoMuestra(usuario,muestra)) {
				resultado += 1;
			}
		}

	return resultado;
}

	private Boolean usuarioVerificoMuestra(Usuario usuario, Muestra muestra) {
		// TODO Auto-generated method stub
		return muestra.usuarioVerifico(usuario);
	}

	public abstract void ascenderUsuario(Usuario usuario);

	public abstract void descenderUsuario(Usuario usuario);

}
