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
 * Editor de botón actualizado para usar imágenes y fondo transparente/blanco.
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
        
        // Configuración visual para que coincida con el Renderer
        this.button.setOpaque(true);
        this.button.setBackground(Color.WHITE);
        this.button.setBorderPainted(false);
        this.button.setContentAreaFilled(false);

        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                
                // Obtenemos los datos antes de imprimir o ejecutar
                Object valorId = tablaUsuarios.getValueAt(fila, 0);
                String id = (valorId != null) ? valorId.toString() : "N/A";
                String accion = tablaUsuarios.getColumnName(columna);

                System.out.println("Acción: " + accion
                        + " sobre el ID/Rol: " + id
                        + " en la fila: " + fila);
                
                // Aquí podrías agregar un switch para manejar las acciones
                // manejarAccion(accion, id);
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        // Guardamos la fila y columna actual para el ActionListener
        this.fila = row;
        this.columna = column;
        
        label = (value == null) ? "" : value.toString();
        
        // Limpiamos texto e icono antes de asignar
        button.setText("");
        button.setIcon(null);

        // Lógica de imágenes (Debe ser idéntica a tu ButtonRenderer)
        try {
            if (label.equalsIgnoreCase("ELIMINAR") || label.equalsIgnoreCase("X") || label.equalsIgnoreCase("INHABILITAR")) {
                button.setIcon(new ImageIcon(getClass().getResource("/Imagenes/borrar.png")));
            } 
            else if (label.equalsIgnoreCase("EDITAR")) {
                button.setIcon(new ImageIcon(getClass().getResource("/Imagenes/editar.png")));
            } 
            else if (label.equalsIgnoreCase("SELECCIONAR") || label.equalsIgnoreCase("SELECT") || label.equalsIgnoreCase("Subir")) {
                button.setIcon(new ImageIcon(getClass().getResource("/Imagenes/seleccionar.png")));
            }
        } catch (Exception e) {
            button.setText(label); // Fallback por si no encuentra la imagen
        }

        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }
}