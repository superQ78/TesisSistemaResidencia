package Utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class ButtonEditor extends DefaultCellEditor {

    private final JButton button;
    private String label;
    private boolean isPushed;
    private final JTable tablaUsuarios;
    private int fila;
    private int columna;

    public ButtonEditor(JCheckBox checkBox, JTable tabla) {
        super(checkBox);
        this.tablaUsuarios = tabla;
        this.button = new JButton();
        this.button.setOpaque(true);

        // Acción al hacer clic
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();

                String rol = tablaUsuarios.getModel().getValueAt(fila, 0).toString();
                String accion = tablaUsuarios.getColumnName(columna);

                System.out.println("Acción: " + accion
                        + " sobre el Rol: " + rol
                        + " en la fila: " + fila);

                // Aquí llamar un método del formulario:
                // ((frmConsultarUsuarios) tablaUsuarios.getTopLevelAncestor())
                //        .ejecutarAccion(accion, fila);
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        label = (value == null) ? "" : value.toString();
        button.setText(label);

        // Aplicar los mismos colores que el renderer
        if (label.equalsIgnoreCase("ELIMINAR") || label.equalsIgnoreCase("INHABILITAR")) {
            button.setBackground(new java.awt.Color(221, 75, 57));
            button.setForeground(java.awt.Color.WHITE);
        } else if (label.equalsIgnoreCase("EDITAR")) {
            button.setBackground(new java.awt.Color(0, 166, 90));
            button.setForeground(java.awt.Color.WHITE);
        } else {
            button.setBackground(new java.awt.Color(60, 141, 188));
            button.setForeground(java.awt.Color.WHITE);
        }

        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }
}
