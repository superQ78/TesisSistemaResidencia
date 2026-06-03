package Persistencia.Interfaces;

import Persistencia.Entidades.ActaEntidad;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Acta.
 *
 * * @author Tesis
 */
public interface IActaDAO {

    /**
     * Inserta un nuevo registro de acta administrativa en la base de datos.
     *
     * * @param acta Objeto ActaEntidad con los datos del incidente.
     * @return true si el registro se inserto correctamente, false en caso
     * contrario.
     */
    boolean insertarActa(ActaEntidad acta);

    /**
     * Consulta y recupera todas las actas administrativas almacenadas en la
     * base de datos.
     *
     * * @return Una lista de objetos ActaEntidad con la informacion de cada
     * acta.
     */
    List<ActaEntidad> consultarTodas();

    /**
     * Elimina fisicamente un registro de acta de la base de datos.
     *
     * * @param idActa El id numericodel acta a eliminar.
     * @return true si la eliminacion fue exitosa, false si ocurrio un error.
     */
    boolean eliminarActa(int idActa);

    /**
     * Actualiza un registro existente en la base de datos para almacenar el PDF
     * del acta firmada.
     *
     * * @param acta Objeto ActaEntidad que contiene el arreglo de bytes y el
     * nombre del archivo.
     * @return true si la base de datos se actualizo correctamente, false en
     * caso contrario.
     */
    boolean subirActaFirmada(ActaEntidad acta);

    /**
     * Busca y recupera todas las actas administrativas correspondientes a un
     * estudiante especifico.
     *
     * * @param idAcademico El ID institucional del residente.
     * @return Una lista de objetos ActaEntidad pertenecientes al residente
     * indicado.
     */
    List<ActaEntidad> consultarPorIdAcademico(String idAcademico);

    /**
     * Recupera exclusivamente los datos binarios del documento adjunto a un
     * acta especifica.
     *
     * * @param idActa El identificador del acta a consultar.
     * @return Objeto ActaEntidad cargado con el archivo binario, o null si no
     * existe.
     */
    ActaEntidad consultarArchivoFirmado(int idActa);
}
