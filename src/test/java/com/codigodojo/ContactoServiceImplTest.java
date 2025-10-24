package com.codigodojo;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.skillnest.web.model.Contacto;
import  com.skillnest.web.services.ContactoServiceImp; 

 class ContactoServiceImplTest {
	 
	 private ContactoServiceImpl service;

	    @BeforeEach
	    void setup() {
	        service = new ContactoServiceImpl();
	    }

	    @Test
	    void registrarYListar_contactoAgregadoYListado() {
	        Contacto c = new Contacto("Ana", "ana@example.com", "12345678");
	        service.registrar(c);

	        List<Contacto> todos = service.obtenerTodos();
	        assertNotNull(todos);
	        assertEquals(1, todos.size());
	        assertEquals("Ana", todos.get(0).getNombre());
	    }

	    private void assertEquals(String string, String string2) {
			// TODO Auto-generated method stub
			
		}

		private void assertNotNull(List<Contacto> todos) {
			// TODO Auto-generated method stub
			
		}

		@Test
	    void buscarPorNombre_funciona() {
	        service.registrar(new Contacto("Ana", "ana@example.com", "111"));
	        service.registrar(new Contacto("Juan", "juan@example.com", "222"));
	        service.registrar(new Contacto("Anastasia", "ana2@example.com", "333"));

	        List<Contacto> encontrados = service.buscarPorNombre("ana");
	        assertEquals(2, encontrados.size());
	    }

}
