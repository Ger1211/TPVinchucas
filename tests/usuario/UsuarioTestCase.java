package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import muestra.Verificacion;

public class UsuarioTestCase {

	private Usuario usuario;
	private TipoDeUsuario tipoDeUsuario1,tipoDeUsuario2;
	private Muestra muestra;
	private List<Muestra> muestras;
	private Verificacion verificacion;

	@Before
	public void setUp() throws Exception {
		muestras = new ArrayList<>();
		verificacion = mock(Verificacion.class);
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
	public void testEnviarMuestra()  {
		usuario.enviarMuestra(muestra);
		verify(tipoDeUsuario1).enviarMuestra(muestra,usuario);
	}
	
	@Test
	public void testVerificarMuestra() {
		when(muestra.usuarioNoVerifico(usuario)).thenReturn(true);
		usuario.verificarMuestra(verificacion,muestra);
		verify(tipoDeUsuario1).verificarMuestra(verificacion,muestra,usuario);
		verify(muestra).usuarioNoVerifico(usuario);
	}
	
	@Test 
	public void testNoVerificarMuestra() {
		when(muestra.usuarioNoVerifico(usuario)).thenReturn(false);
		usuario.verificarMuestra(verificacion, muestra);
		verifyZeroInteractions(tipoDeUsuario1);
		
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
	
	@Test
	public void testVerificacionDeEnvios() {
		when(tipoDeUsuario1.cantidadDeEnvios(usuario, muestras)).thenReturn(11);
		assertTrue(usuario.verificacionEnvios(muestras));
		
		usuario.setTipoDeUsuario(tipoDeUsuario2);
		when(tipoDeUsuario2.cantidadDeEnvios(usuario, muestras)).thenReturn(2);
		assertFalse(usuario.verificacionEnvios(muestras));
	}
	
	@Test
	public void testVerificacionDeRevisiones() {
		when(tipoDeUsuario1.cantidadDeRevisiones(usuario, muestras)).thenReturn(21);
		assertTrue(usuario.verificacionRevisiones(muestras));
		
		usuario.setTipoDeUsuario(tipoDeUsuario2);
		when(tipoDeUsuario2.cantidadDeRevisiones(usuario, muestras)).thenReturn(2);
		assertFalse(usuario.verificacionRevisiones(muestras));
	}
}
