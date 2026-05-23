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
 * @author Tesis
 */
public class ActaDAO implements IActaDAO {

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

        String sql = "SELECT a.idActa, a.idAcademico, a.fecha, a.semestre, "
                + "a.lineamiento, a.descripcion, a.estado, r.nombreCompleto "
                + "FROM ActasAdministrativas a "
                + "INNER JOIN Residentes r ON a.idAcademico = r.idAcademico "
                + "ORDER BY a.idActa DESC";

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
                acta.setNombreResidente(rs.getString("nombreCompleto"));

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

    @Override
    public boolean subirActaFirmada(ActaEntidad acta) {
        String sql = "UPDATE ActasAdministrativas "
                + "SET archivoFirmado = ?, nombreArchivoFirmado = ?, estado = 'Firmada' "
                + "WHERE idAcademico = ? "
                + "ORDER BY idActa DESC "
                + "LIMIT 1";

        try (java.sql.Connection conexion = Conexion.getConexion(); java.sql.PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setBytes(1, acta.getArchivoFirmado());
            ps.setString(2, acta.getNombreArchivoFirmado());
            ps.setString(3, acta.getIdAcademico());

            int filas = ps.executeUpdate();

            System.out.println("Filas actualizadas al subir acta: " + filas);

            return filas > 0;

        } catch (Exception e) {
            System.out.println("Error al subir acta firmada: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ActaEntidad> consultarPorIdAcademico(String idAcademico) {
        List<ActaEntidad> lista = new ArrayList<>();

        String sql = "SELECT idActa, idAcademico, fecha, semestre, lineamiento, descripcion, estado "
                + "FROM ActasAdministrativas "
                + "WHERE idAcademico = ? "
                + "ORDER BY idActa DESC";

        try (Connection conexion = Conexion.getConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, idAcademico);

            try (ResultSet rs = ps.executeQuery()) {
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
            }

        } catch (Exception e) {
            System.out.println("Error al consultar actas por residente: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ActaEntidad consultarArchivoFirmado(int idActa) {
        String sql = "SELECT idActa, idAcademico, archivoFirmado, nombreArchivoFirmado "
                + "FROM ActasAdministrativas "
                + "WHERE idActa = ?";

        try (Connection conexion = Conexion.getConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idActa);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ActaEntidad acta = new ActaEntidad();

                    acta.setIdActa(rs.getInt("idActa"));
                    acta.setIdAcademico(rs.getString("idAcademico"));
                    acta.setArchivoFirmado(rs.getBytes("archivoFirmado"));
                    acta.setNombreArchivoFirmado(rs.getString("nombreArchivoFirmado"));

                    return acta;
                }
            }

        } catch (Exception e) {
            System.out.println("Error al consultar archivo firmado del acta: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
