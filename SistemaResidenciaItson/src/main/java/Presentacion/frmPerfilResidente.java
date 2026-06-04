package Presentacion;

import Negocio.DTOs.ResidenteDTO;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Valeria
 */
public class frmPerfilResidente extends javax.swing.JFrame {

    private DefaultTableModel modeloActaResidentes;
    private String idResidente;
    private ResidenteDTO residenteActual;

    /**
     * Creates new form frmPerfilResidente
     */
    public frmPerfilResidente() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(java.awt.Color.WHITE);
        configurarYcargarTabla();
    }

    /**
     * Atrapa el ID que envía frmConsultarResidente para ver los datos del
     * recidnete
     */
    public frmPerfilResidente(String idResidenteSeleccionado) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(java.awt.Color.WHITE);
        this.idResidente = idResidenteSeleccionado;

        cargarDatosGenerales();
        cargarFotoFormal();
        configurarYcargarTabla();
    }

    /**
     * Consulta la BD con el ID del residente y llena los Labels de los datos
     * con la infromacion del recidente.
     */
    private void cargarDatosGenerales() {
        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
        this.residenteActual = fachada.consultarResidentePorId(this.idResidente);

        if (this.residenteActual != null) {

            // Usa un operador ternario por si algun dato viene nulo, que ponga "N/A"
            lblNombreValor.setText(this.residenteActual.getNombreCompleto() != null ? this.residenteActual.getNombreCompleto() : "N/A");
            lblIdValor.setText(this.residenteActual.getIdAcademico() != null ? this.residenteActual.getIdAcademico() : "N/A");
            lblCelularValor.setText(this.residenteActual.getCelular() != null ? this.residenteActual.getCelular() : "N/A");
            lblCorreoValor.setText(this.residenteActual.getCorreo() != null ? this.residenteActual.getCorreo() : "N/A");
            lblImssValor.setText(this.residenteActual.getNss() != null ? this.residenteActual.getNss() : "N/A");
            lblSemestresValor.setText(this.residenteActual.getSemestre() != null ? this.residenteActual.getSemestre() : "N/A");
            lblCarreraValor.setText(this.residenteActual.getCarrera() != null ? this.residenteActual.getCarrera() : "N/A");

        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se pudo cargar la información de este residente.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void previsualizarDocumento(String tipoDocumento) {
        if (this.idResidente == null || this.idResidente.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No hay un ID de residente cargado.",
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
        Negocio.DTOs.DocumentoDTO doc = fachada.consultarDocumento(this.idResidente, tipoDocumento);

        if (doc == null || doc.getArchivo() == null) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Este documento todavía no está cargado: " + tipoDocumento,
                    "Documento no encontrado",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = doc.getNombreArchivo() != null ? doc.getNombreArchivo().toLowerCase() : "";

        try {
            if (nombre.endsWith(".jpg") || nombre.endsWith(".jpeg") || nombre.endsWith(".png")) {
                mostrarImagenEnVentana(doc);
            } else if (nombre.endsWith(".pdf")) {
                mostrarPdfTemporal(doc);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "No se puede previsualizar este tipo de archivo: " + nombre,
                        "Formato no compatible",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al previsualizar el documento:\n" + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void cargarFotoFormal() {
        if (this.idResidente == null || this.idResidente.trim().isEmpty()) {
            return;
        }

        try {
            Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();

            Negocio.DTOs.DocumentoDTO foto = fachada.consultarDocumento(
                    this.idResidente,
                    "Foto formal"
            );

            if (foto == null || foto.getArchivo() == null || foto.getArchivo().length == 0) {
                // No hace nada. Se queda la imagen de ejemplo que ya tienes en el JLabel.
                return;
            }

            javax.swing.ImageIcon iconoOriginal = new javax.swing.ImageIcon(foto.getArchivo());

            java.awt.Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                    lblFotoPerfil.getWidth(),
                    lblFotoPerfil.getHeight(),
                    java.awt.Image.SCALE_SMOOTH
            );

            lblFotoPerfil.setIcon(new javax.swing.ImageIcon(imagenEscalada));
            lblFotoPerfil.setText("");

        } catch (Exception e) {
            System.err.println("Error al cargar foto formal: " + e.getMessage());
            e.printStackTrace();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActasAdmin = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblTituloActasAdministrativas = new javax.swing.JLabel();
        lblFotoPerfil = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblNumeroImss = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        lblNombreValor = new javax.swing.JLabel();
        lblIdValor = new javax.swing.JLabel();
        lblCelularValor = new javax.swing.JLabel();
        lblCorreoValor = new javax.swing.JLabel();
        lblImssValor = new javax.swing.JLabel();
        lblSemestresValor = new javax.swing.JLabel();
        lblCarreraValor = new javax.swing.JLabel();
        btnComprobantePago = new javax.swing.JButton();
        btnComprobanteDomicilio = new javax.swing.JButton();
        btnRpd = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnIneTutor = new javax.swing.JButton();
        btnSolicitudIngreso = new javax.swing.JButton();
        btnIne = new javax.swing.JButton();
        btnActaNacimiento = new javax.swing.JButton();
        lblCarrera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblTitulo.setText("Residencias ITSON – Panel de gestión de residentes");
        lblTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblSubtitulo.setText("Perfil de recidente");
        jPanel1.add(lblSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, -1, -1));

        tblActasAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblActasAdmin);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 560, 990, 190));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 40, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoLetrasChico.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 130, 150, 170));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, 25));

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblId.setText("ID:");
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, 25));

        lblTituloActasAdministrativas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTituloActasAdministrativas.setText("Actas Administrativas");
        jPanel1.add(lblTituloActasAdministrativas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, -1, 25));

        lblFotoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perfilRecidente.png"))); // NOI18N
        jPanel1.add(lblFotoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 140, 130));

        lblCelular.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCelular.setText("Número celular:");
        jPanel1.add(lblCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, 25));

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCorreo.setText("Correo electrónico:");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 25));

        lblNumeroImss.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNumeroImss.setText("Número afiliación IMSS:");
        jPanel1.add(lblNumeroImss, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, 25));

        lblSemestre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSemestre.setText("Semetres:");
        jPanel1.add(lblSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, 25));

        lblNombreValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombreValor.setText("nombre");
        jPanel1.add(lblNombreValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, 25));

        lblIdValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIdValor.setText("id");
        jPanel1.add(lblIdValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, 25));

        lblCelularValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCelularValor.setText("celular");
        jPanel1.add(lblCelularValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, 25));

        lblCorreoValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCorreoValor.setText("correo");
        jPanel1.add(lblCorreoValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, -1, 25));

        lblImssValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblImssValor.setText("imss");
        jPanel1.add(lblImssValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, 25));

        lblSemestresValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemestresValor.setText("semestre");
        jPanel1.add(lblSemestresValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, 25));

        lblCarreraValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCarreraValor.setText("carrera");
        jPanel1.add(lblCarreraValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, 25));

        btnComprobantePago.setBackground(new java.awt.Color(204, 63, 63));
        btnComprobantePago.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnComprobantePago.setForeground(new java.awt.Color(255, 255, 255));
        btnComprobantePago.setText("Comprobante de pago");
        btnComprobantePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobantePagoActionPerformed(evt);
            }
        });
        jPanel1.add(btnComprobantePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 190, 40));

        btnComprobanteDomicilio.setBackground(new java.awt.Color(204, 204, 204));
        btnComprobanteDomicilio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnComprobanteDomicilio.setText("Comprobante de domicilio");
        btnComprobanteDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobanteDomicilioActionPerformed(evt);
            }
        });
        jPanel1.add(btnComprobanteDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 220, 40));

        btnRpd.setBackground(new java.awt.Color(204, 204, 204));
        btnRpd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnRpd.setText("Registro de Datos Personales (RDP)");
        btnRpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRpdActionPerformed(evt);
            }
        });
        jPanel1.add(btnRpd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 280, 40));

        btnHistorial.setBackground(new java.awt.Color(204, 63, 63));
        btnHistorial.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 120, 40));

        btnIneTutor.setBackground(new java.awt.Color(141, 219, 245));
        btnIneTutor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnIneTutor.setText("INE del tutor");
        btnIneTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIneTutorActionPerformed(evt);
            }
        });
        jPanel1.add(btnIneTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 130, 40));

        btnSolicitudIngreso.setBackground(new java.awt.Color(141, 219, 245));
        btnSolicitudIngreso.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSolicitudIngreso.setText("Solicitud de ingreso");
        btnSolicitudIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSolicitudIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 180, 40));

        btnIne.setBackground(new java.awt.Color(204, 204, 204));
        btnIne.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnIne.setText("INE");
        btnIne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIneActionPerformed(evt);
            }
        });
        jPanel1.add(btnIne, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 430, 110, 40));

        btnActaNacimiento.setBackground(new java.awt.Color(141, 219, 245));
        btnActaNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnActaNacimiento.setText("Acta de nacimiento");
        btnActaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActaNacimientoActionPerformed(evt);
            }
        });
        jPanel1.add(btnActaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 170, 40));

        lblCarrera.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCarrera.setText("Carrera:");
        jPanel1.add(lblCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, 25));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 165;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        frmConsultarResidente volver = new frmConsultarResidente();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnComprobantePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobantePagoActionPerformed
        previsualizarDocumento("Comprobante pago");

    }//GEN-LAST:event_btnComprobantePagoActionPerformed

    private void btnComprobanteDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobanteDomicilioActionPerformed
        previsualizarDocumento("Comprobante domicilio");
    }//GEN-LAST:event_btnComprobanteDomicilioActionPerformed

    private void btnRpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRpdActionPerformed
        previsualizarDocumento("RDP Firmada");
    }//GEN-LAST:event_btnRpdActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        coordinadorVistas.mostrarHistorialResidente(this, this.residenteActual);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnIneTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIneTutorActionPerformed
        previsualizarDocumento("INE Tutor");
    }//GEN-LAST:event_btnIneTutorActionPerformed

    private void btnSolicitudIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudIngresoActionPerformed
        previsualizarDocumento("SIR Firmada");
    }//GEN-LAST:event_btnSolicitudIngresoActionPerformed

    private void btnIneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIneActionPerformed
        previsualizarDocumento("INE/Identificación");
    }//GEN-LAST:event_btnIneActionPerformed

    private void btnActaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActaNacimientoActionPerformed
        previsualizarDocumento("Acta de nacimiento");
    }//GEN-LAST:event_btnActaNacimientoActionPerformed

    public void configurarYcargarTabla() {
        String[] titulos = {"Id Acta", "Fecha", "Estado", "Seleccionar"};

        modeloActaResidentes = new javax.swing.table.DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblActasAdmin.setModel(modeloActaResidentes);
        tblActasAdmin.setRowHeight(55);
        tblActasAdmin.setBackground(java.awt.Color.WHITE);

        String rutaBoton = "/Imagenes/cursor.png";

        tblActasAdmin.getColumnModel().getColumn(3).setCellRenderer(
                new Utilidades.RenderImagen(rutaBoton)
        );

        tblActasAdmin.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblActasAdmin.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblActasAdmin.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblActasAdmin.getColumnModel().getColumn(3).setPreferredWidth(100);

        cargarActasAdministrativas();

        tblActasAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = tblActasAdmin.rowAtPoint(evt.getPoint());
                int columna = tblActasAdmin.columnAtPoint(evt.getPoint());

                if (fila >= 0 && columna == 3) {
                    int idActa = Integer.parseInt(tblActasAdmin.getValueAt(fila, 0).toString());
                    previsualizarActaAdministrativa(idActa);
                }
            }
        });
    }

    private void mostrarImagenEnVentana(Negocio.DTOs.DocumentoDTO doc) throws Exception {
        byte[] bytes = doc.getArchivo();

        javax.swing.ImageIcon iconoOriginal = new javax.swing.ImageIcon(bytes);

        java.awt.Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                800,
                600,
                java.awt.Image.SCALE_SMOOTH
        );

        javax.swing.JLabel lblImagen = new javax.swing.JLabel(new javax.swing.ImageIcon(imagenEscalada));
        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(lblImagen);

        javax.swing.JDialog dialogo = new javax.swing.JDialog(this, "Previsualización - " + doc.getTipoDocumento(), true);
        dialogo.add(scroll);
        dialogo.setSize(900, 700);
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void mostrarPdfTemporal(Negocio.DTOs.DocumentoDTO doc) throws Exception {
        String nombre = doc.getNombreArchivo();

        java.io.File archivoTemporal = java.io.File.createTempFile("preview_", "_" + nombre);
        java.nio.file.Files.write(archivoTemporal.toPath(), doc.getArchivo());

        archivoTemporal.deleteOnExit();

        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop.getDesktop().open(archivoTemporal);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Tu sistema no permite abrir archivos PDF automáticamente.",
                    "No se pudo abrir PDF",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cargarActasAdministrativas() {
        modeloActaResidentes.setRowCount(0);

        if (this.residenteActual == null || this.residenteActual.getIdAcademico() == null) {
            return;
        }

        try {
            String idAcademico = this.residenteActual.getIdAcademico();

            Negocio.GestorActa.IActa gestorActa = new Negocio.GestorActa.ActaFachada();

            java.util.List<Negocio.DTOs.ActaDTO> listaActas
                    = gestorActa.consultarActasPorIdAcademico(idAcademico);

            if (listaActas == null || listaActas.isEmpty()) {
                return;
            }

            for (Negocio.DTOs.ActaDTO acta : listaActas) {
                Object[] fila = {
                    acta.getIdActa(),
                    acta.getFecha(),
                    acta.getEstado(),
                    ""
                };

                modeloActaResidentes.addRow(fila);
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al cargar actas administrativas:\n" + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void previsualizarActaAdministrativa(int idActa) {
        try {
            Negocio.GestorActa.IActa gestorActa = new Negocio.GestorActa.ActaFachada();

            Negocio.DTOs.ActaDTO acta = gestorActa.consultarArchivoActaFirmada(idActa);

            if (acta == null || acta.getArchivoFirmado() == null || acta.getArchivoFirmado().length == 0) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Esta acta todavía no tiene archivo firmado cargado.",
                        "Acta sin archivo",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nombreArchivo = acta.getNombreArchivoFirmado();

            if (nombreArchivo == null || nombreArchivo.trim().isEmpty()) {
                nombreArchivo = "Acta_" + idActa + ".pdf";
            }

            java.io.File archivoTemporal = java.io.File.createTempFile("acta_" + idActa + "_", "_" + nombreArchivo);
            java.nio.file.Files.write(archivoTemporal.toPath(), acta.getArchivoFirmado());

            archivoTemporal.deleteOnExit();

            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().open(archivoTemporal);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Tu sistema no permite abrir archivos PDF automáticamente.",
                        "No se pudo abrir PDF",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al previsualizar el acta:\n" + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(frmPerfilResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPerfilResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPerfilResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPerfilResidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPerfilResidente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActaNacimiento;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnComprobanteDomicilio;
    private javax.swing.JButton btnComprobantePago;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnIne;
    private javax.swing.JButton btnIneTutor;
    private javax.swing.JButton btnRpd;
    private javax.swing.JButton btnSolicitudIngreso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblCarreraValor;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCelularValor;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblCorreoValor;
    private javax.swing.JLabel lblFotoPerfil;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdValor;
    private javax.swing.JLabel lblImssValor;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreValor;
    private javax.swing.JLabel lblNumeroImss;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblSemestresValor;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloActasAdministrativas;
    private javax.swing.JTable tblActasAdmin;
    // End of variables declaration//GEN-END:variables
}
