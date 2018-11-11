package usuario;


public class UsuarioBasico extends TipoDeUsuario {
	
	@Override
	public Integer puntosDeUsuario() {
		return 1;
	}

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


}
