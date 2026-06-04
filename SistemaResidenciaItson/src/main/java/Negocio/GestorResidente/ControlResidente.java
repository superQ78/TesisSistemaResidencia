package Negocio.GestorResidente;

import Negocio.BOs.ResidenteBO;
import Negocio.DTOs.ResidenteDTO;
import Negocio.DTOs.SolicitudIngresoDTO;
import java.util.List;

/**
 * Clase de control que gestiona las validaciones y reglas de negocio para los
 * residentes.
 *
 * @author cesar
 */
public class ControlResidente {

    /**
     * Valida y procesa el registro de un nuevo registro de datos personales.
     *
     * @param dto El objeto ResidenteDTO con los datos capturados.
     * @return true si paso todas las validaciones y se guardo con exito, false
     * en caso contrario.
     */
    public boolean procesarRegistroRDP(ResidenteDTO dto) {
        if (!aplicarReglasNegocio(dto)) {
            System.out.println("Error: El formulario tiene datos obligatorios en blanco.");
            return false;
        }

        // Si todo esta lleno pasamos al traductor
        ResidenteBO bo = new ResidenteBO();
        return bo.registrarRDP(dto);
    }

    /**
     * Valida el parametro de busqueda y solicita la información completa de un
     * residente.
     *
     * @param idAcademico El id institucional del residente.
     * @return Objeto ResidenteDTO cargado con la informacion, o null si el id
     * es invalido.
     */
    public ResidenteDTO consultarResidentePorId(String idAcademico) {
        if (idAcademico == null || idAcademico.trim().isEmpty()) {
            return null;
        }
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.consultarResidentePorId(idAcademico);
    }

