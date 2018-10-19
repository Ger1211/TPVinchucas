package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import ubicacion.Ubicacion;
import usuario.Usuario;


public class MuestraTestCase {

	private Muestra muestra;
	private Ubicacion ubicacion;
	private Usuario usuario;

	@Before
	public void setUp() throws Exception {
		ubicacion = mock(Ubicacion.class);
		usuario  =mock(Usuario.class);
		muestra = new Muestra("a",ubicacion,usuario);
	}

	@Test
	public void testTipoDeMuestra() {
		assertEquals("a",muestra.getTipoMuestra());
	}
	
	@Test
	public void testUbicacion() {
		assertEquals(ubicacion,muestra.getUbicacion());
	}

	@Test
	public void testUsuarioMuestra() {
		assertEquals(usuario,muestra.getUsuarioMuestra());
	}
}
