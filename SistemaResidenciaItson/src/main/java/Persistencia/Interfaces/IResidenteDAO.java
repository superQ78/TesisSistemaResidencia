package Persistencia.Interfaces;

import Persistencia.Entidades.ResidenteEntidad;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface IResidenteDAO {

    boolean insertar(ResidenteEntidad entidad);

    List<ResidenteEntidad> consultarTodos();

    ResidenteEntidad consultarPorId(int id);

    boolean actualizar(ResidenteEntidad entidad);

}
