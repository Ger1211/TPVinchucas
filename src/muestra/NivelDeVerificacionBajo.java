package muestra;

public class NivelDeVerificacionBajo implements NivelDeVerificacion {

	@Override
	public void agregarVerificacion(Verificacion verificacion,Muestra muestra) {
		// TODO Auto-generated method stub
		if(esVerificadoPorUnUsuarioBasico(verificacion)) {
		NivelDeVerificacionMedio nivelMedio = new NivelDeVerificacionMedio();
		muestra.getVerificaciones().add(verificacion);
		muestra.setNivelDeVerificacion(nivelMedio);
		}
		else {
		NivelDeVerificacionAlto nivelAlto = new NivelDeVerificacionAlto();
		muestra.getVerificaciones().add(verificacion);
		muestra.setNivelDeVerificacion(nivelAlto);
		}
	}
	
	public Boolean esVerificadoPorUnUsuarioBasico(Verificacion verificacion) {
		return verificacion.getUsuarioVerificacion().getTipoDeUsuario().puntosDeUsuario() == 1;
	}
	
}
