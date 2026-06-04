package Negocio.GestorUsuario;

import Negocio.BOs.UsuarioBO;
import Negocio.DTOs.UsuarioDTO;
import java.util.List;

/**
 * Clase de control que gestiona las validaciones y reglas de negocio para el
 * modulo de usuarios.
 *
 * @author cesar
 */
public class ControlUsuario {

    /**
     * Valida los datos de entrada e intenta iniciar sesion en el sistema.
     *
     * @param dto Objeto UsuarioDTO que contiene el email y la contrasena a
     * verificar.
     * @return Un objeto UsuarioDTO con los datos del usuario si el login fue
     * exitoso, o null si las credenciales estan vacias o son incorrectas.
     */
    public UsuarioDTO procesarInicioSesion(UsuarioDTO dto) {
        // Validacion que no vengan vacios
        if (dto.getEmail() == null || dto.getEmail().isEmpty()
                || dto.getContrasena() == null || dto.getContrasena().isEmpty()) {
            return null;
        }

        UsuarioBO bo = new UsuarioBO();
        return bo.iniciarSesion(dto);
    }

    /**
     * Aplica reglas de formato y procesa el registro de un nuevo usuario.
     *
     * @param dto Objeto UsuarioDTO con los datos capturados del nuevo usuario.
     * @return true si los datos son validos y se registro correctamente, false
     * en caso de error o datos invalidos.
     */
    public boolean procesarRegistro(UsuarioDTO dto) {
        if (!validarFormatoUsuario(dto)) {
            return false;
        }

        UsuarioBO bo = new UsuarioBO();
        return bo.registrarUsuario(dto);
    }

    /**
     * Valida la existencia del id y el formato de los datos antes de actualizar
     * un usuario.
     *
     * @param dto Objeto UsuarioDTO con la informacion modificada.
     * @return true si paso las validaciones y se actualizo con exito, false en
     * caso de error.
     */
    public boolean actualizarUsuario(UsuarioDTO dto) {
        if (dto.getId() <= 0 || !validarFormatoUsuario(dto)) {
            return false;
        }

        UsuarioBO bo = new UsuarioBO();
        return bo.actualizarUsuario(dto);
    }

    /**
     * Solicita la lista completa de usuarios registrados en el sistema.
     *
     * @return Una lista de objetos UsuarioDTO con la informacion de cada
     * usuario.
     */
    public List<UsuarioDTO> procesarConsultaUsuarios() {
        UsuarioBO bo = new UsuarioBO();
        return bo.consultarUsuarios();
    }

    /**
     * Valida el id y consulta los detalles completos de un usuario especifico.
     *
     * @param id El id unico del usuario a buscar.
     * @return Objeto UsuarioDTO con los datos encontrados, o null si el id es
     * invalido o no existe.
     */
    public UsuarioDTO consultarUsuarioPorId(int id) {
        if (id <= 0) {
            return null;
        }
        UsuarioBO bo = new UsuarioBO();
        return bo.consultarUsuarioPorId(id);
    }

    /**
     * Valida el id y solicita la inhabilitacion de un usuario en el sistema.
     *
     * @param id El identificador del usuario que sera inhabilitado.
     * @return true si la operacion fue exitosa, false si el id es invalido o
     * fallo la base de datos.
     */
    public boolean inhabilitarUsuario(int id) {
        if (id <= 0) {
            return false;
        }
        UsuarioBO bo = new UsuarioBO();
        return bo.inhabilitarUsuario(id);
    }

    /**
     * Metodo privado que verifica si los datos obligatorios de un usuario estan
     * presentes y correctos.
     *
     * @param dto El objeto UsuarioDTO a validar.
     * @return true si el formato de todos los campos es valido, false si alguna
     * regla falla.
     */
    private boolean validarFormatoUsuario(UsuarioDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            return false;
        }
        if (dto.getEmail() == null || !dto.getEmail().contains("@")) {
            return false;
        }
        if (dto.getContrasena() == null || dto.getContrasena().trim().isEmpty()) {
            return false;
        }
        if (dto.getRol() == null || dto.getRol().equals("Selecciona un Rol")) {
            return false;
        }
        // Si pasa todos los if es valido.
        return true;
    }
}
