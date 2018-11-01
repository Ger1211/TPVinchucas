package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import sistema.Sistema;

public class UsuarioExpertoTestCase {

	private TipoDeUsuario usuarioExperto;
	private Sistema sistema;
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		sistema = mock(Sistema.class);
		usuarioExperto = new UsuarioExperto(sistema);
		usuario = new Usuario("German",usuarioExperto);
	}

	@Test
	public void testPuntosDeUsuarioExperto() {
		assertEquals(3,usuarioExperto.puntosDeUsuario(),0);
	}

	@Test
	public void testDescenderUsuarioExperto() {
		usuario.descenderUsuario();
		assertTrue(usuario.getTipoDeUsuario() != usuarioExperto);
	}
	
	@Test
	public void testAscenderUsuarioExperto() {
		usuario.ascenderUsuario();
		assertTrue(usuario.getTipoDeUsuario() == usuarioExperto);
	}
}
