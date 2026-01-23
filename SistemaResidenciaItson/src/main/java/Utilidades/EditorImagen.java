package Utilidades;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 * Editor universal para el sistema ITSON.
 * Maneja los eventos de clic y mantiene la estética del Renderer.
 */
public class EditorImagen extends DefaultCellEditor {

    private final JButton button;
    private String textoAccion;
    private JTable tabla;
    private int filaActual;

    public EditorImagen(JCheckBox checkBox, JTable tabla) {
        super(checkBox);
        this.tabla = tabla; // Guardamos la referencia de la tabla
        button = new JButton();
        button.setOpaque(true);
        button.setBackground(java.awt.Color.WHITE);
        button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                
                // Lógica de acción basada en el texto del botón y la fila
                Object idResidente = tabla.getValueAt(filaActual, 0); // Obtenemos el ID de la primera columna
                System.out.println("Ejecutando: " + textoAccion + " para el ID: " + idResidente);
                
                // Aquí puedes agregar un switch para disparar tus funciones reales
                ejecutarAccion(textoAccion, idResidente);
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        
        this.filaActual = row; // Guardamos la fila donde se hizo clic
        textoAccion = (value == null) ? "" : value.toString();
        
        button.setText(""); 
        button.setIcon(null);

        // --- LÓGICA DE ICONO DINÁMICO (Igual al RenderImagen) ---
        String ruta = "";
        if (textoAccion.equalsIgnoreCase("ELIMINAR") || textoAccion.equalsIgnoreCase("X") || textoAccion.equalsIgnoreCase("INHABILITAR")) {
            ruta = "/Imagenes/borrar.png";
        } else if (textoAccion.equalsIgnoreCase("EDITAR")) {
            ruta = "/Imagenes/editar.png";
        } else if (textoAccion.equalsIgnoreCase("SELECCIONAR") || textoAccion.equalsIgnoreCase("SELECT")) {
            ruta = "/Imagenes/seleccionar.png";
        } else if (textoAccion.equalsIgnoreCase("SUBIR")) {
            ruta = "/Imagenes/SubirArchivo.png";
        }

        if (!ruta.isEmpty()) {
            try {
                URL imgUrl = getClass().getResource(ruta);
                if (imgUrl != null) {
                    ImageIcon original = new ImageIcon(imgUrl);
                    Image escala = original.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
                    button.setIcon(new ImageIcon(escala));
                }
            } catch (Exception e) {
                button.setText(textoAccion);
            }
        }

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return textoAccion;
    }

    // Método opcional para subir
    private void ejecutarAccion(String accion, Object id) {
        if (accion.equalsIgnoreCase("SUBIR")) {
            // Lógica para JFileChooser
        } else if (accion.equalsIgnoreCase("SELECCIONAR")) {
            // Lógica para cargar datos en formulario
        }
    }
}