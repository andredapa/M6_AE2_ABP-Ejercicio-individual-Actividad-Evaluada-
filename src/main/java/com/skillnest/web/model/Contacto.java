package com.skillnest.web.model;

public class Contacto {
	

    private String nombre;
	private String correo;
	private String telefono;
	// --- Constructores (Necesarios para Spring Form Binding) ---
    public Contacto() {
    }

    public Contacto(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // --- Getters y Setters (Necesarios para Spring Form Binding) ---
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

}
