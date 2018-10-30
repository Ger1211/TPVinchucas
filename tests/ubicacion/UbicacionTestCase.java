package ubicacion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UbicacionTestCase {

	private Ubicacion ubicacion1,ubicacion2,ubicacion3;
	private List<Ubicacion> ubicaciones,resultado;

	@Before
	public void setUp() throws Exception {
		ubicacion1 = new Ubicacion(10d,20d);
		ubicacion2 = new Ubicacion(20d,10d);
		ubicacion3 = new Ubicacion(10d,20d);
		ubicaciones = new ArrayList<>();
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		resultado = new ArrayList<>();
		resultado.add(ubicacion3);
	
		
	}

	@Test
	public void testGetLatitudYLongitud() {
		assertEquals(10d,ubicacion1.getLatitud(),0);
		assertEquals(20d,ubicacion1.getLongitud(),0);
	}
	
	@Test
	public void testDistanciaEntreDosUbicaciones() {
		assertEquals(1544.7575610296099d,ubicacion1.distanciaHasta(ubicacion2),0);
	}
	
	@Test
	public void testListaDeUbicacionesAMenosDe1400KmDeLaUbicacion1() {
		assertEquals(resultado,ubicacion1.getUbicacionesAMenosDe(1400d,ubicaciones));
	}

}