/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.vista;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Cliente;
import co.tecnomati.java.controlcaja.dominio.Concepto;

import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.dominio.Comprobanteconcepto;
import co.tecnomati.java.controlcaja.dominio.Proveedor;
import co.tecnomati.java.controlcaja.dominio.Tipocomprobante;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ClienteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ComprobanteconceptoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ConceptoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ProveedorDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoComprobanteDaoImp;
import co.tecnomati.java.controlcaja.reporte.jrdatasource.ModeloReciboJRDataSource;
import co.tecnomati.java.controlcaja.reporte.jrdatasource.RboIntegCuotaSocialJRDataSource;
import co.tecnomati.java.controlcaja.util.Entidad;
import co.tecnomati.java.controlcaja.util.MyUtil;
import co.tecnomati.java.controlcaja.util.mensajero;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import org.jdesktop.swingx.autocomplete.*;
//import org.jfree.data.time.Month;

/**
 *
 * @author Joel
 */
public class GUIComprobante extends javax.swing.JDialog {

    private Comprobante comprobante;
    private boolean modificar;
    private Concepto concepto;
    private boolean agregado;
    
    Entidad entidad=new Entidad();
    private Tipocomprobante tipoComprobante;
    Set<Comprobanteconcepto> conjuntoConceptos;
    Comprobanteconcepto comprobanteconcepto;
    /**
     * Creates new form GUIComprobante
     */
    public GUIComprobante(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modificar = false;
        comprobante = new Comprobante();
        //cargar datos del combobox
        setDatosCmbTipoFormulario();
//        setEscuchadorDeEventosCmboTipoComprobante();

        //cargar los campos de texto con 
//        setDatosNombreEntidad();
        this.setTitle(Constantes.NAME_NUEVO_REGISTRO);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public GUIComprobante(java.awt.Frame parent, boolean modal, Comprobante comprobante) {
        super(parent, modal);
        initComponents();
        modificar = true;
        this.comprobante = comprobante;
        
        // cargos los datos para editar
       dateComprobante.setDate(comprobante.getFecha());
       cmbTipoProceso.setSelectedIndex(comprobante.getTipoProceso());
       txtnumSerie1.setText(String.valueOf(comprobante.getNumeroSerie()));
       
       // entidad
       entidad.setId(comprobante.getIdEntidad());
       entidad.setTipoEntidad(comprobante.getTipoPersona());
       
       //tipo de comprobante
       tipoComprobante = new ComprobanteDaoImp().getTipocomprobante(comprobante.getId());
       txtTipoComprobante.setText(tipoComprobante.getFormulario());
       txtRefTipoCompr.setText(tipoComprobante.getReferencia());
       
       //Conceptoss
        conjuntoConceptos= new ComprobanteDaoImp().listarConcepto(comprobante.getId());
        for (Iterator<Comprobanteconcepto> it = conjuntoConceptos.iterator(); it.hasNext();) {
            comprobanteconcepto = it.next();
            txtCodigoConcepto.setText(String.valueOf(comprobanteconcepto.getConcepto().getCodigoConcepto()));
            txtDescripcionConcepto.setText(comprobanteconcepto.getConcepto().getDescripcion());
            txtMonto.setText(String.valueOf(comprobanteconcepto.getMonto()));
        }
        
        switch (comprobante.getTipoPersona()) {
           
             case Constantes.ASOCIADO_INT : Asociado a = new AsociadoDaoImp().getAsociado(comprobante.getIdEntidad());
                                            txtCuit.setText(String.valueOf(a.getCuit()));
                                            txtNombre.setText(a.getNombre());
                                            break;
             case Constantes.PROVEEDOR_INT :Proveedor p = new ProveedorDaoImp().getProveedor(comprobante.getIdEntidad());
                                            txtCuit.setText(String.valueOf(p.getCuit()));
                                            txtNombre.setText(p.getRazonSocial());
                                            break;
             case Constantes.CLIENTE_INT : Cliente c = new ClienteDaoImp().getCliente(comprobante.getIdEntidad());
                                           txtCuit.setText(String.valueOf(c.getCuit()));
                                           txtNombre.setText(c.getRazonSocial());
                                           break;
         }
        //cargar datos del combobox
        setDatosCmbTipoFormulario();
//        setEscuchadorDeEventosCmboTipoComprobante();

        //cargar los campos de texto con 
//        setDatosNombreEntidad();
        this.setTitle(Constantes.NAME_NUEVO_REGISTRO);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void setDatosCmbTipoFormulario() {
//        cmbTipoComprobante.removeAllItems();
//
//        if (new TipoComprobanteDaoImp().listarTipoFormulario().isEmpty()) {
//            cmbTipoComprobante.setEditable(false);
//        } else {
//            cmbTipoComprobante.setEditable(true);
//            for (Tipocomprobante o : new TipoComprobanteDaoImp().listarTipoFormulario()) {
//                cmbTipoComprobante.addItem(o.getReferencia());
//            }
//            AutoCompleteDecorator.decorate(this.cmbTipoComprobante);
//        }
    }

    public boolean isAgregado() {
        return agregado;
    }

    public void setAgregado(boolean agregado) {
        this.agregado = agregado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        panelComprobante = new org.edisoncor.gui.panel.Panel();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        txtnumSerie1 = new org.edisoncor.gui.textField.TextField();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        cmbTipoProceso = new org.edisoncor.gui.comboBox.ComboBoxRect();
        txtNumSerie2 = new org.edisoncor.gui.textField.TextField();
        txtTipoComprobante = new org.edisoncor.gui.textField.TextField();
        txtRefTipoCompr = new org.edisoncor.gui.textField.TextField();
        panelEntidad = new org.edisoncor.gui.panel.Panel();
        txtCuit = new org.edisoncor.gui.textField.TextField();
        txtNombre = new org.edisoncor.gui.textField.TextField();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric8 = new org.edisoncor.gui.label.LabelMetric();
        panelConcepto = new org.edisoncor.gui.panel.Panel();
        labelMetric6 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric7 = new org.edisoncor.gui.label.LabelMetric();
        txtCodigoConcepto = new org.edisoncor.gui.textField.TextField();
        txtMonto = new org.edisoncor.gui.textField.TextField();
        labelMetric10 = new org.edisoncor.gui.label.LabelMetric();
        txtDescripcionConcepto = new org.edisoncor.gui.textField.TextField();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jCheckBox1 = new javax.swing.JCheckBox();
        btnGuardar = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        dateComprobante = new com.toedter.calendar.JDateChooser();
        btnImprimir = new org.edisoncor.gui.button.ButtonIpod();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(153, 153, 153));

        labelMetric2.setText("Fecha");

        panelComprobante.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comprobante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)));
        panelComprobante.setColorPrimario(new java.awt.Color(153, 153, 153));

        labelMetric4.setText("Tipo Comprobante: ");

        labelMetric5.setText("Serie-Numero");

        txtnumSerie1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumSerie1KeyTyped(evt);
            }
        });

        labelMetric3.setText("Tipo Proceso");

        cmbTipoProceso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENTRADA", "SALIDA" }));
        cmbTipoProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoProcesoActionPerformed(evt);
            }
        });
        cmbTipoProceso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTipoProcesoKeyPressed(evt);
            }
        });

        txtNumSerie2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumSerie2KeyTyped(evt);
            }
        });

        txtTipoComprobante.setEditable(false);
        txtTipoComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTipoComprobanteKeyPressed(evt);
            }
        });

        txtRefTipoCompr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRefTipoComprKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRefTipoComprKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelComprobanteLayout = new javax.swing.GroupLayout(panelComprobante);
        panelComprobante.setLayout(panelComprobanteLayout);
        panelComprobanteLayout.setHorizontalGroup(
            panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComprobanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComprobanteLayout.createSequentialGroup()
                        .addComponent(cmbTipoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelComprobanteLayout.createSequentialGroup()
                        .addComponent(txtRefTipoCompr, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTipoComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelComprobanteLayout.createSequentialGroup()
                        .addComponent(txtnumSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumSerie2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelComprobanteLayout.setVerticalGroup(
            panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComprobanteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtRefTipoCompr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumSerie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        panelEntidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entidad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)));
        panelEntidad.setColorPrimario(new java.awt.Color(153, 153, 153));

        txtCuit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCuitKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuitKeyTyped(evt);
            }
        });

        txtNombre.setEditable(false);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        labelMetric9.setText("RAZON SOCIAL:    ");

        labelMetric8.setText("CUIT");

        javax.swing.GroupLayout panelEntidadLayout = new javax.swing.GroupLayout(panelEntidad);
        panelEntidad.setLayout(panelEntidadLayout);
        panelEntidadLayout.setHorizontalGroup(
            panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        panelEntidadLayout.setVerticalGroup(
            panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelConcepto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Concepto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)));
        panelConcepto.setColorPrimario(new java.awt.Color(153, 153, 153));

        labelMetric6.setText("codigo Concepto: ");

        labelMetric7.setText("Monto ");

        txtCodigoConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoConceptoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoConceptoKeyTyped(evt);
            }
        });

        labelMetric10.setText("Concepto");

        txtDescripcionConcepto.setEditable(false);

        jCheckBox1.setText("Aporte de Monotributo");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jCheckBox1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelConceptoLayout = new javax.swing.GroupLayout(panelConcepto);
        panelConcepto.setLayout(panelConceptoLayout);
        panelConceptoLayout.setHorizontalGroup(
            panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConceptoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelConceptoLayout.createSequentialGroup()
                        .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionConcepto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelConceptoLayout.createSequentialGroup()
                                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 122, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelConceptoLayout.setVerticalGroup(
            panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConceptoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        dateComprobante.setDate(new Date());
        dateComprobante.setMaxSelectableDate(new Date());

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelConcepto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(panelConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbTipoProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoProcesoActionPerformed

    public boolean validarCamposVacio() {
        boolean b = false;

        boolean cTC, cNS1, cNS2, cD, cLN = false;
        cTC = txtTipoComprobante.getText().trim().isEmpty();
        cNS1 = txtnumSerie1.getText().trim().isEmpty();
//            cNS2 = txtnumSerie2.getText().trim().isEmpty();
//            cD = txtDni.getText().trim().isEmpty();
//            cLN = txtLugarNac.getText().trim().isEmpty();



        return b;
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        //cargo los datos en el objeto comprobante
         comprobante.setIdEntidad(entidad.getId());
        comprobante.setTipoPersona(entidad.getTipoEntidad());
        comprobante.setFecha(dateComprobante.getDate());
        comprobante.setNumeroSerie(Long.parseLong(txtnumSerie1.getText()));
        comprobante.setTipoProceso(cmbTipoProceso.getSelectedIndex());
        comprobante.setTipocomprobante(tipoComprobante);

        //realizo el almacenamiento o actualizacion de los datos segun corresponda
        if (modificar) {
            
            //modificar
            new ComprobanteDaoImp().upDateFormulario(comprobante);
            //update comprobante concepto para 1 solo concepto
            comprobanteconcepto.setConcepto(new ConceptoDaoImp().getConcepto(Integer.parseInt(txtCodigoConcepto.getText())));
            comprobanteconcepto.setMonto(Double.parseDouble(txtMonto.getText()));
            new ComprobanteconceptoDaoImp().upDateComprobanteconcepto(comprobanteconcepto);
        } else {
            //el objeto entidad solo se cargara cuando es nuevo
           
            
            new ComprobanteDaoImp().addFormulario(comprobante);
            Comprobanteconcepto detalle = new Comprobanteconcepto();
            detalle.setConcepto(concepto);
            detalle.setComprobante(comprobante);
            detalle.setMonto(Double.parseDouble(txtMonto.getText()));
            new ComprobanteconceptoDaoImp().addComprobanteconcepto(detalle);
        }
        // agregar los conceptos en un conjunto
        Set<Comprobanteconcepto> conjuntoDetalle = new HashSet<Comprobanteconcepto>();

        //agregar los conceptos al detalle




        //         conjuntoDetalle.add(detalle);
//         comprobante.setComprobanteconceptos(conjuntoDetalle);
        // agregar mas conceptos si es neceario
        //pregunto si esta tildado el combo

        //
        //falta la validacion de los datos




        agregado = true;

        JOptionPane.showMessageDialog(null, "Se cargo correctamente...");

//        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            GUIgestorEntidades gestorEntidades = new GUIgestorEntidades(null, true);
            //si selecciono una persona entonces debe reflejarse aqui 
//            if (gestorEntidades.isAgregado()) {
//              
            // vuelco en la clase aux entidad
//                 entidad = new Entidad();
//                 entidad.setId(a.getCuit());
//                 entidad.setDescripcion(a.getNombre());
            // muestro en el formulario recibo
//                 txtCuitDni.setText(String.valueOf(entidad.getId()));
//                 txtNombre.setText(entidad.getDescripcion());
//            }
        }

    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtCodigoConceptoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoConceptoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int codigoConcepto = Integer.parseInt(txtCodigoConcepto.getText().trim());
            if (!"".equals(codigoConcepto)) {
                concepto = new ConceptoDaoImp().getConcepto(codigoConcepto);
                if (concepto != null) {
                    txtCodigoConcepto.setText(String.valueOf(concepto.getCodigoConcepto()));
                    txtDescripcionConcepto.setText(concepto.getDescripcion());
                    txtMonto.requestFocus();
                } else {
                    // llama a la ayuda
                    GUIGestordeConcepto gestorConcepto = new GUIGestordeConcepto(null, true);
                    // si eligio un concepto debe ser reflejado 
                    if (gestorConcepto.isAgregado()) {
                        concepto = gestorConcepto.getAsociado();
                        txtCodigoConcepto.setText(String.valueOf(concepto.getCodigoConcepto()));
                        txtDescripcionConcepto.setText(concepto.getDescripcion());
                        txtMonto.requestFocus();

                    }
                }
            }

        }
    }//GEN-LAST:event_txtCodigoConceptoKeyPressed

    private void txtTipoComprobanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoComprobanteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            GUIGestorTipoComprobante guiGestorTipoFormulario = new GUIGestorTipoComprobante(null, true);
            if (guiGestorTipoFormulario.isAgregado()) {
                tipoComprobante = guiGestorTipoFormulario.getTipoComp();

                txtTipoComprobante.setText(tipoComprobante.getFormulario());
                txtRefTipoCompr.setText(tipoComprobante.getReferencia());
                // para que obtenga el foco 
                txtnumSerie1.requestFocus();
            }

        }
    }//GEN-LAST:event_txtTipoComprobanteKeyPressed

    private void txtRefTipoComprKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRefTipoComprKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String tipo = txtRefTipoCompr.getText().trim();
            if (!"".equals(tipo)) {
                tipoComprobante = new TipoComprobanteDaoImp().getTipoFormularioRef(tipo);
                if (tipoComprobante != null) {

                    txtTipoComprobante.setText(tipoComprobante.getFormulario());
                    txtnumSerie1.requestFocus();
                }
            }

        }

    }//GEN-LAST:event_txtRefTipoComprKeyPressed

    public void Imprimir(){
        Map parametros = new HashMap();
        String logotipo = "/images/1.jpg";
        ModeloReciboJRDataSource dataSource = new ModeloReciboJRDataSource();
        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);
        dataSource.setListCertificado(lista);
        JasperPrint jPrintt;
        try {
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboDePago.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JasperPrintManager.printReport(jPrintt, true);
            // esto es para la vista previa
//            JDialog reporte = new JDialog();
//            reporte.setSize(900, 700);
//            reporte.setLocationRelativeTo(null);
//            reporte.setModal(true);
//            reporte.setTitle("INFORME");
//            JRViewer jv = new JRViewer(jPrintt);
//            reporte.getContentPane().add(jv);
//            reporte.setVisible(true);

        } catch (JRException ex) {
            mensajero.mensajeError(this, "Error de Impresion");
        }

    }
 
    /*Prueba*/
    public void Imprimirec(){
        Map parametros = new HashMap();
        String logotipo = "/images/1.jpg";
        RboIntegCuotaSocialJRDataSource dataSource = new RboIntegCuotaSocialJRDataSource();
        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);
        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboIntegracionCuotas.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JasperPrintManager.printReport(jPrintt, true);
            // esto es para la vista previa
