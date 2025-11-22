package com.skillnest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // <-- 1. Importación necesaria
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model; // Ya está correcta la importación de Model

import com.skillnest.web.model.Contacto;
import com.skillnest.web.service.ContactoService;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;

@Controller // <-- 2. ¡Anotación crucial AÑADIDA!
public class ContactoController {
    
	@Autowired // Inyección de Dependencias
	private ContactoService servicio;
	
    // Línea 14 (ahora funciona porque la clase es un @Controller)
	@GetMapping("/form") 
    public String mostrarFormulario(Model model) {
        // Se añade un objeto vacío para el binding del formulario
        model.addAttribute("contacto", new Contacto()); 
        return "formulario"; // Devuelve la vista formulario.html
    }
    
    // 2. Acción para recibir el formulario (POST)
	@PostMapping("/form")
    public String procesarFormulario(
            @Valid @ModelAttribute("contacto") Contacto contacto, 
            BindingResult bindingResult, // Contiene los errores de validación
            RedirectAttributes redirectAttributes) {
        
        // Verificar si hay errores de validación
        if (bindingResult.hasErrors()) {
            // Si hay errores, se regresa a la vista para mostrar los mensajes
            return "formulario"; 
        }

        servicio.agregar(contacto);
        
        // Se usa RedirectAttributes para pasar el mensaje después de la redirección
        redirectAttributes.addFlashAttribute("msg", "Contacto registrado exitosamente."); 
        return "redirect:/lista";
    }

    // Línea 31 (ahora funciona porque la clase es un @Controller)
    @GetMapping("/lista")
    public String listar(Model model) {
        // Se obtienen los datos de la capa de servicio
        model.addAttribute("contactos", servicio.obtenerTodos()); 
        return "lista"; // Devuelve la vista lista.html
    }
}