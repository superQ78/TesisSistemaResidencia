package Negocio.GestorResidente;

import Negocio.BOs.ResidenteBO;
import Negocio.DTOs.ResidenteDTO;
import Negocio.DTOs.SolicitudIngresoDTO;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ControlResidente {

    public boolean procesarRegistroRDP(ResidenteDTO dto) {
        if (!aplicarReglasNegocio(dto)) {
            System.out.println("Error: El formulario tiene datos obligatorios en blanco.");
            return false;
        }

        // Si todo esta lleno pasamos al traductor
        ResidenteBO bo = new ResidenteBO();
        return bo.registrarRDP(dto);
    }

    public ResidenteDTO consultarResidentePorId(String idAcademico) {
        if (idAcademico == null || idAcademico.trim().isEmpty()) {
            return null;
        }
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.consultarResidentePorId(idAcademico);
    }

    //reglas de negocioo
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
     * Metodo ayudante que revisa si un texto no es nulo y no está vacío.
     */
    private boolean esValido(String texto) {
        return texto != null && !texto.trim().isEmpty() && !texto.toLowerCase().contains("selecciona");
    }

    public List<ResidenteDTO> consultarResidentes() {
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.consultarResidentes();
    }

    public boolean actualizarRDP(ResidenteDTO dto) {
        if (!aplicarReglasNegocio(dto)) {
            System.out.println("Error: El formulario de actualización tiene datos obligatorios en blanco.");
            return false;
        }

        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.actualizarRDP(dto);
    }

    // metodos de solicitud
    public boolean procesarSolicitudIngreso(SolicitudIngresoDTO dto) {
        if (!aplicarReglasNegocio(dto)) {
            return false;
        }

        ResidenteBO bo = new ResidenteBO();
        return bo.registrarSolicitud(dto);
    }

    private boolean aplicarReglasNegocio(SolicitudIngresoDTO dto) {
        if (dto.getCurpResidente() == null || dto.getTipoPago() == null) {
            return false;
        }
        return true;
    }

    public boolean procesarSubidaDocumento(Negocio.DTOs.DocumentoDTO dto) {
        if (dto.getIdAcademico() == null || dto.getArchivo() == null || dto.getArchivo().length == 0) {
            System.out.println("Error: Archivo o ID del residente vacío.");
            return false;
        }

        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.guardarDocumento(dto);
    }

    public java.util.List<Negocio.DTOs.DocumentoDTO> consultarDocumentos(String idAcademico) {
        if (idAcademico == null || idAcademico.trim().isEmpty()) {
            return new java.util.ArrayList<>();
        }

        ResidenteBO bo = new ResidenteBO();
        return bo.consultarDocumentos(idAcademico);
    }

    public Negocio.DTOs.DocumentoDTO consultarDocumento(String idAcademico, String tipoDocumento) {
        if (idAcademico == null || idAcademico.trim().isEmpty()
                || tipoDocumento == null || tipoDocumento.trim().isEmpty()) {
            return null;
        }

        ResidenteBO bo = new ResidenteBO();
        return bo.consultarDocumento(idAcademico, tipoDocumento);
    }
    
    // Para consultar la solicitud por la CURP
    public SolicitudIngresoDTO consultarSolicitudPorCurp(String curp) {
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.consultarSolicitudPorCurp(curp);
    }
    
    // Para actualizar los datos de la solicitud
    public boolean actualizarSolicitud(Negocio.DTOs.SolicitudIngresoDTO dto) {
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.actualizarSolicitud(dto);
    }
    
    // Para el cambiar estado inhabilitar/habilitar
    public boolean cambiarEstadoResidente(String idAcademico, String nuevoEstado) {
        Negocio.BOs.ResidenteBO bo = new Negocio.BOs.ResidenteBO();
        return bo.cambiarEstadoResidente(idAcademico, nuevoEstado);
    }
}
