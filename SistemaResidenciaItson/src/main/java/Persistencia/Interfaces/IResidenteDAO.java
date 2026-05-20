package Persistencia.Interfaces;

import Persistencia.Entidades.DocumentoEntidad;
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

    boolean insertarDocumento(DocumentoEntidad entidad);

    java.util.List<Persistencia.Entidades.DocumentoEntidad> consultarDocumentos(String idAcademico);

    DocumentoEntidad consultarDocumento(String idAcademico, String tipoDocumento);
    
    // Para consultar la solicitud por la CURP
    Negocio.DTOs.SolicitudIngresoDTO consultarSolicitudPorCurp(String curp);

    // Para actualizar los datos de la solicitud
    boolean actualizarSolicitud(Negocio.DTOs.SolicitudIngresoDTO dto);

    // Para el cambiar estado inhabilitar/habilitar
    boolean cambiarEstadoResidente(String idAcademico, String nuevoEstado);
}
