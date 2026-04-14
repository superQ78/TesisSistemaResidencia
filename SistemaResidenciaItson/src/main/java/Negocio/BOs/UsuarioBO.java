/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.BOs;

import Negocio.DTOs.UsuarioDTO;
import Persistencia.DAOs.UsuarioDAO;
import Persistencia.Entidades.UsuarioEntidad;

/**
 *
 * @author cesar
 */
public class UsuarioBO {

    public UsuarioDTO iniciarSesion(UsuarioDTO dto) {
        //Validar que no vengan vacios
        if (dto.getEmail().isEmpty() || dto.getContrasena().isEmpty()) {
            return null;
        }

        //Convertir DTO a Entidad 
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(dto.getContrasena());

        // Llamar al DAO
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioEntidad resultado = dao.consultarCredenciales(entidad);

        // Si el DAO responde, convertimos de vuelta a DTO para la pantalla
        if (resultado != null) {
            UsuarioDTO loginExitoso = new UsuarioDTO();
            loginExitoso.setNombre(resultado.getNombre());
            loginExitoso.setRol(resultado.getRol());
            return loginExitoso;
        }

        return null;
    }

    // Metodo para regisrar un usuario en el sistema
    public boolean registrarUsuario(UsuarioDTO dto) {

        // Aqui es donde aplicaremos una de las reglas negocio que estamos agregando al sistema
        if (dto.getNombre().isEmpty() || dto.getEmail().isEmpty() || dto.getContrasena().isEmpty() || dto.getRol().isEmpty()) {
            return false;
        }

        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setNombre(dto.getNombre());
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(dto.getContrasena());
        entidad.setRol(dto.getRol());
        entidad.setTelefono(dto.getTelefono());

        UsuarioDAO dao = new UsuarioDAO();
        return dao.insertar(entidad);
    }

    private void validarFormatoCredenciales() {
    }

    private UsuarioEntidad crearUsuarioEntidad(UsuarioDTO dto) {

        return new UsuarioEntidad();
    }
}
