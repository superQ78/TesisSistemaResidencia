package Negocio.BOs;

import Negocio.DTOs.ResidenteDTO;
import Persistencia.DAOs.ResidenteDAO;
import Persistencia.Entidades.ResidenteEntidad;
import Persistencia.Interfaces.IResidenteDAO;

public class ResidenteBO {

    public boolean registrarRDP(ResidenteDTO dto) {
        ResidenteEntidad entidad = convertirAEntidad(dto);
        IResidenteDAO dao = new ResidenteDAO();
        return dao.insertar(entidad);
    }

    private ResidenteEntidad convertirAEntidad(ResidenteDTO dto) {
        ResidenteEntidad entidad = new ResidenteEntidad();

        // Datos Personales
        entidad.setNombreCompleto(dto.getNombreCompleto());
        entidad.setSexo(dto.getSexo());
        entidad.setFechaNacimiento(dto.getFechaNacimiento());
        entidad.setDomicilio(dto.getDomicilio());
        entidad.setCurp(dto.getCurp());
        entidad.setLugarResidencia(dto.getLugarResidencia());
        entidad.setNss(dto.getNss());
        entidad.setCelular(dto.getCelular());
        entidad.setTelefono(dto.getTelefono());
        entidad.setCorreo(dto.getCorreo());

        // Datos Académicos
        entidad.setIdAcademico(dto.getIdAcademico());
        entidad.setCorreoInstitucional(dto.getCorreoInstitucional());
        entidad.setCarrera(dto.getCarrera());
        entidad.setSemestre(dto.getSemestre());
        entidad.setBuscaAyudaAcademica(dto.getBuscaAyudaAcademica());
        entidad.setEfectividadEstudio(dto.getEfectividadEstudio());
        entidad.setEfectividadTiempo(dto.getEfectividadTiempo());
        entidad.setAspectosMejoraAcademica(dto.getAspectosMejoraAcademica());

        // Contacto Emergencia
        entidad.setNombreEmergencia(dto.getNombreEmergencia());
        entidad.setParentescoEmergencia(dto.getParentescoEmergencia());
        entidad.setDomicilioEmergencia(dto.getDomicilioEmergencia());
        entidad.setLugarEmergencia(dto.getLugarEmergencia());
        entidad.setCelularEmergencia(dto.getCelularEmergencia());
        entidad.setTelefonoEmergencia(dto.getTelefonoEmergencia());
        entidad.setCorreoEmergencia(dto.getCorreoEmergencia());

        // Tutor
        entidad.setNombreTutor(dto.getNombreTutor());
        entidad.setParentescoTutor(dto.getParentescoTutor());
        entidad.setDomicilioTutor(dto.getDomicilioTutor());
        entidad.setLugarTutor(dto.getLugarTutor());
        entidad.setCelularTutor(dto.getCelularTutor());
        entidad.setTelefonoTutor(dto.getTelefonoTutor());
        entidad.setCorreoTutor(dto.getCorreoTutor());

        // Datos Médicos
        entidad.setEstadoSalud(dto.getEstadoSalud());
        entidad.setTieneDeficienciaVista(dto.isTieneDeficienciaVista());
        entidad.setEspecificarVista(dto.getEspecificarVista());
        entidad.setTieneDeficienciaAuditiva(dto.isTieneDeficienciaAuditiva());
        entidad.setEspecificarAuditiva(dto.getEspecificarAuditiva());
        entidad.setTieneDiscapacidadFisica(dto.isTieneDiscapacidadFisica());
        entidad.setEspecificarFisica(dto.getEspecificarFisica());
        entidad.setTieneLesionesGraves(dto.isTieneLesionesGraves());
        entidad.setEspecificarLesiones(dto.getEspecificarLesiones());
        entidad.setTienePadecimientos(dto.isTienePadecimientos());
        entidad.setEspecificarPadecimientos(dto.getEspecificarPadecimientos());
        entidad.setTieneTratamientosPsicologicos(dto.isTieneTratamientosPsicologicos());
        entidad.setMotivoTratamientosPsicologicos(dto.getMotivoTratamientosPsicologicos());
        entidad.setTieneMedicamentosControlados(dto.isTieneMedicamentosControlados());
        entidad.setEspecificarMedicamentos(dto.getEspecificarMedicamentos());
        entidad.setTieneAlergias(dto.isTieneAlergias());
        entidad.setEspecificarAlergias(dto.getEspecificarAlergias());
        entidad.setTieneTratamientosExternos(dto.isTieneTratamientosExternos());
        entidad.setMotivoTratamientosExternos(dto.getMotivoTratamientosExternos());
        entidad.setTipoSangre(dto.getTipoSangre());
        entidad.setAspectosSaludMejora(dto.getAspectosSaludMejora());
        entidad.setOtraInformacionSalud(dto.getOtraInformacionSalud());

        // Aspectos Personales y Convivencia
        entidad.setHaVividoFuera(dto.isHaVividoFuera());
        entidad.setTiempoVividoFuera(dto.getTiempoVividoFuera());
        entidad.setDecisionResidencia(dto.getDecisionResidencia());
        entidad.setRazonesVivirResidencia(dto.getRazonesVivirResidencia());
        entidad.setAdaptacion(dto.getAdaptacion());
        entidad.setEstiloConvivencia(dto.getEstiloConvivencia());
        entidad.setSituacionesNoDeseadas(dto.getSituacionesNoDeseadas());

        // Compañeros
        entidad.setBuscaCompaneroExtranjero(dto.isBuscaCompaneroExtranjero());
        entidad.setBuscaCompaneroMexicano(dto.isBuscaCompaneroMexicano());
        entidad.setBuscaCompaneroReingreso(dto.isBuscaCompaneroReingreso());

        // Hábitos
        entidad.setHoraDormir(dto.getHoraDormir());
        entidad.setToleraRuido(dto.isToleraRuido());
        entidad.setImportanciaOrden(dto.getImportanciaOrden());
        entidad.setHabitosHigiene(dto.getHabitosHigiene());

        // Objetos
        entidad.setTraeAuto(dto.isTraeAuto());
        entidad.setTraeComputadora(dto.isTraeComputadora());
        entidad.setTraeTv(dto.isTraeTv());
        entidad.setTraeFrigobar(dto.isTraeFrigobar());

        // Actividades y Participación
        entidad.setIniciativaActividades(dto.getIniciativaActividades());
        entidad.setParticipacionGrupo(dto.isParticipacionGrupo());
        entidad.setTipoGrupo(dto.getTipoGrupo());
        entidad.setActividadesRealizadasGrupo(dto.getActividadesRealizadasGrupo());
        entidad.setDeseaActDeportivas(dto.isDeseaActDeportivas());
        entidad.setDeseaActCulturales(dto.isDeseaActCulturales());
        entidad.setDeseaActArtisticas(dto.isDeseaActArtisticas());
        entidad.setAspectosMejoraPersona(dto.getAspectosMejoraPersona());
        entidad.setOtraInformacion(dto.getOtraInformacion());

        return entidad;
    }
}
