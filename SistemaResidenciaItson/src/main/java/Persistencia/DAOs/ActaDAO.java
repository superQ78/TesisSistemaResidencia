/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAOs;

import Persistencia.Conexion.Conexion;
import Persistencia.Entidades.ActaEntidad;
import Persistencia.Interfaces.IActaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ActaDAO implements IActaDAO{
    
    @Override
    public boolean insertarActa(ActaEntidad acta) {
        String sql = "INSERT INTO ActasAdministrativas "
                + "(idAcademico, fecha, semestre, lineamiento, descripcion, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.getConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, acta.getIdAcademico());
            ps.setDate(2, java.sql.Date.valueOf(acta.getFecha()));
            ps.setString(3, acta.getSemestre());
            ps.setString(4, acta.getLineamiento());
            ps.setString(5, acta.getDescripcion());
            ps.setString(6, acta.getEstado());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar acta: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ActaEntidad> consultarTodas() {
        List<ActaEntidad> lista = new ArrayList<>();

        String sql = "SELECT idActa, idAcademico, fecha, semestre, lineamiento, descripcion, estado "
                + "FROM ActasAdministrativas";

        try (Connection conexion = Conexion.getConexion(); PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ActaEntidad acta = new ActaEntidad();

                acta.setIdActa(rs.getInt("idActa"));
                acta.setIdAcademico(rs.getString("idAcademico"));
                acta.setFecha(rs.getDate("fecha").toLocalDate());
                acta.setSemestre(rs.getString("semestre"));
                acta.setLineamiento(rs.getString("lineamiento"));
                acta.setDescripcion(rs.getString("descripcion"));
                acta.setEstado(rs.getString("estado"));

                lista.add(acta);
            }

        } catch (Exception e) {
            System.out.println("Error al consultar actas: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public boolean eliminarActa(int idActa) {
        String sql = "DELETE FROM ActasAdministrativas WHERE idActa = ?";

        try (Connection conexion = Conexion.getConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idActa);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error al eliminar acta: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
