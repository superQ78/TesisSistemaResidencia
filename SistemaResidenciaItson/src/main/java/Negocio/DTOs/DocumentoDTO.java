package Negocio.DTOs;

/**
 *
 * @author cesar
 */
public class DocumentoDTO {

    private String idAcademico;
    private String tipoDocumento;
    private String nombreArchivo;
    private byte[] archivo;
    private String fechaSubida;

    public DocumentoDTO(String idAcademico, String tipoDocumento, String nombreArchivo, byte[] archivo, String fechaSubida) {
        this.idAcademico = idAcademico;
        this.tipoDocumento = tipoDocumento;
        this.nombreArchivo = nombreArchivo;
        this.archivo = archivo;
        this.fechaSubida = fechaSubida;
    }

    public DocumentoDTO() {
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

    public String getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(String fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    @Override
    public String toString() {
        return "DocumentoDTO{" + "idAcademico=" + idAcademico + ", tipoDocumento=" + tipoDocumento + ", nombreArchivo=" + nombreArchivo + ", archivo=" + archivo + '}';
    }

}
