package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;

public class UsuarioTestCase {

	private Usuario usuario;
	private TipoDeUsuario tipoDeUsuario1,tipoDeUsuario2;
	private Muestra muestra;
	private List<Muestra> muestras;

	@Before
	public void setUp() throws Exception {
		muestras = new ArrayList<>();
		tipoDeUsuario1 = mock(TipoDeUsuario.class);
		tipoDeUsuario2 = mock(TipoDeUsuario.class);
		usuario = new Usuario("German",tipoDeUsuario1);
		muestra = mock(Muestra.class);
		muestras.add(muestra);
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
		when(muestra.usuarioVerifico(usuario)).thenReturn(false);
		usuario.verificarMuestra("a",muestra);
		verify(tipoDeUsuario1).verificarMuestra("a",usuario,muestra);
		verify(muestra).usuarioVerifico(usuario);
	}
	
	@Test
	public void testPuntosDeVerificacionDeTipoDeUsuario() {
		usuario.puntosDeUsuario();
		verify(tipoDeUsuario1).puntosDeUsuario();
	}
	
	@Test
	public void testEnvioDeMensajesATipoDeUsuario() {
		usuario.cantidadDeEnvios(muestras);
		verify(tipoDeUsuario1).cantidadDeEnvios(usuario,muestras);
		
		usuario.cantidadDeRevisiones(muestras);
		verify(tipoDeUsuario1).cantidadDeRevisiones(usuario,muestras);
		
		usuario.ascenderUsuario();
		verify(tipoDeUsuario1).ascenderUsuario(usuario);
		
		usuario.descenderUsuario();
		verify(tipoDeUsuario1).descenderUsuario(usuario);
	}
}
