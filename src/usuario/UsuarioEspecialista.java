package usuario;

public class UsuarioEspecialista extends TipoDeUsuario {

	@Override
	public Integer puntosDeUsuario() {
		return 4;
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
