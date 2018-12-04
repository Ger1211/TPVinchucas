package usuario;


public class UsuarioExperto extends TipoDeUsuario {


	@Override
	public void ascenderUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		// Los usuarios expertos no ascienden.
	}

	@Override
	public void descenderUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		TipoDeUsuario usuarioBasico = new UsuarioBasico();
		usuario.setTipoDeUsuario(usuarioBasico);
	}

	@Override
	public Boolean esUsuarioBasico() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean esUsuarioExperto() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean esUsuarioEspecialista() {
		// TODO Auto-generated method stub
		return false;
	}
}
