package Negocio.BOs;

import Negocio.DTOs.ActaDTO;
import Persistencia.DAOs.ActaDAO;
import Persistencia.Entidades.ActaEntidad;
import Persistencia.Interfaces.IActaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja la logica de negocio para las actas administrativas, se
 * encarga de comunicar la capa de presentacion con la capa de persistencia,
 * realiza las conversiones necesarias entre DTOs y entidades.
 *
 * @author cesar
 */
public class ActaBO {

    private IActaDAO actaDAO;

    /**
     * Constructor por defecto. Inicializa la instancia del DAO de actas para el
     * acceso a datos.
     */
    public ActaBO() {
        this.actaDAO = new ActaDAO();
    }

    /**
     * Registra una nueva acta administrativa en el sistema.
     *
     * * @param dto objeto ActaDTO con los datos capturados en la zpantalla.
     * @return true si el acta se registro exitosamente, false en caso
     * contrario.
     */
    public boolean registrarActa(ActaDTO dto) {
        ActaEntidad entidad = convertirAEntidad(dto);
        return actaDAO.insertarActa(entidad);
    }

    /**
     * Obtiene una lista con todas las actas administrativas registradas.
     *
     * * @return Lista de objetos ActaDTO con la informacion de las actas.
     */
    public List<ActaDTO> obtenerActas() {
        List<ActaEntidad> entidades = actaDAO.consultarTodas();
        List<ActaDTO> dtos = new ArrayList<>();

        for (ActaEntidad entidad : entidades) {
            dtos.add(convertirADTO(entidad));
        }

        return dtos;
    }

    /**
     * Elimina un acta administrativa del sistema basandose en su id
     *
     * * @param idActa El id unico del acta a eliminar.
     * @return true si el acta se elimino correctamente, false si hubo un error.
     */
    public boolean eliminarActa(int idActa) {
        return actaDAO.eliminarActa(idActa);
    }

    /**
     * Metodo auxiliar para convertir un objeto ActaDTO (transferencia de datos)
     * a un objeto ActaEntidad (base de datos).
     *
     * * @param dto El objeto ActaDTO a convertir.
     * @return El objeto ActaEntidad resultante.
     */
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

    /**
     * Metodo auxiliar para convertir un objeto ActaEntidad (base de datos) a un
     * objeto ActaDTO (transferencia de datos).
     *
     * * @param entidad El objeto ActaEntidad a convertir.
     * @return El objeto ActaDTO resultante.
     */
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

    /**
     * Sube y actualiza el archivo PDF de un acta previamente registrada (cuando
     * el residente entrega el acta ya firmada).
     *
     * * @param dto El objeto ActaDTO que contiene el arreglo de bytes del
     * archivo.
     * @return true si el documento se subio exitosamente, false en caso
     * contrario.
     */
    public boolean subirActaFirmada(ActaDTO dto) {
        ActaEntidad entidad = convertirAEntidad(dto);
        return actaDAO.subirActaFirmada(entidad);
    }

    /**
     * Obtiene una lista de actas administrativas asociadas a un residente en
     * especifico.
     *
     * * @param idAcademico El id institucional del residente.
     * @return Lista de objetos ActaDTO pertenecientes al residente indicado.
     */
    public List<ActaDTO> obtenerActasPorIdAcademico(String idAcademico) {
        List<ActaEntidad> entidades = actaDAO.consultarPorIdAcademico(idAcademico);
        List<ActaDTO> dtos = new ArrayList<>();

        for (ActaEntidad entidad : entidades) {
            dtos.add(convertirADTO(entidad));
        }

        return dtos;
    }

    /**
     * Consulta y recupera unicamente el archivo firmado (documento digital) de
     * un acta.
     *
     * * @param idActa El identificador unico del acta.
     * @return Un ActaDTO cargado con el archivo bytes del acta, o null si no se
     * encuentra.
     */
    public ActaDTO obtenerArchivoActaFirmada(int idActa) {
        ActaEntidad entidad = actaDAO.consultarArchivoFirmado(idActa);

        if (entidad == null) {
            return null;
        }

        return convertirADTO(entidad);
    }

}
