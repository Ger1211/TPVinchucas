package muestra;


public class NivelDeVerificacionMedio implements NivelDeVerificacion {

	@Override
	public void agregarVerificacion(Verificacion verificacion,Muestra muestra) {
		// TODO Auto-generated method stub
		NivelDeVerificacionAlto  nivelAlto = new NivelDeVerificacionAlto();
		muestra.getVerificaciones().add(verificacion);
		muestra.setNivelDeVerificacion(nivelAlto);
	}

}
