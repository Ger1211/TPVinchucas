package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;

public class UsuarioTestCase {

	private Usuario usuario;
	private TipoDeUsuario tipoDeUsuario1,tipoDeUsuario2;
	private Muestra muestra;

	@Before
	public void setUp() throws Exception {
		tipoDeUsuario1 = mock(TipoDeUsuario.class);
		tipoDeUsuario2 = mock(TipoDeUsuario.class);
		usuario = new Usuario("German",tipoDeUsuario1);
		muestra = mock(Muestra.class);
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
	
	@Test
	public void testVerificarMuestra() {
		usuario.verificarMuestra("a",muestra);
		verify(tipoDeUsuario1).verificarMuestra("a",usuario,muestra);
	}
	
	@Test
	public void testPuntosDeVerificacionDeTipoDeUsuario() {
		usuario.puntosDeUsuario();
		verify(tipoDeUsuario1).puntosDeUsuario();
	}
}
