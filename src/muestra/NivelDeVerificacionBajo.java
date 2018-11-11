package muestra;

public class NivelDeVerificacionBajo extends NivelDeVerificacion {

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
	
}
