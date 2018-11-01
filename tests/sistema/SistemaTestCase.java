package sistema;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import usuario.Usuario;

public class SistemaTestCase {

	private Sistema sistema;
	private Muestra muestra;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Muestra> muestras;

	@Before
	public void setUp() throws Exception {
		muestras = new ArrayList<>();
		usuarios = new ArrayList<>();
		usuario = mock(Usuario.class);
		usuarios.add(usuario);
		muestra = mock(Muestra.class);
		muestras.add(muestra);
		sistema = new Sistema(usuarios,muestras);

	}


	@Test
	public void testAgregadoDeMuestra() {
		sistema.enviarMuestraAlSistema(muestra);
		assertTrue(sistema.getMuestras().contains(muestra));
	}
	

}
