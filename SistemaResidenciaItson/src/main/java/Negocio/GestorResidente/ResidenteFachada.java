package Negocio.GestorResidente;

import Negocio.DTOs.ResidenteDTO;
import Negocio.DTOs.SolicitudIngresoDTO;

/**
 *
 * @author cesar
 */
public class ResidenteFachada implements IResidente {

    @Override
    public boolean registrarRDP(ResidenteDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.procesarRegistroRDP(dto);
    }

    @Override
    public ResidenteDTO consultarResidentePorId(String idAcademico) {
        ControlResidente control = new ControlResidente();
        return control.consultarResidentePorId(idAcademico);
    }

    @Override
    public java.util.List<ResidenteDTO> consultarResidentes() {
        ControlResidente control = new ControlResidente();
        return control.consultarResidentes();
    }
    
    @Override
    public boolean actualizarRDP(ResidenteDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.actualizarRDP(dto);
    }
    
    //metodo de solicitud
    @Override
    public boolean registrarSolicitud(SolicitudIngresoDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.procesarSolicitudIngreso(dto); 
    }
}
