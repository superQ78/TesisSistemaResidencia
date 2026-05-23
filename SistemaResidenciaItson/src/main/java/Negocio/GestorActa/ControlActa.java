/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.GestorActa;

import Negocio.BOs.ActaBO;
import Negocio.DTOs.ActaDTO;
import java.util.List;

/**
 *
 * @author Tesis
 */
public class ControlActa {

    private ActaBO actaBO;

    public ControlActa() {
        this.actaBO = new ActaBO();
    }

    public boolean procesarRegistroActa(ActaDTO acta) {
        if (acta == null) {
            return false;
        }

        if (acta.getIdAcademico() == null || acta.getIdAcademico().trim().isEmpty()) {
            return false;
        }

        if (acta.getLineamiento() == null || acta.getLineamiento().trim().isEmpty()) {
            return false;
        }

        if (acta.getDescripcion() == null || acta.getDescripcion().trim().isEmpty()) {
            return false;
        }

        return actaBO.registrarActa(acta);
    }

    public List<ActaDTO> procesarConsultaActas() {
        return actaBO.obtenerActas();
    }

    public boolean procesarEliminacionActa(int idActa) {
        if (idActa <= 0) {
            return false;
        }

        return actaBO.eliminarActa(idActa);
    }

    public boolean procesarSubidaActaFirmada(ActaDTO acta) {
        if (acta == null) {
            return false;
        }

        if (acta.getIdAcademico() == null || acta.getIdAcademico().trim().isEmpty()) {
            return false;
        }

        if (acta.getArchivoFirmado() == null || acta.getArchivoFirmado().length == 0) {
            return false;
        }

        if (acta.getNombreArchivoFirmado() == null || acta.getNombreArchivoFirmado().trim().isEmpty()) {
            return false;
        }

        return actaBO.subirActaFirmada(acta);
    }

    public List<ActaDTO> procesarConsultaActasPorIdAcademico(String idAcademico) {
        if (idAcademico == null || idAcademico.trim().isEmpty()) {
            return new java.util.ArrayList<>();
        }

        return actaBO.obtenerActasPorIdAcademico(idAcademico);
    }

    public ActaDTO procesarConsultaArchivoActaFirmada(int idActa) {
        if (idActa <= 0) {
            return null;
        }

        return actaBO.obtenerArchivoActaFirmada(idActa);
    }
}
