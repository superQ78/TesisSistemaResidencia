/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.DTOs;

/**
 *
 * @author cesar
 */
public class UsuarioDTO {
    
     private String id;
     private String nombre;
     private String contrasena;
     private String email;
     private String rol;

    public UsuarioDTO(String id, String nombre, String contrasena, String email, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.rol= rol;
    }

    public UsuarioDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", email=" + email + ", rol=" + rol + '}';
    }

    
    
   
     
     
    
    
}
