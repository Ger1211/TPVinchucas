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
}
