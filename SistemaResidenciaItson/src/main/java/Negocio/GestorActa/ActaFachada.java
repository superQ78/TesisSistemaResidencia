/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.GestorActa;

import Negocio.DTOs.ActaDTO;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ActaFachada implements IActa {

    private ControlActa control;

    public ActaFachada() {
        this.control = new ControlActa();
    }

    public boolean registrarActa(ActaDTO acta) {
        return control.procesarRegistroActa(acta);
    }

    public List<ActaDTO> consultarActas() {
        return control.procesarConsultaActas();
    }

    public boolean eliminarActa(int idActa) {
        return control.procesarEliminacionActa(idActa);
    }

}