    /**
     * Aplica las reglas de negocio verificando que todos los campos
     * obligatorios del formulario RDP contengan informacion valida.
     *
     * @param dto El objeto ResidenteDTO a evaluar.
     * @return true si todos los campos obligatorios cumplen las reglas, false
     * si falta algun dato.
     */
    private boolean aplicarReglasNegocio(ResidenteDTO dto) {
        if (dto.getFechaNacimiento() == null) {
            System.out.println("Falla en: Fecha de Nacimiento");
            return false;
        }

        // Datos Personales
        if (!esValido(dto.getNombreCompleto()) || !esValido(dto.getDomicilio())
                || !esValido(dto.getCurp()) || !esValido(dto.getLugarResidencia())
                || !esValido(dto.getNss()) || !esValido(dto.getCelular())
                || !esValido(dto.getCorreo()) || !esValido(dto.getSexo())) {
            System.out.println("Falla en: Datos Personales");
            return false;
        }

        // Academicos
        if (!esValido(dto.getIdAcademico()) || !esValido(dto.getCorreoInstitucional())
                || !esValido(dto.getCarrera()) || !esValido(dto.getSemestre())
                || !esValido(dto.getBuscaAyudaAcademica()) || !esValido(dto.getEfectividadEstudio())
                || !esValido(dto.getEfectividadTiempo()) || !esValido(dto.getAspectosMejoraAcademica())) {
            System.out.println("Falla en: Datos Académicos");
            return false;
        }

        // Datos tutor
        if (!esValido(dto.getNombreTutor()) || !esValido(dto.getParentescoTutor())
                || !esValido(dto.getDomicilioTutor()) || !esValido(dto.getLugarTutor())
                || !esValido(dto.getCelularTutor()) || !esValido(dto.getCorreoTutor())) {
            System.out.println("Falla en: Datos del Tutor");
            return false;
        }

        // Contacto emergencia 
        if (!esValido(dto.getNombreEmergencia()) || !esValido(dto.getParentescoEmergencia())
                || !esValido(dto.getDomicilioEmergencia()) || !esValido(dto.getLugarEmergencia())
                || !esValido(dto.getCelularEmergencia()) || !esValido(dto.getCorreoEmergencia())) {

            System.out.println("Falla en: Contacto de emergencias");

            return false;
        }
        // Datos medicos
        if (!esValido(dto.getEstadoSalud()) || !esValido(dto.getTipoSangre())
                || !esValido(dto.getAspectosSaludMejora())) {
            System.out.println("Falla en: Datos Médicos Base");
            return false;
        }

        // datos medicos condicionales
        if (dto.isTieneDeficienciaVista() && !esValido(dto.getEspecificarVista())) {
            return false;
        }
        if (dto.isTieneDeficienciaAuditiva() && !esValido(dto.getEspecificarAuditiva())) {
            return false;
        }
        if (dto.isTieneDiscapacidadFisica() && !esValido(dto.getEspecificarFisica())) {
            return false;
        }
        if (dto.isTieneLesionesGraves() && !esValido(dto.getEspecificarLesiones())) {
            return false;
        }
        if (dto.isTienePadecimientos() && !esValido(dto.getEspecificarPadecimientos())) {
            return false;
        }
        if (dto.isTieneTratamientosPsicologicos() && !esValido(dto.getMotivoTratamientosPsicologicos())) {
            return false;
        }
        if (dto.isTieneMedicamentosControlados() && !esValido(dto.getEspecificarMedicamentos())) {
            return false;
        }
        if (dto.isTieneAlergias() && !esValido(dto.getEspecificarAlergias())) {
            return false;
        }
        if (dto.isTieneTratamientosExternos() && !esValido(dto.getMotivoTratamientosExternos())) {
            return false;
        }

        // convivencia y habitos
        if (!esValido(dto.getDecisionResidencia()) || !esValido(dto.getRazonesVivirResidencia())
                || !esValido(dto.getAdaptacion()) || !esValido(dto.getEstiloConvivencia())
                || !esValido(dto.getSituacionesNoDeseadas()) || !esValido(dto.getHoraDormir())
                || !esValido(dto.getImportanciaOrden()) || !esValido(dto.getHabitosHigiene())
                || !esValido(dto.getIniciativaActividades()) || !esValido(dto.getAspectosMejoraPersona())) {
            System.out.println("Falla en: Convivencia y Hábitos");
            return false;
        }

        // validacion de condicional de grupos
        if (dto.isParticipacionGrupo()) {
            if (!esValido(dto.getTipoGrupo()) || !esValido(dto.getActividadesRealizadasGrupo())) {
                System.out.println("Falla en: Participación de grupo (Elijó SÍ, pero lo dejó vacío)");
                return false;
            }
        }

        // vaidacion de tiempo vivido fuera
        if (dto.isHaVividoFuera() && !esValido(dto.getTiempoVividoFuera())) {
            System.out.println("Falla en: Tiempo vivido fuera (Elijó SÍ, pero lo dejó vacío)");
            return false;
        }

        return true;
    }

    /**
     * Metodo auxiliar que revisa si una cadena de texto no es nula, no esta
     * vacia y no contiene el texto de marcador de posicion de "selecciona"
     *
     * @param texto La cadena a evaluar.
     * @return true si el texto contiene informacion valida, false en caso
     * contrario.
     */
    private boolean esValido(String texto) {
        return texto != null && !texto.trim().isEmpty() && !texto.toLowerCase().contains("selecciona");
    }

    /**
     * Procesa la solicitud para consultar la lista de todos los residentes
     * registrados.
     *
     * @return Lista de objetos ResidenteDTO con información basica de los
     * residentes.
     */
    public List<ResidenteDTO> consultarResidentes() {
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.consultarResidentes();
    }

    /**
     * Valida y procesa la actualización de los datos de un residente.
     *
     * @param dto El objeto ResidenteDTO con los nuevos datos capturados.
     * @return true si las validaciones pasaron y la información se actualizo,
     * false en caso de error.
     */
    public boolean actualizarRDP(ResidenteDTO dto) {
        if (!aplicarReglasNegocio(dto)) {
            System.out.println("Error: El formulario de actualizacion tiene datos obligatorios en blanco.");
            return false;
        }

        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.actualizarRDP(dto);
    }

    /**
     * Valida y procesa el registro de una nueva solicitud de ingreso.
     *
     * @param dto Objeto SolicitudIngresoDTO con los datos de pago y de
     * companero.
     * @return true si paso las validaciones y se guardo con exito, false en
     * caso contrario.
     */
    public boolean procesarSolicitudIngreso(SolicitudIngresoDTO dto) {
        if (!aplicarReglasNegocio(dto)) {
            return false;
        }

        ResidenteBO bo = new ResidenteBO();
        return bo.registrarSolicitud(dto);
    }

