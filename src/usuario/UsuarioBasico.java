package usuario;


public class UsuarioBasico extends TipoDeUsuario {
	
	@Override
	public void ascenderUsuario(Usuario usuario) {
		TipoDeUsuario usuarioExperto = new UsuarioExperto();
		usuario.setTipoDeUsuario(usuarioExperto);
	}

	@Override
	public void descenderUsuario(Usuario usuario) {
		// Los usuarios b�sicos no descienden.
	}

	@Override
	public Boolean esUsuarioBasico() {
		return true;
	}

	@Override
	public Boolean esUsuarioExperto() {
		return false;
	}

	@Override
	public Boolean esUsuarioEspecialista() {
		return false;
	}


}
