
package Persistencia.Entidades;

/**
 *
 * @author cesar
 */
public class UsuarioEntidad {

    private int id;
    private String nombre;
    private String contrasena;
    private String email;
    private String rol;
    private String telefono;
    private byte[] fotoPerfil;

    public UsuarioEntidad(int id, String nombre, String contrasena, String email, String rol, String telefono, byte[] fotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.rol = rol;
        this.telefono = telefono;
        this.fotoPerfil = fotoPerfil;
    }

    public UsuarioEntidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    @Override
    public String toString() {
        return "UsuarioEntidad{" + "id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", email=" + email + ", rol=" + rol + ", telefono=" + telefono + ", fotoPerfil=" + fotoPerfil + '}';
    }

}
