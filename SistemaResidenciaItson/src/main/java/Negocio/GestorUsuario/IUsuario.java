package Negocio.GestorUsuario;

import Negocio.DTOs.UsuarioDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones principales para la gestion de los
 * usuarios.
 *
 * @author cesar
 */
public interface IUsuario {

    /**
     * Solicita la validacion de credenciales para el inicio de sesión en el
     * sistema.
     *
     * @param dto Objeto UsuarioDTO con las credenciales de acceso
     * @return Objeto UsuarioDTO con los datos del usuario si el login es
     * correcto, o null si falla.
     */
    public UsuarioDTO iniciarSesion(UsuarioDTO dto);

    /**
     * Solicita el registro de un nuevo usuario en la base de datos.
     *
     * @param dto Objeto UsuarioDTO con los datos capturados del nuevo usuario.
     * @return true si el registro fue exitoso, false en caso de error o datos
     * invalidos.
     */
    public boolean registrar(UsuarioDTO dto);

    /**
     * Solicita la consulta de todos los usuarios registrados en el sistema.
     *
     * @return Lista de objetos UsuarioDTO con la informacion general de los
     * usuarios.
     */
    public List<UsuarioDTO> consultarUsuarios();

    /**
     * Solicita la busqueda detallada de un usuario a partir de su
     * identificador.
     *
     * @param id El id unico del usuario a buscar.
     * @return Objeto UsuarioDTO con la informacion encontrada, o null si no
     * existe.
     */
    public UsuarioDTO consultarUsuarioPorId(int id);

    /**
     * Solicita la actualizacion de los datos de un usuario existente.
     *
     * @param dto Objeto UsuarioDTO con la informacion modificada.
     * @return true si la actualizacion se realizo con exito, false si ocurrio
     * un error.
     */
    public boolean actualizarUsuario(UsuarioDTO dto);

    /**
     * Solicita la inhabilitacion (baja logica) de un usuario para restringir su
     * acceso.
     *
     * @param id El id del usuario que sera inhabilitado.
     * @return true si el cambio de estado fue exitoso, false en caso contrario.
     */
    public boolean inhabilitarUsuario(int id);
}
