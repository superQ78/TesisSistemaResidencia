/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio.DTOs;

import java.time.LocalDate;

/**
 *
 * @author cesar
 */
public class ActaDTO {

    private int idActa;
    private String idAcademico;
    private LocalDate fecha;
    private String semestre;
    private String lineamiento;
    private String descripcion;
    private String estado;
    private byte[] archivoFirmado;
    private String nombreResidente;
    private String nombreArchivoFirmado;

    public byte[] getArchivoFirmado() {
        return archivoFirmado;
    }

    public void setArchivoFirmado(byte[] archivoFirmado) {
        this.archivoFirmado = archivoFirmado;
    }

    public String getNombreArchivoFirmado() {
        return nombreArchivoFirmado;
    }

    public void setNombreArchivoFirmado(String nombreArchivoFirmado) {
        this.nombreArchivoFirmado = nombreArchivoFirmado;
    }

    public String getNombreResidente() {
        return nombreResidente;
    }

    public void setNombreResidente(String nombreResidente) {
        this.nombreResidente = nombreResidente;
    }

    public ActaDTO() {
    }

    public int getIdActa() {
        return idActa;
    }

    public void setIdActa(int idActa) {
        this.idActa = idActa;
    }

    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getLineamiento() {
        return lineamiento;
    }

    public void setLineamiento(String lineamiento) {
        this.lineamiento = lineamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
