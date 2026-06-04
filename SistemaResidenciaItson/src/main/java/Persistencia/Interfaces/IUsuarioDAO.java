package Persistencia.Interfaces;

import Persistencia.Entidades.UsuarioEntidad;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad
 * Usuario.
 *
 * @author cesar
 */
public interface IUsuarioDAO {

    /**
     * Consulta y valida las credenciales de un usuario en la base de datos.
     *
     * @param entidad Objeto UsuarioEntidad que contiene el correo y la
     * contrasena ingresados.
     * @return Objeto UsuarioEntidad cargado con la informacion completa del
     * usuario si es valido, o null si falla.
     */
    public UsuarioEntidad consultarCredenciales(UsuarioEntidad entidad);

    /**
     * Inserta un nuevo registro de usuario en la base de datos.
     *
     * @param entidad Objeto UsuarioEntidad con los datos a almacenar.
     * @return true si el usuario se guardo correctamente, false en caso de
     * error.
     */
    public boolean insertar(UsuarioEntidad entidad);

    /**
     * Consulta y recupera todos los usuarios con estado activo de la base de
     * datos.
     *
     * @return Una lista de objetos UsuarioEntidad con los registros
     * encontrados.
     */
    public List<UsuarioEntidad> buscarTodo();

    /**
     * Busca la informacion completa de un usuario utilizando su identificador
     * unico.
     *
     * @param id El id numerico del usuario a consultar.
     * @return Objeto UsuarioEntidad con todos sus atributos cargados, o null si
     * no se encuentra.
     */
    public UsuarioEntidad consultarPorId(int id);

    /**
     * Actualiza los datos de un usuario existente en la base de datos.
     *
     * @param entidad Objeto UsuarioEntidad que contiene los nuevos valores y el
     * id correspondiente.
     * @return true si los cambios se aplicaron exitosamente, false en caso
     * contrario.
     */
    public boolean actualizar(UsuarioEntidad entidad);

    /**
     * Realiza una baja logica de un usuario modificando su estado a
     * inhabilitado mediante su ID.
     *
     * @param id El id numerico del usuario que se desea dar de baja.
     * @return true si el estado del usuario se actualizo correctamente, false
     * en caso de error.
     */
    public boolean eliminar(int id);

}
