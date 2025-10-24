package com.skillnest.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.skillnest.web.model.Contacto;
import com.skillnest.web.services.ContactoService;

import jakarta.validation.Valid;

@Controller
public class ContactoController {

    private final ContactoService contactoService;

    @Autowired
    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

   
    @GetMapping("/")
    public String index() {
        return "redirect:/contactos";
    }

  
    @GetMapping("/contacto/nuevo")
    public String mostrarFormulario(Model model) {
       
        model.addAttribute("contacto", new Contacto());
        return "formulario";
    }

   
    @PostMapping("/contacto/guardar")
    public String guardarContacto(
            @Valid @ModelAttribute("contacto") Contacto contacto,
            BindingResult bindingResult) {
        
        // La validación se activa. Si hay errores, regresa al formulario.
        if (bindingResult.hasErrors()) {
            return "formulario"; 
        }

        contactoService.registrar(contacto);
        // Redirige al listado
        return "redirect:/contactos";
    }


    @GetMapping("/contactos")
    public String listarContactos(Model model) {
        model.addAttribute("listaContactos", contactoService.obtenerTodos());
       
        return "lista";
    }

}
