package Negocio.BOs;

import Negocio.DTOs.UsuarioDTO;
import Persistencia.DAOs.UsuarioDAO;
import Persistencia.Entidades.UsuarioEntidad;
import Persistencia.Interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la capa de negocio encargada de gestionar la logica relacionada con
 * los usuarios
 *
 * @author cesar
 */
public class UsuarioBO {

    /**
     * Valida las credenciales de un usuario para permitir el acceso al sistema.
     *
     * @param dto Objeto UsuarioDTO que contiene unicamente el correo y la
     * contrasena ingresados.
     * @return Un nuevo UsuarioDTO con el nombre y rol del usuario si el login
     * es exitoso, o null si las credenciales son incorrectas.
     */
    public UsuarioDTO iniciarSesion(UsuarioDTO dto) {
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(dto.getContrasena());

        IUsuarioDAO dao = new UsuarioDAO();
        UsuarioEntidad resultado = dao.consultarCredenciales(entidad);

        if (resultado != null) {
            UsuarioDTO loginExitoso = new UsuarioDTO();
            loginExitoso.setNombre(resultado.getNombre());
            loginExitoso.setRol(resultado.getRol());
            return loginExitoso;
        }
        return null;
    }

    /**
     * Procesa el registro de un nuevo usuario en la base de datos.
     *
     * @param dto Objeto UsuarioDTO con los datos capturados del nuevo usuario.
     * @return true si el registro fue insertado con exito, false en caso
     * contrario.
     */
    public boolean registrarUsuario(UsuarioDTO dto) {
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setNombre(dto.getNombre());
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(dto.getContrasena());
        entidad.setRol(dto.getRol());
        entidad.setTelefono(dto.getTelefono());
        entidad.setFotoPerfil(dto.getFotoPerfil());

        IUsuarioDAO dao = new UsuarioDAO();
        return dao.insertar(entidad);
    }

    /**
     * Consulta y recupera la lista completa de usuarios registrados en el
     * sistema.
     *
     * @return Lista de objetos UsuarioDTO con la informacion de todos los
     * usuarios.
     */
    public List<UsuarioDTO> consultarUsuarios() {
        IUsuarioDAO dao = new UsuarioDAO();
        List<UsuarioEntidad> listaEntidades = dao.buscarTodo();
        List<UsuarioDTO> listaDTOs = new ArrayList<>();

        for (UsuarioEntidad entidad : listaEntidades) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(entidad.getId());
            dto.setNombre(entidad.getNombre());
            dto.setEmail(entidad.getEmail());
            dto.setRol(entidad.getRol());
            dto.setTelefono(entidad.getTelefono());
            dto.setFotoPerfil(entidad.getFotoPerfil());
            listaDTOs.add(dto);
        }

        return listaDTOs;
    }

    /**
     * Busca la informacion completa de un usuario en especifico mediante su id.
     *
     * @param id El id unico del usuario a consultar.
     * @return Objeto UsuarioDTO con los datos del usuario, o null si no se
     * encuentra en el sistema.
     */
    public UsuarioDTO consultarUsuarioPorId(int id) {
        IUsuarioDAO dao = new UsuarioDAO();
        UsuarioEntidad entidad = dao.consultarPorId(id);

        if (entidad != null) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(entidad.getId());
            dto.setNombre(entidad.getNombre());
            dto.setEmail(entidad.getEmail());
            dto.setRol(entidad.getRol());
            dto.setTelefono(entidad.getTelefono());
            dto.setContrasena(entidad.getContrasena());
            dto.setFotoPerfil(entidad.getFotoPerfil());
            return dto;
        }
        return null;
    }

    /**
     * Actualiza la informacion de un usuario existente en el sistema.
     *
     * @param dto Objeto UsuarioDTO que contiene el ID original y los nuevos
     * datos modificados.
     * @return true si la actualizacion en la base de datos fue exitosa, false
     * de lo contrario.
     */
    public boolean actualizarUsuario(UsuarioDTO dto) {
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(dto.getContrasena());
        entidad.setRol(dto.getRol());
        entidad.setTelefono(dto.getTelefono());
        entidad.setFotoPerfil(dto.getFotoPerfil());

        IUsuarioDAO dao = new UsuarioDAO();
        return dao.actualizar(entidad);
    }

    /**
     * Inhabilita o da de baja logica a un usuario para impedirle el acceso
     * futuro al sistema.
     *
     * @param id El id numerico del usuario que sera inhabilitado.
     * @return true si la operacion fue procesada correctamente, false en caso
     * de error.
     */
    public boolean inhabilitarUsuario(int id) {
        IUsuarioDAO dao = new UsuarioDAO();
        return dao.eliminar(id); // Llamada al DAO que realiza el cambio de estado o la eliminacion 
    }
}
