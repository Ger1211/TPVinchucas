package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import sistema.Sistema;

public class UsuarioEspecialistaTestCase {

	private TipoDeUsuario usuarioEspecialista;
	private Sistema sistema;
	@Before
	public void setUp() throws Exception {
		sistema = mock(Sistema.class);
		usuarioEspecialista = new UsuarioEspecialista(sistema);
		
	}

	@Test
	public void testPuntosDeUsuarioEspecialista() {
		assertEquals(3,usuarioEspecialista.puntosDeUsuario(),0);
	}

}
