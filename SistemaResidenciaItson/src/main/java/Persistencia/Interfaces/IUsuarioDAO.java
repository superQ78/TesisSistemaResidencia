/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Interfaces;

import Persistencia.Entidades.UsuarioEntidad;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface IUsuarioDAO {

    public UsuarioEntidad consultarCredenciales(UsuarioEntidad entidad);

    public boolean insertar(UsuarioEntidad entidad);

    public List<UsuarioEntidad> buscarTodo();

    public UsuarioEntidad consultarPorId(int id);

    public boolean actualizar(UsuarioEntidad entidad);

    public boolean eliminar(int id);

}