//            JDialog reporte = new JDialog();
//            reporte.setSize(900, 700);
//            reporte.setLocationRelativeTo(null);
//            reporte.setModal(true);
//            reporte.setTitle("INFORME");
//            JRViewer jv = new JRViewer(jPrintt);
//            reporte.getContentPane().add(jv);
//            reporte.setVisible(true);

        } catch (JRException ex) {
            mensajero.mensajeError(this, "Error de Impresion");
        }

    }
    /*Fin de Prueba*/
    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
//        Imprimir();
        Imprimirec();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtCodigoConceptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoConceptoKeyTyped
        MyUtil.consumirLetras(evt, txtCodigoConcepto, 3);

    }//GEN-LAST:event_txtCodigoConceptoKeyTyped

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txtCuitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuitKeyTyped
        MyUtil.consumirLetras(evt, txtCodigoConcepto, 0);
    }//GEN-LAST:event_txtCuitKeyTyped

    private void txtCuitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuitKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            GUIgestorEntidades gestorEntidad = new GUIgestorEntidades(null, true);
            if (gestorEntidad.isSelecciono()) {
                entidad = gestorEntidad.getEntidad();
                if (entidad.getTipoEntidad() == Constantes.PROVEEDOR_INT) {
                    Proveedor proveedor = new ProveedorDaoImp().getProveedor(entidad.getId());
                    txtCuit.setText(String.valueOf(proveedor.getCuit()));
                    txtNombre.setText(proveedor.getRazonSocial());
                } else if (entidad.getTipoEntidad() == Constantes.CLIENTE_INT) {
                    Cliente cliente = new ClienteDaoImp().getCliente(entidad.getId());
                    txtCuit.setText(String.valueOf(cliente.getCuit()));
                    txtNombre.setText(cliente.getRazonSocial());
                } else if (entidad.getTipoEntidad() == Constantes.ASOCIADO_INT) {
                   /*System.out.println(entidad.getTipoEntidad()+" ..tip entidadq");
                    System.out.println(Constantes.ASOCIADO_INT+" ..tipo entidadq");
                    System.out.println("id entidadd"+entidad.getId());
                    */
                    Asociado asociado = new AsociadoDaoImp().getAsociado(entidad.getId());
                    txtCuit.setText(String.valueOf(asociado.getCuit()));
                    txtNombre.setText(asociado.getNombre());
                }
            }
        }
    }//GEN-LAST:event_txtCuitKeyPressed

    private void txtnumSerie1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumSerie1KeyTyped
        
        if (txtnumSerie1.getText().length()==4) {
            txtNumSerie2.requestFocus();
        }
        MyUtil.consumirLetras(evt, txtnumSerie1, 4);
        

    }//GEN-LAST:event_txtnumSerie1KeyTyped

    private void txtNumSerie2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSerie2KeyTyped
         MyUtil.consumirLetras(evt, txtNumSerie2, 8);
         if (txtNumSerie2.getText().length()==8) {
            txtCuit.requestFocus();
         }
    }//GEN-LAST:event_txtNumSerie2KeyTyped

    private void txtRefTipoComprKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRefTipoComprKeyTyped
         if (txtRefTipoCompr.getText().length()==4 && evt.getKeyCode()!=8) {
            txtCuit.requestFocus();
         }
    }//GEN-LAST:event_txtRefTipoComprKeyTyped

    private void cmbTipoProcesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTipoProcesoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRefTipoCompr.requestFocus();
        }
    }//GEN-LAST:event_cmbTipoProcesoKeyPressed

   
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
            java.util.logging.Logger.getLogger(GUIComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIComprobante dialog = new GUIComprobante(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnGuardar;
    private org.edisoncor.gui.button.ButtonIpod btnImprimir;
    private org.edisoncor.gui.comboBox.ComboBoxRect cmbTipoProceso;
    private com.toedter.calendar.JDateChooser dateComprobante;
    private javax.swing.JCheckBox jCheckBox1;
    private org.edisoncor.gui.label.LabelMetric labelMetric10;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric4;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
    private org.edisoncor.gui.label.LabelMetric labelMetric6;
    private org.edisoncor.gui.label.LabelMetric labelMetric7;
    private org.edisoncor.gui.label.LabelMetric labelMetric8;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panelComprobante;
    private org.edisoncor.gui.panel.Panel panelConcepto;
    private org.edisoncor.gui.panel.Panel panelEntidad;
    private org.edisoncor.gui.textField.TextField txtCodigoConcepto;
    private org.edisoncor.gui.textField.TextField txtCuit;
    private org.edisoncor.gui.textField.TextField txtDescripcionConcepto;
    private org.edisoncor.gui.textField.TextField txtMonto;
    private org.edisoncor.gui.textField.TextField txtNombre;
    private org.edisoncor.gui.textField.TextField txtNumSerie2;
    private org.edisoncor.gui.textField.TextField txtRefTipoCompr;
    private org.edisoncor.gui.textField.TextField txtTipoComprobante;
    private org.edisoncor.gui.textField.TextField txtnumSerie1;
    // End of variables declaration//GEN-END:variables
}
