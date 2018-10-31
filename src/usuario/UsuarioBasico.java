package usuario;

import sistema.Sistema;

public class UsuarioBasico extends TipoDeUsuario {

	public UsuarioBasico(Sistema sistema) {
		super(sistema);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Integer puntosDeUsuario() {
		return 1;
	}

	@Override
	public void ascenderUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		TipoDeUsuario usuarioExperto = new UsuarioExperto(this.sistema);
		usuario.setTipoDeUsuario(usuarioExperto);
	}

	@Override
	public void descenderUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		// Los usuarios básicos no descienden.
	}

}
