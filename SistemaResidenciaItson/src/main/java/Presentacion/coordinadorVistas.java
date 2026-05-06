package Presentacion;

import javax.swing.JFrame;

/**
 *
 * @author cesar
 */
public class coordinadorVistas {

    public static String rolLogueado = "";

    /**
     * Regresa al menú correcto dependiendo de quién inició sesión
     */
    public static void regresarMenuPrincipal(JFrame ventanaActual) {
        if ("Administrador".equals(rolLogueado)) {
            mostrarAdminInicio(ventanaActual);

        } else if ("Trabajador".equals(rolLogueado)) {
            mostrarTrabajadorInicio(ventanaActual);

        } else {
            // Por si ocurre un error y se pierde la sesión, lo mandamos al login
            mostrarInicioSesion(ventanaActual);
        }
    }

    /**
     * Abre el menu principal del Administrador
     */
    public static void mostrarAdminInicio(JFrame ventanaActual) {
        frmAdminInicio admin = new frmAdminInicio();
        admin.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre la tabla para consultar a los usuarios
     */
    public static void mostrarConsultarUsuarios(JFrame ventanaActual) {
        frmConsultarUsuarios consulta = new frmConsultarUsuarios();
        consulta.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre la pantalla de Login
     */
    public static void mostrarInicioSesion(JFrame ventanaActual) {
        frmLogin login = new frmLogin();
        login.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Cierra la ventana anterior
     */
    private static void cerrarVentanaAnterior(JFrame ventana) {
        if (ventana != null) {
            ventana.dispose();
        }
    }

    /**
     * Abre la pantalla de Crear Usuario en edicion
     */
    public static void mostrarModificarUsuario(JFrame ventanaActual, int idUsuario) {
        frmCrearUsuario modificar = new frmCrearUsuario(idUsuario);
        modificar.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre la pantalla para ver la informacion detallada del usuario
     */
    public static void mostrarInformacionUsuario(JFrame ventanaActual, int idUsuario) {
        frmInformacionUsuario info = new frmInformacionUsuario(idUsuario);
        info.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre el menu principal del Trabajador
     */
    public static void mostrarTrabajadorInicio(JFrame ventanaActual) {
        frmTrabajadorInicio trabajador = new frmTrabajadorInicio();
        trabajador.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre la pantalla principal del Registro de Datos Personales (RDP)
     */
    public static void mostrarRDP(JFrame ventanaActual) {
        frmRDP rdp = new frmRDP();
        rdp.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre la pantalla del menú de Registrar Residente
     */
    public static void mostrarRegistrarResidente(JFrame ventanaActual) {
        frmRegistrarResidente registrar = new frmRegistrarResidente();
        registrar.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre la tabla para consultar a los residentes (si ya la tienes creada)
     */
    public static void mostrarConsultarResidentes(JFrame ventanaActual) {
        // frmConsultarResidentes consulta = new frmConsultarResidentes();
        // consulta.setVisible(true);
        // cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre la tabla de Modificar Residentes
     */
    public static void mostrarModificarResidente(JFrame ventanaActual) {
        frmModificarResidente tablaModificar = new frmModificarResidente();
        tablaModificar.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }

    /**
     * Abre el formulario RDP en modo EDICIÓN precargando al residente
     */
    public static void mostrarModificarRDP(JFrame ventanaActual, String idResidente) {
        frmRDP formularioEdicion = new frmRDP(idResidente);
        formularioEdicion.setVisible(true);
        cerrarVentanaAnterior(ventanaActual);
    }
}
