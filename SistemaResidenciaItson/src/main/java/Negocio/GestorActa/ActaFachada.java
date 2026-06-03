package Negocio.GestorActa;

import Negocio.DTOs.ActaDTO;
import java.util.List;

/**
 * Clase que implementa el patron de diseño Fachada para el gestor de actas.
 * Actua como un punto de acceso unico para que la capa de presentacion
 * interactue con la logica de negocio.
 *
 * * @author Tesis
 */
public class ActaFachada implements IActa {

    private ControlActa control;

    /**
     * Constructor por defecto. Inicializa la clase de control encargada de
     * procesar las validaciones y reglas de negocio.
     */
    public ActaFachada() {
        this.control = new ControlActa();
    }

    /**
     * Envia la peticion al control para registrar una nueva acta
     * administrativa.
     *
     * * @param acta El objeto ActaDTO con los datos del acta a registrar.
     * @return true si el registro fue validado y guardado exitosamente, false
     * en caso contrario.
     */
    @Override
    public boolean registrarActa(ActaDTO acta) {
        return control.procesarRegistroActa(acta);
    }

    /**
     * Envia la peticion al control para obtener la lista completa de actas
     * registradas.
     *
     * * @return Una lista de objetos ActaDTO con la informacion de todas las
     * actas.
     */
    @Override
    public List<ActaDTO> consultarActas() {
        return control.procesarConsultaActas();
    }

    /**
     * Envia la peticion al control para eliminar un acta especifica del
     * sistema.
     *
     * * @param idActa El identificador numerico del acta que se desea
     * eliminar.
     * @return true si la eliminacion procedio correctamente, false si fallo.
     */
    @Override
    public boolean eliminarActa(int idActa) {
        return control.procesarEliminacionActa(idActa);
    }

    /**
     * Envia la peticion al control para guardar el archivo del acta firmada.
     *
     * * @param acta El objeto ActaDTO que contiene el arreglo de bytes del
     * documento.
     * @return true si el archivo se subio y vinculo correctamente, false en
     * caso contrario.
     */
    @Override
    public boolean subirActaFirmada(ActaDTO acta) {
        return control.procesarSubidaActaFirmada(acta);
    }

    /**
     * Envia la peticion al control para obtener el historial de actas de un
     * estudiante.
     *
     * * @param idAcademico El identificador institucional del residente a
     * buscar.
     * @return Una lista de objetos ActaDTO que pertenecen al residente
     * indicado.
     */
    @Override
    public List<ActaDTO> consultarActasPorIdAcademico(String idAcademico) {
        return control.procesarConsultaActasPorIdAcademico(idAcademico);
    }

    /**
     * Envia la peticion al control para recuperar unicamente el archivo binario
     * de un acta.
     *
     * * @param idActa El id del acta de la que se requiere el
     * documento.
     * @return Un objeto ActaDTO cargado con la informacion del archivo, o null
     * si no se encontro.
     */
    @Override
    public ActaDTO consultarArchivoActaFirmada(int idActa) {
        return control.procesarConsultaArchivoActaFirmada(idActa);
    }

}
