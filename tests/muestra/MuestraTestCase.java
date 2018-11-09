package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import ubicacion.Ubicacion;
import usuario.TipoDeUsuario;
import usuario.Usuario;


public class MuestraTestCase {

	private Muestra muestra1,muestra2,muestra3;
	private Ubicacion ubicacion,otraUbicacion;
	private Usuario usuario1,usuario2;
	private Verificacion verificacion;
	private Verificacion verificacion2;
	private Verificacion verificacion3 ;
	private List<Muestra> muestras,resultado;
	private List<Verificacion> resultadoVerificaciones;
	private LocalDate fechaVerificacion;
	private TipoDeUsuario tipoDeUsuario;
	private NivelDeVerificacion nivelDeVerificacion,nivelDeVerificacionBajo;

	@Before
	public void setUp() throws Exception {
		nivelDeVerificacion = mock(NivelDeVerificacion.class);
		nivelDeVerificacionBajo = new NivelDeVerificacionBajo();
		tipoDeUsuario = mock(TipoDeUsuario.class);
		fechaVerificacion = LocalDate.now();
		ubicacion = mock(Ubicacion.class);
		otraUbicacion = mock(Ubicacion.class);
		usuario1  =mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		verificacion  = mock(Verificacion.class);
		muestra1 = new Muestra("a",ubicacion,usuario1,verificacion,nivelDeVerificacion);
		verificacion2 = mock(Verificacion.class);
		verificacion3 = new Verificacion("a",usuario1,fechaVerificacion);
		muestra2 = new Muestra("a",ubicacion,usuario1,verificacion3,nivelDeVerificacion);
		muestra3 = new Muestra("a",otraUbicacion,usuario1,verificacion,nivelDeVerificacionBajo);
		muestras = new ArrayList<>();
		muestras.add(muestra2);
		muestras.add(muestra3);
		resultado = new ArrayList<>();
		resultado.add(muestra3);
		resultadoVerificaciones = new ArrayList<>();
		resultadoVerificaciones.add(verificacion);
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
	public void testVerificaciones() {
		assertEquals(resultadoVerificaciones,muestra1.getVerificaciones());
	}
	
	@Test
	public void testNivelDeVerificacion() {
		assertEquals(nivelDeVerificacion,muestra1.getNivelDeVerificacion());
	}
	
	@Test
	public void testVerificacionDeUnaMuestraNueva() {
		assertTrue(muestra1.contiene(verificacion));
	}
	
	@Test
	public void testAgregarVerificacionAMuestra() {
		muestra1.agregarVerificacion(verificacion2);
		verify(nivelDeVerificacion).agregarVerificacion(verificacion2,muestra1);
	}
	
	@Test
	public void testUsuario1VerificoMuestraYUsuario2NoVerificoMuestra(){
		assertFalse(muestra2.usuarioNoVerifico(usuario1));
		assertTrue(muestra2.usuarioNoVerifico(usuario2));
	}
	
	@Test
	public void testMuestrasCercaDeMuestra1() {
		when(ubicacion.ubicacionEstaAMenosDe(10d, otraUbicacion)).thenReturn(true);
		when(ubicacion.ubicacionEstaAMenosDe(10d, ubicacion)).thenReturn(false);
		assertEquals(resultado,muestra1.muestrasAMenosDe(10d,muestras));
	}
	
	@Test
	public void testUsuarioEnvioMuestra() {
		when(verificacion.getUsuarioVerificacion()).thenReturn(usuario1);
		assertTrue(muestra1.usuarioEnvioMuestra(usuario1));
		assertFalse(muestra1.usuarioEnvioMuestra(usuario2));
	}
	

	
	@Test
	public void testUsuarioVerificoEnElUltimoMes() {
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario2);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(tipoDeUsuario.puntosDeUsuario()).thenReturn(1);
		muestra3.agregarVerificacion(verificacion2);
		when(verificacion2.getFechaVerificacion()).thenReturn(fechaVerificacion);
		when(tipoDeUsuario.enElUltimomes(fechaVerificacion)).thenReturn(true);
		assertTrue(muestra3.usuarioVerificoEnElUltimoMes(usuario2));
		assertFalse(muestra3.usuarioVerificoEnElUltimoMes(usuario1));
		assertTrue(muestra3.estaVerificadaPorElUsuarioEnLosUltimosTreintaDias(usuario2, verificacion2, fechaVerificacion));
	}
	
}
