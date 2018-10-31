package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import sistema.Sistema;

public class TipoDeUsuarioTestCase {
	private Sistema sistema;
	private TipoDeUsuario tipoDeUsuario;
	private Muestra muestra,otraMuestra;
	private List<Muestra> muestras;
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
			sistema = mock(Sistema.class);
			muestra = mock(Muestra.class);
			otraMuestra = mock(Muestra.class);
			tipoDeUsuario = new UsuarioBasico(sistema);
			muestras = new ArrayList<>();
			muestras.add(muestra);
			usuario = mock(Usuario.class);
	}

	@Test
	public void testSistemaEnviarMuestra() {
		tipoDeUsuario.enviarMuestra(muestra);
		verify(sistema).enviarMuestraAlSistema(muestra);
	}
	
	@Test
	public void testCantidadDeEnvios() {
		when(muestra.usuarioEnvioMuestra(usuario)).thenReturn(true);
		assertEquals(1,tipoDeUsuario.cantidadDeEnvios(usuario, muestras),0);
	}
	
	@Test
	public void testCantidadDeRevisiones() {
		muestras.add(otraMuestra);
		when(muestra.usuarioVerifico(usuario)).thenReturn(true);
		assertEquals(1,tipoDeUsuario.cantidadDeRevisiones(usuario, muestras),0);
	}
	


}
