package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import sistema.Sistema;

public class UsuarioBasicoTestCase {

	private TipoDeUsuario usuarioBasico;
	private Sistema sistema;

	@Before
	public void setUp() throws Exception {
		sistema = mock(Sistema.class);
		usuarioBasico = new UsuarioBasico(sistema);
	}

	@Test
	public void testUsuarioBasicoPuntosDeUsuario() {
		assertEquals(1,usuarioBasico.puntosDeUsuario(),0);
	}

}
