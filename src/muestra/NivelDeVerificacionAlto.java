package muestra;



public class NivelDeVerificacionAlto implements NivelDeVerificacion {


	@Override
	public void agregarVerificacion(Verificacion verificacion, Muestra muestra) {
		// TODO Auto-generated method stub
		muestra.getVerificaciones().add(verificacion);
	}

}
