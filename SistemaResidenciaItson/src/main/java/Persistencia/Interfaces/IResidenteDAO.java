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
}
