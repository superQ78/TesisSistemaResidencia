package Negocio.BOs;

import Negocio.DTOs.UsuarioDTO;
import Persistencia.DAOs.UsuarioDAO;
import Persistencia.Entidades.UsuarioEntidad;
import Persistencia.Interfaces.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *Transformamos datos en esta clase de dto a entity y visebersa
 * @author cesar
 */
public class UsuarioBO {

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

    public boolean inhabilitarUsuario(int id) {
        IUsuarioDAO dao = new UsuarioDAO();
        return dao.eliminar(id);
    }
}
