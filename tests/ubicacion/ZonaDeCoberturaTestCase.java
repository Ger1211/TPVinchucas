package ubicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;

public class ZonaDeCoberturaTestCase {

	private ZonaDeCobertura zonaDeCobertura1,zonaDeCobertura2,zonaDeCobertura3;
	private Ubicacion ubicacion1,ubicacion2,ubicacion3;
	private Muestra muestra1,muestra2,muestra3;
	private List<Muestra> resultado,muestras;
	
	@Before
	public void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestras = new ArrayList<>();
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		ubicacion1 = new Ubicacion(20.0,30.0);
		ubicacion2 = new Ubicacion(15.0,25.0);
		ubicacion3 = new Ubicacion(2500.0,2500.0);
		
		when(muestra1.getUbicacion()).thenReturn(ubicacion1);
		when(muestra2.getUbicacion()).thenReturn(ubicacion2);
		when(muestra3.getUbicacion()).thenReturn(ubicacion3);
		
		zonaDeCobertura1 = new ZonaDeCobertura("Avellaneda",ubicacion1,1000.0,muestras);
		zonaDeCobertura2= new ZonaDeCobertura("Gerli",ubicacion2,200.0,muestras);
		zonaDeCobertura3 = new ZonaDeCobertura("Mar del Plata",ubicacion3,200.0,muestras);
		resultado = new ArrayList<>();
		resultado.add(muestra1);
		resultado.add(muestra2);
	}

	@Test
	public void testGetNombreDeUnaZonaDeCobertura() {
		assertEquals("Avellaneda",zonaDeCobertura1.getNombreZona());
	}

	@Test
	public void testGetEpicentro() {
		assertEquals(ubicacion1,zonaDeCobertura1.getEpicentro());
	}
	
	@Test
	public void testGetRadio() {
		assertEquals(1000.0,zonaDeCobertura1.getRadio(),0);
	}
	
	@Test
	public void testUbicacionPerteneceAZonaDeCobertura() {
		assertTrue(zonaDeCobertura1.perteneceAZonaDeCobertura(ubicacion2));
		assertFalse(zonaDeCobertura1.perteneceAZonaDeCobertura(ubicacion3));
	}
	
	@Test
	public void testMuestrasPertenecenAlAreaDeCobertura() {
		assertEquals(resultado,zonaDeCobertura1.getMuestrasEnElArea());
	}
	
	@Test
	public void testSolapamiento() {
		assertTrue(zonaDeCobertura1.seSolapaCon(zonaDeCobertura2));
		assertFalse(zonaDeCobertura1.seSolapaCon(zonaDeCobertura3));
	}
	
}
