package muestra;



public class NivelDeVerificacionAlto extends NivelDeVerificacion {


	@Override
	public void agregarVerificacion(Verificacion verificacion, Muestra muestra) {
		// TODO Auto-generated method stub
		muestra.getVerificaciones().add(verificacion);
	}

}
