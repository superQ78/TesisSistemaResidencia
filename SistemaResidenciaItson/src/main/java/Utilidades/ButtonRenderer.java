package Utilidades;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
        // Quitamos el borde para que la imagen luzca mejor
        setBorderPainted(false); 
        setContentAreaFilled(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        String texto = (value != null) ? value.toString() : "";
        
        // Limpiamos texto e icono antes de configurar
        setText(""); 
        setIcon(null);
        setBackground(Color.WHITE);

        try {
            if (texto.equalsIgnoreCase("ELIMINAR") || texto.equalsIgnoreCase("X")) {
                // Ajusta el nombre al de tu archivo real (ejemplo: icono_equis.png)
                setIcon(new ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); 
            } 
            else if (texto.equalsIgnoreCase("EDITAR")) {
                setIcon(new ImageIcon(getClass().getResource("/Imagenes/editar.png")));
            } 
            else if (texto.equalsIgnoreCase("SELECCIONAR") || texto.equalsIgnoreCase("SELECT")) {
                // Puedes usar un icono de check o una lupa
                setIcon(new ImageIcon(getClass().getResource("/Imagenes/seleccionar.png"))); 
            }
        } catch (Exception e) {
            // Si falla la carga de la imagen, ponemos el texto para no dejar vacío
            setText(texto);
            System.err.println("No se pudo cargar la imagen para: " + texto);
        }

        return this;
    }
}