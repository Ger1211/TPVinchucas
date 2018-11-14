package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import usuario.TipoDeUsuario;
import usuario.Usuario;
import usuario.UsuarioEspecialista;
import usuario.UsuarioExperto;

public class VerificacionTestCase {

	private Verificacion verificacion1,verificacion2,verificacion3;
	private Usuario usuario,otroUsuario;
	private LocalDate fechaVerificacion;
	private TipoDeUsuario especialista,experto;

	@Before
	public void setUp() throws Exception {
		fechaVerificacion = LocalDate.now();
		usuario = mock(Usuario.class);
		especialista = new UsuarioEspecialista();
		experto = new UsuarioExperto();
		otroUsuario = new Usuario("Martin",especialista);
		verificacion1 = new Verificacion("a",usuario,fechaVerificacion);
		verificacion2 = new Verificacion("a",otroUsuario,fechaVerificacion);
		verificacion3 = new Verificacion("b",usuario,fechaVerificacion);
	}

	@Test
	public void testTipoDeMuestra() {
		assertEquals("a",verificacion1.getTipoMuestra());
	}
	
	@Test
	public void testUsuarioVerificacion() {
		assertEquals(usuario,verificacion1.getUsuarioVerificacion());
	}
	
	@Test
	public void testFechaVerificacion() {
		assertEquals(fechaVerificacion,verificacion1.getFechaVerificacion());
	}
	
	@Test
	public void testVerificacionPuntosDeUsuario() {
		verificacion1.puntosDeVerificacion();
		verify(usuario).puntosDeUsuario();
	}
	
	@Test
	public void testVerificacionPorEspecialista() {
		assertTrue(verificacion2.verificadorEsEspecialista());
		assertFalse(verificacion2.verificadorEsExperto());
	}
	
	@Test
	public void testVerificacionPorExperto() {
		otroUsuario.setTipoDeUsuario(experto);
		assertTrue(verificacion2.verificadorEsExperto());
		assertFalse(verificacion2.verificadorEsEspecialista());
	}
	
	@Test
	public void testVotoAFavorYVotoEnContra() {
		assertTrue(verificacion2.votoAFavor(verificacion1));
		assertFalse(verificacion2.votoAFavor(verificacion3));
		assertTrue(verificacion2.votoEnContra(verificacion3));
		assertFalse(verificacion2.votoEnContra(verificacion1));
	}
}
