/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.BOs;

import Negocio.DTOs.UsuarioDTO;
import Persistencia.DAOs.UsuarioDAO;
import Persistencia.Entidades.UsuarioEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class UsuarioBO {

    public UsuarioDTO iniciarSesion(UsuarioDTO dto) {
        //Validar que no vengan vacios
        if (dto.getEmail().isEmpty() || dto.getContrasena().isEmpty()) {
            return null;
        }

        //Convertir DTO a Entidad 
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(dto.getContrasena());

        // Llamar al DAO
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioEntidad resultado = dao.consultarCredenciales(entidad);

        // Si el DAO responde, convertimos de vuelta a DTO para la pantalla
        if (resultado != null) {
            UsuarioDTO loginExitoso = new UsuarioDTO();
            loginExitoso.setNombre(resultado.getNombre());
            loginExitoso.setRol(resultado.getRol());
            return loginExitoso;
        }

        return null;
    }

    // Metodo para regisrar un usuario en el sistema
    public boolean registrarUsuario(UsuarioDTO dto) {
        // Aqui es donde aplicaremos una de las reglas negocio que estamos agregando al sistema
        if (dto.getNombre().isEmpty() || dto.getEmail().isEmpty() || dto.getContrasena().isEmpty() || dto.getRol().isEmpty()) {
            return false;
        }

        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setNombre(dto.getNombre());
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(dto.getContrasena());
        entidad.setRol(dto.getRol());
        entidad.setTelefono(dto.getTelefono());

        UsuarioDAO dao = new UsuarioDAO();
        return dao.insertar(entidad);
    }

    public List<UsuarioDTO> consultarUsuarios() {
        UsuarioDAO dao = new UsuarioDAO();
        List<UsuarioEntidad> listaEntidades = dao.buscarTodo();

        List<UsuarioDTO> listaDTOs = new ArrayList<>();

        for (UsuarioEntidad entidad : listaEntidades) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(entidad.getId());
            dto.setNombre(entidad.getNombre());
            dto.setEmail(entidad.getEmail());
            dto.setRol(entidad.getRol());
            dto.setTelefono(entidad.getTelefono());

            listaDTOs.add(dto);
        }

        return listaDTOs; // Paso 9
    }

    public UsuarioDTO consultarUsuarioPorId(int id) {
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioEntidad entidad = dao.consultarPorId(id);

        if (entidad != null) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(entidad.getId());
            dto.setNombre(entidad.getNombre());
            dto.setEmail(entidad.getEmail());
            dto.setRol(entidad.getRol());
            dto.setTelefono(entidad.getTelefono());
            dto.setContrasena(entidad.getContrasena());
            return dto;
        }
        return null;
    }

    public boolean actualizarUsuario(UsuarioDTO dto) {
        // Validar que no falten datos
        if (dto.getNombre().isEmpty() || dto.getEmail().isEmpty() || dto.getContrasena().isEmpty()) {
            return false;
        }

        // Convertir de DTO a Entidad
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setId(dto.getId()); 
        entidad.setNombre(dto.getNombre());
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(dto.getContrasena());
        entidad.setRol(dto.getRol());
        entidad.setTelefono(dto.getTelefono());

        // Mandar al DAO 
        UsuarioDAO dao = new UsuarioDAO();
        return dao.actualizar(entidad);
    }

    public boolean inhabilitarUsuario(int id) {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.eliminar(id);
    }

    private void validarFormatoCredenciales() {
    }

    private UsuarioEntidad crearUsuarioEntidad(UsuarioDTO dto) {

        return new UsuarioEntidad();
    }
}
