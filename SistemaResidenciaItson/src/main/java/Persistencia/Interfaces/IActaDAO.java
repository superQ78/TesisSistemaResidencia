/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Interfaces;

import Persistencia.Entidades.ActaEntidad;
import java.util.List;

/**
 *
 * @author Tesis
 */
public interface IActaDAO {

    boolean insertarActa(ActaEntidad acta);

    List<ActaEntidad> consultarTodas();

    boolean eliminarActa(int idActa);

    boolean subirActaFirmada(ActaEntidad acta);

    List<ActaEntidad> consultarPorIdAcademico(String idAcademico);

    ActaEntidad consultarArchivoFirmado(int idActa);
}
