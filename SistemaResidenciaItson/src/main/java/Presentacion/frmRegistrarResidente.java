package Presentacion;

import Negocio.DTOs.ResidenteDTO;
import javax.swing.JFrame;

/**
 *
 * @author cesar
 */
public class frmRegistrarResidente extends javax.swing.JFrame {

    private ResidenteDTO dtoCompartido = null;
    private boolean modoEdicion = false;

    /**
     * Creates new form frmRegistrarResidente
     */
    public frmRegistrarResidente() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.modoEdicion = false;

        configurarTabla();

    }

    public frmRegistrarResidente(ResidenteDTO dtoMemoria) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

       // Si el dto ya tiene id, asume que viene de la tabla de modificar
        if (dtoMemoria != null && dtoMemoria.getIdAcademico() != null && !dtoMemoria.getIdAcademico().isEmpty()) {
            this.modoEdicion = true;
        } else {
            this.modoEdicion = false;
        }

        this.dtoCompartido = dtoMemoria;
        configurarTabla();
        cargarDocumentosSubidos();
    }

    /**
     * consultor de para modificar
     */
    public frmRegistrarResidente(String idResidenteAEditar) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // entra desde la tabla, sí esta editando
        this.modoEdicion = true;
        configurarTabla();

        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
        this.dtoCompartido = fachada.consultarResidentePorId(idResidenteAEditar);

        if (this.dtoCompartido == null) {
            this.dtoCompartido = new ResidenteDTO();
        }
        cargarDocumentosSubidos();
    }

    private void configurarTabla() {
        String[] columnas = {"Documento", "Nombre", "Estado", "Subir"};
        Object[][] datos = {
            {"INE/Identificación", "", "Pendiente", ""},
            {"INE Tutor", "", "Pendiente", ""},
            {"Acta de nacimiento", "", "Pendiente", ""},
            {"Comprobante domicilio", "", "Pendiente", ""},
            {"Comprobante pago", "", "Pendiente", ""},
            {"Foto formal", "", "Pendiente", ""},
            {"SIR Firmada", "", "Pendiente", ""},
            {"RDP Firmada", "", "Pendiente", ""}
        };

        // Creamos el modelo bloqueando la edición directa
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Bloqueamos todo. Los clics los manejaremos con un MouseListener
            }
        };

        tblRegistroResidente.setModel(modelo);
        tblRegistroResidente.setRowHeight(51);
        tblRegistroResidente.setBackground(java.awt.Color.WHITE);

        // Configuramos la imagen del botón en la columna 3
        tblRegistroResidente.getColumnModel().getColumn(3).setCellRenderer(new Utilidades.RenderImagen("/imagenes/SubirArchivo.png"));
        tblRegistroResidente.getColumnModel().getColumn(3).setPreferredWidth(50);

        // Agregamos el escuchador de clics para abrir el buscador de archivos
        tblRegistroResidente.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tblRegistroResidente.rowAtPoint(evt.getPoint());
                int columna = tblRegistroResidente.columnAtPoint(evt.getPoint());

                // Verificamos que haya dado clic específicamente en la columna del icono de Subir
                if (fila >= 0 && columna == 3) {
                    abrirSelectorDeArchivos(fila);
                }
            }
        });
    }

    /**
     * Abre un JFileChooser para que el usuario seleccione un documento y lo
     * sube a la BD.
     */
    private void abrirSelectorDeArchivos(int filaSeleccionada) {
        if (this.dtoCompartido == null || this.dtoCompartido.getIdAcademico() == null || this.dtoCompartido.getIdAcademico().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor, asegúrate de haber llenado al menos el Registro de Datos Personales (RDP) para tener un ID de residente antes de subir documentos.",
                    "Falta ID del Residente",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        javax.swing.filechooser.FileNameExtensionFilter filtro = new javax.swing.filechooser.FileNameExtensionFilter("Archivos PDF e Imágenes", "pdf", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filtro);
        fileChooser.setDialogTitle("Seleccionar Documento");

        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File archivoSeleccionado = fileChooser.getSelectedFile();

            try {
                // 3. Convertimos el archivo físico en un arreglo de bytes (byte[])
                byte[] bytesArchivo = java.nio.file.Files.readAllBytes(archivoSeleccionado.toPath());

                // Obtenemos el nombre del documento según la fila de la tabla (Ej. "INE/Identificación")
                String tipoDocumento = tblRegistroResidente.getValueAt(filaSeleccionada, 0).toString();

                // 4. Empaquetamos todo en el DTO
                Negocio.DTOs.DocumentoDTO documentoDTO = new Negocio.DTOs.DocumentoDTO();
                documentoDTO.setIdAcademico(this.dtoCompartido.getIdAcademico());
                documentoDTO.setTipoDocumento(tipoDocumento);
                documentoDTO.setNombreArchivo(archivoSeleccionado.getName());
                documentoDTO.setArchivo(bytesArchivo);

                // 5. ¡Enviamos a la base de datos a través de la Fachada!
                Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
                boolean exito = fachada.subirDocumento(documentoDTO);

                if (exito) {
                    // Actualizamos la tabla para dar feedback visual
                    tblRegistroResidente.setValueAt(archivoSeleccionado.getName(), filaSeleccionada, 1); // Columna Nombre
                    tblRegistroResidente.setValueAt("Cargado", filaSeleccionada, 2); // Columna Estado

                    javax.swing.JOptionPane.showMessageDialog(this, "Archivo subido exitosamente a la base de datos.");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar el archivo en la base de datos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }

            } catch (java.io.IOException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al leer el archivo de tu computadora.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cargarDocumentosSubidos() {
        if (this.dtoCompartido == null
                || this.dtoCompartido.getIdAcademico() == null
                || this.dtoCompartido.getIdAcademico().trim().isEmpty()) {
            return;
        }

        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
        java.util.List<Negocio.DTOs.DocumentoDTO> documentos = fachada.consultarDocumentos(this.dtoCompartido.getIdAcademico());

        for (Negocio.DTOs.DocumentoDTO doc : documentos) {
            for (int fila = 0; fila < tblRegistroResidente.getRowCount(); fila++) {
                String tipoTabla = tblRegistroResidente.getValueAt(fila, 0).toString();

                if (tipoTabla.equalsIgnoreCase(doc.getTipoDocumento())) {
                    tblRegistroResidente.setValueAt(doc.getNombreArchivo(), fila, 1);
                    tblRegistroResidente.setValueAt("Cargado", fila, 2);
                    break;
                }
            }
        }
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
        jplFrmRegisResi = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistroResidente = new javax.swing.JTable();
        btnRDP = new javax.swing.JButton();
        btnSolicitudIngreso = new javax.swing.JButton();
        lblDetallesInf = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jplFrmRegisResi.setBackground(new java.awt.Color(255, 255, 255));
        jplFrmRegisResi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTitulo.setText("Gestion Residente");
        jplFrmRegisResi.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, -1));

        tblRegistroResidente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRegistroResidente);

        jplFrmRegisResi.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 1060, 440));

        btnRDP.setBackground(new java.awt.Color(204, 255, 255));
        btnRDP.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        btnRDP.setText("Registro de Datos Personales (RDP)");
        btnRDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRDPActionPerformed(evt);
            }
        });
        jplFrmRegisResi.add(btnRDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 610, 380, 70));

        btnSolicitudIngreso.setBackground(new java.awt.Color(204, 255, 255));
        btnSolicitudIngreso.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        btnSolicitudIngreso.setText("Solicitud de ingreso");
        btnSolicitudIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudIngresoActionPerformed(evt);
            }
        });
        jplFrmRegisResi.add(btnSolicitudIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, 320, 70));

        lblDetallesInf.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblDetallesInf.setText("Las identificaciones y comprobantes deben de ser recientes y o vigentes.");
        jplFrmRegisResi.add(lblDetallesInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 730, -1, -1));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jplFrmRegisResi.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplFrmRegisResi, javax.swing.GroupLayout.DEFAULT_SIZE, 1432, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jplFrmRegisResi, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

    private void btnRDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRDPActionPerformed
        // Si no hay datos, lleva a llenar la rdp. Si hay, se lo pasamos.
        if (this.dtoCompartido == null) {
            this.dtoCompartido = new ResidenteDTO();
        }
        coordinadorVistas.mostrarRDP(this, this.dtoCompartido);

    }//GEN-LAST:event_btnRDPActionPerformed

    private void btnSolicitudIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudIngresoActionPerformed
        if (this.dtoCompartido == null) {
            this.dtoCompartido = new ResidenteDTO();
        }
        coordinadorVistas.mostrarSolicitud(this, this.dtoCompartido);
    }//GEN-LAST:event_btnSolicitudIngresoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (this.modoEdicion) {
            // si entra desde modificar
            coordinadorVistas.mostrarModificarResidente(this);
        } else {
            // si entra desde el menu adminInicio
            coordinadorVistas.regresarMenuPrincipal(this);
        }
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegistrarResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistrarResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistrarResidente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRDP;
    private javax.swing.JButton btnSolicitudIngreso;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jplFrmRegisResi;
    private javax.swing.JLabel lblDetallesInf;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblRegistroResidente;
    // End of variables declaration//GEN-END:variables
}