    /**
     * Aplica las reglas de negocio para validar los campos de una solicitud de
     * ingreso.
     *
     * @param dto El objeto SolicitudIngresoDTO a evaluar.
     * @return true si los campos requeridos no son nulos, false en caso
     * contrario.
     */
    private boolean aplicarReglasNegocio(SolicitudIngresoDTO dto) {
        if (dto.getCurpResidente() == null || dto.getTipoPago() == null) {
            return false;
        }
        return true;
    }

    /**
     * Valida y procesa la subida de un documento de requisito para un
     * residente.
     *
     * @param dto Objeto DocumentoDTO que contiene la información binaria del
     * archivo.
     * @return true si el documento es valido y se subio correctamente, false en
     * caso contrario.
     */
    public boolean procesarSubidaDocumento(Negocio.DTOs.DocumentoDTO dto) {
        if (dto.getIdAcademico() == null || dto.getArchivo() == null || dto.getArchivo().length == 0) {
            System.out.println("Error: Archivo o ID del residente vacio.");
            return false;
        }

        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.guardarDocumento(dto);
    }

    /**
     * Valida el id y solicita la lista de documentos subidos por un residente
     * especifico.
     *
     * @param idAcademico El id institucional del residente.
     * @return Lista de objetos DocumentoDTO encontrados, o lista vacia si el id
     * es nulo.
     */
    public java.util.List<Negocio.DTOs.DocumentoDTO> consultarDocumentos(String idAcademico) {
        if (idAcademico == null || idAcademico.trim().isEmpty()) {
            return new java.util.ArrayList<>();
        }

        ResidenteBO bo = new ResidenteBO();
        return bo.consultarDocumentos(idAcademico);
    }

    /**
     * Valida los parametros y solicita un documento digital especifico de un
     * residente.
     *
     * @param idAcademico El id del estudiante al que pertenece el archivo.
     * @param tipoDocumento El tipo o clasificacion del archivo
     * @return Objeto DocumentoDTO cargado con el archivo binario, o null si los
     * parametros son invalidos.
     */
    public Negocio.DTOs.DocumentoDTO consultarDocumento(String idAcademico, String tipoDocumento) {
        if (idAcademico == null || idAcademico.trim().isEmpty()
                || tipoDocumento == null || tipoDocumento.trim().isEmpty()) {
            return null;
        }

        ResidenteBO bo = new ResidenteBO();
        return bo.consultarDocumento(idAcademico, tipoDocumento);
    }

    /**
     * Solicita los datos de la Solicitud de Ingreso registrada a nombre de una
     * CURP en especifico.
     *
     * @param curp La clave CURP del residente a buscar.
     * @return Objeto SolicitudIngresoDTO con los datos de pago y companero, o
     * null si no se encuentra.
     */
    public SolicitudIngresoDTO consultarSolicitudPorCurp(String curp) {
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.consultarSolicitudPorCurp(curp);
    }

    /**
     * Procesa la solicitud para actualizar la información de una solicitud de
     * ingreso existente.
     *
     * @param dto El objeto SolicitudIngresoDTO con la información a
     * sobreescribir.
     * @return true si la actualización en base de datos fue exitosa, false de
     * lo contrario.
     */
    public boolean actualizarSolicitud(Negocio.DTOs.SolicitudIngresoDTO dto) {
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.actualizarSolicitud(dto);
    }

    /**
     * Procesa el cambio de estado logico de un residente en el sistema
     * (habilitar o inhabilitar).
     *
     * @param idAcademico El id institucional del residente a modificar.
     * @param nuevoEstado El texto del estado que se le asignara.
     * @return true si el estado fue cambiado exitosamente en la base de datos,
     * false de lo contrario.
     */
    public boolean cambiarEstadoResidente(String idAcademico, String nuevoEstado) {
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.cambiarEstadoResidente(idAcademico, nuevoEstado);
    }
}
