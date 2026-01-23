package Utilidades;

import java.awt.Component;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Renderizador universal para el sistema ITSON. Gestiona iconos y estilos para
 * todas las acciones de tabla.
 */
public class RenderImagen extends JButton implements TableCellRenderer {

    private String rutaForzada = null;

    // Constructor 1: Automático (Detecta por texto de la celda)
    public RenderImagen() {
        configurarBoton();
    }

    // Constructor 2: Manual (Tú le dices qué imagen usar desde el JFrame)
    public RenderImagen(String rutaImagen) {
        this.rutaForzada = rutaImagen;
        configurarBoton();
    }

    private void configurarBoton() {
        setOpaque(true);
        setName("btnImagen");
        // Borde sutil o sin borde según prefieras
        setBorderPainted(false);
        setContentAreaFilled(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        String texto = (value != null) ? value.toString() : "";
        setText("");
        setIcon(null);

        // Lógica para definir la ruta
        String ruta = "";

        if (this.rutaForzada != null) {
            // Si usamos el constructor con ruta, usamos esa imagen siempre
            ruta = this.rutaForzada;
        } else {
            // Si no, detectamos automáticamente según el texto
            if (texto.equalsIgnoreCase("ELIMINAR") || texto.equalsIgnoreCase("X") || texto.equalsIgnoreCase("INHABILITAR")) {
                ruta = "/Imagenes/BtnInhabilitar.png";
            } else if (texto.equalsIgnoreCase("EDITAR")) {
                ruta = "/Imagenes/Btneditar.png";
            } else if (texto.equalsIgnoreCase("SELECCIONAR") || texto.equalsIgnoreCase("SELECT")) {
                ruta = "/Imagenes/cursor.png";
            } else if (texto.equalsIgnoreCase("SUBIR")) {
                ruta = "/Imagenes/SubirArchivo.png";
            }
        }

        // Cargar imagen
        if (!ruta.isEmpty()) {
            try {
                URL imgUrl = getClass().getResource(ruta);
                if (imgUrl != null) {
                    ImageIcon iconOriginal = new ImageIcon(imgUrl);
                    Image imgEscalada = iconOriginal.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
                    setIcon(new ImageIcon(imgEscalada));
                } else {
                    // Si falla la ruta, muestra texto para depurar
                    setText(texto);
                }
            } catch (Exception e) {
                System.err.println("Error cargando imagen: " + ruta);
            }
        }

        // Estilo de selección
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setOpaque(true);
        } else {
            setBackground(java.awt.Color.WHITE);
            setOpaque(true);
        }

        return this;
    }
}
