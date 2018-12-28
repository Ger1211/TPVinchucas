package muestra;

public class NivelDeVerificacionBajo implements NivelDeVerificacion {

	@Override
	public void actualizarNivelDeVerificacion(Verificacion verificacion, Muestra muestra) {
		if(esVerificadoPorUnUsuarioBasico(verificacion)) {
			NivelDeVerificacionMedio nivelDeVerificacionMedio = new NivelDeVerificacionMedio();
			muestra.setNivelDeVerificacion(nivelDeVerificacionMedio);
		}
		else {
			NivelDeVerificacionAlto nivelDeVerificacionAlto = new NivelDeVerificacionAlto();
			muestra.setNivelDeVerificacion(nivelDeVerificacionAlto);
		}
		
	}

	private Boolean esVerificadoPorUnUsuarioBasico(Verificacion verificacion) {
		return verificacion.getUsuarioVerificacion().getTipoDeUsuario().esUsuarioBasico();
	}



	
}
