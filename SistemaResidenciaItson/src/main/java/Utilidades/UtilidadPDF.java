/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;


import java.awt.Desktop;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tesis
 */
public class UtilidadPDF {

    public static String seleccionarRutaPDF(JFrame ventana, String titulo, String nombreSugerido) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(titulo);
        chooser.setSelectedFile(new File(nombreSugerido));

        int seleccion = chooser.showSaveDialog(ventana);

        if (seleccion != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        File archivo = chooser.getSelectedFile();
        String ruta = archivo.getAbsolutePath();

        if (!ruta.toLowerCase().endsWith(".pdf")) {
            ruta += ".pdf";
        }

        return ruta;
    }

    public static void abrirPDF(String ruta) {
        try {
            File archivo = new File(ruta);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivo);
            }
        } catch (Exception e) {
            System.out.println("No se pudo abrir el PDF: " + e.getMessage());
        }
    }

    public static void mostrarExito(JFrame ventana, String mensaje, String ruta) {
        JOptionPane.showMessageDialog(
                ventana,
                mensaje,
                "PDF generado",
                JOptionPane.INFORMATION_MESSAGE
        );

        abrirPDF(ruta);
    }

    public static String texto(String valor) {
        return valor != null ? valor : "";
    }

    public static String fecha(java.time.LocalDate fecha) {
        return fecha != null ? fecha.toString() : "";
    }

    public static String siNo(boolean valor) {
        return valor ? "Sí" : "No";
    }

    public static String detalleSiNo(boolean valor, String detalle) {
        if (!valor) {
            return "No";
        }

        if (detalle == null || detalle.trim().isEmpty()) {
            return "Sí";
        }

        return "Sí. " + detalle;
    }
}
