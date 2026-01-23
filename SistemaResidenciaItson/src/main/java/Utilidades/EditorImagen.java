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
 * Editor universal para el sistema ITSON. Maneja los eventos de clic y mantiene
 * la estética del Renderer.
 */
public class EditorImagen extends DefaultCellEditor {

    private final JButton button;
    private String textoAccion;
    private JTable tabla;
    private int filaActual;
    private String rutaForzada = null;

    // Constructor Estándar (Requiere la tabla para obtener datos al hacer clic)
    public EditorImagen(JCheckBox checkBox, JTable tabla) {
        super(checkBox);
        this.tabla = tabla;
        button = new JButton();
        configurarBoton();
    }

    // Constructor Opcional: Si quieres forzar una imagen visualmente en el editor también
    public EditorImagen(JCheckBox checkBox, JTable tabla, String rutaImagen) {
        super(checkBox);
        this.tabla = tabla;
        this.rutaForzada = rutaImagen;
        button = new JButton();
        configurarBoton();
    }

    private void configurarBoton() {
        button.setOpaque(true);
        button.setBackground(java.awt.Color.WHITE);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); // Detiene la edición de la celda

                // --- AQUÍ OCURRE LA MAGIA DEL CLIC ---
                Object idObj = tabla.getValueAt(filaActual, 0); // Asumimos que ID está en columna 0
                String id = (idObj != null) ? idObj.toString() : "N/A";

                System.out.println("Clic en acción: " + textoAccion + " | ID Fila: " + id);

                // Aquí deberías llamar a tu controlador o método de negocio
                ejecutarLogica(textoAccion, id);
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        this.filaActual = row;
        textoAccion = (value == null) ? "" : value.toString();

        button.setText("");
        button.setIcon(null);

        // Lógica de imagen (Igual que en Renderer)
        String ruta = "";

        if (this.rutaForzada != null) {
            ruta = this.rutaForzada;
        } else {
            if (textoAccion.equalsIgnoreCase("ELIMINAR") || textoAccion.equalsIgnoreCase("X") || textoAccion.equalsIgnoreCase("INHABILITAR")) {
                ruta = "/Imagenes/borrar.png";
            } else if (textoAccion.equalsIgnoreCase("EDITAR")) {
                ruta = "/Imagenes/editar.png";
            } else if (textoAccion.equalsIgnoreCase("SUBIR")) {
                ruta = "/Imagenes/SubirArchivo.png";
            }
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
            }
        }

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return textoAccion;
    }

    // Método centralizado para manejar acciones
    private void ejecutarLogica(String accion, String id) {
        if (accion.equalsIgnoreCase("SUBIR")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Subir archivo para ID: " + id);
            // JFileChooser...
        } else if (accion.equalsIgnoreCase("EDITAR")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Abriendo edición para: " + id);
            // Abrir ventana editar...
        } else if (accion.equalsIgnoreCase("ELIMINAR") || accion.equalsIgnoreCase("INHABILITAR")) {
            int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "¿Seguro que deseas inhabilitar?");
            if (confirm == 0) {
                System.out.println("Inhabilitando " + id);
            }
        }
    }
}
