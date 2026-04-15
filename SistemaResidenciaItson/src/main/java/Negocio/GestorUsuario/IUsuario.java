/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.GestorUsuario;

import Negocio.DTOs.UsuarioDTO;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface IUsuario {

    public UsuarioDTO iniciarSesion(UsuarioDTO dto);

    public boolean registrar(UsuarioDTO dto);

    public List<UsuarioDTO> consultarUsuarios();

    public UsuarioDTO consultarUsuarioPorId(int id);

    public boolean actualizarUsuario(UsuarioDTO dto);

    public boolean inhabilitarUsuario(int id);
}
