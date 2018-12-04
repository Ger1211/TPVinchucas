package muestra;


public class NivelDeVerificacionMedio implements NivelDeVerificacion {

	@Override
	public void actualizarNivelDeVerificacion(Verificacion verificacion, Muestra muestra) {
		// TODO Auto-generated method stub
		NivelDeVerificacionAlto nivelDeVerificacionAlto = new NivelDeVerificacionAlto();
		muestra.setNivelDeVerificacion(nivelDeVerificacionAlto);
	}




}
