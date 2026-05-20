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

    @Override
    public boolean subirDocumento(Negocio.DTOs.DocumentoDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.procesarSubidaDocumento(dto);
    }

    @Override
    public java.util.List<Negocio.DTOs.DocumentoDTO> consultarDocumentos(String idAcademico) {
        ControlResidente control = new ControlResidente();
        return control.consultarDocumentos(idAcademico);
    }

    @Override
    public Negocio.DTOs.DocumentoDTO consultarDocumento(String idAcademico, String tipoDocumento) {
        ControlResidente control = new ControlResidente();
        return control.consultarDocumento(idAcademico, tipoDocumento);
    }
    
    // Para consultar la solicitud por la CURP
    @Override
    public SolicitudIngresoDTO consultarSolicitudPorCurp(String curp) {
        ControlResidente control = new ControlResidente();
        return control.consultarSolicitudPorCurp(curp);
    }
    
    // Para actualizar los datos de la solicitud
    @Override
    public boolean actualizarSolicitud(Negocio.DTOs.SolicitudIngresoDTO dto) {
        ControlResidente control = new ControlResidente();
        return control.actualizarSolicitud(dto);
    }
    
     // Para el cambiar estado inhabilitar/habilitar
    @Override
    public boolean cambiarEstadoResidente(String idAcademico, String nuevoEstado) {
        ControlResidente control = new ControlResidente();
        return control.cambiarEstadoResidente(idAcademico, nuevoEstado);
    }
}
