package usuario;


public class UsuarioExperto extends TipoDeUsuario {


	@Override
	public void ascenderUsuario(Usuario usuario) {
		// Los usuarios expertos no ascienden.
	}

	@Override
	public void descenderUsuario(Usuario usuario) {
		TipoDeUsuario usuarioBasico = new UsuarioBasico();
		usuario.setTipoDeUsuario(usuarioBasico);
	}

	@Override
	public Boolean esUsuarioBasico() {
		return false;
	}

	@Override
	public Boolean esUsuarioExperto() {
		return true;
	}

	@Override
	public Boolean esUsuarioEspecialista() {
		return false;
	}
}
