/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.vista;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Proveedor;
import co.tecnomati.java.controlcaja.dominio.dao.ProveedorDAO;
import co.tecnomati.java.controlcaja.dominio.dao.imp.ProveedorDaoImp;
import co.tecnomati.java.controlcaja.util.MyUtil;
import co.tecnomati.java.controlcaja.util.mensajero;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author AnahiAramayo
 */
public class GUIProveedor extends javax.swing.JDialog {

    private boolean modificar;
    Proveedor proveedor = null;
   // ProveedorDAO proveedorDAO = new ProveedorDaoImp();
    
    boolean agregado = false;

    public GUIProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        modificar = false;
        proveedor = new Proveedor();
        this.setTitle(Constantes.NAME_NUEVO_PROVEEDOR);
        SNumeros(txtCuit);
        //SNumeros(txtTelefono);
        //SLetras(txtDomicilio);
        //SLetras(txtRazonSocial);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public GUIProveedor(java.awt.Frame parent, boolean modal, Proveedor proveedor) {
        super(parent, modal);
        initComponents();
        this.proveedor = proveedor;
        modificar = true;
        this.setTitle(Constantes.NAME_NUEVO_PROVEEDOR);
        setDatos(proveedor);
        SNumeros(txtCuit);
       // SNumeros(txtTelefono);
        //SLetras(txtDomicilio);
      //  SLetras(txtRazonSocial);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public boolean isAgregado() {
        return agregado;
    }

    public void setAgregado(boolean agregado) {
        this.agregado = agregado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        btnGuardar = new org.edisoncor.gui.button.ButtonIpod();
        jPanel2 = new javax.swing.JPanel();
        labelCuit = new org.edisoncor.gui.label.LabelMetric();
        txtCuit = new javax.swing.JFormattedTextField();
        txtRazonSocial = new org.edisoncor.gui.textField.TextField();
        labelRazonSocial = new org.edisoncor.gui.label.LabelMetric();
        labelRazonSocial1 = new org.edisoncor.gui.label.LabelMetric();
        txtDomicilio = new org.edisoncor.gui.textField.TextField();
        txtTelefono = new org.edisoncor.gui.textField.TextField();
        labelRazonSocial2 = new org.edisoncor.gui.label.LabelMetric();
        labelRazonSocial3 = new org.edisoncor.gui.label.LabelMetric();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(255, 255, 255)));
        jPanel1.setOpaque(false);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/tecnomati/java/controlcaja/imagen/Atras.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/tecnomati/java/controlcaja/imagen/GUARDAR.jpg"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales del Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setOpaque(false);

        labelCuit.setText("CUIT");

        txtCuit.setBackground(new java.awt.Color(204, 204, 204));
        try {
            txtCuit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCuit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCuit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCuitKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuitKeyTyped(evt);
            }
        });

        txtRazonSocial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        labelRazonSocial.setText("Razon Social    *");

        labelRazonSocial1.setText("Domicilio");

        txtDomicilio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        labelRazonSocial2.setText("Telefono");

        labelRazonSocial3.setText("(*) Datos Obligatorios");
        labelRazonSocial3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelRazonSocial1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelRazonSocial2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDomicilio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(labelCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelRazonSocial3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRazonSocial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRazonSocial2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelRazonSocial3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        boolean b = false;   
        if (modificar == false) {
           //si se ingresa un nueva persona
           proveedor = new Proveedor();    
        }
        ProveedorDAO proveedorDAO = new ProveedorDaoImp();
     try {
         boolean cA, cRS, cD, cT = false;
            cA = txtCuit.getText().replaceAll("[.-]", "").trim().isEmpty();
            cRS = txtRazonSocial.getText().trim().isEmpty();
            cD = txtDomicilio.getText().trim().isEmpty();
            cT = txtTelefono.getText().trim().isEmpty();
            //corroboro que no este vacio
//            if (cA || cRS || cT || cD) {
            if ( cRS ) {
               if (cA) {
//                mensajero.mensajeError(null, "Tipo cuit no puede estar vacio");
//                  txtCuit.setText("");
            } else if (cRS) {
                mensajero.mensajeError(null, "razon no puede estar vacio");
            } else if (cD) {
                mensajero.mensajeError(null, "domicilio no puede estar vacio");
            } else if (cT) {
                mensajero.mensajeError(null, "telefono no puede estar vacio");
            } 
        } else {
           
            proveedor.setCuit(txtCuit.getText());
            proveedor.setRazonSocial(txtRazonSocial.getText().toUpperCase());
            proveedor.setDomicilio(txtDomicilio.getText().toUpperCase());
            proveedor.setTelefono(txtTelefono.getText().toUpperCase());
            setAgregado(true);
            
            
            //se crea un proveedor nuevo
            if (modificar == false) {
                proveedorDAO.addProveedor(proveedor);
            } else {
                //se carga un proveedor para editarlo
                proveedorDAO.upDateProveedor(proveedor);
                
            }
            //setAgregado(true);
            JOptionPane.showMessageDialog(null, "Se cargo correctamente...");
            this.dispose();
        } }catch (NullPointerException e) {
        JOptionPane.showMessageDialog(null, "Debes completar todos los campos");
        modificar = false;
        this.dispose();
}
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCuitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuitKeyPressed

    }//GEN-LAST:event_txtCuitKeyPressed

    private void txtCuitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuitKeyTyped

    }//GEN-LAST:event_txtCuitKeyTyped
    /**
     * Setea el formulario con los datos de proveedor pasado por parametro
     *
     * @param proveedor es la persona que se desea que se muestre en el
     * formulario
     */
    public void setDatos(Proveedor proveedor) {
        txtCuit.setText(String.valueOf(proveedor.getCuit()));
        txtRazonSocial.setText(proveedor.getRazonSocial());
        txtDomicilio.setText(proveedor.getDomicilio());
        txtTelefono.setText(proveedor.getTelefono());
    }

    /**
     * Devuelve un objeto prooveedor a partir de los datos que existe en el
     * formulario
     *
     * @return
     */
    public void getDatos() {
        
        proveedor.setCuit(txtCuit.getText());
        proveedor.setRazonSocial(txtRazonSocial.getText());
        proveedor.setTelefono(txtTelefono.getText().trim());
        proveedor.setDomicilio(txtDomicilio.getText().trim());
        
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
            java.util.logging.Logger.getLogger(GUIProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIProveedor dialog = new GUIProveedor(new javax.swing.JFrame(), true);
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
    
            public void SLetras(JTextField a){
    a.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent v){
            char c=v.getKeyChar();
            if (Character.isDigit(c)&& c!='\b'){
                getToolkit().beep();
              // JOptionPane.showMessageDialog(null, "Solo Letras...");
                v.consume();
            }
        }
    });
            }
      public void SNumeros(JTextField a){
    a.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent v){
            char c=v.getKeyChar();
            if (!Character.isDigit(c)&& c!='\b'){
                getToolkit().beep();
               // JOptionPane.showMessageDialog(null, "Solo Nùmeros...");
                v.consume();
            }
        }
    });
            }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.edisoncor.gui.label.LabelMetric labelCuit;
    private org.edisoncor.gui.label.LabelMetric labelRazonSocial;
    private org.edisoncor.gui.label.LabelMetric labelRazonSocial1;
    private org.edisoncor.gui.label.LabelMetric labelRazonSocial2;
    private org.edisoncor.gui.label.LabelMetric labelRazonSocial3;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JFormattedTextField txtCuit;
    private org.edisoncor.gui.textField.TextField txtDomicilio;
    private org.edisoncor.gui.textField.TextField txtRazonSocial;
    private org.edisoncor.gui.textField.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
