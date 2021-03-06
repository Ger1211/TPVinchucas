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


public class TipoDeUsuarioTestCase {
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
			muestra = mock(Muestra.class);
			otraMuestra = mock(Muestra.class);
			tipoDeUsuario = new UsuarioBasico();
			muestras = new ArrayList<>();
			muestras.add(muestra);
			usuario = mock(Usuario.class);
			
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
	
	/*
	@Test
	public void testAscensoDeUsuarioBasico() {
		when(usuario.verificacionEnvios(muestras)).thenReturn(true);
		when(usuario.verificacionRevisiones(muestras)).thenReturn(true);
		tipoDeUsuarioBasico.verificacionAscensoODescensoDeRango(usuario, muestras);
		verify(usuario).ascenderUsuario();
	}
	
	@Test
	public void testDescensoDeUsuarioBasico() {
		when(usuario.verificacionEnvios(muestras)).thenReturn(false);
		when(usuario.verificacionRevisiones(muestras)).thenReturn(true);
		tipoDeUsuarioBasico.verificacionAscensoODescensoDeRango(usuario, muestras);
		verify(usuario).descenderUsuario();
	}

	
*/	


}
