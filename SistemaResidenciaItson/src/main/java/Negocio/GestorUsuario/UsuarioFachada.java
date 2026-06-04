package Negocio.GestorUsuario;

import Negocio.DTOs.UsuarioDTO;
import java.util.List;

/**
 * Clase que implementa el patron de diseño Fachada para el modulo de usuarios.
 *
 * @author cesar
 */
public class UsuarioFachada implements IUsuario {

    /**
     * Envia la peticion al control para procesar el inicio de sesion de un
     * usuario.
     *
     * @param dto Objeto UsuarioDTO con las credenciales de acceso capturadas.
     * @return Objeto UsuarioDTO con los datos del usuario si el login es
     * exitoso, o null en caso contrario.
     */
    @Override
    public UsuarioDTO iniciarSesion(UsuarioDTO dto) {
        ControlUsuario control = new ControlUsuario();
        return control.procesarInicioSesion(dto);
    }

    /**
     * Envia la peticion al control para validar y registrar un nuevo usuario en
     * el sistema.
     *
     * @param dto Objeto UsuarioDTO con la informacion del usuario a registrar.
     * @return true si el registro fue procesado y guardado exitosamente, false
     * si fallo.
     */
    @Override
    public boolean registrar(UsuarioDTO dto) {
        ControlUsuario control = new ControlUsuario();
        return control.procesarRegistro(dto);
    }

    /**
     * Envia la peticion al control para solicitar la lista completa de usuarios
     * registrados.
     *
     * @return Una lista de objetos UsuarioDTO con la informacion de los
     * usuarios.
     */
    @Override
    public List<UsuarioDTO> consultarUsuarios() {
        ControlUsuario control = new ControlUsuario();
        return control.procesarConsultaUsuarios();
    }

    /**
     * Envia la peticion al control para buscar toda la informacion de un
     * usuario especifico.
     *
     * @param id El id unico del usuario.
     * @return Objeto UsuarioDTO con los datos encontrados, o null si no existe.
     */
    @Override
    public UsuarioDTO consultarUsuarioPorId(int id) {
        ControlUsuario control = new ControlUsuario();
        return control.consultarUsuarioPorId(id);
    }

    /**
     * Envia la peticion al control para validar y guardar las modificaciones
     * hechas a un usuario.
     *
     * @param dto Objeto UsuarioDTO con los datos actualizados.
     * @return true si la actualizacion procedio sin errores, false en caso
     * contrario.
     */
    @Override
    public boolean actualizarUsuario(UsuarioDTO dto) {
        ControlUsuario control = new ControlUsuario();
        return control.actualizarUsuario(dto);
    }

    /**
     * Envia la peticion al control para cambiar el estado de un usuario a
     * inhabilitado.
     *
     * @param id El id del usuario a inhabilitar.
     * @return true si el usuario fue inhabilitado correctamente, false si
     * fallo.
     */
    @Override
    public boolean inhabilitarUsuario(int id) {
        ControlUsuario control = new ControlUsuario();
        return control.inhabilitarUsuario(id);
    }
}
