package usuario;

public class Usuario {

	private String alias;
	private TipoDeUsuario tipoDeUsuario;

	public Usuario(String alias, TipoDeUsuario tipoDeUsuario) {
		// TODO Auto-generated constructor stub
		this.alias = alias;
		this.tipoDeUsuario = tipoDeUsuario;
	}

	public String getAlias() {
		// TODO Auto-generated method stub
		return this.alias;
	}

	public TipoDeUsuario getTipoDeUsuario() {
		// TODO Auto-generated method stub
		return this.tipoDeUsuario;
	}

	public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
		// TODO Auto-generated method stub
		this.tipoDeUsuario = tipoDeUsuario;
	}

}
