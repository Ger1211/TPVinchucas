package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import sistema.Sistema;

public class UsuarioExpertoTestCase {

	private TipoDeUsuario usuarioExperto;
	private Sistema sistema;

	@Before
	public void setUp() throws Exception {
		sistema = mock(Sistema.class);
		usuarioExperto = new UsuarioExperto(sistema);
	}

	@Test
	public void testPuntosDeUsuarioExperto() {
		assertEquals(3,usuarioExperto.puntosDeUsuario(),0);
	}

}
