package sistema;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;

public class SistemaTestCase {

	private Sistema sistema;
	private Muestra muestra;

	@Before
	public void setUp() throws Exception {
		sistema = new Sistema();
		muestra = mock(Muestra.class);
	}


	@Test
	public void testAgregadoDeMuestra() {
		sistema.enviarMuestraAlSistema(muestra);
		assertTrue(sistema.getMuestras().contains(muestra));
	}

}
