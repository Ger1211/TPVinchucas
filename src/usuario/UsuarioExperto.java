package usuario;

import sistema.Sistema;

public class UsuarioExperto extends TipoDeUsuario {

	public UsuarioExperto(Sistema sistema) {
		super(sistema);
		// TODO Auto-generated constructor stub
	}

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
		TipoDeUsuario usuarioBasico = new UsuarioBasico(this.sistema);
		usuario.setTipoDeUsuario(usuarioBasico);
	}
}
