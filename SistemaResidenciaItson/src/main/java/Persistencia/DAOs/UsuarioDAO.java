/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAOs;

import Persistencia.Entidades.UsuarioEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class UsuarioDAO {

    public UsuarioEntidad consultarCredenciales(UsuarioEntidad entidad) {
        String sql = "SELECT * FROM Usuarios WHERE email = ? AND contrasena = ?";
        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getEmail());
            ps.setString(2, entidad.getContrasena());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UsuarioEntidad usuarioFound = new UsuarioEntidad();
                usuarioFound.setId(rs.getInt("idUsuario"));
                usuarioFound.setNombre(rs.getString("nombreCompleto"));
                usuarioFound.setRol(rs.getString("rol"));
                return usuarioFound;
            }
        } catch (SQLException e) {
            System.err.println("Error en DAO: " + e.getMessage());
        }
        //returna nada si en caso de que no encuentre nada o que haya un error
        return null;
    }

    // Metodo para agregar un nuevo usuario al sistema
    public boolean insertar(UsuarioEntidad entidad) {
        String sql = "INSERT INTO Usuarios (nombreCompleto, email, contrasena, rol, telefono) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getEmail());
            ps.setString(3, entidad.getContrasena());
            ps.setString(4, entidad.getRol());
            ps.setString(5, entidad.getTelefono());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; 

        } catch (SQLException e) {
            System.err.println("Error al registrar usuario en BD: " + e.getMessage());
            return false;
        }
    }

    public List<UsuarioEntidad> buscarTodo() {
        List<UsuarioEntidad> listaUsuarios = new ArrayList<>();

        String sql = "SELECT * FROM Usuarios WHERE estado = 'Activo'";

        try (java.sql.Connection con = Conexion.getConexion(); java.sql.PreparedStatement ps = con.prepareStatement(sql); java.sql.ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UsuarioEntidad usuario = new UsuarioEntidad();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombreCompleto"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRol(rs.getString("rol"));
                usuario.setTelefono(rs.getString("telefono"));

                listaUsuarios.add(usuario); // Lo agregamos a la lista
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar usuarios: " + e.getMessage());
        }
        return listaUsuarios;
    }

    public UsuarioEntidad consultarPorId(int id) {
        String sql = "SELECT * FROM Usuarios WHERE idUsuario = ?";
        try (java.sql.Connection con = Conexion.getConexion(); java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioEntidad usuario = new UsuarioEntidad();
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombreCompleto"));
                usuario.setEmail(rs.getString("email"));
                usuario.setRol(rs.getString("rol"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setContrasena(rs.getString("contrasena"));
                return usuario;
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Error al buscar por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizar(UsuarioEntidad entidad) {
        String sql = "UPDATE Usuarios SET nombreCompleto = ?, email = ?, contrasena = ?, rol = ?, telefono = ? WHERE idUsuario = ?";
        try (java.sql.Connection con = Conexion.getConexion(); java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getEmail());
            ps.setString(3, entidad.getContrasena());
            ps.setString(4, entidad.getRol());
            ps.setString(5, entidad.getTelefono());
            ps.setInt(6, entidad.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (java.sql.SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "UPDATE Usuarios SET estado = 'Inhabilitado' WHERE idUsuario = ?";

        try (java.sql.Connection con = Conexion.getConexion(); java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (java.sql.SQLException e) {
            System.err.println("Error al inhabilitar usuario: " + e.getMessage());
            return false;
        }

    }
}
