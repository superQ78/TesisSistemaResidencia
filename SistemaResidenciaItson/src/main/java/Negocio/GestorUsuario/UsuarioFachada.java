/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.GestorUsuario;

import Negocio.DTOs.UsuarioDTO;

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
}