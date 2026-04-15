/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.GestorUsuario;

import Negocio.DTOs.UsuarioDTO;
import java.util.List;

/**
 *
 * @author cesar
 */
public class UsuarioFachada implements IUsuario {

    @Override
    public UsuarioDTO iniciarSesion(UsuarioDTO dto) {
        ControlUsuario control = new ControlUsuario();
        return control.procesarInicioSesion(dto);
    }

    @Override
    public boolean registrar(UsuarioDTO dto) {
        ControlUsuario control = new ControlUsuario();
        return control.procesarRegistro(dto);
    }

    @Override
    public List<UsuarioDTO> consultarUsuarios() {
        ControlUsuario control = new ControlUsuario();
        return control.procesarConsultaUsuarios();
    }

    @Override
    public UsuarioDTO consultarUsuarioPorId(int id) {
        ControlUsuario control = new ControlUsuario();
        return control.consultarUsuarioPorId(id);
    }

    @Override
    public boolean actualizarUsuario(UsuarioDTO dto) {
        ControlUsuario control = new ControlUsuario();
        return control.actualizarUsuario(dto);
    }
    
    @Override
    public boolean inhabilitarUsuario(int id) {
        ControlUsuario control = new ControlUsuario();
        return control.inhabilitarUsuario(id);
    }
}
