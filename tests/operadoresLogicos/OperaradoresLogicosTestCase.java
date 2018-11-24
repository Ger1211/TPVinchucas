package operadoresLogicos;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;

public class OperaradoresLogicosTestCase {
	private Filtro criterio1,criterio2;
	private OperadorLogico and,or;
	private List<Filtro> filtros;
	private List<Muestra> muestras,resultadoAnd,resultadoOr,listaCriterio1,listaCriterio2;
	private Muestra muestra1,muestra2,muestra3;
	
	@Before
	public void setUp() throws Exception {
		criterio1 = mock(CriterioNivelDeValidacion.class);
		criterio2 = mock(CriterioTipoDeMuestraDetectado.class);
		filtros = new ArrayList<>();
		filtros.add(criterio1);
		filtros.add(criterio2);
		and = new And(filtros);
		or = new Or(filtros); 
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestras = new ArrayList<>();
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		resultadoAnd = new ArrayList<>();
		resultadoAnd.add(muestra2);
		listaCriterio1 = new ArrayList<>();
		listaCriterio2 = new ArrayList<>();
		resultadoOr = new ArrayList<>();
		resultadoOr.add(muestra1);
		resultadoOr.add(muestra3);
	}

	@Test
	public void testFiltroAndOr() {
		assertEquals(filtros,and.getOperadores());
		assertEquals(filtros,or.getOperadores());
	}
	
	@Test
	public void filtrarPorCriterioAnd() {
		listaCriterio1.add(muestra1);
		listaCriterio1.add(muestra2);
		listaCriterio2.add(muestra2);
		when(criterio1.filtrarPorCriterio(muestras)).thenReturn(listaCriterio1);
		when(criterio2.filtrarPorCriterio(listaCriterio1)).thenReturn(listaCriterio2);
		assertEquals(resultadoAnd,and.filtrarPorCriterio(muestras));
	}
	
	@Test
	public void filtrarPorCriterioOr() {
		listaCriterio1.add(muestra1);
		listaCriterio1.add(muestra3);
		listaCriterio2.add(muestra3);
		when(criterio1.filtrarPorCriterio(muestras)).thenReturn(listaCriterio1);
		when(criterio2.filtrarPorCriterio(muestras)).thenReturn(listaCriterio2);
		assertEquals(resultadoOr,or.filtrarPorCriterio(muestras));
	}
}
