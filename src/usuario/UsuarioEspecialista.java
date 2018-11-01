package usuario;

import sistema.Sistema;

public class UsuarioEspecialista extends TipoDeUsuario {

	public UsuarioEspecialista(Sistema sistema) {
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
		// Los usuarios especialistas no ascienden.
	}

	@Override
	public void descenderUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		// Los usuarios especialistas no descienden.
	}
}
