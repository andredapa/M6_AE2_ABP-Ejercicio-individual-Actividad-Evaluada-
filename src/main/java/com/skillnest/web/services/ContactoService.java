package com.skillnest.web.services;

import com.skillnest.web.services.ContactoServiceImp;
import java.util.List;

import com.skillnest.web.model.Contacto; 

public abstract class ContactoService {
	
	 public abstract Contacto registrar(Contacto contacto);
	 public abstract List<Contacto> obtenerTodos();
	 abstract List<Contacto> buscarPorNombre(String nombre);

}
