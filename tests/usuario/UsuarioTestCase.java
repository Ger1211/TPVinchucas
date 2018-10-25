package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTestCase {

	private Usuario usuario;
	private TipoDeUsuario tipoDeUsuario1,tipoDeUsuario2;

	@Before
	public void setUp() throws Exception {
		tipoDeUsuario1 = mock(TipoDeUsuario.class);
		tipoDeUsuario2 = mock(TipoDeUsuario.class);
		usuario = new Usuario("German",tipoDeUsuario1);
	}

	@Test
	public void testUsuarioAliasGerman() {
		assertEquals("German",usuario.getAlias());
	}
	
	@Test
	public void testTipoDeUsuario() {
		assertEquals(tipoDeUsuario1,usuario.getTipoDeUsuario());
	}
	
	@Test
	public void testSetTipoDeUsuario() {
		usuario.setTipoDeUsuario(tipoDeUsuario2);
		assertEquals(tipoDeUsuario2,usuario.getTipoDeUsuario());
	}
}
