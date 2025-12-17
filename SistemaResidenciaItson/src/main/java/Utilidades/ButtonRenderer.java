package Utilidades;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 *
 * @author User
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        // 1. Obtener el texto que viene del modelo de la tabla
        String texto = (value != null) ? value.toString() : "";
        setText(texto);

        // 2. Configurar colores según el texto del botón
        if (texto.equalsIgnoreCase("ELIMINAR") || texto.equalsIgnoreCase("INHABILITAR") || texto.equalsIgnoreCase("X")) {
            setBackground(new java.awt.Color(221, 75, 57)); // Rojo
            setForeground(java.awt.Color.WHITE);
        } else if (texto.equalsIgnoreCase("EDITAR")) {
            setBackground(new java.awt.Color(0, 166, 90)); // Verde
            setForeground(java.awt.Color.WHITE);
        } else if (texto.equalsIgnoreCase("CONSULTAR") || texto.equalsIgnoreCase("SELECT")) {
            setBackground(new java.awt.Color(60, 141, 188)); // Azul
            setForeground(java.awt.Color.WHITE);
        } else {
            setBackground(javax.swing.UIManager.getColor("Button.background"));
            setForeground(java.awt.Color.BLACK);
        }

        return this;
    }
}
