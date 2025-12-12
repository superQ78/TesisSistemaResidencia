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
    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {

        // Texto y color por columna
        setForeground(Color.WHITE);

        if (column == 3) {           // Consultar
            setText("CONSULTAR");
            setBackground(new Color(60, 51, 255));
        } else if (column == 4) {    // Editar
            setText("EDITAR");
            setBackground(new Color(60, 141, 188));
        } else if (column == 5) {    // Inhabilitar
            setText("INHABILITAR");
            setBackground(new Color(221, 75, 57));
        }

        // Colores de selección
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        }

        return this;
    }
}
