package Persistencia.Interfaces;

import Persistencia.Entidades.ResidenteEntidad;
import Persistencia.Entidades.SolicitudIngresoEntidad;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface IResidenteDAO {

    boolean insertar(ResidenteEntidad entidad);

    List<ResidenteEntidad> consultarTodos();

    ResidenteEntidad consultarPorId(String id);

    boolean actualizar(ResidenteEntidad entidad);
    
    boolean insertarSolicitud(SolicitudIngresoEntidad entidad);

}
