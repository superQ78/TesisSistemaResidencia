/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Interfaces;

import Persistencia.Entidades.ActaEntidad;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface   IActaDAO {

    boolean insertarActa(ActaEntidad acta);

    List<ActaEntidad> consultarTodas();

    boolean eliminarActa(int idActa);
}
