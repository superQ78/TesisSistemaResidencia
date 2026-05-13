package Persistencia.Entidades;

/**
 *
 * @author User
 */
public class SolicitudIngresoEntidad {

    private int idSolicitud;
    private String curpResidente;
    private String tipoPago;
    private String montoPago;
    private String nombreCompanero;
    private String idCompanero;

    public SolicitudIngresoEntidad(int idSolicitud, String curpResidente, String tipoPago, String montoPago, String nombreCompanero, String idCompanero) {
        this.idSolicitud = idSolicitud;
        this.curpResidente = curpResidente;
        this.tipoPago = tipoPago;
        this.montoPago = montoPago;
        this.nombreCompanero = nombreCompanero;
        this.idCompanero = idCompanero;
    }

    public SolicitudIngresoEntidad() {
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getCurpResidente() {
        return curpResidente;
    }

    public void setCurpResidente(String curpResidente) {
        this.curpResidente = curpResidente;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(String montoPago) {
        this.montoPago = montoPago;
    }

    public String getNombreCompanero() {
        return nombreCompanero;
    }

    public void setNombreCompanero(String nombreCompanero) {
        this.nombreCompanero = nombreCompanero;
    }

    public String getIdCompanero() {
        return idCompanero;
    }

    public void setIdCompanero(String idCompanero) {
        this.idCompanero = idCompanero;
    }

}
