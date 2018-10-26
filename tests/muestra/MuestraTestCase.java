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
	private Verificacion verificacion;
	private Verificacion verificacion2;

	@Before
	public void setUp() throws Exception {
		ubicacion = mock(Ubicacion.class);
		usuario  =mock(Usuario.class);
		verificacion  = mock(Verificacion.class);
		muestra = new Muestra("a",ubicacion,usuario,verificacion);
		verificacion2 = mock(Verificacion.class);
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
	
	@Test
	public void testVerificacionDeUnaMuestraNueva() {
		assertTrue(muestra.contiene(verificacion));
	}
	
	@Test
	public void testAgregarVerificacionAMuestra() {
		muestra.agregarVerificacion(verificacion2);
		assertTrue(muestra.contiene(verificacion2));
	}
}
