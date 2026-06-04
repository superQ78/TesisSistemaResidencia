package Negocio.GestorResidente;

import Negocio.DTOs.ResidenteDTO;
import Negocio.DTOs.SolicitudIngresoDTO;

/**
 * Clase que implementa el patron de diseño Fachada para la gestion de
 * residentes. Funciona como ls puerta de entrada para la capa de presentacion,
 * recibiendo las peticiones e instanciando al controlador para que procese las
 * reglas de negocio.
 *
 * @author cesar
 */
public class ResidenteFachada implements IResidente {

    /**
     * Envia la peticion al control para registrar un nuevo registro de datos
     * personales (RDP).
     *
     * @param dto El objeto ResidenteDTO con los datos capturados.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    @Override
    public boolean registrarRDP(ResidenteDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.procesarRegistroRDP(dto);
    }

    /**
     * Envia la peticion al control para buscar toda la informacion de un
     * residente.
     *
     * @param idAcademico El id institucional del residente.
     * @return Objeto ResidenteDTO con los datos encontrados, o null si no
     * existe.
     */
    @Override
    public ResidenteDTO consultarResidentePorId(String idAcademico) {
        ControlResidente control = new ControlResidente();
        return control.consultarResidentePorId(idAcademico);
    }

    /**
     * Envia la peticion al control para obtener la lista general de residentes.
     *
     * @return Una lista de objetos ResidenteDTO.
     */
    @Override
    public java.util.List<ResidenteDTO> consultarResidentes() {
        ControlResidente control = new ControlResidente();
        return control.consultarResidentes();
    }

    /**
     * Envia la peticion al control para guardar las modificaciones de un RDP.
     *
     * @param dto El objeto ResidenteDTO con los datos actualizados.
     * @return true si la actualizacion se realizo con exito, false en caso de
     * error.
     */
    @Override
    public boolean actualizarRDP(ResidenteDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.actualizarRDP(dto);
    }

    /**
     * Envia la peticion al control para registrar la solicitud de ingreso de un
     * residente.
     *
     * @param dto El objeto SolicitudIngresoDTO con los datos a registrar.
     * @return true si la solicitud se guardo correctamente, false si fallo.
     */
    @Override
    public boolean registrarSolicitud(SolicitudIngresoDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.procesarSolicitudIngreso(dto);
    }

    /**
     * Envia la petición al control para subir un documento digital al sistema.
     *
     * @param dto El objeto DocumentoDTO que incluye el archivo en bytes.
     * @return true si el documento se subio exitosamente, false en caso
     * contrario.
     */
    @Override
    public boolean subirDocumento(Negocio.DTOs.DocumentoDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.procesarSubidaDocumento(dto);
    }

    /**
     * Envia la peticion al control para listar los documentos subidos por un
     * residente.
     *
     * @param idAcademico El id del estudiante.
     * @return Lista de objetos DocumentoDTO con la informacion de los archivos.
     */
    @Override
    public java.util.List<Negocio.DTOs.DocumentoDTO> consultarDocumentos(String idAcademico) {
        ControlResidente control = new ControlResidente();
        return control.consultarDocumentos(idAcademico);
    }

    /**
     * Envia la peticion al control para descargar el archivo digital de un
     * documento.
     *
     * @param idAcademico El id del estudiante propietario.
     * @param tipoDocumento El tipo de documento que se desea consultar.
     * @return Objeto DocumentoDTO cargado con los bytes del archivo, o null si
     * no se encuentra.
     */
    @Override
    public Negocio.DTOs.DocumentoDTO consultarDocumento(String idAcademico, String tipoDocumento) {
        ControlResidente control = new ControlResidente();
        return control.consultarDocumento(idAcademico, tipoDocumento);
    }

    /**
     * Envia la peticion al control para buscar una solicitud de ingreso por
     * medio de la CURP.
     *
     * @param curp La clave CURP del estudiante.
     * @return Objeto SolicitudIngresoDTO con los datos de la solicitud, o null
     * si no se localiza.
     */
    @Override
    public SolicitudIngresoDTO consultarSolicitudPorCurp(String curp) {
        ControlResidente control = new ControlResidente();
        return control.consultarSolicitudPorCurp(curp);
    }

    /**
     * Envia la peticion al control para guardar las modificaciones hechas a una
     * solicitud de ingreso.
     *
     * @param dto El objeto SolicitudIngresoDTO con la informacion actualizada.
     * @return true si se actualizo correctamente, false en caso de error.
     */
    @Override
    public boolean actualizarSolicitud(Negocio.DTOs.SolicitudIngresoDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.actualizarSolicitud(dto);
    }

    /**
     * Envia la peticion al control para habilitar o inhabilitar un residente en
     * la base de datos.
     *
     * @param idAcademico El id del residente a modificar.
     * @param nuevoEstado El valor del nuevo estado asignado.
     * @return true si el cambio se aplico exitosamente, false en caso
     * contrario.
     */
    @Override
    public boolean cambiarEstadoResidente(String idAcademico, String nuevoEstado) {
        ControlResidente control = new ControlResidente();
        return control.cambiarEstadoResidente(idAcademico, nuevoEstado);
    }
}
