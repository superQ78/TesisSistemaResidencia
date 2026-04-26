/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import javax.swing.JFrame;

/**
 *
 * @author cesar
 */
public class coordinadorVistas {

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
}
