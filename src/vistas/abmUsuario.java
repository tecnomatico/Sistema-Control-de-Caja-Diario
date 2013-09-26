/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JOptionPane;
import novedades.dao.imp.UsuarioDaoImp;
import pojo.Empleado;
import pojo.Usuario;

/**
 *
 * @author usuario
 */
public class abmUsuario extends javax.swing.JDialog {

   Usuario usuario; //  este objeto contien los datos del usuario que llenas en el formulario  para crear o modificar 
   boolean agregado= false;   // se pone en true: si se presiono el boton guardar para registrar la operacion . y False en otro caso
   boolean nuevo; // se encarga de chequear si esta pantalla se usa para agregar un nuevo usuario .. true: nuevo ..false:modificar
   
   
   /**  Este constructo lo ussas para cargar un usuario nuevo
    * 
    * @param parent
    * @param modal 
    */
   public abmUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // modifico la variable nuevo para que indiqe que se utilizara este formulario para hacer una nueva carga
        nuevo= true;
       // le damos vida al usuario
        usuario= new Usuario();
         //  centro y muesttro la pantalla
        this.setTitle("CARGA DE USUARIO");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
 /**
  *  Este constructor lo usas cuando quieras realizar una modificacion de datos  del usuario  
  * @param parent  // no les de bola  a esto
  * @param modal            " 
  * @param usuario es el usuario que queres que se modifique
  */
    
 public abmUsuario(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        // lo seteo al usuario con los datos pasados como parametro
        this.usuario = usuario; 
        // indica que este formualrio se usara para editar un usuario
        nuevo= false;
        
        //  centro y muesttro la pantalla
        this.setTitle("MODIFICACION DE USUARIO");
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

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtId = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtDescripcion = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        txtTipo = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        panelShadow1 = new org.edisoncor.gui.panel.PanelShadow();
        panelTranslucidoComplete1 = new org.edisoncor.gui.panel.PanelTranslucidoComplete();
        btnAceptar = new org.edisoncor.gui.button.ButtonIpod();
        btnNuevo = new org.edisoncor.gui.button.ButtonIpod();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        btnModificar = new org.edisoncor.gui.button.ButtonIpod();
        buttonIpod2 = new org.edisoncor.gui.button.ButtonIpod();
        txtContraseña = new org.edisoncor.gui.passwordField.PasswordFieldRoundIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 2, true), "ALTA, BAJA Y MODIFICACION DE USUARIOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 24), java.awt.Color.white)); // NOI18N
        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/textura-metallica-2.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USUARIO");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DESCRIPCION");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONTRASEÑA");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TIPO");

        txtUsuario.setBackground(new java.awt.Color(102, 102, 102));
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setCaretColor(new java.awt.Color(102, 102, 102));
        txtUsuario.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtUsuario.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        txtId.setBackground(new java.awt.Color(102, 102, 102));
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtId.setCaretColor(new java.awt.Color(102, 102, 102));
        txtId.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtId.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        txtDescripcion.setBackground(new java.awt.Color(102, 102, 102));
        txtDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        txtDescripcion.setCaretColor(new java.awt.Color(102, 102, 102));
        txtDescripcion.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtDescripcion.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        txtTipo.setBackground(new java.awt.Color(102, 102, 102));
        txtTipo.setForeground(new java.awt.Color(255, 255, 255));
        txtTipo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTipo.setCaretColor(new java.awt.Color(102, 102, 102));
        txtTipo.setColorDeBorde(new java.awt.Color(255, 102, 0));
        txtTipo.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        panelShadow1.setDistance(10);

        panelTranslucidoComplete1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTranslucidoComplete1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelTranslucidoComplete1.setOpaque(false);

        btnAceptar.setBorder(new org.edisoncor.gui.util.DropShadowBorder());
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Tick (1).png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnNuevo.setBorder(new org.edisoncor.gui.util.DropShadowBorder());
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/adduser.png"))); // NOI18N
        btnNuevo.setText("Nuevo");

        btnCancelar.setBorder(new org.edisoncor.gui.util.DropShadowBorder());
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        btnModificar.setBorder(new org.edisoncor.gui.util.DropShadowBorder());
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar.png"))); // NOI18N
        btnModificar.setText("Modificar");

        buttonIpod2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        buttonIpod2.setText("Eliminar");

        javax.swing.GroupLayout panelTranslucidoComplete1Layout = new javax.swing.GroupLayout(panelTranslucidoComplete1);
        panelTranslucidoComplete1.setLayout(panelTranslucidoComplete1Layout);
        panelTranslucidoComplete1Layout.setHorizontalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonIpod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTranslucidoComplete1Layout.setVerticalGroup(
            panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucidoComplete1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonIpod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addComponent(panelTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        txtContraseña.setBackground(new java.awt.Color(102, 102, 102));
        txtContraseña.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseña.setColorDeBorde(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(49, 49, 49)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         // guarda un usuario
              
        //le pasamos los datos objeto usuario para q contenga los datos de usuario
        usuario.setClave(txtContraseña.getText());
        usuario.setDescripcion(txtDescripcion.getText());
        usuario.setTipo(txtTipo.getText());
        usuario.setUsuario(txtUsuario.getText());
        usuario.setEmpleado(new Empleado());
        // pregunto de nuevo si se realizara la carga de un nuevo usuario entonces add
        if (nuevo) {
            new UsuarioDaoImp().addUsuario(usuario);
        } else {
            // sino es porque se esta por editar un usuario
            new UsuarioDaoImp().upDateUsuario(usuario);
        }
        // estas lineas lo ejecuta cuando todo sale bien, 
        // entonces indico que si se realizo la operacion mediante la variable booleanda agregado
        agregado= true;
        // mensajito que indica todo ok
        JOptionPane.showMessageDialog(null, "Se cargo correctamente...");
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(abmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(abmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(abmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(abmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                abmUsuario dialog = new abmUsuario(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonIpod btnAceptar;
    private org.edisoncor.gui.button.ButtonIpod btnCancelar;
    private org.edisoncor.gui.button.ButtonIpod btnModificar;
    private org.edisoncor.gui.button.ButtonIpod btnNuevo;
    private org.edisoncor.gui.button.ButtonIpod buttonIpod2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelShadow panelShadow1;
    private org.edisoncor.gui.panel.PanelTranslucidoComplete panelTranslucidoComplete1;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundIcon txtContraseña;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtDescripcion;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtId;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtTipo;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtUsuario;
    // End of variables declaration//GEN-END:variables
}
