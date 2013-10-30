/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.util;

import co.tecnomati.java.controlcaja.cons.Constantes;
import co.tecnomati.java.controlcaja.dominio.Comprobante;
import co.tecnomati.java.controlcaja.reporte.jrdatasource.ModeloReciboJRDataSource;
import co.tecnomati.java.controlcaja.reporte.jrdatasource.RboAnticipoRetornoDataSource;
import co.tecnomati.java.controlcaja.reporte.jrdatasource.RboDistribucionExcedentesDataSource;
import co.tecnomati.java.controlcaja.reporte.jrdatasource.RboIntegCuotaSocialJRDataSource;
import co.tecnomati.java.controlcaja.reporte.jrdatasource.RboReembolsoCuotaSocial;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author joel
 */
public class Impresora {
    private Comprobante comprobante;
    private  int tipoComprobante ;
    private RenderedImage image;
    //public final String logo="co/tecnomati/java/controlcaja/imagen/logo.jpg";
    public final String logo="co/tecnomati/java/controlcaja/reporte/logo.jpg";
  
    
    /**
     * 
     * @param comprobante representa uno de los 5 recibos a imprimir
     * @param tipo es el tipo de comprobante ej: recibo de pago, recibo anticipo retorno.....
     */
    public Impresora(Comprobante comprobante) {
        this.comprobante = comprobante;
        this.tipoComprobante= comprobante.getTipocomprobante().getCodigo();
    }
   
