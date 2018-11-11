package muestra;


public abstract class NivelDeVerificacion {

	public abstract void agregarVerificacion(Verificacion verificacion, Muestra muestra);

	protected Boolean esVerificadoPorUnUsuarioBasico(Verificacion verificacion) {
		return verificacion.getUsuarioVerificacion().getTipoDeUsuario().puntosDeUsuario() == 1;
	}

}
