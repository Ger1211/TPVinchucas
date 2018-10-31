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

}
