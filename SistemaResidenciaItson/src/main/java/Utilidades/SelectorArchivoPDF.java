/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.io.File;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tesis
 */
public class SelectorArchivoPDF {

    public static File seleccionarPDF(JFrame ventana) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar acta firmada en PDF");

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos PDF", "pdf");
        chooser.setFileFilter(filtro);

        int seleccion = chooser.showOpenDialog(ventana);

        if (seleccion != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        File archivo = chooser.getSelectedFile();

        if (archivo == null || !archivo.getName().toLowerCase().endsWith(".pdf")) {
            return null;
        }

        return archivo;
    }

    public static byte[] convertirABytes(File archivo) throws Exception {
        return Files.readAllBytes(archivo.toPath());
    }
}
