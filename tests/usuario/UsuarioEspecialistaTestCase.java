package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioEspecialistaTestCase {

	private TipoDeUsuario usuarioEspecialista;
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		usuarioEspecialista = new UsuarioEspecialista();
		usuario = new Usuario("German",usuarioEspecialista);
	}
	
	@Test
	public void testUnUsuarioEsEspecialista() {
		assertTrue(usuarioEspecialista.esUsuarioEspecialista());
		assertFalse(usuarioEspecialista.esUsuarioExperto());
		assertFalse(usuarioEspecialista.esUsuarioBasico());
	}

	@Test
	public void testAscenderUsuarioEspecialista() {
		usuario.ascenderUsuario();
		assertTrue(usuario.getTipoDeUsuario().getClass().equals(usuarioEspecialista.getClass()));
	}
	
	@Test
	public void testDescenderUsuarioEspecialista() {
		usuario.descenderUsuario();
		assertTrue(usuario.getTipoDeUsuario().getClass().equals(usuarioEspecialista.getClass()));
	}
}
