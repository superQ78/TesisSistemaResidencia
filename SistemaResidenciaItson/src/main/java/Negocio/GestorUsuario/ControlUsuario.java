/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.GestorUsuario;

import Negocio.BOs.UsuarioBO;
import Negocio.DTOs.UsuarioDTO;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ControlUsuario {

    public UsuarioDTO procesarInicioSesion(UsuarioDTO dto) {
        // Validacion que no vengan vacios
        if (dto.getEmail() == null || dto.getEmail().isEmpty()
                || dto.getContrasena() == null || dto.getContrasena().isEmpty()) {
            return null;
        }

        UsuarioBO bo = new UsuarioBO();
        return bo.iniciarSesion(dto);
    }

    public boolean procesarRegistro(UsuarioDTO dto) {
        if (!validarFormatoUsuario(dto)) {
            return false; 
        }

        UsuarioBO bo = new UsuarioBO();
        return bo.registrarUsuario(dto);
    }

    public boolean actualizarUsuario(UsuarioDTO dto) {
        if (dto.getId() <= 0 || !validarFormatoUsuario(dto)) {
            return false;
        }

        UsuarioBO bo = new UsuarioBO();
        return bo.actualizarUsuario(dto);
    }

    public List<UsuarioDTO> procesarConsultaUsuarios() {
        UsuarioBO bo = new UsuarioBO();
        return bo.consultarUsuarios();
    }

    public UsuarioDTO consultarUsuarioPorId(int id) {
        if (id <= 0) {
            return null;
        }
        UsuarioBO bo = new UsuarioBO();
        return bo.consultarUsuarioPorId(id);
    }

    public boolean inhabilitarUsuario(int id) {
        if (id <= 0) {
            return false;
        }
        UsuarioBO bo = new UsuarioBO();
        return bo.inhabilitarUsuario(id);
    }

    /**
     * Valida que los datos obligatorios del usuario esten presentes.
     */
    private boolean validarFormatoUsuario(UsuarioDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            return false;
        }
        if (dto.getEmail() == null || !dto.getEmail().contains("@")) {
            return false;
        }
        if (dto.getContrasena() == null || dto.getContrasena().trim().isEmpty()) {
            return false;
        }
        if (dto.getRol() == null || dto.getRol().equals("Selecciona un Rol")) {
            return false;
        }
        // Si pasa todos los if es valido.
        return true; 
    }
}
