package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import sistema.Sistema;

public class UsuarioEspecialistaTestCase {

	private TipoDeUsuario usuarioEspecialista;
	private Sistema sistema;
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		sistema = mock(Sistema.class);
		usuarioEspecialista = new UsuarioEspecialista(sistema);
		usuario = new Usuario("German",usuarioEspecialista);
	}

	@Test
	public void testPuntosDeUsuarioEspecialista() {
		assertEquals(3,usuarioEspecialista.puntosDeUsuario(),0);
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
