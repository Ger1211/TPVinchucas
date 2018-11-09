package usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class UsuarioExpertoTestCase {

	private TipoDeUsuario usuarioExperto;
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		usuarioExperto = new UsuarioExperto();
		usuario = new Usuario("German",usuarioExperto);
	}

	@Test
	public void testPuntosDeUsuarioExperto() {
		assertEquals(3,usuarioExperto.puntosDeUsuario(),0);
	}

	@Test
	public void testDescenderUsuarioExperto() {
		usuario.descenderUsuario();
		assertFalse(usuario.getTipoDeUsuario().getClass().equals(usuarioExperto.getClass()));
	}
	
	@Test
	public void testAscenderUsuarioExperto() {
		usuario.ascenderUsuario();
		assertTrue(usuario.getTipoDeUsuario().getClass().equals(usuarioExperto.getClass()));
	}
}
