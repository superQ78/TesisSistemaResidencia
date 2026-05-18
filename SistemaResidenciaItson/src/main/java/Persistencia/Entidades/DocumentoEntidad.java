/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Entidades;

/**
 *
 * @author cesar
 */
public class DocumentoEntidad {

    private String idAcademico;
    private int idDocumento;
    private String tipoDocumento;
    private String nombreArchivo;
    private byte[] archivo;

    public DocumentoEntidad() {
    }

    public DocumentoEntidad(String idAcademico, int idDocumento, String tipoDocumento, String nombreArchivo, byte[] archivo) {
        this.idAcademico = idAcademico;
        this.tipoDocumento = tipoDocumento;
        this.nombreArchivo = nombreArchivo;
        this.archivo = archivo;
        this.idDocumento = idDocumento;

    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "DocumentoEntidad{" + "idAcademico=" + idAcademico + ", tipoDocumento=" + tipoDocumento + ", nombreArchivo=" + nombreArchivo + ", archivo=" + archivo + '}';
    }

}
