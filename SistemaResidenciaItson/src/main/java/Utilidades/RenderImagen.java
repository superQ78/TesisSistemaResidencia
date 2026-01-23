/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author cesar
 */
public class RenderImagen extends JButton implements TableCellRenderer {

    private ImageIcon icono;

    // Modificamos el constructor para recibir la ruta de la imagen
    public RenderImagen(String rutaImagen) {
        setOpaque(true);
        setName("btnImagen");

        try {
            // Usamos la ruta que nos pasan por parámetro
            java.net.URL imgUrl = getClass().getResource(rutaImagen);

            if (imgUrl != null) {
                ImageIcon original = new ImageIcon(imgUrl);
                // Ajusta el tamaño (30x30 suele ser bueno para iconos de tabla, 90 es muy grande)
                Image escala = original.getImage().getScaledInstance(33, 33, Image.SCALE_SMOOTH);
                icono = new ImageIcon(escala);
            } else {
                System.err.println("No se encontró la imagen: " + rutaImagen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        setIcon(icono);

        // Estética: Fondo blanco o selección
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(java.awt.Color.WHITE);
        }

        // Borde suave o sin borde
        setBorderPainted(false);

        return this;
    }
}
