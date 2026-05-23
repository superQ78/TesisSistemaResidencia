package Presentacion;

import Utilidades.RenderImagen;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesar
 */
public class frmModificarResidente extends javax.swing.JFrame {

    private javax.swing.table.TableRowSorter<DefaultTableModel> sorter;
    /**
     * Creates new form frmModificarResidente
     */
    public frmModificarResidente() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Llama al metodo para configurar la tabla
        configurarTabla();
        
        // buscador dinamico, detecta cambios en el txt en tiempo real
        txtBuscar.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrarTabla(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrarTabla(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrarTabla(); }

            private void filtrarTabla() {
                String texto = txtBuscar.getText().trim();
                if (texto.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + texto));
                }
            }
        });
    }

    private void configurarTabla() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3 || column == 4;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre residente");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Editar");
        modelo.addColumn("Acción"); // columna para guarda el estado

        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
        java.util.List<Negocio.DTOs.ResidenteDTO> listaResidentes = fachada.consultarResidentes();

        if (listaResidentes != null) {

            // ordena a los activos arriba y los inhabilitados abajo
            listaResidentes.sort((r1, r2) -> {
                String e1 = r1.getEstado() != null ? r1.getEstado() : "Activo";
                String e2 = r2.getEstado() != null ? r2.getEstado() : "Activo";
                return e1.compareTo(e2);
            });

            // llena la tabla
            for (Negocio.DTOs.ResidenteDTO res : listaResidentes) {
                String nacionalidad = res.getLugarResidencia() != null ? res.getLugarResidencia() : "N/A";
                String estadoReal = res.getEstado() != null ? res.getEstado() : "Activo";

                Object[] fila = {
                    res.getIdAcademico(),
                    res.getNombreCompleto(),
                    nacionalidad,
                    "",
                    estadoReal
                };
                modelo.addRow(fila);
            }
        }

        tblModResisdentes.setModel(modelo);
        
        // filtro a la tabla
        sorter = new javax.swing.table.TableRowSorter<>(modelo);
        tblModResisdentes.setRowSorter(sorter);
        
        tblModResisdentes.setRowHeight(40);

        // boton editar
        tblModResisdentes.getColumnModel().getColumn(3).setCellRenderer(
                new Utilidades.RenderImagen("/imagenes/BtnEditar.png")
        );

        // boton de estado, lee el estado y pone el boton correcto
        tblModResisdentes.getColumnModel().getColumn(4).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                javax.swing.JLabel etiqueta = new javax.swing.JLabel();
                etiqueta.setOpaque(true);
                etiqueta.setBackground(java.awt.Color.WHITE);
                etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                String estadoCelda = (value != null) ? value.toString() : "Activo";
                String rutaImg = estadoCelda.equals("Activo") ? "/imagenes/BtnInhabilitar.png" : "/imagenes/BtnHabilitar.png";

                try {
                    java.net.URL url = getClass().getResource(rutaImg);
                    if (url != null) {
                        etiqueta.setIcon(new javax.swing.ImageIcon(url));
                    } else {
                        etiqueta.setText(estadoCelda.equals("Activo") ? "Inhabilitar" : "Habilitar");
                    }
                } catch (Exception e) {
                    etiqueta.setText("Error");
                }
                return etiqueta;
            }
        });

        tblModResisdentes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int filaVisual = tblModResisdentes.rowAtPoint(evt.getPoint());
                int columna = tblModResisdentes.columnAtPoint(evt.getPoint());

                if (filaVisual >= 0 && (columna == 3 || columna == 4)) {
                  
                    int filaReal = tblModResisdentes.convertRowIndexToModel(filaVisual);
                    
                    String idSeleccionado = tblModResisdentes.getModel().getValueAt(filaReal, 0).toString();
                    String nombreSeleccionado = tblModResisdentes.getModel().getValueAt(filaReal, 1).toString();

                    if (columna == 3) {
                        // clic en editar
                        coordinadorVistas.mostrarRegistrarResidenteEdicion(frmModificarResidente.this, idSeleccionado);

                    } else if (columna == 4) {
                        // clic en inhabilitar / habilitar
                        String estadoActual = tblModResisdentes.getModel().getValueAt(filaReal, 4).toString();
                        String accion = estadoActual.equals("Activo") ? "inhabilitar" : "habilitar";
                        String nuevoEstado = estadoActual.equals("Activo") ? "Inhabilitado" : "Activo";

                        int respuesta = javax.swing.JOptionPane.showConfirmDialog(null,
                                "¿Estás seguro de " + accion + " al residente: " + nombreSeleccionado + "?",
                                "Confirmar Acción",
                                javax.swing.JOptionPane.YES_NO_OPTION,
                                javax.swing.JOptionPane.WARNING_MESSAGE);

                        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {

                            // llama al metodo
                            boolean exito = fachada.cambiarEstadoResidente(idSeleccionado, nuevoEstado);

                            if (exito) {
                                javax.swing.JOptionPane.showMessageDialog(null, "El residente ha sido " + nuevoEstado.toLowerCase() + ".");
                                configurarTabla(); // para ordenar automaticamente el estado
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(null, "Error al cambiar el estado.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTituloGestionResi = new javax.swing.JLabel();
        lblSubtituloSoliIngre = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModResisdentes = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTituloGestionResi.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTituloGestionResi.setText("Residencias ITSON – Panel de Gestión de residentes");
        jPanel1.add(lblTituloGestionResi, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        lblSubtituloSoliIngre.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblSubtituloSoliIngre.setText("Modificar residente");
        jPanel1.add(lblSubtituloSoliIngre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 740, 40));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jPanel1.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoLetrasChico.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, -1, -1));

        tblModResisdentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblModResisdentes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 1020, 430));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        coordinadorVistas.regresarMenuPrincipal(this);
    }//GEN-LAST:event_btnAtrasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmModificarResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmModificarResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmModificarResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmModificarResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmModificarResidente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblSubtituloSoliIngre;
    private javax.swing.JLabel lblTituloGestionResi;
    private javax.swing.JTable tblModResisdentes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
