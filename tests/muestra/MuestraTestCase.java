package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import ubicacion.Ubicacion;
import usuario.Usuario;


public class MuestraTestCase {

	private Muestra muestra1,muestra2,muestra3;
	private Ubicacion ubicacion,otraUbicacion;
	private Usuario usuario1,usuario2;
	private Verificacion verificacion;
	private Verificacion verificacion2;
	private Verificacion verificacion3 ;
	private List<Muestra> muestras,resultado;

	@Before
	public void setUp() throws Exception {
		ubicacion = mock(Ubicacion.class);
		otraUbicacion = mock(Ubicacion.class);
		usuario1  =mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		verificacion  = mock(Verificacion.class);
		muestra1 = new Muestra("a",ubicacion,usuario1,verificacion);
		verificacion2 = mock(Verificacion.class);
		verificacion3 = new Verificacion("a",usuario1);
		muestra2 = new Muestra("a",ubicacion,usuario1,verificacion3);
		muestra3 = new Muestra("a",otraUbicacion,usuario1,verificacion);
		muestras = new ArrayList<>();
		muestras.add(muestra2);
		muestras.add(muestra3);
		resultado = new ArrayList<>();
		resultado.add(muestra3);
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
	
	@Test
	public void testMuestrasCercaDeMuestra1() {
		when(ubicacion.ubicacionEstaAMenosDe(10d, otraUbicacion)).thenReturn(true);
		when(ubicacion.ubicacionEstaAMenosDe(10d, ubicacion)).thenReturn(false);
		assertEquals(resultado,muestra1.muestrasAMenosDe(10d,muestras));
	}
}
