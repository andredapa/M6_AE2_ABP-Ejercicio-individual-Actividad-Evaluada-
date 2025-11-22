package com.skillnest.web.service;

import com.skillnest.web.model.Contacto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService {
	
	// Lista local estática (simulación de base de datos en memoria)
    private static final List<Contacto> contactos = new ArrayList<>();
    
    @Override
    public void agregar(Contacto c) {
        contactos.add(c);
    }

    @Override
    public List<Contacto> obtenerTodos() {
        // Devuelve una copia defensiva
        return new ArrayList<>(contactos); 
    }

    @Override
    public Contacto buscarPorNombre(String nombre) {
        return contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

}
