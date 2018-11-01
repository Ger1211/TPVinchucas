package muestra;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NivelDeVerificacionBajoMedioYAltoTestCase {
	private NivelDeVerificacion nivelBajo,nivelMedio,nivelAlto;
	private List<Verificacion> verificaciones;
	private Verificacion verificacion;
	private Muestra muestra;

	@Before
	public void setUp() throws Exception {
		nivelBajo = new NivelDeVerificacionBajo();
		nivelMedio = new NivelDeVerificacionMedio();
		nivelAlto = new NivelDeVerificacionAlto();
		verificaciones = new ArrayList<>();
		verificacion = mock(Verificacion.class);
		muestra = mock(Muestra.class);
	}

	@Test
	public void testNivelBajoAgregarVerificacion() {
		when(muestra.getVerificaciones()).thenReturn(verificaciones);
		nivelBajo.agregarVerificacion(verificacion,muestra);
		assertTrue(verificaciones.contains(verificacion));
	}

	@Test
	public void testNivelMedioAgregarVerificacion() {
		when(muestra.getVerificaciones()).thenReturn(verificaciones);
		nivelMedio.agregarVerificacion(verificacion,muestra);
		assertTrue(verificaciones.contains(verificacion));
	}
	
	@Test
	public void testNivelAltoAgregarVerificacion() {
		when(muestra.getVerificaciones()).thenReturn(verificaciones);
		nivelAlto.agregarVerificacion(verificacion, muestra);
		assertFalse(verificaciones.contains(verificacion));
	}
	

}
