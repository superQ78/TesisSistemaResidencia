package Presentacion;

import Negocio.DTOs.ResidenteDTO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author cesar
 */
public class frmSolicitudIngreso extends javax.swing.JFrame {

    pnlDatosSolicitante panelSolicitante = new pnlDatosSolicitante();
    pnlDatosTutor panelTutor = new pnlDatosTutor();
    pnlContactoEmergencia panelEmergencia = new pnlContactoEmergencia();
    pnlFormaPago panelPago = new pnlFormaPago();
    pnlCompanero panelCompanero = new pnlCompanero();

    // dto compartido, para rellenar datos
    private ResidenteDTO dtoCompartido = null;

    /**
     * Creates new form frmSolicitudIngreso
     */
    public frmSolicitudIngreso() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        tabSolicitud.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        configurarTabs();
        configurarScrolls();
        configurarEstiloGeneral();
        configurarAutocompletadoEmergencia();

        tabSolicitud.revalidate();
        tabSolicitud.repaint();
    }

    /**
     * Constructor para recibir datos compartidos desde el RDP (o empezar uno
     * nuevo)
     */
    public frmSolicitudIngreso(ResidenteDTO dtoMemoria) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        tabSolicitud.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        configurarTabs();
        configurarScrolls();
        configurarEstiloGeneral();
        configurarAutocompletadoEmergencia();

        tabSolicitud.revalidate();
        tabSolicitud.repaint();

        // guarda los daots
        this.dtoCompartido = dtoMemoria;

        // Si trae datos, aparecen en los paneles
        if (this.dtoCompartido != null) {
            panelSolicitante.cargarDatosSolicitante(this.dtoCompartido);
            panelTutor.cargarDatosTutor(this.dtoCompartido);
            panelEmergencia.cargarDatosEmergencia(this.dtoCompartido);
        }
    }

    /**
     * Configura el diseño visual del componente JTabbedPane. Se personaliza la
     * apariencia de las pestañas, incluyendo: Colores de fondo, cambio de tipo
     * de letra, centrado de texto, eliminación de bordes separación mediante
     * líneas entre pestañas.
     */
    private void configurarTabs() {
        tabSolicitud.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {

            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, java.awt.FontMetrics metrics) {
                return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + 25;
            }

            @Override
            protected void paintTabBackground(java.awt.Graphics g, int tabPlacement,
                    int tabIndex, int x, int y, int w, int h, boolean isSelected) {

                if (isSelected) {
                    g.setColor(new java.awt.Color(0, 102, 204));
                } else {
                    g.setColor(new java.awt.Color(180, 210, 240));
                }

                g.fillRect(x, y, w, h);
            }

            @Override
            protected void paintText(java.awt.Graphics g, int tabPlacement,
                    java.awt.Font font, java.awt.FontMetrics metrics, int tabIndex,
                    String title, java.awt.Rectangle textRect, boolean isSelected) {

                java.awt.Font fuente = isSelected
                        ? new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
                        : new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);

                g.setFont(fuente);

                g.setColor(isSelected ? java.awt.Color.WHITE : java.awt.Color.BLACK);

                java.awt.FontMetrics fm = g.getFontMetrics(fuente);

                // centrar el texto
                int textWidth = fm.stringWidth(title);
                int textX = textRect.x + (textRect.width - textWidth) / 2;
                int textY = textRect.y + ((textRect.height - fm.getHeight()) / 2) + fm.getAscent();

                g.drawString(title, textX, textY);
            }

            @Override
            protected void paintTabBorder(java.awt.Graphics g, int tabPlacement,
                    int tabIndex, int x, int y, int w, int h, boolean isSelected) {

                // línea blanca centrada, para separar los tabs
                g.setColor(java.awt.Color.WHITE);
                g.drawLine(x + w - 1, y + 4, x + w - 1, y + h - 4);
            }

            @Override
            protected void paintContentBorder(java.awt.Graphics g, int tabPlacement,
                    int selectedIndex) {
                // elimina borde negro 
            }

            @Override
            protected void paintFocusIndicator(java.awt.Graphics g, int tabPlacement,
                    java.awt.Rectangle[] rects, int tabIndex,
                    java.awt.Rectangle iconRect, java.awt.Rectangle textRect,
                    boolean isSelected) {
                // nada
            }
        });

        tabSolicitud.setOpaque(true);
        tabSolicitud.setBackground(new java.awt.Color(241, 241, 241));
    }

    /**
     * Crea y configura un JScrollPane personalizado para un panel.
     * Configuraciones aplicadas: mas velocidad de desplazamiento, se oculta la
     * barra de scroll y eliminan los bordes
     *
     * @param panel panel dentro del scroll
     * @return JScrollPane configurado con el panel
     */
    private JScrollPane crearScroll(JPanel panel) {
        JScrollPane scroll = new JScrollPane(panel);
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        scroll.getVerticalScrollBar().setPreferredSize(new java.awt.Dimension(0, 0));
        scroll.setBorder(null);
        return scroll;
    }

    /**
     * Agrega cada uno de los paneles al JTabbedPane dentro de un JScrollPane.
     * Esto permite que cada sección del formulario sea desplazable,
     * especialmente util cuando el contenido es extenso. Se eliminan las
     * pestañas existentes para evitar duplicaciones
     */
    private void configurarScrolls() {
        tabSolicitud.removeAll(); // importante

        tabSolicitud.addTab("Solicitante", crearScroll(panelSolicitante));
        tabSolicitud.addTab("Tutor", crearScroll(panelTutor));
        tabSolicitud.addTab("Emergencia", crearScroll(panelEmergencia));
        tabSolicitud.addTab("Pago", crearScroll(panelPago));
        tabSolicitud.addTab("Compañero", crearScroll(panelCompanero));
    }

    /**
     * Configura el estilo general de la ventana y los paneles internos. color
     * de fondo neutro para la ventana principal y un fondo blanco para cada
     * panel
     */
    private void configurarEstiloGeneral() {
        getContentPane().setBackground(new java.awt.Color(240, 242, 245));

        panelSolicitante.setBackground(java.awt.Color.WHITE);
        panelTutor.setBackground(java.awt.Color.WHITE);
        panelEmergencia.setBackground(java.awt.Color.WHITE);
        panelPago.setBackground(java.awt.Color.WHITE);
        panelCompanero.setBackground(java.awt.Color.WHITE);
    }

    /**
     * Si el usaurio escoje el mismo parentesco que el del tutor, copia todos
     * los datos automaticamente.
     */
    private void configurarAutocompletadoEmergencia() {
        panelEmergencia.getCmbParentescoEmergencia().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                // ve que parentesco se elige en emergencia
                String parentescoElegido = panelEmergencia.getCmbParentescoEmergencia().getSelectedItem().toString();

                // pide al panel del tutor que de los datos actuales
                Negocio.DTOs.ResidenteDTO dtoTemporal = new Negocio.DTOs.ResidenteDTO();
                panelTutor.empaquetarDatosTutor(dtoTemporal);

                // si se escojio el mismo parentesco, los datos se copian
                if (!parentescoElegido.toLowerCase().contains("selecciona")
                        && parentescoElegido.equals(dtoTemporal.getParentescoTutor())) {
                    panelEmergencia.autocompletarConTutor(dtoTemporal);
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

        pnlBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnVaciarCampos = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubTitulo = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        pnlFondoTabs = new javax.swing.JPanel();
        tabSolicitud = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBotones.setBackground(new java.awt.Color(255, 255, 255));

        btnGuardar.setBackground(new java.awt.Color(51, 204, 0));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVaciarCampos.setBackground(new java.awt.Color(255, 51, 51));
        btnVaciarCampos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVaciarCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnVaciarCampos.setText("Vaciar campos");
        btnVaciarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarCamposActionPerformed(evt);
            }
        });

        btnImprimir.setBackground(new java.awt.Color(0, 153, 255));
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(369, Short.MAX_VALUE)
                .addComponent(btnVaciarCampos)
                .addGap(62, 62, 62)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVaciarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBotones, java.awt.BorderLayout.PAGE_END);

        pnlTitulo.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTitulo.setText("Residencias ITSON – Panel de Gestión de residentes");
        pnlTitulo.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        lblSubTitulo.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblSubTitulo.setText("Solicitud de ingreso");
        pnlTitulo.add(lblSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 250, -1));

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        pnlTitulo.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, 40));

        getContentPane().add(pnlTitulo, java.awt.BorderLayout.PAGE_START);

        pnlFondoTabs.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoTabs.setLayout(new java.awt.BorderLayout());

        tabSolicitud.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 100, 20, 100));
        tabSolicitud.setToolTipText("");
        pnlFondoTabs.add(tabSolicitud, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlFondoTabs, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // se guarda todo lo que se hayan ingresado en la pantalla actual
        if (this.dtoCompartido == null) {
            this.dtoCompartido = new Negocio.DTOs.ResidenteDTO();
        }
        panelSolicitante.empaquetarDatosPersonales(this.dtoCompartido);
        panelTutor.empaquetarDatosTutor(this.dtoCompartido);
        panelEmergencia.empaquetarDatosEmergencia(this.dtoCompartido);

        coordinadorVistas.mostrarRegistrarResidenteConDatos(this, this.dtoCompartido);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        boolean solValido = panelSolicitante.validarCampos();
        boolean tutValido = panelTutor.validarCampos();
        boolean emeValido = panelEmergencia.validarCampos();
        boolean pagoValido = panelPago.validarCampos();
        boolean companeroValido = panelCompanero.validarCampos();

        if (!solValido || !tutValido || !emeValido || !pagoValido || !companeroValido) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Por favor, asegúrate de llenar todos los campos obligatorios.",
                    "Campos incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (this.dtoCompartido == null) {
            this.dtoCompartido = new Negocio.DTOs.ResidenteDTO();
        }

        // se guarda lo ingresado en los paneles que comparte con rdp
        panelSolicitante.empaquetarDatosPersonales(this.dtoCompartido);
        panelTutor.empaquetarDatosTutor(this.dtoCompartido);
        panelEmergencia.empaquetarDatosEmergencia(this.dtoCompartido);

        if (this.dtoCompartido.getCurp() == null || this.dtoCompartido.getCurp().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "La CURP del solicitante es obligatoria para poder guardar la solicitud.",
                    "Faltan datos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // crear la solicitud
        Negocio.DTOs.SolicitudIngresoDTO dtoSolicitud = new Negocio.DTOs.SolicitudIngresoDTO();

        dtoSolicitud.setCurpResidente(this.dtoCompartido.getCurp());

        panelPago.empaquetarDatosPago(dtoSolicitud);
        panelCompanero.empaquetarDatosCompanero(dtoSolicitud);

        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
        boolean exito = fachada.registrarSolicitud(dtoSolicitud);

        if (exito) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Solicitud de ingreso guardada correctamente en la Base de Datos.",
                    "Éxito",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

            coordinadorVistas.mostrarRegistrarResidenteConDatos(this, this.dtoCompartido);

        } else {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al guardar la solicitud en BD. Revisa tu conexión o los datos ingresados.",
                    "Error de guardado",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVaciarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarCamposActionPerformed

        // pregunta se desea borrar todos los datos
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que deseas vaciar todos los campos? Se perderá la información no guardada.",
                "Confirmar limpieza",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE);

        // si dice si
        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {

            limpiarComponentes(panelSolicitante);
            limpiarComponentes(panelTutor);
            limpiarComponentes(panelEmergencia);
            limpiarComponentes(panelPago);
            limpiarComponentes(panelCompanero);
            this.dtoCompartido = new Negocio.DTOs.ResidenteDTO();
            //   this.idResidenteEdicion = null; // si esta editanto, lo convierte en nuevo

            javax.swing.JOptionPane.showMessageDialog(this, "Se borraron todos los datos ingresados.");
        }
    }//GEN-LAST:event_btnVaciarCamposActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        boolean solValido = panelSolicitante.validarCampos();
        boolean tutValido = panelTutor.validarCampos();
        boolean emeValido = panelEmergencia.validarCampos();
        boolean pagoValido = panelPago.validarCampos();
        boolean companeroValido = panelCompanero.validarCampos();

        if (!solValido || !tutValido || !emeValido || !pagoValido || !companeroValido) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Primero llena todos los campos obligatorios antes de generar el PDF.",
                    "Campos incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (this.dtoCompartido == null) {
            this.dtoCompartido = new ResidenteDTO();
        }

        panelSolicitante.empaquetarDatosPersonales(this.dtoCompartido);
        panelTutor.empaquetarDatosTutor(this.dtoCompartido);
        panelEmergencia.empaquetarDatosEmergencia(this.dtoCompartido);

        Negocio.DTOs.SolicitudIngresoDTO dtoSolicitud = new Negocio.DTOs.SolicitudIngresoDTO();
        dtoSolicitud.setCurpResidente(this.dtoCompartido.getCurp());

        panelPago.empaquetarDatosPago(dtoSolicitud);
        panelCompanero.empaquetarDatosCompanero(dtoSolicitud);

        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setDialogTitle("Guardar Solicitud de Ingreso en PDF");
        chooser.setSelectedFile(new java.io.File("SIR_" + texto(this.dtoCompartido.getIdAcademico()) + ".pdf"));

        int seleccion = chooser.showSaveDialog(this);

        if (seleccion != javax.swing.JFileChooser.APPROVE_OPTION) {
            return;
        }

        java.io.File archivo = chooser.getSelectedFile();
        String ruta = archivo.getAbsolutePath();

        if (!ruta.toLowerCase().endsWith(".pdf")) {
            ruta += ".pdf";
        }

        try {
            Utilidades.GeneradorPDFSolicitudIngreso.generarSolicitudIngreso(
                    ruta,
                    this.dtoCompartido,
                    dtoSolicitud
            );

            javax.swing.JOptionPane.showMessageDialog(this,
                    "PDF generado correctamente.\nAhora puedes abrirlo, imprimirlo, firmarlo y después subirlo como SIR Firmada.",
                    "PDF generado",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

            abrirArchivoPDF(ruta);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al generar el PDF:\n" + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    private String texto(String valor) {
        return valor != null ? valor : "";
    }

    private void abrirArchivoPDF(String ruta) {
        try {
            java.io.File archivo = new java.io.File(ruta);

            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop.getDesktop().open(archivo);
            }
        } catch (Exception e) {
            System.out.println("No se pudo abrir automáticamente el PDF: " + e.getMessage());
        }
    }

    /**
     * Metodo recursivo que busca todas las cajas de texto, combos y fechas
     * dentro de un panel y los vacia.
     */
    private void limpiarComponentes(java.awt.Container contenedor) {
        for (java.awt.Component comp : contenedor.getComponents()) {

            if (comp instanceof javax.swing.JTextField) {
                ((javax.swing.JTextField) comp).setText("");
            } else if (comp instanceof javax.swing.JTextArea) {
                ((javax.swing.JTextArea) comp).setText("");
            } else if (comp instanceof javax.swing.JComboBox) {
                if (((javax.swing.JComboBox<?>) comp).getItemCount() > 0) {
                    ((javax.swing.JComboBox<?>) comp).setSelectedIndex(0); // Vuelve a seleccionar
                }
            } else if (comp instanceof javax.swing.JCheckBox || comp instanceof javax.swing.JRadioButton) {
                javax.swing.AbstractButton boton = (javax.swing.AbstractButton) comp;
                boton.setSelected(false);

                if (boton.getModel() instanceof javax.swing.DefaultButtonModel) {
                    javax.swing.ButtonGroup grupo = ((javax.swing.DefaultButtonModel) boton.getModel()).getGroup();
                    if (grupo != null) {
                        grupo.clearSelection();
                    }
                }
            } else if (comp instanceof com.toedter.calendar.JDateChooser) {
                ((com.toedter.calendar.JDateChooser) comp).setDate(null);
            }

            if (comp instanceof java.awt.Container) {
                limpiarComponentes((java.awt.Container) comp);
            }
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
            java.util.logging.Logger.getLogger(frmSolicitudIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSolicitudIngreso.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSolicitudIngreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVaciarCampos;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFondoTabs;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTabbedPane tabSolicitud;
    // End of variables declaration//GEN-END:variables
}
