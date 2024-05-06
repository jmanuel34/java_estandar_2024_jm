package testing;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.ContactosService;

class TestContactosService {
	static ContactosService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service=new ContactosServiceFactory.getContactosService();
	}

	@Test
	void testBuscarContactoPorId() {
		assertEquals(36, service.buscarContactoPorId(3).getEdad());
		assertNull(service.buscarContactoPorId(30));
	}

	@Test
	void testGetContactos() {
		assertEquals(4, service.getContactos().size());
	}

}
