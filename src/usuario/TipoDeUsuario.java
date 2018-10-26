package usuario;

import muestra.Muestra;
import muestra.Verificacion;
import sistema.Sistema;
import ubicacion.Ubicacion;

public class TipoDeUsuario {
	
	private Sistema sistema;

	public TipoDeUsuario(Sistema sistema) {
		this.sistema = sistema;
	}

	public void verificarMuestra(String tipoDeMuestra, Usuario usuario, Muestra muestra) {
		// TODO Auto-generated method stub
		Verificacion verificacion = new Verificacion(tipoDeMuestra,usuario);
		muestra.agregarVerificacion(verificacion);
		
	}

	public void enviarMuestra(String tipoDeMuestra, Usuario usuario) {
		// TODO Auto-generated method stub
		Ubicacion ubicacion = new Ubicacion();
		Verificacion verificacion = new Verificacion(tipoDeMuestra,usuario);
		Muestra muestra = new Muestra(tipoDeMuestra,ubicacion,usuario,verificacion);
		sistema.enviarMuestra(muestra);
	}

}
