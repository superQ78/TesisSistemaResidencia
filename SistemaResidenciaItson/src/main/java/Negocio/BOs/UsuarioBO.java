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
        validarFormatoCredenciales();
        UsuarioEntidad entidad = crearUsuarioEntidad(dto);
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioEntidad usuarioValidado = dao.consultarCredenciales(entidad);
        // Aqui convertimos de nuevo a DTO para poder regresarlo
        return null; 
    }
    
    private void validarFormatoCredenciales() {
    }
    
    private UsuarioEntidad crearUsuarioEntidad(UsuarioDTO dto) {

        return new UsuarioEntidad();
    }
}
