package Presentacion;

import Negocio.DTOs.ResidenteDTO;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author cesar
 */
public class frmRDP extends javax.swing.JFrame {

    pnlDatosSolicitante panelSolicitante = new pnlDatosSolicitante();
    pnlDatosTutor panelTutor = new pnlDatosTutor();
    pnlContactoEmergencia panelEmergencia = new pnlContactoEmergencia();
    pnlAspAcademicos panelAcademicos = new pnlAspAcademicos();
    pnlAspPersonales panelPersonales = new pnlAspPersonales();
    pnlDatosMedicos panelMedicos = new pnlDatosMedicos();
    private String idResidenteEdicion = null;

    /**
     * Creates new form frmCrearResidente
     */
    public frmRDP() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        tabDatosRegistroResi.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        configurarTabs();
        configurarScrolls();
        configurarEstiloGeneral();

        tabDatosRegistroResi.revalidate();
        tabDatosRegistroResi.repaint();
    }

    public frmRDP(String idSeleccionado) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tabDatosRegistroResi.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        configurarTabs();
        configurarScrolls();
        configurarEstiloGeneral();

        // Guardamos el ID
        this.idResidenteEdicion = idSeleccionado;

        // Cambiamos el texto visual para que el usuario sepa que está editando
        // Asegúrate de que lblSubTitulo sea el nombre correcto de tu JLabel en la UI
        lblSubTitulo1.setText("Modificar Datos del Residente");

        cargarDatosParaEditar();
    }

    private void cargarDatosParaEditar() {
        // 1. Instanciar la fachada de Residentes
        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
        
        // 2. Consultar toda la información del residente usando su ID
        ResidenteDTO residente = fachada.consultarResidentePorId(this.idResidenteEdicion);

        // 3. Si la base de datos sí nos devolvió la información, llenamos los paneles
        if (residente != null) {
            
            // Le mandamos el "maletín" entero a cada panel para que cada uno agarre lo que necesita
            panelSolicitante.cargarDatos(residente);
            panelTutor.cargarDatos(residente);
            panelEmergencia.cargarDatos(residente);
            panelPersonales.cargarDatos(residente);
            panelAcademicos.cargarDatos(residente);
            panelMedicos.cargarDatos(residente);
            
        } else {
            // Si por alguna razón el ID no existe o hubo un error de conexión
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "No se encontró la información del residente en la Base de Datos.", 
                    "Error de Carga", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            
            // Usamos tu Coordinador para sacarlo de ahí y regresarlo a la tabla
            coordinadorVistas.mostrarModificarResidente(this);
        }
    }

    /**
     * Configura el diseño visual del componente JTabbedPane.
     *
     * Se personaliza la apariencia de las pestañas, incluyendo: Colores de
     * fondo, cambio de tipo de letra, centrado de texto, eliminación de bordes
     * separación mediante líneas entre pestañas.
     */
    private void configurarTabs() {
        tabDatosRegistroResi.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {

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

        tabDatosRegistroResi.setOpaque(true);
        tabDatosRegistroResi.setBackground(new java.awt.Color(241, 241, 241));
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
        tabDatosRegistroResi.removeAll(); // importante

        tabDatosRegistroResi.addTab("Solicitante", crearScroll(panelSolicitante));
        tabDatosRegistroResi.addTab("Tutor", crearScroll(panelTutor));
        tabDatosRegistroResi.addTab("Emergencia", crearScroll(panelEmergencia));
        tabDatosRegistroResi.addTab("Personales", crearScroll(panelPersonales));
        tabDatosRegistroResi.addTab("Académicos", crearScroll(panelAcademicos));
        tabDatosRegistroResi.addTab("Médicos", crearScroll(panelMedicos));
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
        panelPersonales.setBackground(java.awt.Color.WHITE);
        panelAcademicos.setBackground(java.awt.Color.WHITE);
        panelMedicos.setBackground(java.awt.Color.WHITE);
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
        pnlTitulo = new javax.swing.JPanel();
        lblSubTitulo = new javax.swing.JLabel();
        lblSubTitulo1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        pnlFondoTabs = new javax.swing.JPanel();
        tabDatosRegistroResi = new javax.swing.JTabbedPane();

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

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonesLayout.createSequentialGroup()
                .addContainerGap(445, Short.MAX_VALUE)
                .addComponent(btnVaciarCampos)
                .addGap(62, 62, 62)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnVaciarCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pnlBotones, java.awt.BorderLayout.PAGE_END);

        pnlTitulo.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubTitulo.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblSubTitulo.setText("Residencias ITSON – Panel de Gestión de residentes");
        pnlTitulo.add(lblSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        lblSubTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblSubTitulo1.setText("Registrar residente");
        pnlTitulo.add(lblSubTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 243, -1));

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

        tabDatosRegistroResi.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 100, 20, 100));
        tabDatosRegistroResi.setToolTipText("");
        pnlFondoTabs.add(tabDatosRegistroResi, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlFondoTabs, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if (this.idResidenteEdicion == null) {
            coordinadorVistas.mostrarAdminInicio(this); // Regresa al menú si estaba creando
        } else {
            coordinadorVistas.mostrarModificarResidente(this); // Regresa a la tabla si estaba editando
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        boolean solValido = panelSolicitante.validarCampos();
        boolean tutValido = panelTutor.validarCampos();
        boolean emeValido = panelEmergencia.validarCampos();
        boolean perValido = panelPersonales.validarCampos();
        boolean acaValido = panelAcademicos.validarCampos();
        boolean medValido = panelMedicos.validarCampos();

        if (!solValido || !tutValido || !emeValido || !perValido || !acaValido || !medValido) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Hay campos obligatorios vacíos.",
                    "Campos incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        ResidenteDTO dtoNuevo = new ResidenteDTO();

        // Que cada panel meta sus datos al maletín
        panelSolicitante.empaquetarDatosPersonales(dtoNuevo);
        panelTutor.empaquetarDatosTutor(dtoNuevo);
        panelEmergencia.empaquetarDatosEmergencia(dtoNuevo);
        panelPersonales.empaquetarDatosPersonales(dtoNuevo);
        panelAcademicos.empaquetarDatosAcademicos(dtoNuevo);
        panelMedicos.empaquetarDatosMedicos(dtoNuevo);

        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();
        
        // Empezamos asumiendo que es falso para que el if de abajo haga la llamada de verdad
        boolean exito = false;

        if (this.idResidenteEdicion == null) {
            // Es nuevo, hacemos INSERT
            exito = fachada.registrarRDP(dtoNuevo); 
        } else {
            // Es modificación, aseguramos que lleve el ID original a actualizar
            dtoNuevo.setIdAcademico(this.idResidenteEdicion); 
            exito = fachada.actualizarRDP(dtoNuevo); 
        }

        if (exito) {
            String msj = (this.idResidenteEdicion == null) ? "¡Residente registrado con éxito!" : "¡Datos actualizados con éxito!";
            javax.swing.JOptionPane.showMessageDialog(this, msj, "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            if (this.idResidenteEdicion == null) {
                coordinadorVistas.regresarMenuPrincipal(this);
            } else {
                coordinadorVistas.mostrarModificarResidente(this);
            }
            
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar en la BD. Revisa que el ID o CURP no existan ya.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVaciarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarCamposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVaciarCamposActionPerformed

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
            java.util.logging.Logger.getLogger(frmRDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRDP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVaciarCampos;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblSubTitulo1;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFondoTabs;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTabbedPane tabDatosRegistroResi;
    // End of variables declaration//GEN-END:variables
}
