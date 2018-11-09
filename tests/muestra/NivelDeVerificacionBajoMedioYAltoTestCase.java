package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import ubicacion.Ubicacion;
import usuario.TipoDeUsuario;
import usuario.Usuario;
import usuario.UsuarioBasico;
import usuario.UsuarioExperto;

public class NivelDeVerificacionBajoMedioYAltoTestCase {
	private NivelDeVerificacion nivelBajo,nivelMedio,nivelAlto;
	private Verificacion verificacion1,verificacion2;
	private Muestra muestra;
	private Usuario usuario;
	private TipoDeUsuario tipoUsuarioBasico,tipoUsuarioExperto;
	private Ubicacion ubicacion;

	@Before
	public void setUp() throws Exception {
		ubicacion = mock(Ubicacion.class);
		tipoUsuarioBasico = new UsuarioBasico();
		tipoUsuarioExperto = new UsuarioExperto();
		usuario = mock(Usuario.class);
		nivelBajo = new NivelDeVerificacionBajo();
		nivelMedio = new NivelDeVerificacionMedio();
		nivelAlto = new NivelDeVerificacionAlto();
		verificacion1 = mock(Verificacion.class);
		verificacion2 = mock(Verificacion.class);
		muestra = new Muestra("a",ubicacion,usuario,verificacion1,nivelBajo);
	}

	@Test
	public void testNivelBajoAgregarVerificacion() {
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario);
		when(usuario.getTipoDeUsuario()).thenReturn(tipoUsuarioBasico);
		nivelBajo.agregarVerificacion(verificacion2,muestra);
		assertTrue(muestra.getVerificaciones().contains(verificacion2));
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelMedio.getClass()));
	}
	
	@Test
	public void testNivelBajoAgregarVerificacionDeUsuarioExperto() {
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario);
		when(usuario.getTipoDeUsuario()).thenReturn(tipoUsuarioExperto);
		nivelBajo.agregarVerificacion(verificacion2,muestra);
		assertTrue(muestra.getVerificaciones().contains(verificacion2));
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelAlto.getClass()));
	}

	@Test
	public void testNivelMedioAgregarVerificacion() {
		muestra.setNivelDeVerificacion(nivelMedio);
		nivelMedio.agregarVerificacion(verificacion2,muestra);
		assertTrue(muestra.getVerificaciones().contains(verificacion2));
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelAlto.getClass()));
	}


	@Test
	public void testNivelAltoAgregarVerificacion() {
		muestra.setNivelDeVerificacion(nivelAlto);
		nivelAlto.agregarVerificacion(verificacion2, muestra);
		assertTrue(muestra.getVerificaciones().contains(verificacion2));
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelAlto.getClass()));
	}
	

}
