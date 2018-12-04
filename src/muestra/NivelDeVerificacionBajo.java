package muestra;

public class NivelDeVerificacionBajo implements NivelDeVerificacion {

	@Override
	public void actualizarNivelDeVerificacion(Verificacion verificacion, Muestra muestra) {
		// TODO Auto-generated method stub
		if(verificacion.getUsuarioVerificacion().getTipoDeUsuario().esUsuarioBasico()) {
			NivelDeVerificacionMedio nivelDeVerificacionMedio = new NivelDeVerificacionMedio();
			muestra.setNivelDeVerificacion(nivelDeVerificacionMedio);
		}
		else {
			NivelDeVerificacionAlto nivelDeVerificacionAlto = new NivelDeVerificacionAlto();
			muestra.setNivelDeVerificacion(nivelDeVerificacionAlto);
		}
		
	}



	
}
