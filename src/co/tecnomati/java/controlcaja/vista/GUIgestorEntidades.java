/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.vista;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.modelo.ModeloAsociado;
import co.tecnomati.java.controlcaja.modelo.ModeloCliente;
import co.tecnomati.java.controlcaja.modelo.ModeloProveedor;
import co.tecnomati.java.controlcaja.util.ComprobanteUtil;
import co.tecnomati.java.controlcaja.util.Entidad;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author joel
 */
public class GUIgestorEntidades extends javax.swing.JDialog {
    
  
    
   int numeroSeleccion;
    boolean selecciono; //esta variable nos dice si el usuario selecciono una entidad del formulario
    Entidad entidad; // guardara la entidad que se selecciono .Puede ser un cliente,proveedor, asociado.
    private TableRowSorter sorter;
    ModeloAsociado modeloAsociado = new ModeloAsociado();
    ModeloCliente modeloCliente = new ModeloCliente();
    ModeloProveedor modeloProveedor = new ModeloProveedor();

    public Entidad getEntidad() {
        return entidad;
    }

    
    /**
     * Creates new form GUIgestorEntidades
     */
    public GUIgestorEntidades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // si es un tipo de comprobante 
        inicializarTablaAsociado();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public GUIgestorEntidades(java.awt.Frame parent, boolean modal,int codTipoCompr) {
        super(parent, modal);
        initComponents();
        
        // algunos comprobantes solo son para asociados , en consecuencia en estos casos solo se debe permitir el filtro por asociado solamente
        if (ComprobanteUtil.isReciboParaAsociado(codTipoCompr)){
             cmbFiltroEntidad.setSelectedIndex(Constantes.ASOCIADO_INT);
             cmbFiltroEntidad.setEnabled(false);
        }
        inicializarTablaAsociado();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEntidad = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntidad = new javax.swing.JTable();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        cmbFiltroEntidad = new javax.swing.JComboBox();
        txtRazonSocial = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        btnNuevoEntidad = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar1 = new org.edisoncor.gui.button.ButtonIpod();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblEntidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "cuit", "razon Social"
            }
        ));
        tblEntidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEntidadMouseClicked(evt);
            }
        });
        tblEntidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblEntidadKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblEntidad);

        labelMetric1.setText("Filtro");

        cmbFiltroEntidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASOCIADO", "CLIENTE", "PROVEEDOR" }));
        cmbFiltroEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroEntidadActionPerformed(evt);
            }
        });

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyPressed(evt);
            }
        });

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });

        labelMetric2.setText("Razon Social");

        labelMetric3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelMetric3.setText("CUIT");

        btnNuevoEntidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/tecnomati/java/controlcaja/imagen/Profile_1.png"))); // NOI18N
        btnNuevoEntidad.setText("Nuevo");
        btnNuevoEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEntidadActionPerformed(evt);
            }
        });

        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/tecnomati/java/controlcaja/imagen/Atras.png"))); // NOI18N
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEntidadLayout = new javax.swing.GroupLayout(panelEntidad);
        panelEntidad.setLayout(panelEntidadLayout);
        panelEntidadLayout.setHorizontalGroup(
            panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntidadLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltroEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEntidadLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEntidadLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(labelMetric2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRazonSocial)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelEntidadLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntidadLayout.createSequentialGroup()
                        .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevoEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEntidadLayout.setVerticalGroup(
            panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntidadLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFiltroEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isSelecciono() {
        return selecciono;
    }

    public void setSelecciono(boolean seleccionado) {
        this.selecciono = seleccionado;
    }

    public void inicializarTablaAsociado() {

        modeloAsociado = new ModeloAsociado();
        sorter = new TableRowSorter(modeloAsociado);
        tblEntidad.setModel(modeloAsociado);
    }

    public void inicializarTablaCliente() {

        modeloCliente = new ModeloCliente();
        sorter = new TableRowSorter(modeloCliente);
        tblEntidad.setModel(modeloCliente);
    }

    public void inicializarTablaProveedor() {

        modeloProveedor = new ModeloProveedor();
        sorter = new TableRowSorter(modeloProveedor);
        tblEntidad.setModel(modeloProveedor);
    }

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void cmbFiltroEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroEntidadActionPerformed

        if (cmbFiltroEntidad.getSelectedIndex()==Constantes.PROVEEDOR_INT) {
            inicializarTablaProveedor();
        } else if (cmbFiltroEntidad.getSelectedIndex()==Constantes.CLIENTE_INT) {
            inicializarTablaCliente();

        } else if (cmbFiltroEntidad.getSelectedIndex()==Constantes.ASOCIADO_INT) {
            inicializarTablaAsociado();
        }



    }//GEN-LAST:event_cmbFiltroEntidadActionPerformed

    public void filtro(JTextField caja){
          if (tblEntidad.getModel().getRowCount() != 0) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + caja.getText() + ".*"));
            tblEntidad.setRowSorter(sorter);

    }
    }
    private void txtRazonSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyPressed


