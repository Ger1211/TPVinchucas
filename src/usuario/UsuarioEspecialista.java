package usuario;

public class UsuarioEspecialista extends TipoDeUsuario {


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

	@Override
	public Boolean esUsuarioBasico() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean esUsuarioExperto() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean esUsuarioEspecialista() {
		// TODO Auto-generated method stub
		return true;
	}
}
