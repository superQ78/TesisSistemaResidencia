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
}
