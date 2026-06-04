package Negocio.GestorActa;

import Negocio.BOs.ActaBO;
import Negocio.DTOs.ActaDTO;
import java.util.List;

/**
 * Clase de control que gestiona las validaciones de negocio para las actas.
 *
 * * @author Tesis
 */
public class ControlActa {

    private ActaBO actaBO;

    /**
     * Constructor por defecto que inicializa el objeto de negocio de actas.
     */
    public ControlActa() {
        this.actaBO = new ActaBO();
    }

    /**
     * Valida y procesa el registro de una nueva acta administrativa. Revisa que
     * el DTO no sea nulo y que los campos obligatorios contengan informacion.
     *
     * * @param acta El objeto ActaDTO con los datos capturados.
     * @return true si paso las validaciones y se guardo con exito, false si
     * faltan datos o fallo el guardado.
     */
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

    /**
     * Procesa la solicitud para consultar el historial completo de actas del
     * sistema.
     *
     * * @return Una lista con todos los objetos ActaDTO encontrados.
     */
    public List<ActaDTO> procesarConsultaActas() {
        return actaBO.obtenerActas();
    }

    /**
     * Valida el ID y procesa la eliminacion de un acta.
     *
     * * @param idActa El id del acta a eliminar.
     * @return true si el id es valido y se elimino correctamente, false en caso
     * contrario.
     */
    public boolean procesarEliminacionActa(int idActa) {
        if (idActa <= 0) {
            return false;
        }

        return actaBO.eliminarActa(idActa);
    }

    /**
     * Valida y procesa la subida de un documento PDF de un acta firmada.
     *
     * * @param acta El objeto ActaDTO que contiene el archivo digital.
     * @return true si paso validaciones y el documento se actualizo, false en
     * caso de error.
     */
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

    /**
     * Valida el parametro de busqueda y solicita las actas de un residente
     * especifico.
     *
     * * @param idAcademico El identificador del estudiante a buscar.
     * @return Lista de actas encontradas, o una lista vacia si el id
     * proporcionado es invalido.
     */
    public List<ActaDTO> procesarConsultaActasPorIdAcademico(String idAcademico) {
        if (idAcademico == null || idAcademico.trim().isEmpty()) {
            return new java.util.ArrayList<>();
        }

        return actaBO.obtenerActasPorIdAcademico(idAcademico);
    }

    /**
     * Valida el parametro de busqueda y solicita el archivo binario de un acta
     * especifica.
     *
     * * @param idActa El ID numerico del acta de la cual queremos su archivo.
     * @return Objeto ActaDTO cargado con el archivo, o null si el ID es
     * invalido o no se encontro.
     */
    public ActaDTO procesarConsultaArchivoActaFirmada(int idActa) {
        if (idActa <= 0) {
            return null;
        }

        return actaBO.obtenerArchivoActaFirmada(idActa);
    }
}
