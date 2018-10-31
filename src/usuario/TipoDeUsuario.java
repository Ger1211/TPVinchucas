package usuario;

import muestra.Muestra;
import muestra.Verificacion;
import sistema.Sistema;

public abstract class TipoDeUsuario {
	
	private Sistema sistema;

	public TipoDeUsuario(Sistema sistema) {
		this.sistema = sistema;
	}

	public void verificarMuestra(String tipoDeMuestra, Usuario usuario, Muestra muestra) {
		// TODO Auto-generated method stub
		Verificacion verificacion = new Verificacion(tipoDeMuestra,usuario);
		muestra.agregarVerificacion(verificacion);
		
	}

	public void enviarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		sistema.enviarMuestraAlSistema(muestra);
	}

	public abstract Integer puntosDeUsuario();

}
