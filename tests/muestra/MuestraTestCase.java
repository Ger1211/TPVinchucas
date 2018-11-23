
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
import ubicacion.ZonaDeCobertura;
import usuario.TipoDeUsuario;
import usuario.Usuario;


public class MuestraTestCase {

	private Muestra muestra1,muestra2,muestra3;
	private Ubicacion ubicacion,otraUbicacion;
	private Usuario usuario1,usuario2,usuario3;
	private Verificacion verificacion;
	private Verificacion verificacion2;
	private Verificacion verificacion3,verificacion4 ;
	private List<Muestra> muestras,resultado;
	private List<Verificacion> resultadoVerificaciones;
	private LocalDate fechaVerificacion;
	private TipoDeUsuario tipoDeUsuario;
	private NivelDeVerificacion nivelDeVerificacion,nivelDeVerificacionBajo;
	private ZonaDeCobertura zonaDeCobertura1,zonaDeCobertura2;
	private List<ZonaDeCobertura> zonas,resultadoZonas;
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
		usuario3 = mock(Usuario.class);
		verificacion  = mock(Verificacion.class);
		muestra1 = new Muestra("a",ubicacion,usuario1,verificacion,nivelDeVerificacion);
		verificacion2 = mock(Verificacion.class);
		verificacion3 = new Verificacion("a",usuario1,fechaVerificacion);
		verificacion4 = mock(Verificacion.class);
		muestra2 = new Muestra("a",ubicacion,usuario1,verificacion3,nivelDeVerificacion);
		muestra3 = new Muestra("a",otraUbicacion,usuario1,verificacion,nivelDeVerificacionBajo);
		muestras = new ArrayList<>();
		muestras.add(muestra2);
		muestras.add(muestra3);
		resultado = new ArrayList<>();
		resultado.add(muestra3);
		resultadoVerificaciones = new ArrayList<>();
		resultadoVerificaciones.add(verificacion);
		zonaDeCobertura1 = mock(ZonaDeCobertura.class);
		zonaDeCobertura2 = mock(ZonaDeCobertura.class);
		zonas = new ArrayList<>();
		zonas.add(zonaDeCobertura1);
		zonas.add(zonaDeCobertura2);
		resultadoZonas = new ArrayList<>();
		resultadoZonas.add(zonaDeCobertura1);
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
	
	
	@Test
public void testVerificarMuestraDeVinchucaPorUnUsuarioEspecialista() {
		when(verificacion.getUsuarioVerificacion()).thenReturn(usuario1);
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario2);
		when(verificacion4.getUsuarioVerificacion()).thenReturn(usuario3);
		when(usuario1.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario3.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(tipoDeUsuario.puntosDeUsuario()).thenReturn(1);
		muestra3.agregarVerificacion(verificacion2);
		muestra3.agregarVerificacion(verificacion4);
		when(verificacion.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion2.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion4.verificadorEsEspecialista()).thenReturn(true);
		when(verificacion4.votoAFavor(verificacion4)).thenReturn(true);
		when(verificacion4.getTipoMuestra()).thenReturn("a");
		assertEquals("a",muestra3.verificar());
	}
	

@Test
public void testVerificarMuestraDeVinchucaPorDosUsuariosEspecialistasQueVotaronIgual() {
		//Agregado de las verificaciones
		when(verificacion.getUsuarioVerificacion()).thenReturn(usuario1);
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario2);
		when(verificacion4.getUsuarioVerificacion()).thenReturn(usuario3);
		when(usuario1.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario3.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(tipoDeUsuario.puntosDeUsuario()).thenReturn(1);
		muestra3.agregarVerificacion(verificacion2);
		muestra3.agregarVerificacion(verificacion4);
		// Verificacion de usuario especialista
		when(verificacion.verificadorEsEspecialista()).thenReturn(true);
		when(verificacion2.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion4.verificadorEsEspecialista()).thenReturn(true);
		// Verificacion cantidad de votos
		when(verificacion.getTipoMuestra()).thenReturn("a");
		when(verificacion.votoAFavor(verificacion)).thenReturn(true);
		when(verificacion.votoAFavor(verificacion4)).thenReturn(true);
		when(verificacion.votoEnContra(verificacion)).thenReturn(false);
		when(verificacion.votoEnContra(verificacion4)).thenReturn(false);
		assertEquals("a",muestra3.verificar());
	}

	
@Test
public void testVerificarMuestraDeVinchucaPorDosUsuariosEspecialistasQueNoVotaronIgual() {
		// Agregar verificaciones
		when(verificacion.getUsuarioVerificacion()).thenReturn(usuario1);
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario2);
		when(verificacion4.getUsuarioVerificacion()).thenReturn(usuario3);
		when(usuario1.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario3.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(tipoDeUsuario.puntosDeUsuario()).thenReturn(1);
		muestra3.agregarVerificacion(verificacion2);
		muestra3.agregarVerificacion(verificacion4);
		// Verificacion de usuario especialista
		when(verificacion.verificadorEsEspecialista()).thenReturn(true);
		when(verificacion2.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion4.verificadorEsEspecialista()).thenReturn(true);
		// Verificacion de usuario experto
		when(verificacion.verificadorEsExperto()).thenReturn(false);
		when(verificacion2.verificadorEsExperto()).thenReturn(false);
		when(verificacion4.verificadorEsExperto()).thenReturn(false);
		// Verificacion de votos a favor
		when(verificacion.votoAFavor(verificacion)).thenReturn(true);
		when(verificacion.votoAFavor(verificacion4)).thenReturn(false);
		when(verificacion4.votoAFavor(verificacion)).thenReturn(false);
		when(verificacion4.votoAFavor(verificacion4)).thenReturn(true);
		// Verificacion votos en contra
		when(verificacion.votoEnContra(verificacion)).thenReturn(false);
		when(verificacion.votoEnContra(verificacion4)).thenReturn(true);
		when(verificacion4.votoEnContra(verificacion)).thenReturn(true);
		when(verificacion4.votoEnContra(verificacion4)).thenReturn(false);
		when(verificacion.getTipoMuestra()).thenReturn("b");
		when(verificacion4.getTipoMuestra()).thenReturn("a");
		when(verificacion2.getTipoMuestra()).thenReturn("c");
		assertEquals("Muestra no identificada",muestra3.verificar());
	}

@Test
public void testVerificarMuestraDeVinchucaPorDosUsuariosExpertosQueVotaronIgual() {
		// Agregado verificaciones
		when(verificacion.getUsuarioVerificacion()).thenReturn(usuario1);
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario2);
		when(verificacion4.getUsuarioVerificacion()).thenReturn(usuario3);
		when(usuario1.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario3.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(tipoDeUsuario.puntosDeUsuario()).thenReturn(1);
		muestra3.agregarVerificacion(verificacion2);
		muestra3.agregarVerificacion(verificacion4);
		// Verificacion usuario especialista
		when(verificacion.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion2.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion4.verificadorEsEspecialista()).thenReturn(false);
		// Verificacion usuario experto
		when(verificacion.verificadorEsExperto()).thenReturn(true);
		when(verificacion2.verificadorEsExperto()).thenReturn(false);
		when(verificacion4.verificadorEsExperto()).thenReturn(true);
		// Verificacion voto a favor
		when(verificacion.votoAFavor(verificacion)).thenReturn(true);
		when(verificacion.votoAFavor(verificacion4)).thenReturn(true);
		// Verificacion voto en contra
		when(verificacion.votoEnContra(verificacion)).thenReturn(false);
		when(verificacion.votoEnContra(verificacion4)).thenReturn(false);
		when(verificacion.getTipoMuestra()).thenReturn("a");
		when(verificacion4.getTipoMuestra()).thenReturn("a");
		assertEquals("a",muestra3.verificar());
	}


@Test
public void testVerificarMuestraDeVinchucaPorDosUsuariosExpertosQueNoVotaronIgual() {
		// Agregado de verificaciones
		when(verificacion.getUsuarioVerificacion()).thenReturn(usuario1);
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario2);
		when(verificacion4.getUsuarioVerificacion()).thenReturn(usuario3);
		when(usuario1.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario3.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(tipoDeUsuario.puntosDeUsuario()).thenReturn(1);
		muestra3.agregarVerificacion(verificacion2);
		muestra3.agregarVerificacion(verificacion4);
		// Verificacion usuarios especialistas
		when(verificacion.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion2.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion4.verificadorEsEspecialista()).thenReturn(false);
		// Verificacion usuarios expertos
		when(verificacion.verificadorEsExperto()).thenReturn(true);
		when(verificacion2.verificadorEsExperto()).thenReturn(false);
		when(verificacion4.verificadorEsExperto()).thenReturn(true);
		// Verificacion votos a favor
		when(verificacion.votoAFavor(verificacion)).thenReturn(true);
		when(verificacion.votoAFavor(verificacion4)).thenReturn(false);
		when(verificacion4.votoAFavor(verificacion)).thenReturn(false);
		when(verificacion4.votoAFavor(verificacion4)).thenReturn(true);
		// Verificacion votos en contra
		when(verificacion.votoEnContra(verificacion)).thenReturn(false);
		when(verificacion.votoEnContra(verificacion4)).thenReturn(true);
		when(verificacion4.votoEnContra(verificacion)).thenReturn(true);
		when(verificacion4.votoEnContra(verificacion4)).thenReturn(false);
		when(verificacion.getTipoMuestra()).thenReturn("b");
		when(verificacion4.getTipoMuestra()).thenReturn("a");
		when(verificacion2.getTipoMuestra()).thenReturn("c");
		assertEquals("Muestra no identificada",muestra3.verificar());
	}

@Test
public void testVerificarMuestraDeVinchucaPorDosUsuariosBasicosQueVotaronIgual() {
		when(verificacion.getUsuarioVerificacion()).thenReturn(usuario1);
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario2);
		when(verificacion4.getUsuarioVerificacion()).thenReturn(usuario3);
		when(usuario1.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario3.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(tipoDeUsuario.puntosDeUsuario()).thenReturn(1);
		muestra3.agregarVerificacion(verificacion2);
		muestra3.agregarVerificacion(verificacion4);
		when(verificacion.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion2.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion4.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion.verificadorEsExperto()).thenReturn(false);
		when(verificacion2.verificadorEsExperto()).thenReturn(false);
		when(verificacion4.verificadorEsExperto()).thenReturn(false);
		when(verificacion.votoAFavor(verificacion)).thenReturn(true);
		when(verificacion.votoAFavor(verificacion4)).thenReturn(true);
		when(verificacion4.votoAFavor(verificacion)).thenReturn(true);
		when(verificacion4.votoAFavor(verificacion4)).thenReturn(true);
		when(verificacion.getTipoMuestra()).thenReturn("b");
		when(verificacion4.getTipoMuestra()).thenReturn("b");
		when(verificacion2.getTipoMuestra()).thenReturn("c");
		assertEquals("b",muestra3.verificar());
	}

@Test
public void testVerificarMuestraDeVinchucaPorTresUsuariosBasicosQueNoVotaronIgual() {
		// Agregado de verificaciones
		when(verificacion.getUsuarioVerificacion()).thenReturn(usuario1);
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario2);
		when(verificacion4.getUsuarioVerificacion()).thenReturn(usuario3);
		when(usuario1.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(usuario3.getTipoDeUsuario()).thenReturn(tipoDeUsuario);
		when(tipoDeUsuario.puntosDeUsuario()).thenReturn(1);
		muestra3.agregarVerificacion(verificacion2);
		muestra3.agregarVerificacion(verificacion4);
		// Verificacion usuario especialista
		when(verificacion.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion2.verificadorEsEspecialista()).thenReturn(false);
		when(verificacion4.verificadorEsEspecialista()).thenReturn(false);
		// Verificacion usuario experto
		when(verificacion.verificadorEsExperto()).thenReturn(false);
		when(verificacion2.verificadorEsExperto()).thenReturn(false);
		when(verificacion4.verificadorEsExperto()).thenReturn(false);
		// Verificacion voto a favor
		when(verificacion.votoAFavor(verificacion)).thenReturn(true);
		when(verificacion.votoAFavor(verificacion4)).thenReturn(false);
		when(verificacion.votoAFavor(verificacion2)).thenReturn(false);
		when(verificacion2.votoAFavor(verificacion2)).thenReturn(true);
		when(verificacion2.votoAFavor(verificacion)).thenReturn(false);
		when(verificacion2.votoAFavor(verificacion4)).thenReturn(false);
		when(verificacion4.votoAFavor(verificacion4)).thenReturn(true);
		when(verificacion4.votoAFavor(verificacion)).thenReturn(false);
		when(verificacion4.votoAFavor(verificacion2)).thenReturn(false);
		// Verificacion voto en contra
		when(verificacion.votoEnContra(verificacion)).thenReturn(false);
		when(verificacion.votoEnContra(verificacion4)).thenReturn(true);
		when(verificacion.votoEnContra(verificacion2)).thenReturn(true);
		when(verificacion2.votoEnContra(verificacion2)).thenReturn(false);
		when(verificacion2.votoEnContra(verificacion)).thenReturn(true);
		when(verificacion2.votoEnContra(verificacion4)).thenReturn(true);
		when(verificacion4.votoEnContra(verificacion4)).thenReturn(false);
		when(verificacion4.votoEnContra(verificacion)).thenReturn(true);
		when(verificacion4.votoEnContra(verificacion2)).thenReturn(true);
		
		when(verificacion.getTipoMuestra()).thenReturn("b");
		when(verificacion4.getTipoMuestra()).thenReturn("a");
		when(verificacion2.getTipoMuestra()).thenReturn("c");
		assertEquals("Muestra no identificada",muestra3.verificar());
	}

	@Test
	public void testAgregarZonaDeCobertura() {
		when(zonaDeCobertura1.perteneceAZonaDeCobertura(ubicacion)).thenReturn(true);
		when(zonaDeCobertura2.perteneceAZonaDeCobertura(ubicacion)).thenReturn(false);
		muestra1.agregarMisZonasDeCobertura(zonas);
		assertEquals(resultadoZonas,muestra1.getZonasDeCobertura());
	}
	
	@Test
	public void testNotificarAZonas() {
		when(zonaDeCobertura1.perteneceAZonaDeCobertura(ubicacion)).thenReturn(true);
		when(zonaDeCobertura2.perteneceAZonaDeCobertura(ubicacion)).thenReturn(false);
		muestra1.agregarMisZonasDeCobertura(zonas);
		muestra1.notificarAMisZonas();
		verify(zonaDeCobertura1).notificar(muestra1);
	}
}