      public void imprimirReciboReembolsoCuotaSociales() {
        
       //String logotipo = "co/tecnomati/java/controlcaja/imagen/1.jpg";
       //Image img = new ImageIcon(getClass().getResource("/co/tecnomati/java/controlcaja/imagen/iconTecnomatica.png")).getImage();
          
       // creo el objeto  asitencia     
     
       //Map<String,java.awt.Image> parametros = new HashMap<String,java.awt.Image>();
//        parametros.put("logo", img);
          Map parametros = new HashMap();

        RboReembolsoCuotaSocial dataSource = new RboReembolsoCuotaSocial();
        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);
        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
            parametros.put("logo", this.getClass().getResourceAsStream(logo));
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream
                    ("co/tecnomati/java/controlcaja/reporte/RboReembolsoCuotasSociales.jasper"), (Map) parametros, dataSource);

            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            // esto es para la vista previa
            JDialog reporte = new JDialog();
            reporte.setSize(1250, 700);
            reporte.setLocationRelativeTo(null);
            reporte.setModal(true);
            reporte.setTitle("VISTA PREVIA");
            JRViewer jv = new JRViewer(jPrintt);
            reporte.getContentPane().add(jv);
            reporte.setVisible(true);
            //JasperPrintManager.printReport(jPrintt, true);
            
            
            //JasperPrintManager.printReport(jPrintt, true);

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }

    }

    public void imprimirReciboIntegracionDeCuota() {
        Map parametros = new HashMap();
        //String logotipo = "/images/1.jpg";
        RboIntegCuotaSocialJRDataSource dataSource = new RboIntegCuotaSocialJRDataSource();

        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);

        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
           parametros.put("logo", this.getClass().getResourceAsStream(logo));
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboIntegracionCuotas.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JDialog reporte = new JDialog();
            reporte.setSize(1250, 700);
            reporte.setLocationRelativeTo(null);
            reporte.setModal(true);
            reporte.setTitle("VISTA PREVIA");
            JRViewer jv = new JRViewer(jPrintt);
            reporte.getContentPane().add(jv);
            reporte.setVisible(true);
            //JasperPrintManager.printReport(jPrintt, true);

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }
    }

    public void imprimirReciboAnticipoDeRetorno() {
        Map parametros = new HashMap();
        //String logotipo = "/images/1.jpg";
        RboAnticipoRetornoDataSource dataSource = new RboAnticipoRetornoDataSource();

        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);

        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
           parametros.put("logo", this.getClass().getResourceAsStream(logo));
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboAnticipoRetorno.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JDialog reporte = new JDialog();
            reporte.setSize(1250, 700);
            reporte.setLocationRelativeTo(null);
            reporte.setModal(true);
            reporte.setTitle("VISTA PREVIA");
            JRViewer jv = new JRViewer(jPrintt);
            reporte.getContentPane().add(jv);
            reporte.setVisible(true);
            //JasperPrintManager.printReport(jPrintt, true);

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }
    }

    public void imprimirReciboDistribucionDeExcedentes() {
        
        Map parametros = new HashMap();
        //String logotipo = "/images/1.jpg";
        RboDistribucionExcedentesDataSource dataSource = new RboDistribucionExcedentesDataSource();

        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);

        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
           parametros.put("logo", this.getClass().getResourceAsStream(logo));
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboDistribucionExcedentes.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JDialog reporte = new JDialog();
            reporte.setSize(1250, 700);
            reporte.setLocationRelativeTo(null);
            reporte.setModal(true);
            reporte.setTitle("VISTA PREVIA");
            JRViewer jv = new JRViewer(jPrintt);
            reporte.getContentPane().add(jv);
            reporte.setVisible(true);
            //JasperPrintManager.printReport(jPrintt, true);

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }

    }

    public void imprimirReciboDePago() {
        
        Map parametros = new HashMap();
      // String logotipo = "co/tecnomati/java/controlcaja/imagen/1.jpg";
        //  Image img = new ImageIcon(getClass().getResource("/co/tecnomati/java/controlcaja/imagen/iconTecnomatica.png")).getImage();
          // Map<String,java.awt.Image> parametros = new HashMap<String,java.awt.Image>();
//        parametros.put("logo", img);
        
        ModeloReciboJRDataSource dataSource = new ModeloReciboJRDataSource();

        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);

        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
             parametros.put("logo", this.getClass().getResourceAsStream(logo));
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboDePago.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JDialog reporte = new JDialog();
            reporte.setSize(1250, 700);
            reporte.setLocationRelativeTo(null);
            reporte.setModal(true);
            reporte.setTitle("VISTA PREVIA");
            JRViewer jv = new JRViewer(jPrintt);
            reporte.getContentPane().add(jv);
            reporte.setVisible(true);
            //JasperPrintManager.printReport(jPrintt, true);

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }


    }

    /**
     * Controlador 
     * metodo que en funcion del tipo de comprobante realiza la impresiondeterminado comprobante
     */
    
    public void Imprimir() {
        switch (tipoComprobante) {

            case Constantes.CODIGO_RECIBO_ANTICIPO_RETORNO:
                
                imprimirReciboAnticipoDeRetorno();
               System.out.print("RECIBO ANICIPO RETORNO");

                break;
            case Constantes.CODIGO_RECIBO_PAGO:
                System.out.print("RECIBO DE PAGO");
                imprimirReciboDePago();
                break;
            case Constantes.CODIGO_RECIBO_DISTRIBUCION_EXCEDENTE:
                imprimirReciboDistribucionDeExcedentes();
                System.out.print("RECIBO DISTRIBUCIONDE EXCEDENTES");
                break;
            case Constantes.CODIGO_RECIBO_INTEGRACION_CUOTA:
                imprimirReciboIntegracionDeCuota();
                System.out.print("RECIBO INTEGRACION DE CUOTA");
                break;
            case Constantes.CODIGO_RECIBO_REEMBOLSO_CUOTA_SOCIALES:
                imprimirReciboReembolsoCuotaSociales();
                System.out.print("RECIBO REEMBOLSO DE CUOTA SOCIALES");
                break;
        }
    }
    
      // esto es para la vista previa
//            JDialog reporte = new JDialog();
//            reporte.setSize(900, 700);
//            reporte.setLocationRelativeTo(null);
//            reporte.setModal(true);
//            reporte.setTitle("INFORME");
//            JRViewer jv = new JRViewer(jPrintt);
//            reporte.getContentPane().add(jv);
//            reporte.setVisible(true);
  
    
    
}
