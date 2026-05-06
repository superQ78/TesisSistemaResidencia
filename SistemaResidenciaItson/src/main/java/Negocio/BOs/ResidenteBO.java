package Negocio.BOs;

import Negocio.DTOs.ResidenteDTO;
import Persistencia.DAOs.ResidenteDAO;
import Persistencia.Entidades.ResidenteEntidad;
import Persistencia.Interfaces.IResidenteDAO;
import java.util.List;

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

    public ResidenteDTO consultarResidentePorId(String idAcademico) {
        Persistencia.Interfaces.IResidenteDAO dao = new Persistencia.DAOs.ResidenteDAO();
        Persistencia.Entidades.ResidenteEntidad entidad = dao.consultarPorId(idAcademico);

        if (entidad != null) {
            ResidenteDTO dto = new ResidenteDTO();

            // 1-10 Personales
            dto.setNombreCompleto(entidad.getNombreCompleto());
            dto.setSexo(entidad.getSexo());
            dto.setFechaNacimiento(entidad.getFechaNacimiento());
            dto.setDomicilio(entidad.getDomicilio());
            dto.setCurp(entidad.getCurp());
            dto.setLugarResidencia(entidad.getLugarResidencia());
            dto.setNss(entidad.getNss());
            dto.setCelular(entidad.getCelular());
            dto.setTelefono(entidad.getTelefono());
            dto.setCorreo(entidad.getCorreo());

            // 11-18 Académicos
            dto.setIdAcademico(entidad.getIdAcademico());
            dto.setCorreoInstitucional(entidad.getCorreoInstitucional());
            dto.setCarrera(entidad.getCarrera());
            dto.setSemestre(entidad.getSemestre());
            dto.setBuscaAyudaAcademica(entidad.getBuscaAyudaAcademica());
            dto.setEfectividadEstudio(entidad.getEfectividadEstudio());
            dto.setEfectividadTiempo(entidad.getEfectividadTiempo());
            dto.setAspectosMejoraAcademica(entidad.getAspectosMejoraAcademica());

            // 19-25 Emergencia
            dto.setNombreEmergencia(entidad.getNombreEmergencia());
            dto.setParentescoEmergencia(entidad.getParentescoEmergencia());
            dto.setDomicilioEmergencia(entidad.getDomicilioEmergencia());
            dto.setLugarEmergencia(entidad.getLugarEmergencia());
            dto.setCelularEmergencia(entidad.getCelularEmergencia());
            dto.setTelefonoEmergencia(entidad.getTelefonoEmergencia());
            dto.setCorreoEmergencia(entidad.getCorreoEmergencia());

            // 26-32 Tutor
            dto.setNombreTutor(entidad.getNombreTutor());
            dto.setParentescoTutor(entidad.getParentescoTutor());
            dto.setDomicilioTutor(entidad.getDomicilioTutor());
            dto.setLugarTutor(entidad.getLugarTutor());
            dto.setCelularTutor(entidad.getCelularTutor());
            dto.setTelefonoTutor(entidad.getTelefonoTutor());
            dto.setCorreoTutor(entidad.getCorreoTutor());

            // 33-54 Médicos
            dto.setEstadoSalud(entidad.getEstadoSalud());
            dto.setTieneDeficienciaVista(entidad.isTieneDeficienciaVista());
            dto.setEspecificarVista(entidad.getEspecificarVista());
            dto.setTieneDeficienciaAuditiva(entidad.isTieneDeficienciaAuditiva());
            dto.setEspecificarAuditiva(entidad.getEspecificarAuditiva());
            dto.setTieneDiscapacidadFisica(entidad.isTieneDiscapacidadFisica());
            dto.setEspecificarFisica(entidad.getEspecificarFisica());
            dto.setTieneLesionesGraves(entidad.isTieneLesionesGraves());
            dto.setEspecificarLesiones(entidad.getEspecificarLesiones());
            dto.setTienePadecimientos(entidad.isTienePadecimientos());
            dto.setEspecificarPadecimientos(entidad.getEspecificarPadecimientos());
            dto.setTieneTratamientosPsicologicos(entidad.isTieneTratamientosPsicologicos());
            dto.setMotivoTratamientosPsicologicos(entidad.getMotivoTratamientosPsicologicos());
            dto.setTieneMedicamentosControlados(entidad.isTieneMedicamentosControlados());
            dto.setEspecificarMedicamentos(entidad.getEspecificarMedicamentos());
            dto.setTieneAlergias(entidad.isTieneAlergias());
            dto.setEspecificarAlergias(entidad.getEspecificarAlergias());
            dto.setTieneTratamientosExternos(entidad.isTieneTratamientosExternos());
            dto.setMotivoTratamientosExternos(entidad.getMotivoTratamientosExternos());
            dto.setTipoSangre(entidad.getTipoSangre());
            dto.setAspectosSaludMejora(entidad.getAspectosSaludMejora());
            dto.setOtraInformacionSalud(entidad.getOtraInformacionSalud());

            // 55-61 Convivencia
            dto.setHaVividoFuera(entidad.isHaVividoFuera());
            dto.setTiempoVividoFuera(entidad.getTiempoVividoFuera());
            dto.setDecisionResidencia(entidad.getDecisionResidencia());
            dto.setRazonesVivirResidencia(entidad.getRazonesVivirResidencia());
            dto.setAdaptacion(entidad.getAdaptacion());
            dto.setEstiloConvivencia(entidad.getEstiloConvivencia());
            dto.setSituacionesNoDeseadas(entidad.getSituacionesNoDeseadas());

            // 62-68 Compañeros y Hábitos
            dto.setBuscaCompaneroExtranjero(entidad.isBuscaCompaneroExtranjero());
            dto.setBuscaCompaneroMexicano(entidad.isBuscaCompaneroMexicano());
            dto.setBuscaCompaneroReingreso(entidad.isBuscaCompaneroReingreso());
            dto.setHoraDormir(entidad.getHoraDormir());
            dto.setToleraRuido(entidad.isToleraRuido());
            dto.setImportanciaOrden(entidad.getImportanciaOrden());
            dto.setHabitosHigiene(entidad.getHabitosHigiene());

            // 69-72 Objetos
            dto.setTraeAuto(entidad.isTraeAuto());
            dto.setTraeComputadora(entidad.isTraeComputadora());
            dto.setTraeTv(entidad.isTraeTv());
            dto.setTraeFrigobar(entidad.isTraeFrigobar());

            // 73-81 Actividades y Mejora
            dto.setIniciativaActividades(entidad.getIniciativaActividades());
            dto.setParticipacionGrupo(entidad.isParticipacionGrupo());
            dto.setTipoGrupo(entidad.getTipoGrupo());
            dto.setActividadesRealizadasGrupo(entidad.getActividadesRealizadasGrupo());
            dto.setDeseaActDeportivas(entidad.isDeseaActDeportivas());
            dto.setDeseaActCulturales(entidad.isDeseaActCulturales());
            dto.setDeseaActArtisticas(entidad.isDeseaActArtisticas());
            dto.setAspectosMejoraPersona(entidad.getAspectosMejoraPersona());
            dto.setOtraInformacion(entidad.getOtraInformacion());

            return dto;
        }
        return null;
    }

    public List<ResidenteDTO> consultarResidentes() {
        Persistencia.Interfaces.IResidenteDAO dao = new Persistencia.DAOs.ResidenteDAO();
        List<Persistencia.Entidades.ResidenteEntidad> entidades = dao.consultarTodos();
        List<ResidenteDTO> dtos = new java.util.ArrayList<>();

        for (Persistencia.Entidades.ResidenteEntidad entidad : entidades) {
            ResidenteDTO dto = new ResidenteDTO();
            dto.setIdAcademico(entidad.getIdAcademico());
            dto.setNombreCompleto(entidad.getNombreCompleto());
            dto.setLugarResidencia(entidad.getLugarResidencia());
            dtos.add(dto);
        }
        return dtos;
    }

    public boolean actualizarRDP(ResidenteDTO dto) {
        Persistencia.Entidades.ResidenteEntidad entidad = new Persistencia.Entidades.ResidenteEntidad();

        // Datos personales
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

        // Datos academicos
        entidad.setIdAcademico(dto.getIdAcademico());
        entidad.setCorreoInstitucional(dto.getCorreoInstitucional());
        entidad.setCarrera(dto.getCarrera());
        entidad.setSemestre(dto.getSemestre());
        entidad.setBuscaAyudaAcademica(dto.getBuscaAyudaAcademica());
        entidad.setEfectividadEstudio(dto.getEfectividadEstudio());
        entidad.setEfectividadTiempo(dto.getEfectividadTiempo());
        entidad.setAspectosMejoraAcademica(dto.getAspectosMejoraAcademica());

        // Contacto Eemergencia
        entidad.setNombreEmergencia(dto.getNombreEmergencia());
        entidad.setParentescoEmergencia(dto.getParentescoEmergencia());
        entidad.setDomicilioEmergencia(dto.getDomicilioEmergencia());
        entidad.setLugarEmergencia(dto.getLugarEmergencia());
        entidad.setCelularEmergencia(dto.getCelularEmergencia());
        entidad.setTelefonoEmergencia(dto.getTelefonoEmergencia());
        entidad.setCorreoEmergencia(dto.getCorreoEmergencia());

        //datos tutor
        entidad.setNombreTutor(dto.getNombreTutor());
        entidad.setParentescoTutor(dto.getParentescoTutor());
        entidad.setDomicilioTutor(dto.getDomicilioTutor());
        entidad.setLugarTutor(dto.getLugarTutor());
        entidad.setCelularTutor(dto.getCelularTutor());
        entidad.setTelefonoTutor(dto.getTelefonoTutor());
        entidad.setCorreoTutor(dto.getCorreoTutor());

        // Datos medicos
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

        // Aspecto vivienda
        entidad.setHaVividoFuera(dto.isHaVividoFuera());
        entidad.setTiempoVividoFuera(dto.getTiempoVividoFuera());
        entidad.setDecisionResidencia(dto.getDecisionResidencia());
        entidad.setRazonesVivirResidencia(dto.getRazonesVivirResidencia());
        entidad.setAdaptacion(dto.getAdaptacion());
        entidad.setEstiloConvivencia(dto.getEstiloConvivencia());
        entidad.setSituacionesNoDeseadas(dto.getSituacionesNoDeseadas());

        entidad.setBuscaCompaneroExtranjero(dto.isBuscaCompaneroExtranjero());
        entidad.setBuscaCompaneroMexicano(dto.isBuscaCompaneroMexicano());
        entidad.setBuscaCompaneroReingreso(dto.isBuscaCompaneroReingreso());
        entidad.setHoraDormir(dto.getHoraDormir());
        entidad.setToleraRuido(dto.isToleraRuido());
        entidad.setImportanciaOrden(dto.getImportanciaOrden());
        entidad.setHabitosHigiene(dto.getHabitosHigiene());

        entidad.setTraeAuto(dto.isTraeAuto());
        entidad.setTraeComputadora(dto.isTraeComputadora());
        entidad.setTraeTv(dto.isTraeTv());
        entidad.setTraeFrigobar(dto.isTraeFrigobar());

        entidad.setIniciativaActividades(dto.getIniciativaActividades());
        entidad.setParticipacionGrupo(dto.isParticipacionGrupo());
        entidad.setTipoGrupo(dto.getTipoGrupo());
        entidad.setActividadesRealizadasGrupo(dto.getActividadesRealizadasGrupo());
        entidad.setDeseaActDeportivas(dto.isDeseaActDeportivas());
        entidad.setDeseaActCulturales(dto.isDeseaActCulturales());
        entidad.setDeseaActArtisticas(dto.isDeseaActArtisticas());
        entidad.setAspectosMejoraPersona(dto.getAspectosMejoraPersona());
        entidad.setOtraInformacion(dto.getOtraInformacion());

        Persistencia.Interfaces.IResidenteDAO dao = new Persistencia.DAOs.ResidenteDAO();
        return dao.actualizar(entidad);
    }
}
