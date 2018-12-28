package usuario;

public class UsuarioEspecialista extends TipoDeUsuario {


	@Override
	public void ascenderUsuario(Usuario usuario) {
		// Los usuarios especialistas no ascienden.
	}

	@Override
	public void descenderUsuario(Usuario usuario) {
		// Los usuarios especialistas no descienden.
	}

	@Override
	public Boolean esUsuarioBasico() {
		return false;
	}

	@Override
	public Boolean esUsuarioExperto() {
		return false;
	}

	@Override
	public Boolean esUsuarioEspecialista() {
		return true;
	}
}
