package com.skillnest.web;

import static org.junit.jupiter.api.Assertions.assertEquals; // <-- ¡NUEVA IMPORTACIÓN!
import static org.junit.jupiter.api.Assertions.assertNotNull; // Recomendado para verificar si se encontró algo

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skillnest.web.model.Contacto;
import com.skillnest.web.service.ContactoService;



@SpringBootTest
public class ContactoServiceTest {

    @Autowired
    private ContactoService servicio;

    @Test
    void agregarYListarContactos() {
        // Asegúrate de que el servicio esté listo para la prueba (ej. que la lista esté vacía o conocida)
        
        Contacto c = new Contacto("Juan", "juan@mail.com", "12345");
        servicio.agregar(c);

        // 1. Verificar el tamaño de la lista
        assertEquals(1, servicio.obtenerTodos().size(), "Debería haber un contacto en la lista.");
        
        // 2. Verificar la búsqueda por nombre (Añadiendo un assertNotNull antes)
        Contacto contactoEncontrado = servicio.buscarPorNombre("Juan");
        assertNotNull(contactoEncontrado, "El contacto 'Juan' no debería ser nulo.");
        assertEquals("Juan", contactoEncontrado.getNombre(), "El nombre del contacto encontrado debe ser 'Juan'.");
    }

   
}