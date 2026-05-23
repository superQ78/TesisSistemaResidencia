/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.BOs;

import Negocio.DTOs.ActaDTO;
import Persistencia.DAOs.ActaDAO;
import Persistencia.Entidades.ActaEntidad;
import Persistencia.Interfaces.IActaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ActaBO {

    private IActaDAO actaDAO;

    public ActaBO() {
        this.actaDAO = new ActaDAO();
    }

    public boolean registrarActa(ActaDTO dto) {
        ActaEntidad entidad = convertirAEntidad(dto);
        return actaDAO.insertarActa(entidad);
    }

    public List<ActaDTO> obtenerActas() {
        List<ActaEntidad> entidades = actaDAO.consultarTodas();
        List<ActaDTO> dtos = new ArrayList<>();

        for (ActaEntidad entidad : entidades) {
            dtos.add(convertirADTO(entidad));
        }

        return dtos;
    }

    public boolean eliminarActa(int idActa) {
        return actaDAO.eliminarActa(idActa);
    }

    private ActaEntidad convertirAEntidad(ActaDTO dto) {
        ActaEntidad entidad = new ActaEntidad();

        entidad.setIdActa(dto.getIdActa());
        entidad.setIdAcademico(dto.getIdAcademico());
        entidad.setFecha(dto.getFecha());
        entidad.setSemestre(dto.getSemestre());
        entidad.setLineamiento(dto.getLineamiento());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setEstado(dto.getEstado());
        entidad.setArchivoFirmado(dto.getArchivoFirmado());
        entidad.setNombreArchivoFirmado(dto.getNombreArchivoFirmado());

        return entidad;
    }

    private ActaDTO convertirADTO(ActaEntidad entidad) {
        ActaDTO dto = new ActaDTO();

        dto.setIdActa(entidad.getIdActa());
        dto.setIdAcademico(entidad.getIdAcademico());
        dto.setFecha(entidad.getFecha());
        dto.setSemestre(entidad.getSemestre());
        dto.setLineamiento(entidad.getLineamiento());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setEstado(entidad.getEstado());
        dto.setNombreResidente(entidad.getNombreResidente());
        dto.setArchivoFirmado(entidad.getArchivoFirmado());
        dto.setNombreArchivoFirmado(entidad.getNombreArchivoFirmado());

        return dto;
    }

    public boolean subirActaFirmada(ActaDTO dto) {
        ActaEntidad entidad = convertirAEntidad(dto);
        return actaDAO.subirActaFirmada(entidad);
    }

    public List<ActaDTO> obtenerActasPorIdAcademico(String idAcademico) {
        List<ActaEntidad> entidades = actaDAO.consultarPorIdAcademico(idAcademico);
        List<ActaDTO> dtos = new ArrayList<>();

        for (ActaEntidad entidad : entidades) {
            dtos.add(convertirADTO(entidad));
        }

        return dtos;
    }

    public ActaDTO obtenerArchivoActaFirmada(int idActa) {
        ActaEntidad entidad = actaDAO.consultarArchivoFirmado(idActa);

        if (entidad == null) {
            return null;
        }

        return convertirADTO(entidad);
    }

}
