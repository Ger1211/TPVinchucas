package organizacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrganizacionTestCase {

	private Organizacion organizacion;

	@Before
	public void setUp() throws Exception {
		organizacion = new Organizacion("Salud",5000);
	}

	@Test
	public void test() {
		assertEquals("Salud",organizacion.getTipo());
	}
	
	@Test
	public void testNroEmpleados5000() {
		assertEquals(5000,organizacion.getNroEmpleados(),0);
	}
}
