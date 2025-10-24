package com.skillnest.web.services;

import com.skillnest.web.services.ContactoService;
import com.skillnest.web.model.Contacto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ContactoServiceImp  implements ContactoService{
	
    // Usamos synchronized list para seguridad básica de concurrencia en prototipo.
    private final List<Contacto> contactos = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Contacto registrar(Contacto contacto) {
        contactos.add(contacto);
        return contacto;
    }

    @Override
    public List<Contacto> obtenerTodos() {
        // devolvemos copia para evitar exposición del interno
        synchronized (contactos) {
            return new ArrayList<>(contactos);
        }
    }

    @Override
    public List<Contacto> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return obtenerTodos();
        }
        String lower = nombre.toLowerCase();
        synchronized (contactos) {
            return contactos.stream()
                    .filter(c -> c.getNombre() != null && c.getNombre().toLowerCase().contains(lower))
                    .collect(Collectors.toList());
        }
    }

}
