package muestra;


public class NivelDeVerificacionMedio implements NivelDeVerificacion {

	@Override
	public void actualizarNivelDeVerificacion(Verificacion verificacion, Muestra muestra) {
		NivelDeVerificacionAlto nivelDeVerificacionAlto = new NivelDeVerificacionAlto();
		muestra.setNivelDeVerificacion(nivelDeVerificacionAlto);
	}




}
