package muestra;

public class NivelDeVerificacionBajo extends NivelDeVerificacion {

	@Override
	public void agregarVerificacion(Verificacion verificacion,Muestra muestra) {
		// TODO Auto-generated method stub
		NivelDeVerificacionMedio nivelMedio = new NivelDeVerificacionMedio();
		muestra.getVerificaciones().add(verificacion);
		muestra.setNivelDeVerificacion(nivelMedio);
	}

}
