package Negocio.GestorResidente;

import Negocio.DTOs.ResidenteDTO;
import Negocio.DTOs.SolicitudIngresoDTO;

/**
 *
 * @author cesar
 */
public interface IResidente {

    public boolean registrarRDP(ResidenteDTO dto);

    public ResidenteDTO consultarResidentePorId(String idAcademico);

    public java.util.List<ResidenteDTO> consultarResidentes();

    public boolean actualizarRDP(ResidenteDTO dto);

    boolean registrarSolicitud(SolicitudIngresoDTO dto);

    public boolean subirDocumento(Negocio.DTOs.DocumentoDTO dto);

    public java.util.List<Negocio.DTOs.DocumentoDTO> consultarDocumentos(String idAcademico);

    public Negocio.DTOs.DocumentoDTO consultarDocumento(String idAcademico, String tipoDocumento);

    // Para consultar la solicitud por la CURP
    public Negocio.DTOs.SolicitudIngresoDTO consultarSolicitudPorCurp(String curp);

    // Para actualizar los datos de la solicitud
    public boolean actualizarSolicitud(SolicitudIngresoDTO dto);

    // Para el cambiar estado inhabilitar/habilitar
    public boolean cambiarEstadoResidente(String idAcademico, String nuevoEstado);
}
