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
	private NivelDeVerificacionBajo nivelBajo;
	private NivelDeVerificacionAlto nivelAlto;
	private NivelDeVerificacionMedio nivelMedio;
	private Verificacion verificacion1,verificacion2,verificacion3;
	private Muestra muestra,muestra2;
	private Usuario usuario,usuario2;
	private TipoDeUsuario tipoUsuarioBasico,tipoUsuarioExperto;
	private Ubicacion ubicacion;

	@Before
	public void setUp() throws Exception {
		nivelBajo = new NivelDeVerificacionBajo();
		nivelAlto = new NivelDeVerificacionAlto();
		nivelMedio = new NivelDeVerificacionMedio();
		ubicacion = mock(Ubicacion.class);
		tipoUsuarioBasico = new UsuarioBasico();
		tipoUsuarioExperto = new UsuarioExperto();
		usuario = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		verificacion1 = mock(Verificacion.class);
		verificacion2 = mock(Verificacion.class);
		verificacion3 = mock(Verificacion.class);
		
		when(verificacion1.getUsuarioVerificacion()).thenReturn(usuario);
		when(usuario.getTipoDeUsuario()).thenReturn(tipoUsuarioBasico);
		
		when(verificacion3.getUsuarioVerificacion()).thenReturn(usuario2);
		when(usuario2.getTipoDeUsuario()).thenReturn(tipoUsuarioExperto);
		
		muestra = new Muestra("a",ubicacion,usuario,verificacion1);
		muestra2 = new Muestra("b",ubicacion,usuario,verificacion3);
	}
	
	@Test
		public void testNivelDeVerificacionBajoDesdeElConstructor() {
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelBajo.getClass()));
	}
	
	
	@Test
	public void testNivelDeVerificacionAltoDesdeElConstructor() {
	assertTrue(muestra2.getNivelDeVerificacion().getClass().equals(nivelAlto.getClass()));
}

	@Test
	public void testNivelDeVerificacionMedio() {
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario);
		when(usuario.getTipoDeUsuario()).thenReturn(tipoUsuarioBasico);
		muestra.agregarVerificacion(verificacion2);
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelMedio.getClass()));
	}
	
	@Test
	public void testNivelDeVerificacionAltoAgregandoLaTerceraVerificacionDeUnUsuarioBasico() {
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario);
		when(usuario.getTipoDeUsuario()).thenReturn(tipoUsuarioBasico);
		muestra.agregarVerificacion(verificacion2);
		muestra.agregarVerificacion(verificacion2);
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelAlto.getClass()));
	}
	
	@Test
	public void testNivelDeVerificacionAltoAgregandoUnaVerificacionDeUnExperto() {
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario);
		when(usuario.getTipoDeUsuario()).thenReturn(tipoUsuarioExperto);
		muestra.agregarVerificacion(verificacion2);
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelAlto.getClass()));
	}
	
	@Test
	public void testAgregadoDeVerificacionAUnaMuestraConAltoNivelDeVerificacion() {
		when(verificacion2.getUsuarioVerificacion()).thenReturn(usuario);
		when(usuario.getTipoDeUsuario()).thenReturn(tipoUsuarioExperto);
		muestra.agregarVerificacion(verificacion2);
		muestra.agregarVerificacion(verificacion2);
		assertTrue(muestra.getNivelDeVerificacion().getClass().equals(nivelAlto.getClass()));
	}
}
