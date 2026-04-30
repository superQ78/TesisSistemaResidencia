
package Persistencia.Interfaces;

import Persistencia.Entidades.UsuarioEntidad;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface IUsuarioDAO {

    public UsuarioEntidad consultarCredenciales(UsuarioEntidad entidad);

    public boolean insertar(UsuarioEntidad entidad);

    public List<UsuarioEntidad> buscarTodo();

    public UsuarioEntidad consultarPorId(int id);

    public boolean actualizar(UsuarioEntidad entidad);

    public boolean eliminar(int id);

}
