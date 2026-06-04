package Negocio.GestorActa;

import Negocio.DTOs.ActaDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones disponibles para la gestion de actas.
 *
 * * @author Tesis
 */
public interface IActa {

    /**
     * Solicita el registro de una nueva acta administrativa en el sistema.
     *
     * * @param acta Objeto ActaDTO con la informacion del acta a crear
     * @return true si el acta se registro con exito, false si fallo alguna
     * validacion o el guardado.
     */
    boolean registrarActa(ActaDTO acta);

    /**
     * Solicita la consulta de todas las actas administrativas almacenadas.
     *
     * * @return Lista de objetos ActaDTO con la informacion detallada de cada
     * acta.
     */
    List<ActaDTO> consultarActas();

    /**
     * Solicita la eliminacion de un acta del sistema basandose en su id.
     *
     * * @param idActa id numerico unico del acta que se va a eliminar.
     * @return true si se elimino de forma correcta, false en caso contrario.
     */
    boolean eliminarActa(int idActa);

    /**
     * Solicita la vinculacion de un documento a un acta existente.
     *
     * * @param acta Objeto ActaDTO que contiene el archivo binario y el nombre
     * del documento.
     * @return true si el documento se adjunto correctamente, false si ocurrio
     * un error.
     */
    boolean subirActaFirmada(Negocio.DTOs.ActaDTO acta);

    /**
     * Solicita el historial de actas administrativas asociadas a un solo
     * residente.
     *
     * * @param idAcademico El ID institucional del estudiante.
     * @return Lista de objetos ActaDTO que pertenecen unicamente al residente
     * indicado.
     */
    List<ActaDTO> consultarActasPorIdAcademico(String idAcademico);

    /**
     * Solicita la recuperacion del documento de un acta especifica.
     *
     * * @param idActa id del acta de la cual se necesita extraer el archivo.
     * @return Objeto ActaDTO cargado con los bytes del archivo, o null si no se
     * localiza.
     */
    ActaDTO consultarArchivoActaFirmada(int idActa);

}
