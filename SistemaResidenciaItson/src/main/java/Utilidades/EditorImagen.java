/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
/**
 *
 * @author cesar
 */
public class EditorImagen extends DefaultCellEditor {

    private final JButton button;
    private ImageIcon icono;
    private String textoAccion; // Para guardar qué acción es (subir, etc)

    public EditorImagen(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        
        // --- CARGA DE IMAGEN (Igual que en el Render) ---
        try {
            java.net.URL imgUrl = getClass().getResource("/Imagenes/SubirArchvo.png");
            if (imgUrl != null) {
                ImageIcon original = new ImageIcon(imgUrl);
                Image escala = original.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
                icono = new ImageIcon(escala);
            }
        } catch (Exception e) { }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); // Detiene la edición
                // AQUÍ PONES LA LÓGICA DE CLIC
                System.out.println("Clic en el boton de imagen: " + textoAccion);
                // Ejemplo: abrirJFileChooser();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        
        textoAccion = (value == null) ? "" : value.toString();
        
        button.setText(""); // Sin texto
        button.setIcon(icono);
        button.setBackground(java.awt.Color.WHITE);
        button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));

        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return textoAccion; // Devuelve el valor original al modelo
    }
}
