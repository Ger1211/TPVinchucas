package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import ubicacion.Ubicacion;
import usuario.Usuario;


public class MuestraTestCase {

	private Muestra muestra1,muestra2;
	private Ubicacion ubicacion;
	private Usuario usuario1,usuario2;
	private Verificacion verificacion;
	private Verificacion verificacion2;
	private Verificacion verificacion3 ;

	@Before
	public void setUp() throws Exception {
		ubicacion = mock(Ubicacion.class);
		usuario1  =mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		verificacion  = mock(Verificacion.class);
		muestra1 = new Muestra("a",ubicacion,usuario1,verificacion);
		verificacion2 = mock(Verificacion.class);
		verificacion3 = new Verificacion("a",usuario1);
		muestra2 = new Muestra("a",ubicacion,usuario1,verificacion3);

	}

	@Test
	public void testTipoDeMuestra() {
		assertEquals("a",muestra1.getTipoMuestra());
	}
	
	@Test
	public void testUbicacion() {
		assertEquals(ubicacion,muestra1.getUbicacion());
	}

	@Test
	public void testUsuarioMuestra() {
		assertEquals(usuario1,muestra1.getUsuarioMuestra());
	}
	
	@Test
	public void testVerificacionDeUnaMuestraNueva() {
		assertTrue(muestra1.contiene(verificacion));
	}
	
	@Test
	public void testAgregarVerificacionAMuestra() {
		muestra1.agregarVerificacion(verificacion2);
		assertTrue(muestra1.contiene(verificacion2));
	}
	
	@Test
	public void testUsuario1VerificoMuestraYUsuario2NoVerificoMuestra(){
		assertTrue(muestra2.usuarioVerifico(usuario1));
		assertFalse(muestra2.usuarioVerifico(usuario2));
	}
}
