package operadoresLogicos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import muestra.NivelDeVerificacion;

public class CriterioDeBusquedaTestCase {

	
	
	private List<Muestra> resultadoFechaCreacion,resultadoFechaVerificacion,resultadoTipoMuestra,resultadoNivelValidacion;
	private FechaCreacionMuestra fechaCreacion;
	private FechaUltimaVerificacion fechaVerificacion;
	private TipoDeMuestraDetectado tipoMuestraDetectado;
	private NivelDeValidacion nivelDeValidacion;
	private LocalDate  fecha1,fecha2;
	private List<Muestra> muestras;
    private Muestra muestra1, muestra2, muestra3;
	private NivelDeVerificacion nivelVerificacion1,nivelVerificacion2;
	
	@Before
	public void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		nivelVerificacion1 = mock(NivelDeVerificacion.class);
		nivelVerificacion2 = mock(NivelDeVerificacion.class);
		muestras = new ArrayList<>();
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		fecha1 = LocalDate.now();
		fecha2 = LocalDate.of(2014, 10, 13);
		
		fechaCreacion = new FechaCreacionMuestra(fecha1);
		fechaVerificacion = new FechaUltimaVerificacion(fecha1);
		tipoMuestraDetectado = new TipoDeMuestraDetectado("Vinchuca");
		nivelDeValidacion = new NivelDeValidacion(nivelVerificacion1);
		
		resultadoFechaCreacion = new ArrayList<>();
		resultadoFechaCreacion.add(muestra2);
		resultadoFechaVerificacion = new ArrayList<>();
		resultadoFechaVerificacion.add(muestra1);
		resultadoFechaVerificacion.add(muestra2);
		resultadoTipoMuestra = new ArrayList<>();
		resultadoTipoMuestra.add(muestra3);
		resultadoNivelValidacion = new ArrayList<>();
		resultadoNivelValidacion.add(muestra2);
	}

	@Test
	public void testFechaCreacionMuestra() {
		when(muestra1.getFechaCreacion()).thenReturn(fecha2);
		when(muestra3.getFechaCreacion()).thenReturn(fecha2);
		when(muestra2.getFechaCreacion()).thenReturn(fecha1);
		assertEquals(resultadoFechaCreacion,fechaCreacion.filtrarPorCriterio(muestras));
	}

	@Test
	public void testFechaVerificacion() {
		when(muestra1.getFechaUltimaVerificacion()).thenReturn(fecha2);
		when(muestra2.getFechaUltimaVerificacion()).thenReturn(fecha2);
		when(muestra3.getFechaUltimaVerificacion()).thenReturn(fecha1);
		assertEquals(resultadoFechaVerificacion,fechaVerificacion.filtrarPorCriterio(muestras));
	}
	
	@Test
	public void testTipoDeMuestra() {
		when(muestra1.verificar()).thenReturn("Chinche");
		when(muestra2.verificar()).thenReturn("Chinche");
		when(muestra3.verificar()).thenReturn("Vinchuca");
		assertEquals(resultadoTipoMuestra,tipoMuestraDetectado.filtrarPorCriterio(muestras));
	}
	
	@Test
	public void testNivelValidacion() {
		when(muestra1.getNivelDeVerificacion()).thenReturn(nivelVerificacion2);
		when(muestra2.getNivelDeVerificacion()).thenReturn(nivelVerificacion1);
		when(muestra3.getNivelDeVerificacion()).thenReturn(nivelVerificacion2);
		assertEquals(resultadoNivelValidacion,nivelDeValidacion.filtrarPorCriterio(muestras));
	}
}
