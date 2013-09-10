/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.vista;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.Concepto;
import co.tecnomati.java.controlcaja.dominio.Diario;
import co.tecnomati.java.controlcaja.dominio.Entidad;
import co.tecnomati.java.controlcaja.dominio.Formulario;
import co.tecnomati.java.controlcaja.dominio.TipoFormulario;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ConceptoDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.DiarioDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.FormularioDaoImp;
import co.tecnomati.java.controlcaja.dominio.dao.imp.TipoFormularioDaoImp;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.*;
/**
 *
 * @author Joel
 */
public class GUIRegistrarControlDiario extends javax.swing.JDialog {
    private boolean modificar;
    private Formulario formulario;
    private TipoFormulario tipoForm;
    private Concepto concepto;
    private Entidad entidad ;
    private boolean agregado;
    
    /**
     * Creates new form GUIRegistrarControlDiario
     */
    public GUIRegistrarControlDiario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setTitle(Constantes.NAME_NUEVO_REGISTRO);
        this.setLocationRelativeTo(null);
       
        //cargar datos del combobox
        setDatosCmbTipoFormulario();
        setEscuchadorDeEventosCmboTipoComprobante();
        
        //cargar los campos de texto con 
//        setDatosNombreEntidad();
        this.setVisible(true);
        
    }

    public void setDatosCmbTipoFormulario(){
    cmbTipoComprobante.removeAllItems();
                System.out.print(new TipoFormularioDaoImp().listarTipoFormulario().size());

    if (new TipoFormularioDaoImp().listarTipoFormulario().isEmpty()) {
        cmbTipoComprobante.setEditable(false);
    }else{
                  cmbTipoComprobante.setEditable(true);   
           for (TipoFormulario o : new TipoFormularioDaoImp().listarTipoFormulario()) {
        cmbTipoComprobante.addItem( o.getFormulario());
    }
    AutoCompleteDecorator.decorate(this.cmbTipoComprobante);
    }
           
 
    
    
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
        cmbTipoComprobante = new org.edisoncor.gui.comboBox.ComboBoxRect();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        txtnumSerie1 = new org.edisoncor.gui.textField.TextField();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        cmbTipoProceso = new org.edisoncor.gui.comboBox.ComboBoxRect();
        txtNumSerie2 = new org.edisoncor.gui.textField.TextField();
        txtTipoComprobante = new org.edisoncor.gui.textField.TextField();
        panelEntidad = new org.edisoncor.gui.panel.Panel();
        txtCuitDni = new org.edisoncor.gui.textField.TextField();
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
        btnGuardar = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        dateComprobante = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setColorPrimario(new java.awt.Color(153, 153, 153));

        labelMetric2.setText("Fecha");

        panelComprobante.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comprobante", 0, 0, null, new java.awt.Color(255, 255, 255)));
        panelComprobante.setColorPrimario(new java.awt.Color(153, 153, 153));

        cmbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FACTURA", "RECIBO" }));
        cmbTipoComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTipoComprobanteKeyPressed(evt);
            }
        });

        labelMetric4.setText("Tipo Comprobante");

        labelMetric5.setText("Serie-Numero");

        labelMetric3.setText("Tipo Proceso");

        cmbTipoProceso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ENTRADA", "SALIDA" }));
        cmbTipoProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoProcesoActionPerformed(evt);
            }
        });

        txtTipoComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTipoComprobanteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelComprobanteLayout = new javax.swing.GroupLayout(panelComprobante);
        panelComprobante.setLayout(panelComprobanteLayout);
        panelComprobanteLayout.setHorizontalGroup(
            panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComprobanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComprobanteLayout.createSequentialGroup()
                        .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtnumSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumSerie2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelComprobanteLayout.createSequentialGroup()
                        .addComponent(cmbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelComprobanteLayout.createSequentialGroup()
                        .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipoComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelComprobanteLayout.createSequentialGroup()
                                .addComponent(cmbTipoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelComprobanteLayout.setVerticalGroup(
            panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComprobanteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(cmbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnumSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumSerie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        panelEntidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entidad", 0, 0, null, new java.awt.Color(255, 255, 255)));
        panelEntidad.setColorPrimario(new java.awt.Color(153, 153, 153));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        labelMetric9.setText("RAZON SOCIAL");

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
                .addGap(53, 53, 53)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCuitDni, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelEntidadLayout.setVerticalGroup(
            panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntidadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuitDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelConcepto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Concepto", 0, 0, null, new java.awt.Color(255, 255, 255)));
        panelConcepto.setColorPrimario(new java.awt.Color(153, 153, 153));

        labelMetric6.setText("codigo Concepto");

        labelMetric7.setText("Monto ");

        txtCodigoConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoConceptoKeyPressed(evt);
            }
        });

        labelMetric10.setText("Concepto");

        javax.swing.GroupLayout panelConceptoLayout = new javax.swing.GroupLayout(panelConcepto);
        panelConcepto.setLayout(panelConceptoLayout);
        panelConceptoLayout.setHorizontalGroup(
            panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConceptoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcionConcepto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelConceptoLayout.createSequentialGroup()
                        .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelConceptoLayout.setVerticalGroup(
            panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConceptoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConceptoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConceptoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescripcionConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConceptoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelConcepto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(panelComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cmbTipoComprobanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTipoComprobanteKeyPressed
          
//         switch(evt.getKeyChar()){
//             
//             case KeyEvent.VK_ENTER:
//                 System.out.println("hola");
//                 break;
//             case KeyEvent.VK_F1:
//                 //gestor de comprobante
//                 System.out.println("f1");
//
//                 break;
//             case KeyEvent.VK_F2: 
//                 //nuevo comprobante
//                 TipoFormulario ventanaDoc = new TipoFormulario(null, true);
//                 
//                 // actualizar los datos del combobox
//                 setDatosCmbTipoFormulario();
//                 cmbTipoComprobante.setSelectedItem(ventanaDoc.getDoc().getFormulario());
//                 break;
//            
//         }
            
        
        
        
        
//        
//        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
//               // debe capturar el nombre y 
//                     
//          }else{
//              if (rootPaneCheckingEnabled) {
//                  
//              }
//          }
//         
    }//GEN-LAST:event_cmbTipoComprobanteKeyPressed

    private void cmbTipoProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoProcesoActionPerformed

    
    public  boolean validarCamposVacio(){
        boolean b=false;
        
            boolean cTC, cNS1,cNS2, cD, cLN = false;
            cTC = txtTipoComprobante.getText().trim().isEmpty();
            cNS1 = txtnumSerie1.getText().trim().isEmpty();
//            cNS2 = txtnumSerie2.getText().trim().isEmpty();
//            cD = txtDni.getText().trim().isEmpty();
//            cLN = txtLugarNac.getText().trim().isEmpty();

        
        
        return b;
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       

        if (!modificar) {
            //si se ingresa un nueva persona
            formulario = new Formulario();

        } 

                //completar los datos
                formulario.setTipoProceso(cmbTipoProceso.getSelectedItem().toString());
                formulario.setTipoFormulario(tipoForm);
                formulario.setNumeroSerie(Integer.valueOf(txtnumSerie1.getText().trim()));
                formulario.setConcepto(concepto);
                formulario.setCuit(entidad.getId());
                formulario.setNombre(entidad.getDescripcion());
                formulario.setMonto(Double.valueOf(txtMonto.getText().trim()));
                //falta el diario
                Diario diario;
                Date fecha = dateComprobante.getDate();
                try{
                
                 diario= new DiarioDaoImp().getDiario(fecha);  
                 // que linea mas rara  gracias a este system se pudo guardar
                 System.out.println(diario.getFecha());
                 formulario.setDiario(diario);
                 
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Se creo una nueva Caja debido a q No se encontro registro de caja para la fecha");
                   diario = new Diario(fecha);
                   new DiarioDaoImp().addDiario(diario);
                     System.out.println("entro por el catch");
                }
//                
                setAgregado(true);

                if (modificar) {
                     new FormularioDaoImp().upDateFormulario(formulario);
                  
                 } else {
                     new FormularioDaoImp().addFormulario(formulario);
                            
                        }

                   
                    
                    JOptionPane.showMessageDialog(null, "Se cargo correctamente...");
                    modificar = false;
                    this.dispose();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_F1){
             GUIGestorAsociado gestorEntidades = new GUIGestorAsociado(null, true);
             //si selecciono una persona entonces debe reflejarse aqui 
             if (gestorEntidades.isAgregado()) {
                 Asociado a = gestorEntidades.getAsociado();
                 // vuelco en la clase aux entidad
                 entidad = new Entidad();
                 entidad.setId(a.getCuit());
                 entidad.setDescripcion(a.getNombre());
                 // muestro en el formulario recibo
                 txtCuitDni.setText(String.valueOf(entidad.getId()));
                 txtNombre.setText(entidad.getDescripcion());
             }
         }
            
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtCodigoConceptoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoConceptoKeyPressed
          if (evt.getKeyCode()==KeyEvent.VK_F1){
              // ir al gestor de concepto para seleccionar un concetp
              GUIGestordeConcepto gestorConcepto = new GUIGestordeConcepto(null, true);
              // si eligio un concepto debe ser reflejado 
              if (gestorConcepto.isAgregado()) {
                 concepto = gestorConcepto.getAsociado();
                 txtCodigoConcepto.setText(String.valueOf(concepto.getCodigo()));
                 txtDescripcionConcepto.setText(concepto.getDescripcion());
              }
          }
        
        
    }//GEN-LAST:event_txtCodigoConceptoKeyPressed

    private void txtTipoComprobanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoComprobanteKeyPressed
         if (evt.getKeyCode()==KeyEvent.VK_F1){
             GUIGestorTipoFormulario guiGestorTipoFormulario = new GUIGestorTipoFormulario(null, true);
             if (guiGestorTipoFormulario.isAgregado()) {
                 tipoForm = guiGestorTipoFormulario.getTipoComp();
                  
                 txtTipoComprobante.setText(tipoForm.getFormulario());
                 // para que obtenga el foco 
                 txtnumSerie1.requestFocus();
             }
             
         }
    }//GEN-LAST:event_txtTipoComprobanteKeyPressed

    private void setEscuchadorDeEventosCmboTipoComprobante(){
         cmbTipoComprobante.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch(e.getKeyChar()){
             
             case KeyEvent.VK_ENTER:
                 System.out.println("enter");
                 break;
             case KeyEvent.VK_DOWN:
                 //gestor de comprobante
                 System.out.println("f1");

                 break;
             case KeyEvent.VK_F2: 
                 //nuevo comprobante
                 GUITipoFormulario ventanaDoc = new GUITipoFormulario(null, true);
                 
                 // actualizar los datos del combobox
                 setDatosCmbTipoFormulario();
                 cmbTipoComprobante.setSelectedItem(ventanaDoc.getDoc().getFormulario());
                 break;
            
         }
            }             
        });
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
            java.util.logging.Logger.getLogger(GUIRegistrarControlDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrarControlDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrarControlDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIRegistrarControlDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIRegistrarControlDiario dialog = new GUIRegistrarControlDiario(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.comboBox.ComboBoxRect cmbTipoComprobante;
    private org.edisoncor.gui.comboBox.ComboBoxRect cmbTipoProceso;
    private com.toedter.calendar.JDateChooser dateComprobante;
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
    private org.edisoncor.gui.panel.Panel panelComprobante;
    private org.edisoncor.gui.panel.Panel panelConcepto;
    private org.edisoncor.gui.panel.Panel panelEntidad;
    private org.edisoncor.gui.textField.TextField txtCodigoConcepto;
    private org.edisoncor.gui.textField.TextField txtCuitDni;
    private org.edisoncor.gui.textField.TextField txtDescripcionConcepto;
    private org.edisoncor.gui.textField.TextField txtMonto;
    private org.edisoncor.gui.textField.TextField txtNombre;
    private org.edisoncor.gui.textField.TextField txtNumSerie2;
    private org.edisoncor.gui.textField.TextField txtTipoComprobante;
    private org.edisoncor.gui.textField.TextField txtnumSerie1;
    // End of variables declaration//GEN-END:variables
}
