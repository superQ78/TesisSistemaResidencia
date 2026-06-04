package Negocio.GestorResidente;

import Negocio.DTOs.ResidenteDTO;
import Negocio.DTOs.SolicitudIngresoDTO;

/**
 * Interfaz que define las operaciones principales para la gestion de los
 * residentes.
 *
 * @author cesar
 */
public interface IResidente {

    /**
     * Solicita el registro inicial de un nuevo residente mediante su registro
     * de datos personales.
     *
     * @param dto El objeto ResidenteDTO con todos los datos capturados.
     * @return true si el registro se realizo correctamente, false en caso de
     * error.
     */
    public boolean registrarRDP(ResidenteDTO dto);

    /**
     * Solicita la consulta detallada de un residente utilizando su id
     * institucional.
     *
     * @param idAcademico El identificador unico del estudiante.
     * @return Un objeto ResidenteDTO con la informacion completa, o null si no
     * se encuentra.
     */
    public ResidenteDTO consultarResidentePorId(String idAcademico);

    /**
     * Solicita la consulta de todos los residentes almacenados en el sistema.
     *
     * @return Lista de objetos ResidenteDTO con información basica de cada
     * residente.
     */
    public java.util.List<ResidenteDTO> consultarResidentes();

    /**
     * Solicita la actualizacion del registro de datos personales de un
     * residente existente.
     *
     * @param dto El objeto ResidenteDTO modificado.
     * @return true si los cambios se guardaron exitosamente, false en caso
     * contrario.
     */
    public boolean actualizarRDP(ResidenteDTO dto);

    /**
     * Solicita el registro de una solicitud de ingreso asociada a un residente.
     *
     * @param dto El objeto SolicitudIngresoDTO con la información de pagos y
     * companeros.
     * @return true si la solicitud se registro con exito, false si fallo.
     */
    boolean registrarSolicitud(SolicitudIngresoDTO dto);

    /**
     * Solicita el almacenamiento de un archivo digital correspondiente a un
     * documento de requisito.
     *
     * @param dto El objeto DocumentoDTO que incluye el archivo en arreglo de
     * bytes.
     * @return true si el documento fue subido y asociado correctamente, false
     * en caso de error.
     */
    public boolean subirDocumento(Negocio.DTOs.DocumentoDTO dto);

    /**
     * Solicita la lista de documentos que ha subido un residente al sistema.
     *
     * @param idAcademico El id del estudiante.
     * @return Lista de objetos DocumentoDTO con informacion descriptiva de los
     * archivos.
     */
    public java.util.List<Negocio.DTOs.DocumentoDTO> consultarDocumentos(String idAcademico);

    /**
     * Solicita la descarga o recuperacion de un documento digital especifico de
     * un residente.
     *
     * @param idAcademico El identificador del estudiante propietario del
     * documento.
     * @param tipoDocumento El tipo de documento solicitado
     * @return Un objeto DocumentoDTO cargado con el arreglo de bytes del
     * documento, o null si no existe.
     */
    public Negocio.DTOs.DocumentoDTO consultarDocumento(String idAcademico, String tipoDocumento);

    /**
     * Solicita la busqueda de una solicitud de ingreso a partir de la CURP del
     * residente.
     *
     * @param curp La clave CURP del estudiante a consultar.
     * @return Objeto SolicitudIngresoDTO con los detalles de la solicitud, o
     * null si no se encontro.
     */
    public Negocio.DTOs.SolicitudIngresoDTO consultarSolicitudPorCurp(String curp);

    /**
     * Solicita la modificacion de los datos de una solicitud de ingreso
     * previamente registrada.
     *
     * @param dto El objeto SolicitudIngresoDTO con los nuevos valores.
     * @return true si la actualización procedio correctamente, false en caso de
     * error.
     */
    public boolean actualizarSolicitud(SolicitudIngresoDTO dto);

    /**
     * Solicita el cambio logico del estado de un residente dentro del sistema.
     * util para habilitar o inhabilitar perfiles.
     *
     * @param idAcademico El id institucional del residente a
     * afectar.
     * @param nuevoEstado El texto representativo del nuevo estado asignado.
     * @return true si el estado fue cambiado en la base de datos, false de lo
     * contrario.
     */
    public boolean cambiarEstadoResidente(String idAcademico, String nuevoEstado);
}
