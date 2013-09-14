/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.vista;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Asociado;
import co.tecnomati.java.controlcaja.modelo.ModeloAsociado;
import co.tecnomati.java.controlcaja.dominio.dao.imp.AsociadoDaoImp;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Joel
 */
public class GUIGestorAsociado extends javax.swing.JDialog {
    int numeroSeleccion;
    Asociado asociado;
    ModeloAsociado modeloasociado ;
    boolean agregado = false;

    public boolean isAgregado() {
        return agregado;
    }

    public void setAgregado(boolean agregado) {
        this.agregado = agregado;
    }
    
    
    private  TableRowSorter sorter;
    GUIGestorAsociado parent;
    //private final JTextField tipoPersona;
    //private final Strng qPersonas;
    public Asociado getAsociado() {
        return asociado;
    }
    public void setAsociado(Asociado asociado) {
        this.asociado = asociado;
    }
    /**
     * Creates new form GUIGestorAsociado
     */
    public GUIGestorAsociado(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        this.setTitle(Constantes.NAME_GESTOR_ASOCIADO);
        inicializarTabla();
//        this.parent = parent;//Estoy creando una variable global, le asigno el parent 
        this.setLocationRelativeTo(null);
        this.setVisible(true);
}

    public void inicializarTabla(){
        modeloasociado = new ModeloAsociado();
        sorter = new TableRowSorter(modeloasociado);
        tblAsociado.setModel(modeloasociado);  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAsociado = new javax.swing.JTable();
        btnCancelar = new org.edisoncor.gui.button.ButtonIpod();
        btnNuevo = new org.edisoncor.gui.button.ButtonIpod();
        btnEditar = new org.edisoncor.gui.button.ButtonIpod();
        btnSeleccionar = new org.edisoncor.gui.button.ButtonIpod();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblAsociado.setBackground(new java.awt.Color(204, 204, 204));
        tblAsociado.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        tblAsociado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "LEGAJO", "CUIT", "NOMBRE", "FECHA INGRESO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAsociado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAsociadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAsociado);
        tblAsociado.getColumnModel().getColumn(1).setMinWidth(20);
        tblAsociado.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblAsociado.getColumnModel().getColumn(1).setMaxWidth(20);
        tblAsociado.getColumnModel().getColumn(3).setMinWidth(20);
        tblAsociado.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblAsociado.getColumnModel().getColumn(3).setMaxWidth(20);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
       GUIAsociados nuevoAsociado = new GUIAsociados(null, true);
        if (nuevoAsociado.isAgregado()) {
            inicializarTabla();
        }
       
      
        


    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

         if (tblAsociado.getSelectedRow() != -1) {
            numeroSeleccion = sorter.convertRowIndexToModel(tblAsociado.getSelectedRow());
            asociado = modeloasociado.getAsociado(numeroSeleccion);
            // abrir el formulario alta de persona para editar los datos de persona
            GUIAsociados modificarPersona = new GUIAsociados(null, true, asociado);
            // actulizar la tabla con los datos modificados
             if (modificarPersona.isAgregado()) {
                 inicializarTabla();
             }
           
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
       }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblAsociadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAsociadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAsociadoMouseClicked

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        
        if (tblAsociado.getSelectedRow() != -1) {
            numeroSeleccion = sorter.convertRowIndexToModel(tblAsociado.getSelectedRow());
            asociado = modeloasociado.getAsociado(numeroSeleccion);
            setAgregado(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }
        
    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(GUIGestorAsociado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIGestorAsociado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIGestorAsociado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIGestorAsociado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //GestorAsociado dialog = new GUIGestorAsociado(asociado, parent, rootPaneCheckingEnabled);
                GUIGestorAsociado dialog = new GUIGestorAsociado(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonIpod btnEditar;
    private org.edisoncor.gui.button.ButtonIpod btnNuevo;
    private org.edisoncor.gui.button.ButtonIpod btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tblAsociado;
    // End of variables declaration//GEN-END:variables
}
