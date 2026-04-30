package Persistencia.Entidades;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class ResidenteEntidad {

    // Datos personales
    private String nombreCompleto;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String domicilio;
    private String curp;
    private String lugarResidencia; // Ciudad, Estado, País
    private String nss; // Número de afiliación IMSS
    private String celular; // Lada + Número ya concatenados
    private String telefono;
    private String correo;

    // datos academicos
    private String idAcademico;
    private String correoInstitucional;
    private String carrera;
    private String semestre;
    private String buscaAyudaAcademica; // "Siempre", "A veces", "Nunca"
    private String efectividadEstudio;
    private String efectividadTiempo;
    private String aspectosMejoraAcademica;

    // Datos de contacto de emergencia
    private String nombreEmergencia;
    private String parentescoEmergencia;
    private String domicilioEmergencia;
    private String lugarEmergencia;
    private String celularEmergencia;
    private String telefonoEmergencia;
    private String correoEmergencia;

    // datos de tutor
    private String nombreTutor;
    private String parentescoTutor;
    private String domicilioTutor;
    private String lugarTutor;
    private String celularTutor;
    private String telefonoTutor;
    private String correoTutor;

    // datos medicos
    private String estadoSalud; // "Bueno", "Regular", "Malo"
    private boolean tieneDeficienciaVista;
    private String especificarVista;
    private boolean tieneDeficienciaAuditiva;
    private String especificarAuditiva;
    private boolean tieneDiscapacidadFisica;
    private String especificarFisica;
    private boolean tieneLesionesGraves;
    private String especificarLesiones;
    private boolean tienePadecimientos;
    private String especificarPadecimientos;
    private boolean tieneTratamientosPsicologicos;
    private String motivoTratamientosPsicologicos;
    private boolean tieneMedicamentosControlados;
    private String especificarMedicamentos;
    private boolean tieneAlergias;
    private String especificarAlergias;
    private boolean tieneTratamientosExternos;
    private String motivoTratamientosExternos;
    private String tipoSangre;
    private String aspectosSaludMejora;
    private String otraInformacionSalud;

    //Datos de aspectos personales y de convivencia
    private boolean haVividoFuera;
    private String tiempoVividoFuera;
    private String decisionResidencia; // "Tuya", "Padres", "Ambos"
    private String razonesVivirResidencia;
    private String adaptacion;
    private String estiloConvivencia; // "Ceder", "Negociar", "Persuadir"
    private String situacionesNoDeseadas;

    // Para las casillas múltiples (Checkboxes) usamos List<String> o booleanos. 
    // Usaremos booleanos para que sea más fácil de insertar en MySQL.
    private boolean buscaCompaneroExtranjero;
    private boolean buscaCompaneroMexicano;
    private boolean buscaCompaneroReingreso;

    private String horaDormir;
    private boolean toleraRuido;
    private String importanciaOrden; // "Poco", "Regular", "Muy importante"
    private String habitosHigiene;

    // Objetos a traer (Checkboxes)
    private boolean traeAuto;
    private boolean traeComputadora;
    private boolean traeTv;
    private boolean traeFrigobar;

    private String iniciativaActividades;
    private boolean participacionGrupo;
    private String tipoGrupo;
    private String actividadesRealizadasGrupo;

    // Actividades deseadas (Checkboxes)
    private boolean deseaActDeportivas;
    private boolean deseaActCulturales;
    private boolean deseaActArtisticas;

    private String aspectosMejoraPersona;
    private String otraInformacion;

    public ResidenteEntidad(String nombreCompleto, String sexo, LocalDate fechaNacimiento, String domicilio, String curp, String lugarResidencia, String nss, String celular, String telefono, String correo, String idAcademico, String correoInstitucional, String carrera, String semestre, String buscaAyudaAcademica, String efectividadEstudio, String efectividadTiempo, String aspectosMejoraAcademica, String nombreEmergencia, String parentescoEmergencia, String domicilioEmergencia, String lugarEmergencia, String celularEmergencia, String telefonoEmergencia, String correoEmergencia, String nombreTutor, String parentescoTutor, String domicilioTutor, String lugarTutor, String celularTutor, String telefonoTutor, String correoTutor, String estadoSalud, boolean tieneDeficienciaVista, String especificarVista, boolean tieneDeficienciaAuditiva, String especificarAuditiva, boolean tieneDiscapacidadFisica, String especificarFisica, boolean tieneLesionesGraves, String especificarLesiones, boolean tienePadecimientos, String especificarPadecimientos, boolean tieneTratamientosPsicologicos, String motivoTratamientosPsicologicos, boolean tieneMedicamentosControlados, String especificarMedicamentos, boolean tieneAlergias, String especificarAlergias, boolean tieneTratamientosExternos, String motivoTratamientosExternos, String tipoSangre, String aspectosSaludMejora, String otraInformacionSalud, boolean haVividoFuera, String tiempoVividoFuera, String decisionResidencia, String razonesVivirResidencia, String adaptacion, String estiloConvivencia, String situacionesNoDeseadas, boolean buscaCompaneroExtranjero, boolean buscaCompaneroMexicano, boolean buscaCompaneroReingreso, String horaDormir, boolean toleraRuido, String importanciaOrden, String habitosHigiene, boolean traeAuto, boolean traeComputadora, boolean traeTv, boolean traeFrigobar, String iniciativaActividades, boolean participacionGrupo, String tipoGrupo, String actividadesRealizadasGrupo, boolean deseaActDeportivas, boolean deseaActCulturales, boolean deseaActArtisticas, String aspectosMejoraPersona, String otraInformacion) {
        this.nombreCompleto = nombreCompleto;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.curp = curp;
        this.lugarResidencia = lugarResidencia;
        this.nss = nss;
        this.celular = celular;
        this.telefono = telefono;
        this.correo = correo;
        this.idAcademico = idAcademico;
        this.correoInstitucional = correoInstitucional;
        this.carrera = carrera;
        this.semestre = semestre;
        this.buscaAyudaAcademica = buscaAyudaAcademica;
        this.efectividadEstudio = efectividadEstudio;
        this.efectividadTiempo = efectividadTiempo;
        this.aspectosMejoraAcademica = aspectosMejoraAcademica;
        this.nombreEmergencia = nombreEmergencia;
        this.parentescoEmergencia = parentescoEmergencia;
        this.domicilioEmergencia = domicilioEmergencia;
        this.lugarEmergencia = lugarEmergencia;
        this.celularEmergencia = celularEmergencia;
        this.telefonoEmergencia = telefonoEmergencia;
        this.correoEmergencia = correoEmergencia;
        this.nombreTutor = nombreTutor;
        this.parentescoTutor = parentescoTutor;
        this.domicilioTutor = domicilioTutor;
        this.lugarTutor = lugarTutor;
        this.celularTutor = celularTutor;
        this.telefonoTutor = telefonoTutor;
        this.correoTutor = correoTutor;
        this.estadoSalud = estadoSalud;
        this.tieneDeficienciaVista = tieneDeficienciaVista;
        this.especificarVista = especificarVista;
        this.tieneDeficienciaAuditiva = tieneDeficienciaAuditiva;
        this.especificarAuditiva = especificarAuditiva;
        this.tieneDiscapacidadFisica = tieneDiscapacidadFisica;
        this.especificarFisica = especificarFisica;
        this.tieneLesionesGraves = tieneLesionesGraves;
        this.especificarLesiones = especificarLesiones;
        this.tienePadecimientos = tienePadecimientos;
        this.especificarPadecimientos = especificarPadecimientos;
        this.tieneTratamientosPsicologicos = tieneTratamientosPsicologicos;
        this.motivoTratamientosPsicologicos = motivoTratamientosPsicologicos;
        this.tieneMedicamentosControlados = tieneMedicamentosControlados;
        this.especificarMedicamentos = especificarMedicamentos;
        this.tieneAlergias = tieneAlergias;
        this.especificarAlergias = especificarAlergias;
        this.tieneTratamientosExternos = tieneTratamientosExternos;
        this.motivoTratamientosExternos = motivoTratamientosExternos;
        this.tipoSangre = tipoSangre;
        this.aspectosSaludMejora = aspectosSaludMejora;
        this.otraInformacionSalud = otraInformacionSalud;
        this.haVividoFuera = haVividoFuera;
        this.tiempoVividoFuera = tiempoVividoFuera;
        this.decisionResidencia = decisionResidencia;
        this.razonesVivirResidencia = razonesVivirResidencia;
        this.adaptacion = adaptacion;
        this.estiloConvivencia = estiloConvivencia;
        this.situacionesNoDeseadas = situacionesNoDeseadas;
        this.buscaCompaneroExtranjero = buscaCompaneroExtranjero;
        this.buscaCompaneroMexicano = buscaCompaneroMexicano;
        this.buscaCompaneroReingreso = buscaCompaneroReingreso;
        this.horaDormir = horaDormir;
        this.toleraRuido = toleraRuido;
        this.importanciaOrden = importanciaOrden;
        this.habitosHigiene = habitosHigiene;
        this.traeAuto = traeAuto;
        this.traeComputadora = traeComputadora;
        this.traeTv = traeTv;
        this.traeFrigobar = traeFrigobar;
        this.iniciativaActividades = iniciativaActividades;
        this.participacionGrupo = participacionGrupo;
        this.tipoGrupo = tipoGrupo;
        this.actividadesRealizadasGrupo = actividadesRealizadasGrupo;
        this.deseaActDeportivas = deseaActDeportivas;
        this.deseaActCulturales = deseaActCulturales;
        this.deseaActArtisticas = deseaActArtisticas;
        this.aspectosMejoraPersona = aspectosMejoraPersona;
        this.otraInformacion = otraInformacion;
    }

    public ResidenteEntidad() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getBuscaAyudaAcademica() {
        return buscaAyudaAcademica;
    }

    public void setBuscaAyudaAcademica(String buscaAyudaAcademica) {
        this.buscaAyudaAcademica = buscaAyudaAcademica;
    }

    public String getEfectividadEstudio() {
        return efectividadEstudio;
    }

    public void setEfectividadEstudio(String efectividadEstudio) {
        this.efectividadEstudio = efectividadEstudio;
    }

    public String getEfectividadTiempo() {
        return efectividadTiempo;
    }

    public void setEfectividadTiempo(String efectividadTiempo) {
        this.efectividadTiempo = efectividadTiempo;
    }

    public String getAspectosMejoraAcademica() {
        return aspectosMejoraAcademica;
    }

    public void setAspectosMejoraAcademica(String aspectosMejoraAcademica) {
        this.aspectosMejoraAcademica = aspectosMejoraAcademica;
    }

    public String getNombreEmergencia() {
        return nombreEmergencia;
    }

    public void setNombreEmergencia(String nombreEmergencia) {
        this.nombreEmergencia = nombreEmergencia;
    }

    public String getParentescoEmergencia() {
        return parentescoEmergencia;
    }

    public void setParentescoEmergencia(String parentescoEmergencia) {
        this.parentescoEmergencia = parentescoEmergencia;
    }

    public String getDomicilioEmergencia() {
        return domicilioEmergencia;
    }

    public void setDomicilioEmergencia(String domicilioEmergencia) {
        this.domicilioEmergencia = domicilioEmergencia;
    }

    public String getLugarEmergencia() {
        return lugarEmergencia;
    }

    public void setLugarEmergencia(String lugarEmergencia) {
        this.lugarEmergencia = lugarEmergencia;
    }

    public String getCelularEmergencia() {
        return celularEmergencia;
    }

    public void setCelularEmergencia(String celularEmergencia) {
        this.celularEmergencia = celularEmergencia;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getCorreoEmergencia() {
        return correoEmergencia;
    }

    public void setCorreoEmergencia(String correoEmergencia) {
        this.correoEmergencia = correoEmergencia;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getParentescoTutor() {
        return parentescoTutor;
    }

    public void setParentescoTutor(String parentescoTutor) {
        this.parentescoTutor = parentescoTutor;
    }

    public String getDomicilioTutor() {
        return domicilioTutor;
    }

    public void setDomicilioTutor(String domicilioTutor) {
        this.domicilioTutor = domicilioTutor;
    }

    public String getLugarTutor() {
        return lugarTutor;
    }

    public void setLugarTutor(String lugarTutor) {
        this.lugarTutor = lugarTutor;
    }

    public String getCelularTutor() {
        return celularTutor;
    }

    public void setCelularTutor(String celularTutor) {
        this.celularTutor = celularTutor;
    }

    public String getTelefonoTutor() {
        return telefonoTutor;
    }

    public void setTelefonoTutor(String telefonoTutor) {
        this.telefonoTutor = telefonoTutor;
    }

    public String getCorreoTutor() {
        return correoTutor;
    }

    public void setCorreoTutor(String correoTutor) {
        this.correoTutor = correoTutor;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public boolean isTieneDeficienciaVista() {
        return tieneDeficienciaVista;
    }

    public void setTieneDeficienciaVista(boolean tieneDeficienciaVista) {
        this.tieneDeficienciaVista = tieneDeficienciaVista;
    }

    public String getEspecificarVista() {
        return especificarVista;
    }

    public void setEspecificarVista(String especificarVista) {
        this.especificarVista = especificarVista;
    }

    public boolean isTieneDeficienciaAuditiva() {
        return tieneDeficienciaAuditiva;
    }

    public void setTieneDeficienciaAuditiva(boolean tieneDeficienciaAuditiva) {
        this.tieneDeficienciaAuditiva = tieneDeficienciaAuditiva;
    }

    public String getEspecificarAuditiva() {
        return especificarAuditiva;
    }

    public void setEspecificarAuditiva(String especificarAuditiva) {
        this.especificarAuditiva = especificarAuditiva;
    }

    public boolean isTieneDiscapacidadFisica() {
        return tieneDiscapacidadFisica;
    }

    public void setTieneDiscapacidadFisica(boolean tieneDiscapacidadFisica) {
        this.tieneDiscapacidadFisica = tieneDiscapacidadFisica;
    }

    public String getEspecificarFisica() {
        return especificarFisica;
    }

    public void setEspecificarFisica(String especificarFisica) {
        this.especificarFisica = especificarFisica;
    }

    public boolean isTieneLesionesGraves() {
        return tieneLesionesGraves;
    }

    public void setTieneLesionesGraves(boolean tieneLesionesGraves) {
        this.tieneLesionesGraves = tieneLesionesGraves;
    }

    public String getEspecificarLesiones() {
        return especificarLesiones;
    }

    public void setEspecificarLesiones(String especificarLesiones) {
        this.especificarLesiones = especificarLesiones;
    }

    public boolean isTienePadecimientos() {
        return tienePadecimientos;
    }

    public void setTienePadecimientos(boolean tienePadecimientos) {
        this.tienePadecimientos = tienePadecimientos;
    }

    public String getEspecificarPadecimientos() {
        return especificarPadecimientos;
    }

    public void setEspecificarPadecimientos(String especificarPadecimientos) {
        this.especificarPadecimientos = especificarPadecimientos;
    }

    public boolean isTieneTratamientosPsicologicos() {
        return tieneTratamientosPsicologicos;
    }

    public void setTieneTratamientosPsicologicos(boolean tieneTratamientosPsicologicos) {
        this.tieneTratamientosPsicologicos = tieneTratamientosPsicologicos;
    }

    public String getMotivoTratamientosPsicologicos() {
        return motivoTratamientosPsicologicos;
    }

    public void setMotivoTratamientosPsicologicos(String motivoTratamientosPsicologicos) {
        this.motivoTratamientosPsicologicos = motivoTratamientosPsicologicos;
    }

    public boolean isTieneMedicamentosControlados() {
        return tieneMedicamentosControlados;
    }

    public void setTieneMedicamentosControlados(boolean tieneMedicamentosControlados) {
        this.tieneMedicamentosControlados = tieneMedicamentosControlados;
    }

    public String getEspecificarMedicamentos() {
        return especificarMedicamentos;
    }

    public void setEspecificarMedicamentos(String especificarMedicamentos) {
        this.especificarMedicamentos = especificarMedicamentos;
    }

    public boolean isTieneAlergias() {
        return tieneAlergias;
    }

    public void setTieneAlergias(boolean tieneAlergias) {
        this.tieneAlergias = tieneAlergias;
    }

    public String getEspecificarAlergias() {
        return especificarAlergias;
    }

    public void setEspecificarAlergias(String especificarAlergias) {
        this.especificarAlergias = especificarAlergias;
    }

    public boolean isTieneTratamientosExternos() {
        return tieneTratamientosExternos;
    }

    public void setTieneTratamientosExternos(boolean tieneTratamientosExternos) {
        this.tieneTratamientosExternos = tieneTratamientosExternos;
    }

    public String getMotivoTratamientosExternos() {
        return motivoTratamientosExternos;
    }

    public void setMotivoTratamientosExternos(String motivoTratamientosExternos) {
        this.motivoTratamientosExternos = motivoTratamientosExternos;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAspectosSaludMejora() {
        return aspectosSaludMejora;
    }

    public void setAspectosSaludMejora(String aspectosSaludMejora) {
        this.aspectosSaludMejora = aspectosSaludMejora;
    }

    public String getOtraInformacionSalud() {
        return otraInformacionSalud;
    }

    public void setOtraInformacionSalud(String otraInformacionSalud) {
        this.otraInformacionSalud = otraInformacionSalud;
    }

    public boolean isHaVividoFuera() {
        return haVividoFuera;
    }

    public void setHaVividoFuera(boolean haVividoFuera) {
        this.haVividoFuera = haVividoFuera;
    }

    public String getTiempoVividoFuera() {
        return tiempoVividoFuera;
    }

    public void setTiempoVividoFuera(String tiempoVividoFuera) {
        this.tiempoVividoFuera = tiempoVividoFuera;
    }

    public String getDecisionResidencia() {
        return decisionResidencia;
    }

    public void setDecisionResidencia(String decisionResidencia) {
        this.decisionResidencia = decisionResidencia;
    }

    public String getRazonesVivirResidencia() {
        return razonesVivirResidencia;
    }

    public void setRazonesVivirResidencia(String razonesVivirResidencia) {
        this.razonesVivirResidencia = razonesVivirResidencia;
    }

    public String getAdaptacion() {
        return adaptacion;
    }

    public void setAdaptacion(String adaptacion) {
        this.adaptacion = adaptacion;
    }

    public String getEstiloConvivencia() {
        return estiloConvivencia;
    }

    public void setEstiloConvivencia(String estiloConvivencia) {
        this.estiloConvivencia = estiloConvivencia;
    }

    public String getSituacionesNoDeseadas() {
        return situacionesNoDeseadas;
    }

    public void setSituacionesNoDeseadas(String situacionesNoDeseadas) {
        this.situacionesNoDeseadas = situacionesNoDeseadas;
    }

    public boolean isBuscaCompaneroExtranjero() {
        return buscaCompaneroExtranjero;
    }

    public void setBuscaCompaneroExtranjero(boolean buscaCompaneroExtranjero) {
        this.buscaCompaneroExtranjero = buscaCompaneroExtranjero;
    }

    public boolean isBuscaCompaneroMexicano() {
        return buscaCompaneroMexicano;
    }

    public void setBuscaCompaneroMexicano(boolean buscaCompaneroMexicano) {
        this.buscaCompaneroMexicano = buscaCompaneroMexicano;
    }

    public boolean isBuscaCompaneroReingreso() {
        return buscaCompaneroReingreso;
    }

    public void setBuscaCompaneroReingreso(boolean buscaCompaneroReingreso) {
        this.buscaCompaneroReingreso = buscaCompaneroReingreso;
    }

    public String getHoraDormir() {
        return horaDormir;
    }

    public void setHoraDormir(String horaDormir) {
        this.horaDormir = horaDormir;
    }

    public boolean isToleraRuido() {
        return toleraRuido;
    }

    public void setToleraRuido(boolean toleraRuido) {
        this.toleraRuido = toleraRuido;
    }

    public String getImportanciaOrden() {
        return importanciaOrden;
    }

    public void setImportanciaOrden(String importanciaOrden) {
        this.importanciaOrden = importanciaOrden;
    }

    public String getHabitosHigiene() {
        return habitosHigiene;
    }

    public void setHabitosHigiene(String habitosHigiene) {
        this.habitosHigiene = habitosHigiene;
    }

    public boolean isTraeAuto() {
        return traeAuto;
    }

    public void setTraeAuto(boolean traeAuto) {
        this.traeAuto = traeAuto;
    }

    public boolean isTraeComputadora() {
        return traeComputadora;
    }

    public void setTraeComputadora(boolean traeComputadora) {
        this.traeComputadora = traeComputadora;
    }

    public boolean isTraeTv() {
        return traeTv;
    }

    public void setTraeTv(boolean traeTv) {
        this.traeTv = traeTv;
    }

    public boolean isTraeFrigobar() {
        return traeFrigobar;
    }

    public void setTraeFrigobar(boolean traeFrigobar) {
        this.traeFrigobar = traeFrigobar;
    }

    public String getIniciativaActividades() {
        return iniciativaActividades;
    }

    public void setIniciativaActividades(String iniciativaActividades) {
        this.iniciativaActividades = iniciativaActividades;
    }

    public boolean isParticipacionGrupo() {
        return participacionGrupo;
    }

    public void setParticipacionGrupo(boolean participacionGrupo) {
        this.participacionGrupo = participacionGrupo;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public String getActividadesRealizadasGrupo() {
        return actividadesRealizadasGrupo;
    }

    public void setActividadesRealizadasGrupo(String actividadesRealizadasGrupo) {
        this.actividadesRealizadasGrupo = actividadesRealizadasGrupo;
    }

    public boolean isDeseaActDeportivas() {
        return deseaActDeportivas;
    }

    public void setDeseaActDeportivas(boolean deseaActDeportivas) {
        this.deseaActDeportivas = deseaActDeportivas;
    }

    public boolean isDeseaActCulturales() {
        return deseaActCulturales;
    }

    public void setDeseaActCulturales(boolean deseaActCulturales) {
        this.deseaActCulturales = deseaActCulturales;
    }

    public boolean isDeseaActArtisticas() {
        return deseaActArtisticas;
    }

    public void setDeseaActArtisticas(boolean deseaActArtisticas) {
        this.deseaActArtisticas = deseaActArtisticas;
    }

    public String getAspectosMejoraPersona() {
        return aspectosMejoraPersona;
    }

    public void setAspectosMejoraPersona(String aspectosMejoraPersona) {
        this.aspectosMejoraPersona = aspectosMejoraPersona;
    }

    public String getOtraInformacion() {
        return otraInformacion;
    }

    public void setOtraInformacion(String otraInformacion) {
        this.otraInformacion = otraInformacion;
    }

}
