package com.skillnest.web.service; // ¡Asegúrate del paquete!

import com.skillnest.web.model.Contacto; // Importa el modelo
import java.util.List;

public interface ContactoService {
    void agregar(Contacto c);
    List<Contacto> obtenerTodos();
    Contacto buscarPorNombre(String nombre);
}