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
}
