package usuario;


public class UsuarioBasico extends TipoDeUsuario {
	
	@Override
	public void ascenderUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		TipoDeUsuario usuarioExperto = new UsuarioExperto();
		usuario.setTipoDeUsuario(usuarioExperto);
	}

	@Override
	public void descenderUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		// Los usuarios básicos no descienden.
	}

	@Override
	public Boolean esUsuarioBasico() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean esUsuarioExperto() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean esUsuarioEspecialista() {
		// TODO Auto-generated method stub
		return false;
	}


}
