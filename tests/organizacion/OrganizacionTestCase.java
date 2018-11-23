package organizacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import muestra.Muestra;
import ubicacion.ZonaDeCobertura;

public class OrganizacionTestCase {

	private Organizacion organizacion;
	private List<FuncionalidadExterna> funcionalidades;
    private FuncionalidadExterna funcionalidad1;
    private ZonaDeCobertura zona1;
    private Muestra muestra1;
    
	@Before
	public void setUp() throws Exception {
		funcionalidades = new ArrayList<>();
		funcionalidad1   = mock(FuncionalidadExterna.class);
		funcionalidades.add(funcionalidad1);
		organizacion = new Organizacion("Salud",5000,funcionalidades);
		zona1 = mock(ZonaDeCobertura.class);
		muestra1 = mock(Muestra.class);
	}

	@Test
	public void test() {
		assertEquals("Salud",organizacion.getTipo());
	}
	
	@Test
	public void testNroEmpleados5000() {
		assertEquals(5000,organizacion.getNroEmpleados(),0);
	}
	
	@Test
	public void testNuevoEventoDeFuncionalidad(){
	      organizacion.actualizar(zona1, muestra1);
	      verify(funcionalidad1).nuevoEvento(organizacion, zona1, muestra1);
	}
}
