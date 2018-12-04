package sistema;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import ubicacion.ZonaDeCobertura;
import usuario.Usuario;

public class SistemaTestCase {

	private Sistema sistema;
	private Muestra muestra;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Muestra> muestras;
	private List<ZonaDeCobertura> zonas;
	private ZonaDeCobertura zonaDeCobertura;

	@Before
	public void setUp() throws Exception {
		muestras = new ArrayList<>();
		usuarios = new ArrayList<>();
		zonas = new ArrayList<>();
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		usuario = mock(Usuario.class);
		usuarios.add(usuario);
		muestra = mock(Muestra.class);
		muestras.add(muestra);
		sistema = new Sistema(usuarios,muestras,zonas);

	}


	@Test
	public void testAgregadoDeMuestra() {
		sistema.enviarMuestraAlSistema(muestra);
		assertTrue(sistema.getMuestras().contains(muestra));
	}
	
	@Test
	public void agregadoDeUnaNuevaZonaYActualizacionDeLaMuestra() {
		sistema.agregarZonaDeCobertura(zonaDeCobertura);
		verify(muestra).verificarYActualizarSiPertenezcoAZona(zonaDeCobertura);
	}

}
