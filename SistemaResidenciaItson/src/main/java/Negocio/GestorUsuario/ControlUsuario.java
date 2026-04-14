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
        UsuarioBO bo = new UsuarioBO();
        return bo.iniciarSesion(dto);
    }

    public boolean procesarRegistro(UsuarioDTO dto) {
        UsuarioBO bo = new UsuarioBO();
        return bo.registrarUsuario(dto);
    }
   
   public List<UsuarioDTO> procesarConsultaUsuarios() {
        UsuarioBO bo = new UsuarioBO();
        return bo.consultarUsuarios();
    }
   
}
