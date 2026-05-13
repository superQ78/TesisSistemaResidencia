package Persistencia.DAOs;

import Persistencia.Conexion.Conexion;
import Persistencia.Entidades.ResidenteEntidad;
import Persistencia.Entidades.SolicitudIngresoEntidad;
import Persistencia.Interfaces.IResidenteDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResidenteDAO implements IResidenteDAO {

    @Override
    public boolean insertar(ResidenteEntidad entidad) {
        String sql = "INSERT INTO residentes ("
                + "nombreCompleto, sexo, fechaNacimiento, domicilio, curp, lugarResidencia, nss, celular, telefono, correo, "
                + "idAcademico, correoInstitucional, carrera, semestre, buscaAyudaAcademica, efectividadEstudio, efectividadTiempo, aspectosMejoraAcademica, "
                + "nombreEmergencia, parentescoEmergencia, domicilioEmergencia, lugarEmergencia, celularEmergencia, telefonoEmergencia, correoEmergencia, "
                + "nombreTutor, parentescoTutor, domicilioTutor, lugarTutor, celularTutor, telefonoTutor, correoTutor, "
                + "estadoSalud, tieneDeficienciaVista, especificarVista, tieneDeficienciaAuditiva, especificarAuditiva, tieneDiscapacidadFisica, especificarFisica, tieneLesionesGraves, especificarLesiones, tienePadecimientos, especificarPadecimientos, tieneTratamientosPsicologicos, motivoTratamientosPsicologicos, tieneMedicamentosControlados, especificarMedicamentos, tieneAlergias, especificarAlergias, tieneTratamientosExternos, motivoTratamientosExternos, tipoSangre, aspectosSaludMejora, otraInformacionSalud, "
                + "haVividoFuera, tiempoVividoFuera, decisionResidencia, razonesVivirResidencia, adaptacion, estiloConvivencia, situacionesNoDeseadas, "
                + "buscaCompaneroExtranjero, buscaCompaneroMexicano, buscaCompaneroReingreso, horaDormir, toleraRuido, importanciaOrden, habitosHigiene, "
                + "traeAuto, traeComputadora, traeTv, traeFrigobar, iniciativaActividades, participacionGrupo, tipoGrupo, actividadesRealizadasGrupo, "
                + "deseaActDeportivas, deseaActCulturales, deseaActArtisticas, aspectosMejoraPersona, otraInformacion) "
                + "VALUES ("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " // 1-10
                + "?, ?, ?, ?, ?, ?, ?, ?, " // 11-18
                + "?, ?, ?, ?, ?, ?, ?, " // 19-25
                + "?, ?, ?, ?, ?, ?, ?, " // 26-32
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " // 33-54
                + "?, ?, ?, ?, ?, ?, ?, " // 55-61
                + "?, ?, ?, ?, ?, ?, ?, " // 62-68
                + "?, ?, ?, ?, ?, ?, ?, ?, " // 69-76
                + "?, ?, ?, ?, ?)"; // 77-81

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            // 1-10 Personales
            ps.setString(1, entidad.getNombreCompleto());
            ps.setString(2, entidad.getSexo());
            ps.setDate(3, entidad.getFechaNacimiento() != null ? Date.valueOf(entidad.getFechaNacimiento()) : null);
            ps.setString(4, entidad.getDomicilio());
            ps.setString(5, entidad.getCurp());
            ps.setString(6, entidad.getLugarResidencia());
            ps.setString(7, entidad.getNss());
            ps.setString(8, entidad.getCelular());
            ps.setString(9, entidad.getTelefono());
            ps.setString(10, entidad.getCorreo());

            // 11-18 Académicos
            ps.setString(11, entidad.getIdAcademico());
            ps.setString(12, entidad.getCorreoInstitucional());
            ps.setString(13, entidad.getCarrera());
            ps.setString(14, entidad.getSemestre());
            ps.setString(15, entidad.getBuscaAyudaAcademica());
            ps.setString(16, entidad.getEfectividadEstudio());
            ps.setString(17, entidad.getEfectividadTiempo());
            ps.setString(18, entidad.getAspectosMejoraAcademica());

            // 19-25 Emergencia
            ps.setString(19, entidad.getNombreEmergencia());
            ps.setString(20, entidad.getParentescoEmergencia());
            ps.setString(21, entidad.getDomicilioEmergencia());
            ps.setString(22, entidad.getLugarEmergencia());
            ps.setString(23, entidad.getCelularEmergencia());
            ps.setString(24, entidad.getTelefonoEmergencia());
            ps.setString(25, entidad.getCorreoEmergencia());

            // 26-32 Tutor
            ps.setString(26, entidad.getNombreTutor());
            ps.setString(27, entidad.getParentescoTutor());
            ps.setString(28, entidad.getDomicilioTutor());
            ps.setString(29, entidad.getLugarTutor());
            ps.setString(30, entidad.getCelularTutor());
            ps.setString(31, entidad.getTelefonoTutor());
            ps.setString(32, entidad.getCorreoTutor());

            // 33-54 Médicos
            ps.setString(33, entidad.getEstadoSalud());
            ps.setBoolean(34, entidad.isTieneDeficienciaVista());
            ps.setString(35, entidad.getEspecificarVista());
            ps.setBoolean(36, entidad.isTieneDeficienciaAuditiva());
            ps.setString(37, entidad.getEspecificarAuditiva());
            ps.setBoolean(38, entidad.isTieneDiscapacidadFisica());
            ps.setString(39, entidad.getEspecificarFisica());
            ps.setBoolean(40, entidad.isTieneLesionesGraves());
            ps.setString(41, entidad.getEspecificarLesiones());
            ps.setBoolean(42, entidad.isTienePadecimientos());
            ps.setString(43, entidad.getEspecificarPadecimientos());
            ps.setBoolean(44, entidad.isTieneTratamientosPsicologicos());
            ps.setString(45, entidad.getMotivoTratamientosPsicologicos());
            ps.setBoolean(46, entidad.isTieneMedicamentosControlados());
            ps.setString(47, entidad.getEspecificarMedicamentos());
            ps.setBoolean(48, entidad.isTieneAlergias());
            ps.setString(49, entidad.getEspecificarAlergias());
            ps.setBoolean(50, entidad.isTieneTratamientosExternos());
            ps.setString(51, entidad.getMotivoTratamientosExternos());
            ps.setString(52, entidad.getTipoSangre());
            ps.setString(53, entidad.getAspectosSaludMejora());
            ps.setString(54, entidad.getOtraInformacionSalud());

            // 55-61 Convivencia
            ps.setBoolean(55, entidad.isHaVividoFuera());
            ps.setString(56, entidad.getTiempoVividoFuera());
            ps.setString(57, entidad.getDecisionResidencia());
            ps.setString(58, entidad.getRazonesVivirResidencia());
            ps.setString(59, entidad.getAdaptacion());
            ps.setString(60, entidad.getEstiloConvivencia());
            ps.setString(61, entidad.getSituacionesNoDeseadas());

            // 62-68 Compañeros y Hábitos
            ps.setBoolean(62, entidad.isBuscaCompaneroExtranjero());
            ps.setBoolean(63, entidad.isBuscaCompaneroMexicano());
            ps.setBoolean(64, entidad.isBuscaCompaneroReingreso());
            ps.setString(65, entidad.getHoraDormir());
            ps.setBoolean(66, entidad.isToleraRuido());
            ps.setString(67, entidad.getImportanciaOrden());
            ps.setString(68, entidad.getHabitosHigiene());

            // 69-72 Objetos
            ps.setBoolean(69, entidad.isTraeAuto());
            ps.setBoolean(70, entidad.isTraeComputadora());
            ps.setBoolean(71, entidad.isTraeTv());
            ps.setBoolean(72, entidad.isTraeFrigobar());

            // 73-81 Actividades y Mejora
            ps.setString(73, entidad.getIniciativaActividades());
            ps.setBoolean(74, entidad.isParticipacionGrupo());
            ps.setString(75, entidad.getTipoGrupo());
            ps.setString(76, entidad.getActividadesRealizadasGrupo());
            ps.setBoolean(77, entidad.isDeseaActDeportivas());
            ps.setBoolean(78, entidad.isDeseaActCulturales());
            ps.setBoolean(79, entidad.isDeseaActArtisticas());
            ps.setString(80, entidad.getAspectosMejoraPersona());
            ps.setString(81, entidad.getOtraInformacion());

            int filasInsertadas = ps.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar RDP en BD: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ResidenteEntidad> consultarTodos() {
        List<ResidenteEntidad> lista = new ArrayList<>();
        // Solo traemos a todos para cargar la tabla
        String sql = "SELECT idAcademico, nombreCompleto, lugarResidencia FROM residentes";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); java.sql.ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ResidenteEntidad entidad = new ResidenteEntidad();
                entidad.setIdAcademico(rs.getString("idAcademico"));
                entidad.setNombreCompleto(rs.getString("nombreCompleto"));
                entidad.setLugarResidencia(rs.getString("lugarResidencia"));
                lista.add(entidad);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar todos los residentes en BD: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public ResidenteEntidad consultarPorId(String idAcademico) {
        String sql = "SELECT * FROM residentes WHERE idAcademico = ?"; // Usamos el id de estudiante

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, idAcademico);
            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ResidenteEntidad entidad = new ResidenteEntidad();

                //Personales
                entidad.setNombreCompleto(rs.getString("nombreCompleto"));
                entidad.setSexo(rs.getString("sexo"));
                java.sql.Date fecha = rs.getDate("fechaNacimiento");
                if (fecha != null) {
                    entidad.setFechaNacimiento(fecha.toLocalDate());
                }
                entidad.setDomicilio(rs.getString("domicilio"));
                entidad.setCurp(rs.getString("curp"));
                entidad.setLugarResidencia(rs.getString("lugarResidencia"));
                entidad.setNss(rs.getString("nss"));
                entidad.setCelular(rs.getString("celular"));
                entidad.setTelefono(rs.getString("telefono"));
                entidad.setCorreo(rs.getString("correo"));

                //Académicos
                entidad.setIdAcademico(rs.getString("idAcademico"));
                entidad.setCorreoInstitucional(rs.getString("correoInstitucional"));
                entidad.setCarrera(rs.getString("carrera"));
                entidad.setSemestre(rs.getString("semestre"));
                entidad.setBuscaAyudaAcademica(rs.getString("buscaAyudaAcademica"));
                entidad.setEfectividadEstudio(rs.getString("efectividadEstudio"));
                entidad.setEfectividadTiempo(rs.getString("efectividadTiempo"));
                entidad.setAspectosMejoraAcademica(rs.getString("aspectosMejoraAcademica"));

                //Emergencia
                entidad.setNombreEmergencia(rs.getString("nombreEmergencia"));
                entidad.setParentescoEmergencia(rs.getString("parentescoEmergencia"));
                entidad.setDomicilioEmergencia(rs.getString("domicilioEmergencia"));
                entidad.setLugarEmergencia(rs.getString("lugarEmergencia"));
                entidad.setCelularEmergencia(rs.getString("celularEmergencia"));
                entidad.setTelefonoEmergencia(rs.getString("telefonoEmergencia"));
                entidad.setCorreoEmergencia(rs.getString("correoEmergencia"));

                //Tutor
                entidad.setNombreTutor(rs.getString("nombreTutor"));
                entidad.setParentescoTutor(rs.getString("parentescoTutor"));
                entidad.setDomicilioTutor(rs.getString("domicilioTutor"));
                entidad.setLugarTutor(rs.getString("lugarTutor"));
                entidad.setCelularTutor(rs.getString("celularTutor"));
                entidad.setTelefonoTutor(rs.getString("telefonoTutor"));
                entidad.setCorreoTutor(rs.getString("correoTutor"));

                //Médicos
                entidad.setEstadoSalud(rs.getString("estadoSalud"));
                entidad.setTieneDeficienciaVista(rs.getBoolean("tieneDeficienciaVista"));
                entidad.setEspecificarVista(rs.getString("especificarVista"));
                entidad.setTieneDeficienciaAuditiva(rs.getBoolean("tieneDeficienciaAuditiva"));
                entidad.setEspecificarAuditiva(rs.getString("especificarAuditiva"));
                entidad.setTieneDiscapacidadFisica(rs.getBoolean("tieneDiscapacidadFisica"));
                entidad.setEspecificarFisica(rs.getString("especificarFisica"));
                entidad.setTieneLesionesGraves(rs.getBoolean("tieneLesionesGraves"));
                entidad.setEspecificarLesiones(rs.getString("especificarLesiones"));
                entidad.setTienePadecimientos(rs.getBoolean("tienePadecimientos"));
                entidad.setEspecificarPadecimientos(rs.getString("especificarPadecimientos"));
                entidad.setTieneTratamientosPsicologicos(rs.getBoolean("tieneTratamientosPsicologicos"));
                entidad.setMotivoTratamientosPsicologicos(rs.getString("motivoTratamientosPsicologicos"));
                entidad.setTieneMedicamentosControlados(rs.getBoolean("tieneMedicamentosControlados"));
                entidad.setEspecificarMedicamentos(rs.getString("especificarMedicamentos"));
                entidad.setTieneAlergias(rs.getBoolean("tieneAlergias"));
                entidad.setEspecificarAlergias(rs.getString("especificarAlergias"));
                entidad.setTieneTratamientosExternos(rs.getBoolean("tieneTratamientosExternos"));
                entidad.setMotivoTratamientosExternos(rs.getString("motivoTratamientosExternos"));
                entidad.setTipoSangre(rs.getString("tipoSangre"));
                entidad.setAspectosSaludMejora(rs.getString("aspectosSaludMejora"));
                entidad.setOtraInformacionSalud(rs.getString("otraInformacionSalud"));

                //Convivencia
                entidad.setHaVividoFuera(rs.getBoolean("haVividoFuera"));
                entidad.setTiempoVividoFuera(rs.getString("tiempoVividoFuera"));
                entidad.setDecisionResidencia(rs.getString("decisionResidencia"));
                entidad.setRazonesVivirResidencia(rs.getString("razonesVivirResidencia"));
                entidad.setAdaptacion(rs.getString("adaptacion"));
                entidad.setEstiloConvivencia(rs.getString("estiloConvivencia"));
                entidad.setSituacionesNoDeseadas(rs.getString("situacionesNoDeseadas"));

                //Compañeros y habitos
                entidad.setBuscaCompaneroExtranjero(rs.getBoolean("buscaCompaneroExtranjero"));
                entidad.setBuscaCompaneroMexicano(rs.getBoolean("buscaCompaneroMexicano"));
                entidad.setBuscaCompaneroReingreso(rs.getBoolean("buscaCompaneroReingreso"));
                entidad.setHoraDormir(rs.getString("horaDormir"));
                entidad.setToleraRuido(rs.getBoolean("toleraRuido"));
                entidad.setImportanciaOrden(rs.getString("importanciaOrden"));
                entidad.setHabitosHigiene(rs.getString("habitosHigiene"));

                //Objetos
                entidad.setTraeAuto(rs.getBoolean("traeAuto"));
                entidad.setTraeComputadora(rs.getBoolean("traeComputadora"));
                entidad.setTraeTv(rs.getBoolean("traeTv"));
                entidad.setTraeFrigobar(rs.getBoolean("traeFrigobar"));

                //Actividades y mejora
                entidad.setIniciativaActividades(rs.getString("iniciativaActividades"));
                entidad.setParticipacionGrupo(rs.getBoolean("participacionGrupo"));
                entidad.setTipoGrupo(rs.getString("tipoGrupo"));
                entidad.setActividadesRealizadasGrupo(rs.getString("actividadesRealizadasGrupo"));
                entidad.setDeseaActDeportivas(rs.getBoolean("deseaActDeportivas"));
                entidad.setDeseaActCulturales(rs.getBoolean("deseaActCulturales"));
                entidad.setDeseaActArtisticas(rs.getBoolean("deseaActArtisticas"));
                entidad.setAspectosMejoraPersona(rs.getString("aspectosMejoraPersona"));
                entidad.setOtraInformacion(rs.getString("otraInformacion"));

                return entidad;
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar RDP por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(ResidenteEntidad entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // metodo solicitud
    @Override
    public boolean insertarSolicitud(SolicitudIngresoEntidad entidad) {
        String sql = "INSERT INTO SolicitudesIngreso "
                   + "(curpResidente, tipoPago, montoPago, nombreCompanero, idCompanero) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getCurpResidente());
            ps.setString(2, entidad.getTipoPago());
            ps.setString(3, entidad.getMontoPago());

            if (entidad.getNombreCompanero() != null && !entidad.getNombreCompanero().trim().isEmpty()) {
                ps.setString(4, entidad.getNombreCompanero());
            } else {
                ps.setNull(4, java.sql.Types.VARCHAR);
            }

            if (entidad.getIdCompanero() != null && !entidad.getIdCompanero().trim().isEmpty()) {
                ps.setString(5, entidad.getIdCompanero());
            } else {
                ps.setNull(5, java.sql.Types.VARCHAR);
            }

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar la solicitud en la base de datos: " + e.getMessage());
            e.printStackTrace(); 
            return false;
        }
    }
}
