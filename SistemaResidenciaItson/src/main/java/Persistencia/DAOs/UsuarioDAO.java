package Persistencia.DAOs;

import Persistencia.Conexion.Conexion;
import Persistencia.Entidades.UsuarioEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Persistencia.Interfaces.IUsuarioDAO;

/**
 * Clase que maneja el acceso a datos para la tabla de Usuarios en la base de
 * datos.
 *
 * @author cesar
 */
public class UsuarioDAO implements IUsuarioDAO {

    /**
     * Verifica las credenciales de un usuario en la base de datos para el
     * inicio de sesion. Solo permite el acceso a usuarios que tengan el estado
     * activo.
     *
     * @param entidad Objeto UsuarioEntidad que contiene el email y la
     * contrasena a validar.
     * @return Objeto UsuarioEntidad con los datos del usuario si las
     * credenciales son correctas, o null si fallan.
     */
    @Override
    public UsuarioEntidad consultarCredenciales(UsuarioEntidad entidad) {
        String sql = "SELECT * FROM Usuarios "
                + "WHERE email = ? AND contrasena = ? AND estado = 'Activo'";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getEmail());
            ps.setString(2, entidad.getContrasena());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UsuarioEntidad usuarioFound = new UsuarioEntidad();

                usuarioFound.setId(rs.getInt("idUsuario"));
                usuarioFound.setNombre(rs.getString("nombreCompleto"));
                usuarioFound.setEmail(rs.getString("email"));
                usuarioFound.setContrasena(rs.getString("contrasena"));
                usuarioFound.setRol(rs.getString("rol"));
                usuarioFound.setTelefono(rs.getString("telefono"));
                usuarioFound.setFotoPerfil(rs.getBytes("fotoPerfil"));

                return usuarioFound;
            }

        } catch (SQLException e) {
            System.err.println("Error en DAO al consultar credenciales: " + e.getMessage());
        }

        return null;
    }

    /**
     * Inserta un nuevo registro de usuario en la base de datos.
     *
     * @param entidad Objeto UsuarioEntidad con los datos del usuario a
     * registrar.
     * @return true si la insercion fue exitosa, false en caso de error.
     */
    @Override
    public boolean insertar(UsuarioEntidad entidad) {
        String sql = "INSERT INTO Usuarios (nombreCompleto, email, contrasena, rol, telefono, fotoPerfil) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getEmail());
            ps.setString(3, entidad.getContrasena());
            ps.setString(4, entidad.getRol());
            ps.setString(5, entidad.getTelefono());
            ps.setBytes(6, entidad.getFotoPerfil());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    /**
     * Consulta y recupera todos los usuarios que se encuentran con estado
     * activo en el sistema.
     *
     * @return Lista de objetos UsuarioEntidad con la informacion de los
     * usuarios activos.
     */
    @Override
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
                usuario.setFotoPerfil(rs.getBytes("fotoPerfil"));

                listaUsuarios.add(usuario); // Lo agregamos a la lista
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar usuarios: " + e.getMessage());
        }
        return listaUsuarios;
    }

    /**
     * Busca y recupera la informacion completa de un usuario utilizando su id
     * unico.
     *
     * @param id El id numerico del usuario a consultar.
     * @return Objeto UsuarioEntidad con los datos encontrados, o null si no
     * existe.
     */
    @Override
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
                usuario.setFotoPerfil(rs.getBytes("fotoPerfil"));
                return usuario;
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Error al buscar por ID: " + e.getMessage());
        }
        return null;
    }

    /**
     * Actualiza la informacion de un usuario existente en la base de datos.
     *
     * @param entidad Objeto UsuarioEntidad con los datos modificados.
     * @return true si los cambios fueron guardados exitosamente, false en caso
     * de excepcion.
     */
    @Override
    public boolean actualizar(UsuarioEntidad entidad) {
        String sql = "UPDATE Usuarios SET nombreCompleto = ?, email = ?, contrasena = ?, rol = ?, telefono = ?, fotoPerfil = ? WHERE idUsuario = ?";
        try (java.sql.Connection con = Conexion.getConexion(); java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getEmail());
            ps.setString(3, entidad.getContrasena());
            ps.setString(4, entidad.getRol());
            ps.setString(5, entidad.getTelefono());
            ps.setBytes(6, entidad.getFotoPerfil());
            ps.setInt(7, entidad.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (java.sql.SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    /**
     * Realiza una baja logica de un usuario en el sistema, cambiando su estado
     * a inhabilitado.
     *
     * @param id El id unico del usuario a inhabilitar.
     * @return true si la actualizacion del estado fue exitosa, false de lo
     * contrario.
     */
    @Override
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
