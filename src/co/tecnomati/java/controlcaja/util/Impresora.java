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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

/**
 *
 * @author joel
 */
public class Impresora {
    private Comprobante comprobante;
    private  int tipoComprobante ;
  
    
    /**
     * 
     * @param comprobante representa uno de los 5 recibos a imprimir
     * @param tipo es el tipo de comprobante ej: recibo de pago, recibo anticipo retorno.....
     */
    public Impresora(Comprobante comprobante, int tipo) {
        this.comprobante = comprobante;
        this.tipoComprobante= tipo;
    }
   
      public void imprimirReciboReembolsoCuotaSociales() {
        Map parametros = new HashMap();
        String logotipo = "/images/1.jpg";
        RboReembolsoCuotaSocial dataSource = new RboReembolsoCuotaSocial();
        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);
        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboReembolsoCuotasSociales.jasper"), (Map) parametros, dataSource);

            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JasperPrintManager.printReport(jPrintt, true);

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }

    }

    public void imprimirReciboIntegracionDeCuota() {
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

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }
    }

    public void imprimirReciboAnticipoDeRetorno() {
        Map parametros = new HashMap();
        String logotipo = "/images/1.jpg";
        RboAnticipoRetornoDataSource dataSource = new RboAnticipoRetornoDataSource();

        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);

        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboAnticipoRetorno.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JasperPrintManager.printReport(jPrintt, true);

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }
    }

    public void imprimirReciboDistribucionDeExcedentes() {
        
        Map parametros = new HashMap();
        String logotipo = "/images/1.jpg";
        RboDistribucionExcedentesDataSource dataSource = new RboDistribucionExcedentesDataSource();

        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);

        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboDistribucionExcedentes.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JasperPrintManager.printReport(jPrintt, true);

        } catch (JRException ex) {
            mensajero.mensajeError(null, "Error de Impresion");
        }

    }

    public void imprimirReciboDePago() {
        Map parametros = new HashMap();
        String logotipo = "/images/1.jpg";
        ModeloReciboJRDataSource dataSource = new ModeloReciboJRDataSource();

        List<Comprobante> lista = new ArrayList<Comprobante>();
        lista.add(comprobante);

        dataSource.setListComprobante(lista);
        JasperPrint jPrintt;
        try {
            jPrintt = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("co/tecnomati/java/controlcaja/reporte/RboDePago.jasper"), (Map) parametros, dataSource);
            // este metodo imprime el reporte , recibe el jprint(el informe, ) y el otro parametro es para decirle que muestre la pantalla de configuracion de la impresora
            // si es false imprime de una con la configuarcion por defecto.
            JasperPrintManager.printReport(jPrintt, true);

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
