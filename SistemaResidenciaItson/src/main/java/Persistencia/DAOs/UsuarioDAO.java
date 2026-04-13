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

/**
 *
 * @author cesar
 */
public class UsuarioDAO {
    public UsuarioEntidad consultarCredenciales(UsuarioEntidad entidad) {
        String sql = "SELECT * FROM Usuarios WHERE email = ? AND contrasena = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
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
        return null; //returna nada si en caso de que no encuentre nada o que haya un error
    }
}