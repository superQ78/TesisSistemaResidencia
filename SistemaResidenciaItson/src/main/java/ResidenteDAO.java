//import Persistencia.Conexion.Conexion;
//import Persistencia.Entidades.ResidenteEntidad;
//import Persistencia.Interfaces.IResidenteDAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class ResidenteDAO implements IResidenteDAO {
//
//    @Override
//    public boolean insertar(ResidenteEntidad entidad) {
//
//        String sql = "INSERT INTO Residentes "
//                + "(nombreCompleto, sexo, fechaNacimiento, domicilio, curp, correo, carrera, semestre, nombreTutor, nombreEmergencia, estadoSalud) "
//                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try (Connection con = Conexion.getConexion();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, entidad.getNombreCompleto());
//            ps.setString(2, entidad.getSexo());
//            ps.setDate(3, java.sql.Date.valueOf(entidad.getFechaNacimiento()));
//            ps.setString(4, entidad.getDomicilio());
//            ps.setString(5, entidad.getCurp());
//            ps.setString(6, entidad.getCorreo());
//
//            ps.setString(7, entidad.getCarrera());
//            ps.setString(8, entidad.getSemestre());
//
//            ps.setString(9, entidad.getNombreTutor());
//            ps.setString(10, entidad.getNombreEmergencia());
//
//            ps.setString(11, entidad.getEstadoSalud());
//
//            return ps.executeUpdate() > 0;
//
//        } catch (SQLException e) {
//            System.err.println("Error al insertar residente: " + e.getMessage());
//            return false;
//        }
//    }
//}
