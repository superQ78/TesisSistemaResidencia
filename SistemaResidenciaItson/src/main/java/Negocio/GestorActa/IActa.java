/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio.GestorActa;

import Negocio.DTOs.ActaDTO;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface IActa {

    boolean registrarActa(ActaDTO acta);

    List<ActaDTO> consultarActas();

    boolean eliminarActa(int idActa);
}
