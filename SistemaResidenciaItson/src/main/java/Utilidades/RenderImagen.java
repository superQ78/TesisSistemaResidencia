package Utilidades;

import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Renderizador universal para el sistema ITSON.
 * Gestiona iconos y estilos para todas las acciones de tabla.
 */
public class RenderImagen extends JButton implements TableCellRenderer {

    public RenderImagen() {
        setOpaque(true);
        setName("btnImagen");
        // Borde gris suave para dar apariencia de botón moderno
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        String texto = (value != null) ? value.toString() : "";
        setText(""); // No mostramos texto, solo imagen
        setIcon(null);

        // 1. Identificar qué imagen cargar según el texto de la celda
        String ruta = "";
        if (texto.equalsIgnoreCase("ELIMINAR") || texto.equalsIgnoreCase("X") || texto.equalsIgnoreCase("INHABILITAR")) {
            ruta = "/Imagenes/borrar.png";
        } else if (texto.equalsIgnoreCase("EDITAR")) {
            ruta = "/Imagenes/editar.png";
        } else if (texto.equalsIgnoreCase("SELECCIONAR") || texto.equalsIgnoreCase("SELECT")) {
            ruta = "/Imagenes/seleccionar.png";
        } else if (texto.equalsIgnoreCase("SUBIR")) {
            ruta = "/Imagenes/SubirArchivo.png";
        }

        // 2. Cargar y redimensionar la imagen solo si hay una ruta válida
        if (!ruta.isEmpty()) {
            try {
                URL imgUrl = getClass().getResource(ruta);
                if (imgUrl != null) {
                    ImageIcon iconOriginal = new ImageIcon(imgUrl);
                    // Redimensionamos a 32x32 para que quepa bien en la fila de 51px
                    Image imgEscalada = iconOriginal.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
                    setIcon(new ImageIcon(imgEscalada));
                }
            } catch (Exception e) {
                System.err.println("Error al cargar icono para: " + texto);
            }
        }

        // 3. Estilo de fondo (Blanco por defecto, color de selección si se marca)
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(java.awt.Color.WHITE);
        }

        return this;
    }
}