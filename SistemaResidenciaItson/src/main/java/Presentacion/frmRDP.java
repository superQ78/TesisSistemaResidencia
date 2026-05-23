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
    private ResidenteDTO dtoCompartido = null;

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
        configurarAutocompletadoEmergencia();

        tabDatosRegistroResi.revalidate();
        tabDatosRegistroResi.repaint();
    }

    //Constructor para modificar informacion de recidentes
    public frmRDP(String idSeleccionado) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tabDatosRegistroResi.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        configurarTabs();
        configurarScrolls();
        configurarEstiloGeneral();
        configurarAutocompletadoEmergencia();

        // Guardamos el ID
        this.idResidenteEdicion = idSeleccionado;

        // Cambiamos el texto visual para que el usuario sepa que está editando
        lblSubTitulo1.setText("Modificar Datos del Residente");

        cargarDatosParaEditar();
    }

    /**
     * Constructor para recibir datos compartidos desde la pantalla de Solicitud
     */
    public frmRDP(ResidenteDTO dtoMemoria) {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tabDatosRegistroResi.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        configurarTabs();
        configurarScrolls();
        configurarEstiloGeneral();
        configurarAutocompletadoEmergencia();

        // guarda los datos que se pasaron
        this.dtoCompartido = dtoMemoria;

        // se estraen los datos a los paneles comunes
        if (this.dtoCompartido != null) {
            panelSolicitante.cargarDatosSolicitante(this.dtoCompartido);
            panelTutor.cargarDatosTutor(this.dtoCompartido);
            panelEmergencia.cargarDatosEmergencia(this.dtoCompartido);
            panelPersonales.cargarDatosPersonales(this.dtoCompartido);
            panelAcademicos.cargarDatosAcademicos(this.dtoCompartido);
            panelMedicos.cargarDatosMedicos(this.dtoCompartido);
        }
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
            panelPersonales.cargarDatosPersonales(residente);
            panelAcademicos.cargarDatosAcademicos(residente);
            panelMedicos.cargarDatosMedicos(residente);

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
        btnImprimir = new javax.swing.JButton();
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

        btnImprimir.setBackground(new java.awt.Color(0, 153, 255));
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setToolTipText("");
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
                .addContainerGap(445, Short.MAX_VALUE)
                .addComponent(btnVaciarCampos)
                .addGap(62, 62, 62)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnVaciarCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(pnlBotones, java.awt.BorderLayout.PAGE_END);

        pnlTitulo.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitulo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSubTitulo.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblSubTitulo.setText("Residencias ITSON – Panel de Gestión de residentes");
        pnlTitulo.add(lblSubTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        lblSubTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblSubTitulo1.setText("Registrar residente");
        pnlTitulo.add(lblSubTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 243, -1));

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
        // se guarda todo lo que se haya escrito en la pantalla actual
        if (this.dtoCompartido == null) {
            this.dtoCompartido = new ResidenteDTO();
        }
        panelSolicitante.empaquetarDatosPersonales(this.dtoCompartido);
        panelTutor.empaquetarDatosTutor(this.dtoCompartido);
        panelEmergencia.empaquetarDatosEmergencia(this.dtoCompartido);
        panelPersonales.empaquetarDatosPersonales(this.dtoCompartido);
        panelAcademicos.empaquetarDatosAcademicos(this.dtoCompartido);
        panelMedicos.empaquetarDatosMedicos(this.dtoCompartido);

        coordinadorVistas.mostrarRegistrarResidenteConDatos(this, this.dtoCompartido);
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
                    "Hay campos obligatorios vacios.",
                    "Campos incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        ResidenteDTO dtoGuardar = (this.dtoCompartido != null) ? this.dtoCompartido : new ResidenteDTO();

        // Que cada panel meta sus datos al maletín
        panelSolicitante.empaquetarDatosPersonales(dtoGuardar);
        panelTutor.empaquetarDatosTutor(dtoGuardar);
        panelEmergencia.empaquetarDatosEmergencia(dtoGuardar);
        panelPersonales.empaquetarDatosPersonales(dtoGuardar);
        panelAcademicos.empaquetarDatosAcademicos(dtoGuardar);
        panelMedicos.empaquetarDatosMedicos(dtoGuardar);

        Negocio.GestorResidente.IResidente fachada = new Negocio.GestorResidente.ResidenteFachada();

        // Empezamos asumiendo que es falso para que el if de abajo haga la llamada de verdad
        boolean exito = false;

        if (this.idResidenteEdicion == null) {
            // Es nuevo hacemos INSERT
            exito = fachada.registrarRDP(dtoGuardar);
        } else {
            // Es modificacion aseguramos que lleve el ID original a actualizar
            dtoGuardar.setIdAcademico(this.idResidenteEdicion);
            exito = fachada.actualizarRDP(dtoGuardar);
        }

        if (exito) {
            String msj = (this.idResidenteEdicion == null) ? "¡Residente registrado con éxito!" : "¡Datos actualizados con éxito!";
            javax.swing.JOptionPane.showMessageDialog(this, msj, "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);

            if (this.idResidenteEdicion == null) {
                coordinadorVistas.mostrarRegistrarResidenteConDatos(this, this.dtoCompartido);
            } else {
                coordinadorVistas.mostrarModificarResidente(this);
            }

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar en la BD. Revisa que el ID o CURP no existan ya.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
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
            limpiarComponentes(panelAcademicos);
            limpiarComponentes(panelPersonales);
            limpiarComponentes(panelMedicos);

            // borra la memoria del programa para que no intente
            // volver a cargar los datos viejos si cambiamos de pestaña.
            this.dtoCompartido = new Negocio.DTOs.ResidenteDTO();
            this.idResidenteEdicion = null; // si esta editanto, lo convierte en nuevo

            javax.swing.JOptionPane.showMessageDialog(this, "Se borraron todos los datos ingresados.");
        }
    }//GEN-LAST:event_btnVaciarCamposActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        boolean solValido = panelSolicitante.validarCampos();
        boolean tutValido = panelTutor.validarCampos();
        boolean emeValido = panelEmergencia.validarCampos();
        boolean perValido = panelPersonales.validarCampos();
        boolean acaValido = panelAcademicos.validarCampos();
        boolean medValido = panelMedicos.validarCampos();

        if (!solValido || !tutValido || !emeValido || !perValido || !acaValido || !medValido) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Primero llena todos los campos obligatorios antes de generar el PDF.",
                    "Campos incompletos",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        ResidenteDTO dtoPDF = (this.dtoCompartido != null) ? this.dtoCompartido : new ResidenteDTO();

        panelSolicitante.empaquetarDatosPersonales(dtoPDF);
        panelTutor.empaquetarDatosTutor(dtoPDF);
        panelEmergencia.empaquetarDatosEmergencia(dtoPDF);
        panelPersonales.empaquetarDatosPersonales(dtoPDF);
        panelAcademicos.empaquetarDatosAcademicos(dtoPDF);
        panelMedicos.empaquetarDatosMedicos(dtoPDF);

        String ruta = Utilidades.UtilidadPDF.seleccionarRutaPDF(
                this,
                "Guardar RDP en PDF",
                "RDP_" + Utilidades.UtilidadPDF.texto(dtoPDF.getIdAcademico()) + ".pdf"
        );

        if (ruta == null) {
            return;
        }

        try {
            Utilidades.GeneradorPDFRegistro.generarRegistroResidente(ruta, dtoPDF);

            Utilidades.UtilidadPDF.mostrarExito(
                    this,
                    "PDF generado correctamente.\nAhora puedes imprimirlo, firmarlo y después subirlo como RDP Firmada.",
                    ruta
            );

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al generar el PDF:\n" + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

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
                    ((javax.swing.JComboBox<?>) comp).setSelectedIndex(0); // Vuelve a "Selecciona..."
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
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVaciarCampos;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblSubTitulo1;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFondoTabs;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTabbedPane tabDatosRegistroResi;
    // End of variables declaration//GEN-END:variables
}
