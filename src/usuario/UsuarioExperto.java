package usuario;


public class UsuarioExperto extends TipoDeUsuario {

	@Override
	public Integer puntosDeUsuario() {
		return 3;
	}

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
}
