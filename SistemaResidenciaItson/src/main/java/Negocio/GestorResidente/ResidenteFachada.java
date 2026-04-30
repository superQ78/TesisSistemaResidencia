package Negocio.GestorResidente;

import Negocio.DTOs.ResidenteDTO;

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
}
