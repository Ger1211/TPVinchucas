package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import sistema.Sistema;

public class TipoDeUsuarioTestCase {
	Sistema sistema;
	TipoDeUsuario tipoDeUsuario;
	Muestra muestra;
	@Before
	public void setUp() throws Exception {
			sistema = mock(Sistema.class);
			muestra = mock(Muestra.class);
			tipoDeUsuario = new TipoDeUsuario(sistema);
	}

	@Test
	public void testSistemaEnviarMuestra() {
		tipoDeUsuario.enviarMuestra(muestra);
		verify(sistema).enviarMuestraAlSistema(muestra);
	}

}
