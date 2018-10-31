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

	@Before
	public void setUp() throws Exception {
		usuarios = new ArrayList<>();
		usuario = mock(Usuario.class);
		usuarios.add(usuario);
		sistema = new Sistema(usuarios);
		muestra = mock(Muestra.class);

	}


	@Test
	public void testAgregadoDeMuestra() {
		sistema.enviarMuestraAlSistema(muestra);
		assertTrue(sistema.getMuestras().contains(muestra));
	}
	
	@Test
	public void testUsuarioCambioAExperto(){
		when(usuario.cantidadDeEnvios()).thenReturn(11);
		when(usuario.cantidadDeRevisiones()).thenReturn(21);
		sistema.modificarRangoUsuarios();
		verify(usuario).cantidadDeEnvios();
		verify(usuario).cantidadDeRevisiones();
		verify(usuario).ascenderUsuario();
	}
	
	@Test
	public void testUsuarioCambioABasico() {
		when(usuario.cantidadDeEnvios()).thenReturn(5);
		sistema.modificarRangoUsuarios();
		verify(usuario).cantidadDeEnvios();
		verify(usuario).descenderUsuario();
	}

}
