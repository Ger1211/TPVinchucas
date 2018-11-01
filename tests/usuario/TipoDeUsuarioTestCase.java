package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import muestra.Verificacion;
import sistema.Sistema;

public class TipoDeUsuarioTestCase {
	private Sistema sistema;
	private TipoDeUsuario tipoDeUsuario;
	private Muestra muestra,otraMuestra;
	private List<Muestra> muestras;
	private Usuario usuario;
	private Verificacion verificacion1,verificacion2;
	private LocalDate hoy ;
	private List<Verificacion> verificaciones;
	
	@Before
	public void setUp() throws Exception {
			verificaciones = new ArrayList<>();
			hoy = LocalDate.now();
			verificacion1 = mock(Verificacion.class);
			verificacion2 = mock(Verificacion.class);
			verificaciones.add(verificacion1);
			verificaciones.add(verificacion2);
			sistema = mock(Sistema.class);
			muestra = mock(Muestra.class);
			otraMuestra = mock(Muestra.class);
			tipoDeUsuario = new UsuarioBasico(sistema);
			muestras = new ArrayList<>();
			muestras.add(muestra);
			usuario = mock(Usuario.class);
			
			
	}

	@Test
	public void testSistemaEnviarMuestra() {
		tipoDeUsuario.enviarMuestra(muestra,usuario);
		verify(sistema).enviarMuestraAlSistema(muestra);
	}
	
	@Test
	public void testCantidadDeEnvios() {
		when(muestra.usuarioEnvioMuestra(usuario)).thenReturn(true);
		when(muestra.getVerificaciones()).thenReturn(verificaciones);
		when(verificacion1.getFechaVerificacion()).thenReturn(hoy);
		assertEquals(1,tipoDeUsuario.cantidadDeEnvios(usuario, muestras),0);
	}
	
	@Test
	public void testCantidadDeRevisiones() {
		muestras.add(otraMuestra);
		when(muestra.usuarioVerificoEnElUltimoMes(usuario)).thenReturn(true);
		assertEquals(1,tipoDeUsuario.cantidadDeRevisiones(usuario, muestras),0);
	}
	
	@Test
	public void testAgregarVerificacion() {
		tipoDeUsuario.verificarMuestra(verificacion1, muestra,usuario);
		verify(muestra).agregarVerificacion(verificacion1);
	}


}
