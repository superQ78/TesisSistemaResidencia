package Negocio.GestorResidente;

import Negocio.BOs.ResidenteBO;
import Negocio.DTOs.ResidenteDTO;
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

    private boolean aplicarReglasNegocio(ResidenteDTO dto) {
        if (dto.getFechaNacimiento() == null) {
            return false;
        }

        if (!esValido(dto.getNombreCompleto()) || !esValido(dto.getDomicilio())
                || !esValido(dto.getCurp()) || !esValido(dto.getLugarResidencia())
                || !esValido(dto.getNss()) || !esValido(dto.getCelular())
                || !esValido(dto.getTelefono()) || !esValido(dto.getCorreo())
                || !esValido(dto.getSexo())) {
            return false;
        }

        if (!esValido(dto.getIdAcademico()) || !esValido(dto.getCorreoInstitucional())
                || !esValido(dto.getCarrera()) || !esValido(dto.getSemestre())
                || !esValido(dto.getBuscaAyudaAcademica()) || !esValido(dto.getEfectividadEstudio())
                || !esValido(dto.getEfectividadTiempo()) || !esValido(dto.getAspectosMejoraAcademica())) {
            return false;
        }

        // Datos Tutor
        if (!esValido(dto.getNombreTutor()) || !esValido(dto.getParentescoTutor())
                || !esValido(dto.getDomicilioTutor()) || !esValido(dto.getLugarTutor())
                || !esValido(dto.getCelularTutor()) || !esValido(dto.getTelefonoTutor())
                || !esValido(dto.getCorreoTutor())) {
            return false;
        }

        // Contacto emergencia.
        if (!esValido(dto.getNombreEmergencia()) || !esValido(dto.getParentescoEmergencia())
                || !esValido(dto.getDomicilioEmergencia()) || !esValido(dto.getLugarEmergencia())
                || !esValido(dto.getCelularEmergencia()) || !esValido(dto.getTelefonoEmergencia())
                || !esValido(dto.getCorreoEmergencia())) {
            return false;
        }

        // Datos Medicos
        if (!esValido(dto.getEstadoSalud()) || !esValido(dto.getTipoSangre())
                || !esValido(dto.getAspectosSaludMejora()) || !esValido(dto.getOtraInformacionSalud())) {
            return false;
        }

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

        if (!esValido(dto.getDecisionResidencia()) || !esValido(dto.getRazonesVivirResidencia())
                || !esValido(dto.getAdaptacion()) || !esValido(dto.getEstiloConvivencia())
                || !esValido(dto.getSituacionesNoDeseadas()) || !esValido(dto.getHoraDormir())
                || !esValido(dto.getImportanciaOrden()) || !esValido(dto.getHabitosHigiene())
                || !esValido(dto.getIniciativaActividades()) || !esValido(dto.getTipoGrupo())
                || !esValido(dto.getActividadesRealizadasGrupo()) || !esValido(dto.getAspectosMejoraPersona())
                || !esValido(dto.getOtraInformacion())) {
            return false;
        }

        if (dto.isHaVividoFuera() && !esValido(dto.getTiempoVividoFuera())) {
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
}
