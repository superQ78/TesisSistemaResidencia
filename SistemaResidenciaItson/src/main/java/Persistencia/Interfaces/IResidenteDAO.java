package Persistencia.Interfaces;

import Persistencia.Entidades.DocumentoEntidad;
import Persistencia.Entidades.ResidenteEntidad;
import Persistencia.Entidades.SolicitudIngresoEntidad;
import java.util.List;

/**
 * Interfaz que establece las operaciones de acceso a datos para la gestion de
 * residentes, solicitudes de ingreso y sus documentos.
 *
 * @author cesar
 */
public interface IResidenteDAO {

    /**
     * Inserta un nuevo residente en la base de datos con toda su informacion
     * del RDP.
     *
     * @param entidad El objeto ResidenteEntidad con los datos capturados.
     * @return true si la insercion en base de datos fue exitosa, false en caso
     * contrario.
     */
    boolean insertar(ResidenteEntidad entidad);

    /**
     * Consulta y devuelve la lista de todos los residentes registrados en el
     * sistema.
     *
     * @return Lista de objetos ResidenteEntidad con informacion basica.
     */
    List<ResidenteEntidad> consultarTodos();

    /**
     * Busca la informacion completa de un residente utilizando su identificador
     * institucional.
     *
     * @param id El id unico del estudiante.
     * @return Objeto ResidenteEntidad con todos los datos cargados, o null si
     * no se encuentra.
     */
    ResidenteEntidad consultarPorId(String id);

    /**
     * Actualiza la informacion de un residente existente en la base de datos.
     *
     * @param entidad El objeto ResidenteEntidad con los datos modificados.
     * @return true si los cambios se guardaron con exito, false en caso de
     * error.
     */
    boolean actualizar(ResidenteEntidad entidad);

    /**
     * Inserta una nueva solicitud de ingreso ligada a la CURP del residente.
     *
     * @param entidad Objeto SolicitudIngresoEntidad con los datos de pago y
     * companero.
     * @return true si la insercion fue exitosa, false de lo contrario.
     */
    boolean insertarSolicitud(SolicitudIngresoEntidad entidad);

    /**
     * Guarda un archivo asociado a un residente.
     *
     * @param entidad Objeto DocumentoEntidad que contiene el archivo en arreglo
     * de bytes.
     * @return true si el documento fue registrado correctamente en BD, false si
     * ocurrio un error.
     */
    boolean insertarDocumento(DocumentoEntidad entidad);

    /**
     * Obtiene la lista de documentos que han sido cargados por un residente
     * especifico.
     *
     * @param idAcademico El id del estudiante propietario.
     * @return Lista de objetos DocumentoEntidad con los metadatos de los
     * archivos.
     */
    java.util.List<Persistencia.Entidades.DocumentoEntidad> consultarDocumentos(String idAcademico);

    /**
     * Descarga de la base de datos un documento digital especifico, incluyendo
     * sus datos binarios.
     *
     * @param idAcademico El id institucional del estudiante.
     * @param tipoDocumento El tipo o nombre del documento
     * @return Objeto DocumentoEntidad cargado con el archivo, o null si no
     * existe
     */
    DocumentoEntidad consultarDocumento(String idAcademico, String tipoDocumento);

    /**
     * Busca los datos de una solicitud de ingreso utilizando la CURP del
     * residente.
     *
     * @param curp La clave CURP del estudiante a buscar.
     * @return Objeto SolicitudIngresoDTO con los datos encontrados, o null si
     * no hay registros.
     */
    Negocio.DTOs.SolicitudIngresoDTO consultarSolicitudPorCurp(String curp);

    /**
     * Actualiza la informacion de pago y companero de una solicitud de ingreso
     * existente.
     *
     * @param dto El objeto SolicitudIngresoDTO con los datos actualizados.
     * @return true si la actualizacion procedio correctamente, false en caso de
     * excepcion.
     */
    boolean actualizarSolicitud(Negocio.DTOs.SolicitudIngresoDTO dto);

    /**
     * Cambia logicamente el estado de un residente en la base de datos
     *
     * @param idAcademico El id del estudiante a modificar.
     * @param nuevoEstado El nuevo estado que se le asignara.
     * @return true si el estado fue cambiado de manera exitosa, false en caso
     * contrario.
     */
    boolean cambiarEstadoResidente(String idAcademico, String nuevoEstado);
}
