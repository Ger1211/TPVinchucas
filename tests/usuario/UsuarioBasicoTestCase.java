package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import sistema.Sistema;

public class UsuarioBasicoTestCase {

	private TipoDeUsuario usuarioBasico;
	private Sistema sistema;
	private Usuario usuario;

	@Before
	public void setUp() throws Exception {
		sistema = mock(Sistema.class);
		usuarioBasico = new UsuarioBasico(sistema);
		usuario = new Usuario("German",usuarioBasico);
	}

	@Test
	public void testUsuarioBasicoPuntosDeUsuario() {
		assertEquals(1,usuarioBasico.puntosDeUsuario(),0);
	}
	
	@Test
	public void testAscenderUsuarioBasico() {
		usuario.ascenderUsuario();
		assertFalse (usuario.getTipoDeUsuario().getClass().equals(usuarioBasico.getClass()));
	}
	
	@Test
	public void testDescenderUsuarioBasico() {
		usuario.descenderUsuario();
		assertTrue(usuario.getTipoDeUsuario().getClass().equals(usuarioBasico.getClass()));
	}

}
