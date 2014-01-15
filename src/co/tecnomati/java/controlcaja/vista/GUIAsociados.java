/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.vista;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
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
public class GUIAsociados extends javax.swing.JDialog {

    private boolean modificar = false;
    Asociado asociado;
    boolean agregado = false;

    /**
     * Creates new form GUIAsociados
     */
    public GUIAsociados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle(Constantes.NAME_NUEVO_ASOCIADO);
        // nuevo asociado 
        asociado = new Asociado();
        txtLegajo.setText(new AsociadoDaoImp().getLastID()+1+"");
        SNumeros(txtCuit);
        //SNumeros(txtTelefono);
        SNumeros(txtDNI);
        SLetras(txtApellido);
        SLetras(txtNombre);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

  /**
   *  Constructor usado para editar los datos de un asociado
   * @param parent
   * @param modal
   * @param asociado  objeto a editar 
   */    
    public GUIAsociados(java.awt.Frame parent, boolean modal, Asociado asociado) {

        super(parent, modal);
        initComponents();
        this.asociado = asociado;
        // se indica que se utiliza este formulario para modificar datos
        modificar = true;
        this.setTitle(Constantes.NAME_EDITAR_ASOCIADO);
        
        setDatosaFormulario();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    /**
     * Recibe el objeto (Asociado) y lo muestra en la vista 
     */ 
    private void setDatosaFormulario(){
        txtLegajo.setText(String.valueOf(asociado.getLegajo()));
        txtCuit.setText(String.valueOf(asociado.getCuit()));
        txtDNI.setText(String.valueOf(asociado.getDni()));
        txtApellido.setText(asociado.getApellido());
        txtNombre.setText(asociado.getNombre());
        txtTelefono.setText(asociado.getTelefono());
        dateIngreso.setDate(asociado.getIngreso());

}
    
    /**
     * obtiene los datos de la vista y lo guarda en el objeto (Asociado)
     */
    private void getDatosaFormulario() {
                  
        asociado.setCuit(txtCuit.getText());
        asociado.setDni(Integer.valueOf(txtDNI.getText()));
        asociado.setApellido(txtApellido.getText());
        asociado.setNombre(txtNombre.getText());
        asociado.setIngreso(dateIngreso.getDate());
        asociado.setTelefono(txtTelefono.getText());
        asociado.setLegajo(Integer.parseInt(txtLegajo.getText())); 
        
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
        jPanel1 = new javax.swing.JPanel();
        txtCuit = new javax.swing.JFormattedTextField();
        labelTelefono = new org.edisoncor.gui.label.LabelMetric();
        txtDNI = new org.edisoncor.gui.textField.TextField();
        labelDni = new org.edisoncor.gui.label.LabelMetric();
        txtTelefono = new org.edisoncor.gui.textField.TextField();
        labelFechaIngreso = new org.edisoncor.gui.label.LabelMetric();
        labelLegajo = new org.edisoncor.gui.label.LabelMetric();
        txtLegajo = new org.edisoncor.gui.textField.TextField();
        labelNombres = new org.edisoncor.gui.label.LabelMetric();
        labelCuit = new org.edisoncor.gui.label.LabelMetric();
        Apellido2 = new org.edisoncor.gui.label.LabelMetric();
        txtApellido = new org.edisoncor.gui.textField.TextField();
        txtNombre = new org.edisoncor.gui.textField.TextField();
        dateIngreso = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asociado");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", 0, 0, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setOpaque(false);

        txtCuit.setBackground(new java.awt.Color(204, 204, 204));
        try {
            txtCuit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCuit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        labelTelefono.setText("TELEFONO");
        labelTelefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        txtDNI.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        labelDni.setText("D.N.I.");
        labelDni.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        labelFechaIngreso.setText("FECHA INGRESO");
        labelFechaIngreso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        labelLegajo.setText("LEGAJO");
        labelLegajo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        txtLegajo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtLegajo.setEnabled(false);
        txtLegajo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtLegajo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLegajoKeyTyped(evt);
            }
        });

        labelNombres.setText("NOMBRES");
        labelNombres.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        labelCuit.setText("CUIT");
        labelCuit.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        Apellido2.setText("APELLIDO");
        Apellido2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        dateIngreso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelNombres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Apellido2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelFechaIngreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLegajo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCuit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setOpaque(false);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/tecnomati/java/controlcaja/imagen/GUARDAR.jpg"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/tecnomati/java/controlcaja/imagen/Atras.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