filtro(txtRazonSocial);
    }//GEN-LAST:event_txtRazonSocialKeyPressed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        
        filtro(txtId);
    }//GEN-LAST:event_txtIdKeyPressed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
                this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnNuevoEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEntidadActionPerformed
          switch (cmbFiltroEntidad.getSelectedIndex()) {

            case Constantes.ASOCIADO_INT:
                GUIAsociados guiAsociado = new GUIAsociados(null, true);
                if (guiAsociado.isAgregado()) {
                    inicializarTablaAsociado();
                }
                
                 break;
            case Constantes.PROVEEDOR_INT:
               GUIProveedor guiProveedor = new GUIProveedor(null, true);
                if (guiProveedor.isAgregado()) {
                    inicializarTablaProveedor();
                }
               
                break;
            case Constantes.CLIENTE_INT:
               GUIClientes guiCliente = new GUIClientes(null, true);
                if (guiCliente.isAgregado()) {
                    inicializarTablaCliente();
                }
                break;
        }
    }//GEN-LAST:event_btnNuevoEntidadActionPerformed

    private void getEntidadDeJTable(){
          int fila = tblEntidad.getSelectedRow();
        if (tblEntidad.getSelectedRow() != -1) {
            numeroSeleccion = sorter.convertRowIndexToModel(tblEntidad.getSelectedRow());
             entidad= new Entidad();
            System.out.print(cmbFiltroEntidad.getSelectedIndex()+"index cmb");
            if (cmbFiltroEntidad.getSelectedIndex()==Constantes.PROVEEDOR_INT) {
                entidad.setTipoEntidad(Constantes.PROVEEDOR_INT);
            } else if (cmbFiltroEntidad.getSelectedIndex()==Constantes.CLIENTE_INT) {
                entidad.setTipoEntidad(Constantes.CLIENTE_INT);

            } else if (cmbFiltroEntidad.getSelectedIndex()==Constantes.ASOCIADO_INT) {
                entidad.setTipoEntidad(Constantes.ASOCIADO_INT);
            }
            int id = (int) tblEntidad.getModel().getValueAt(fila, 0);
            setSelecciono(true);
            entidad.setId(id);
        }else {
                JOptionPane.showMessageDialog(this, "Seleccione una fila");
                setSelecciono(false);
            }
           
            this.dispose();
    }
    private void tblEntidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEntidadMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==2) {
            // hizo doble clik con el mouse 
            getEntidadDeJTable();
        }
       
    }//GEN-LAST:event_tblEntidadMouseClicked

    private void tblEntidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEntidadKeyPressed
        if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER ) {
            getEntidadDeJTable();
        }
    }//GEN-LAST:event_tblEntidadKeyPressed

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
            java.util.logging.Logger.getLogger(GUIgestorEntidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIgestorEntidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIgestorEntidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIgestorEntidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIgestorEntidades dialog = new GUIgestorEntidades(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonIpod btnCancelar1;
    private org.edisoncor.gui.button.ButtonIpod btnNuevoEntidad;
    private javax.swing.JComboBox cmbFiltroEntidad;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.panel.Panel panelEntidad;
    private javax.swing.JTable tblEntidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtRazonSocial;
    // End of variables declaration//GEN-END:variables
}
