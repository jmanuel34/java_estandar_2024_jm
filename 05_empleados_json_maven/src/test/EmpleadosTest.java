package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.EmpleadosService;
	
class EmpleadosTest {
	static  EmpleadosService service= new EmpleadosService();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		final EmpleadosService service= new EmpleadosService();
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testEmpleadosDepartamento() {
		assertEquals(2, service.listadoPorDepartamento("RRHH").size());
		assertEquals(2, service.listadoPorDepartamento("RRHH").size());
	}
	@Test
	void testEmpleadoMayorSalario() {
		assertEquals("Javier", service.mayorSalario().getEmpleado());
	}


}