   /**
    * ESte metodo verifica si  un campo obligatorio esta o no vacio 
    * @return true si existe un campo vacio , ademas muestra un mensaje del primer elemento que encuentre vacio.
    *         false si todos los campos se completaron
    */
    public boolean isCamposVacios() {
        boolean vacio = true;
        boolean cCuit, cA, cN, cT, cDni = false;
        cCuit = txtCuit.getText().replaceAll("[.-]", "").trim().isEmpty();
        cA = txtApellido.getText().trim().isEmpty();
        cN = txtNombre.getText().trim().isEmpty();
        cT = txtTelefono.getText().trim().isEmpty();
        cDni = txtDNI.getText().trim().isEmpty();
        vacio = (cCuit || cA || cT || cN || cDni);
        //corroboro que no este vacio
        if (vacio) {
            if (cCuit) {
                mensajero.mensajeError(null, "Tipo cuit no puede estar vacio");
            } else if (cA) {
                mensajero.mensajeError(null, "Apellido no puede estar vacio");
            } else if (cN) {
                mensajero.mensajeError(null, "Nombre no puede estar vacio");
            } else if (cT) {
                mensajero.mensajeError(null, "telefono no puede estar vacio");
            } else if (cDni) {
                mensajero.mensajeError(null, "dni no puede estar vacio");
            }

        }
        return vacio;
    }

   /**
    * Caundo hace click en el boton guardar
    * @param evt 
    */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      try{
        if (!isCamposVacios()) {
            //obtengo los datos del formulario y lo guardo en un objeto
            getDatosaFormulario();
        
           if (modificar == false) {
             new AsociadoDaoImp().addAsociado(asociado);
           } else {
             //se carga un proveedor para editarlo
             new AsociadoDaoImp().upDateAsociado(asociado);
        }
        setAgregado(true);
        JOptionPane.showMessageDialog(null, "Se cargo correctamente...");
        this.dispose();
        }
      }catch(org.hibernate.exception.ConstraintViolationException e){
//          http://cursohibernate.es/doku.php?id=unidades:06_objetos_validaciones:03_columna_unica
          
           mensajero.mensajeError(null, "El legajo o Cuil de la persona ya existe, por favor revise");
      }
        
//          
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        MyUtil.consumirLetras(evt, txtDNI, 8);
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtLegajoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLegajoKeyTyped
        MyUtil.consumirLetras(evt, txtLegajo, 3);
    }//GEN-LAST:event_txtLegajoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
                                                   
        //MyUtil.consumirLetras(evt, txtTelefono, 14);
        if (txtTelefono.getText().length() == 14) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        
        //MyUtil.consumirLetras(evt, txtApellido, 8);
        SLetras(txtApellido);
        if (txtApellido.getText().length() == 15) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        //MyUtil.consumirLetras(evt, txtNombre, 8);
        SLetras(txtNombre);
        if (txtNombre.getText().length() == 16) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

        public void SLetras(JTextField a){
            a.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent v){
            char c=v.getKeyChar();
            if (Character.isDigit(c)&& c!='\b'){
                getToolkit().beep();
             //   JOptionPane.showMessageDialog(null, "Ingrese solo Letras...");
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
          //      JOptionPane.showMessageDialog(null, "Ingrese solo Nùmeros...");
                v.consume();
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
            java.util.logging.Logger.getLogger(GUIAsociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAsociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAsociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAsociados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIAsociados dialog = new GUIAsociados(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.label.LabelMetric Apellido2;
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnGuardar;
    private com.toedter.calendar.JDateChooser dateIngreso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private org.edisoncor.gui.label.LabelMetric labelCuit;
    private org.edisoncor.gui.label.LabelMetric labelDni;
    private org.edisoncor.gui.label.LabelMetric labelFechaIngreso;
    private org.edisoncor.gui.label.LabelMetric labelLegajo;
    private org.edisoncor.gui.label.LabelMetric labelNombres;
    private org.edisoncor.gui.label.LabelMetric labelTelefono;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.textField.TextField txtApellido;
    private javax.swing.JFormattedTextField txtCuit;
    private org.edisoncor.gui.textField.TextField txtDNI;
    private org.edisoncor.gui.textField.TextField txtLegajo;
    private org.edisoncor.gui.textField.TextField txtNombre;
    private org.edisoncor.gui.textField.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
