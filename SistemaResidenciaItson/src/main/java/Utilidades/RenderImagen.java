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

    public RenderImagen() {
        // Configuramos el botón para que sea opaco y se vea el fondo
        setOpaque(true);
        setName("btnImagen"); // Nombre identificador
        
        // --- CARGA DE IMAGEN ---
        try {
            // Ruta según lo que indicaste: src/main/resources/imagenes/subirFlecha.png
            // Al compilarse, resources suele quedar en la raíz. Probamos con /imagenes/...
            java.net.URL imgUrl = getClass().getResource("/imagenes/SubirArchivo.png");
            
            if (imgUrl != null) {
                ImageIcon original = new ImageIcon(imgUrl);
                // Redimensionar a 20x20 (ajusta según tu fila)
                Image escala = original.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                icono = new ImageIcon(escala);
            } else {
                System.err.println("No se encontro la imagen en /Imagenes/SubirArchivo.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        // Limpiamos texto para que solo se vea el ícono
        setText("");
        setIcon(icono);

        // --- ESTILO VISUAL (Gris/Blanco como la foto) ---
        if (isSelected) {
            // Color cuando seleccionas la fila (opcional)
            setBackground(table.getSelectionBackground());
        } else {
            // Fondo blanco como en tu imagen de ejemplo
            setBackground(java.awt.Color.WHITE);
        }
        
        // Quitamos el borde por defecto para que se vea limpio o ponemos uno suave
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        return this;
    }
}