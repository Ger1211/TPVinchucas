package usuario;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


public class UsuarioBasicoTestCase {

	private TipoDeUsuario usuarioBasico;
	private Usuario usuario;

	@Before
	public void setUp() throws Exception {
		usuarioBasico = new UsuarioBasico();
		usuario = new Usuario("German",usuarioBasico);
	}
	
	@Test
	public void testUnUsuarioEsBasico() {
		assertTrue(usuarioBasico.esUsuarioBasico());
		assertFalse(usuarioBasico.esUsuarioExperto());
		assertFalse(usuarioBasico.esUsuarioEspecialista());
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
