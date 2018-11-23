package ubicacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import observer.Observador;

public class ZonaDeCoberturaTestCase {

	private ZonaDeCobertura zonaDeCobertura1,zonaDeCobertura2,zonaDeCobertura3;
	private Ubicacion ubicacion1,ubicacion2,ubicacion3;
	private Observador observador1;
	private Muestra muestra1;
	
	@Before
	public void setUp() throws Exception {
		observador1 = mock(Observador.class);
		ubicacion1 = new Ubicacion(20.0,30.0);
		ubicacion2 = new Ubicacion(15.0,25.0);
		ubicacion3 = new Ubicacion(2500.0,2500.0);
		zonaDeCobertura1 = new ZonaDeCobertura("Avellaneda",ubicacion1,1000.0);
		zonaDeCobertura2= new ZonaDeCobertura("Gerli",ubicacion2,200.0);
		zonaDeCobertura3 = new ZonaDeCobertura("Mar del Plata",ubicacion3,200.0);
        muestra1 = mock(Muestra.class);
        
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
	public void testSolapamiento() {
		assertTrue(zonaDeCobertura1.seSolapaCon(zonaDeCobertura2));
		assertFalse(zonaDeCobertura1.seSolapaCon(zonaDeCobertura3));
	}
	
	@Test
	public void testAgregarObservador() {
		zonaDeCobertura1.agregarObservador(observador1);
		assertTrue(zonaDeCobertura1.getObservadores().contains(observador1));
	}
	
	@Test
	public void testEliminarObservador() {
		zonaDeCobertura1.agregarObservador(observador1);
		zonaDeCobertura1.eliminarObservador(observador1);
		assertFalse(zonaDeCobertura1.getObservadores().contains(observador1));
	}
	
	@Test
	public void testNotificarAObservador(){
		zonaDeCobertura1.agregarObservador(observador1);
		zonaDeCobertura1.notificar(muestra1);
		verify(observador1).actualizar(zonaDeCobertura1, muestra1);
	}
}
