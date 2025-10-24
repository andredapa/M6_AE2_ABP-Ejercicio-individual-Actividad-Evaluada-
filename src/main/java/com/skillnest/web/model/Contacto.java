package com.skillnest.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Contacto {
	
	// 6. Validación: Campos obligatorios y formato de correo
    @NotBlank(message = "El nombre es obligatorio.")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio.")
    @Pattern(regexp = "^.+@.+\\..+$", message = "Formato de correo inválido.")
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio.")
    private String telefono;

	public Contacto(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


}
