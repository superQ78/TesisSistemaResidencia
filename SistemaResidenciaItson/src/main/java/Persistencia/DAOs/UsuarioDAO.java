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

            // executeUpdate(), esto nos devuelve el numero de filas que se cambiaron en la bd
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Si es mayor a 0 se guardó con exito

        } catch (SQLException e) {
            System.err.println("Error al registrar usuario en BD: " + e.getMessage());
            return false;
        }
    }

    public List<UsuarioEntidad> buscarTodo() {
        List<UsuarioEntidad> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios"; // Trae todos los registros

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

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
}
