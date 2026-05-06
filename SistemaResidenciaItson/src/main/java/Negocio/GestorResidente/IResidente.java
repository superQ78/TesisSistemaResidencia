package Negocio.GestorResidente;

import Negocio.DTOs.ResidenteDTO;

/**
 *
 * @author cesar
 */
public interface IResidente {

    public boolean registrarRDP(ResidenteDTO dto);

    public ResidenteDTO consultarResidentePorId(String idAcademico);

    public java.util.List<ResidenteDTO> consultarResidentes();
    
    public boolean actualizarRDP(ResidenteDTO dto);
}
