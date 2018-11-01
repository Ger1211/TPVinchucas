package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class VerificacionTestCase {

	private Verificacion verificacion1;
	private Usuario usuario;
	private LocalDate fechaVerificacion;

	@Before
	public void setUp() throws Exception {
		fechaVerificacion = LocalDate.now();
		usuario = mock(Usuario.class);
		verificacion1 = new Verificacion("a",usuario,fechaVerificacion);
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
	
}
