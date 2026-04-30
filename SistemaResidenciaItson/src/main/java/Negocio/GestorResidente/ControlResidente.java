package Negocio.GestorResidente;

import Negocio.BOs.ResidenteBO;
import Negocio.DTOs.ResidenteDTO;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author cesar
 */
public class ControlResidente {

    public boolean procesarRegistroRDP(ResidenteDTO dto) {
        // 1. El cerebro evalúa que NINGÚN campo obligatorio venga vacío
        if (!aplicarReglasNegocio(dto)) {
            System.out.println("Error: El formulario tiene datos obligatorios en blanco.");
            return false; // Rebotamos el guardado
        }

        // 2. Si todo está lleno, pasamos al traductor (BO)
        ResidenteBO bo = new ResidenteBO();
        return bo.registrarRDP(dto);
    }

    private boolean aplicarReglasNegocio(ResidenteDTO dto) {
        // --- 1. DATOS PERSONALES ---
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

        // --- 2. DATOS ACADÉMICOS ---
        if (!esValido(dto.getIdAcademico()) || !esValido(dto.getCorreoInstitucional())
                || !esValido(dto.getCarrera()) || !esValido(dto.getSemestre())
                || !esValido(dto.getBuscaAyudaAcademica()) || !esValido(dto.getEfectividadEstudio())
                || !esValido(dto.getEfectividadTiempo()) || !esValido(dto.getAspectosMejoraAcademica())) {
            return false;
        }

        // --- 3. DATOS DEL TUTOR ---
        if (!esValido(dto.getNombreTutor()) || !esValido(dto.getParentescoTutor())
                || !esValido(dto.getDomicilioTutor()) || !esValido(dto.getLugarTutor())
                || !esValido(dto.getCelularTutor()) || !esValido(dto.getTelefonoTutor())
                || !esValido(dto.getCorreoTutor())) {
            return false;
        }

        // --- 4. CONTACTO DE EMERGENCIA ---
        if (!esValido(dto.getNombreEmergencia()) || !esValido(dto.getParentescoEmergencia())
                || !esValido(dto.getDomicilioEmergencia()) || !esValido(dto.getLugarEmergencia())
                || !esValido(dto.getCelularEmergencia()) || !esValido(dto.getTelefonoEmergencia())
                || !esValido(dto.getCorreoEmergencia())) {
            return false;
        }

        // --- 5. DATOS MÉDICOS ---
        if (!esValido(dto.getEstadoSalud()) || !esValido(dto.getTipoSangre())
                || !esValido(dto.getAspectosSaludMejora()) || !esValido(dto.getOtraInformacionSalud())) {
            return false;
        }

        // Validaciones inteligentes: Si marcó "Sí" en una enfermedad, TIENE que especificar
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

        // --- 6. ASPECTOS PERSONALES Y CONVIVENCIA ---
        if (!esValido(dto.getDecisionResidencia()) || !esValido(dto.getRazonesVivirResidencia())
                || !esValido(dto.getAdaptacion()) || !esValido(dto.getEstiloConvivencia())
                || !esValido(dto.getSituacionesNoDeseadas()) || !esValido(dto.getHoraDormir())
                || !esValido(dto.getImportanciaOrden()) || !esValido(dto.getHabitosHigiene())
                || !esValido(dto.getIniciativaActividades()) || !esValido(dto.getTipoGrupo())
                || !esValido(dto.getActividadesRealizadasGrupo()) || !esValido(dto.getAspectosMejoraPersona())
                || !esValido(dto.getOtraInformacion())) {
            return false;
        }

        // Validación inteligente de vivienda anterior
        if (dto.isHaVividoFuera() && !esValido(dto.getTiempoVividoFuera())) {
            return false;
        }

        // Si pasó todos los filtros sin hacer return false
        return true;
    }

    /**
     * Método ayudante que revisa si un texto no es nulo y no está vacío.
     */
    private boolean esValido(String texto) {
        return texto != null && !texto.trim().isEmpty() && !texto.toLowerCase().contains("selecciona");
    }
}
