/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.tecnomati.java.controlcaja.util;

/**
 *
 * @author Cmop
 */
import java.awt.Component;
import javax.swing.JOptionPane;

public class mensajero extends JOptionPane{
   public static final String NOMBRE_SISTEMA = "Gestor de Caja";
   public static final String ACCION_ALTA = "ALTA";
   public static final String ACCION_BAJA = "BAJA";
   public static final String ACCION_ACTUALIZACION = "ACTUALIZACION";
   public static final String OPERACION_OK = "LA OPERACION SE REALIZO EXITOSAMENTE";
    public static void mensajeError(Component padre,String mensaje)
    {
        JOptionPane.showMessageDialog(padre,mensaje,NOMBRE_SISTEMA,JOptionPane.ERROR_MESSAGE);
    }
    public static void mensajeInformacionAtualizacionOK(Component padre){
        JOptionPane.showMessageDialog(padre,OPERACION_OK,ACCION_ACTUALIZACION,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mensajeInformacionBajaOK(Component padre){
        JOptionPane.showMessageDialog(padre,OPERACION_OK,ACCION_BAJA,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mensajeInformacionAltaOK(Component padre){
        JOptionPane.showMessageDialog(padre,OPERACION_OK,ACCION_ALTA,JOptionPane.INFORMATION_MESSAGE);
    }
}
