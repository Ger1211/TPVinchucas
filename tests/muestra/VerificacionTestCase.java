package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class VerificacionTestCase {

	private Verificacion verificacion1,verificacion2;
	private Usuario usuario;

	@Before
	public void setUp() throws Exception {
		usuario = mock(Usuario.class);
		verificacion1 = new Verificacion("a",usuario);
		verificacion2 = new Verificacion("a",usuario);
	}

	@Test
	public void testTipoDeMuestra() {
		assertEquals("a",verificacion1.getTipoMuestra());
	}
	
	@Test
	public void testUsuarioVerificacion() {
		assertEquals(usuario,verificacion1.getUsuarioVerificacion());
	}
	
	@Test
	public void testDosVerificacionesSonIguales() {
		assertTrue(verificacion1.esIgual(verificacion2));
	}

}
