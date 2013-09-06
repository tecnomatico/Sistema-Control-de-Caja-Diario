
package vista.novedades;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
 
import com.lowagie.text.Anchor;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.Table;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
 
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
 
import com.lowagie.text.Image;
 
import java.sql.*;
 
public class GenerarPDFEmpleados
{
    private String strNombreDelPDF;
 
    private  Font fuenteNegra10 = new Font(Font.TIMES_ROMAN, 10, Font.BOLD, Color.BLACK);
    private  Font fuente8 = new Font(Font.TIMES_ROMAN, 8, Font.NORMAL, Color.BLACK);
    private  Font fuenteAzul25 = new Font(Font.TIMES_ROMAN, 25, Font.BOLD, Color.BLUE);
 
    Color grisClaro = new Color( 230,230,230);  
    Color azulClaro = new Color( 124,195,255 );
 
    //############# VARIABLES PARA MANEJO DE BASE DE DATOS ########################
    //Guarda la consulta operacion a realizar
    String strConsultaSQL;
    //Apuntador a la conexion
    Connection conn = null; 
    //Para ejecutar operaciones SQL
    Statement estSQL1;
    //Para guardar los resultados de una operacion SELECT
    ResultSet rs;
    Document document;
    PdfWriter writer;
    String strRotuloPDF;
     
    //Metodo principal del ejemplo
    public GenerarPDFEmpleados(String titulo, String nomPDF)
    {
        strRotuloPDF = titulo;
        strNombreDelPDF = nomPDF;
        try
        {       //Hoja tamanio carta, rotarla (cambiar a horizontal)
            document = new Document( PageSize.LETTER.rotate() );
             
            writer = PdfWriter.getInstance(
            // that listens to the document
                    document,
                    // direccionar el PDF-stream a un archivo
                    new FileOutputStream(strNombreDelPDF));
            document.open();
 
            agregarMetaDatos(document);
            agregarContenido(document);
             
            document.close();
             
            System.out.println("Se ha generado el PDF: "+ strNombreDelPDF);
                 
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
     
    //agrega el contenido del documento; para este ejemplo agrega una tabla con datos y una imagen
    //Espera como entrada el documento donde agregara el contenido
    private void agregarContenido(Document document) throws DocumentException
    {
        Paragraph ParrafoHoja = new Paragraph();
                 
        // Agregamos una linea en blanco al principio del documento
        agregarLineasEnBlanco(ParrafoHoja, 1);
        // Colocar un encabezado (en mayusculas)
        ParrafoHoja.add(new Paragraph(strRotuloPDF.toUpperCase (), fuenteAzul25) );
        agregarLineasEnBlanco(ParrafoHoja, 1);
        // 1.- AGREGAMOS LA TABLA
        agregarTabla(ParrafoHoja);
        //Agregar 2 lineas en blanco
        agregarLineasEnBlanco(ParrafoHoja, 2);
        // 2.- AGREGAMOS LA IMAGEN
        try
        {
            Image im = Image.getInstance("logo_mysql.gif");
            im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP );
            im.setWidthPercentage (50);
          ParrafoHoja.add(im);
        }
        catch(Exception e)
        {
            e.printStackTrace ();
        }
         
        document.add(ParrafoHoja);
 
    }
 
    //Se conecta al DBMS MySQL , obtiene los datos de la tabla (SELECT) y los acomoda en una tabla JTable de iText.
    // Espera como entrada el parrafo donde agregara la tabla
    private void agregarTabla(Paragraph parrafo) throws BadElementException 
    {
        //Anchos de las columnas
        float anchosFilas[] = { 0.2f,1f,1f,0.5f,0.5f,0.3f,1f,1.5f,0.7f };
        PdfPTable tabla = new PdfPTable(anchosFilas);
        String rotulosColumnas[] = {"id","Nombre","Apellidos","Sexo","Telefono","Edad","Correo","Direccion","Fecha\nContratacion"};
        // Porcentaje que ocupa a lo ancho de la pagina del PDF
        tabla.setWidthPercentage(100);
        //Alineacion horizontal centrada
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        //agregar celda que ocupa las 9 columnas de los rotulos
        PdfPCell cell = new PdfPCell(new Paragraph("Tabla: Empleados"));
        cell.setColspan(9);
        //Centrar contenido de celda
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        //Color de fondo de la celda
        cell.setBackgroundColor (azulClaro);        
        tabla.addCell(cell);
 
        try
        {
            if ( ConectarBD() )
            {
                // Mostrar los rotulos de las columnas
                for(int i=0; i<rotulosColumnas.length; i++)
                {
                    cell = new PdfPCell(new Paragraph(rotulosColumnas[i],fuenteNegra10));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor (grisClaro);
                    tabla.addCell(cell);
                }
                 
                //Consultar la tabla empleados
                strConsultaSQL = "SELECT * FROM empleados";
                //ejecutar consulta
                rs = estSQL1.executeQuery(strConsultaSQL);
 
                //Iterar Mientras haya una fila siguiente
            while (rs.next())
            {           //Agregar 9 celdas
                    cell = new PdfPCell(new Paragraph(String.valueOf(rs.getInt ("idEmpleado")),fuente8 ));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("nombre"),fuente8));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("apellidos"),fuente8));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("sexo"),fuente8));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("telefono"),fuente8));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(String.valueOf(rs.getInt("edad")),fuente8) );
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("correo"),fuente8));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getString("direccion"),fuente8));
                    tabla.addCell(cell);
                    cell = new PdfPCell(new Paragraph(rs.getDate("fechaContratacion").toString (),fuente8 ) );
                    tabla.addCell(cell);
            }
             
                //Cerrar los objetos de manejo de BD
                CrearConexion.cerrar(rs);           //ResultSet
                CrearConexion.cerrar(estSQL1);  //Statement
                CrearConexion.cerrar(conn);     //Connection
            }       //Fin de if que comprueba si se pudo conectar
             
        }
        catch(Exception e) 
        {
            System.out.println("Excepcion al ejecutar CONSULTA!!!");
            //Mostrar la traza de la pila
            e.printStackTrace();
        }
        //Agregar la tabla con los datos al parrafo que nos llego como entrada
        parrafo.add(tabla);
    }  //Fin del metodo que crea la tabla
 
    //Agrega las lineas en blanco  especificadas a un parrafo especificado
    private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas) 
    {
        for (int i = 0; i < nLineas; i++) 
            parrafo.add(new Paragraph(" "));
    }
     
    //Agrega los metadatos del documento, los metadatos a asignar son
    //Titulo, Asunto, Palabras clave, Autor y el sw o org con el cual fue generado
    private static void agregarMetaDatos(Document document)
    {
        document.addTitle("Documento con datos de tabla MySQL");
        document.addSubject("Usando iText y MySQL");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Gonzalo Silverio");
        document.addCreator("http://gonzasilve.wordpress.com");
    }
 
    //devuelve true en caso de que si se pudo conectar
    //devuelve false sino se logro conectar
    public boolean ConectarBD() throws Exception
    {
        try
        {       
                //Aqui se instancia a la otra clase --> CrearConexion.java               
                //y se le mandan en el constructor los datos de conexion
                CrearConexion con  = new CrearConexion("root","root","prueba");
                //Obtiene una referencia a la conexion abierta
                conn = con.getConnection();
             
            //Comprobar si hay una refencia valida
            if(conn!=null)
            {
                    //Mostrar MSG al usuario de la conexion se ha establecido
                    System.out.println("Conexion establecida");
                    //Se prepara para ejecutar sentencias en la conexion recien abierta
                estSQL1 = conn.createStatement();
                    return true;
            }
            else
                return false;
                 
         }
        catch (SQLException e)
        {
             
          // the above drop statements will throw exceptions
          // if the types and tables did not exist before. Just ingore it.
          System.out.println("Error en la conexion!!!");
          e.printStackTrace();
          return false;
        }
                 
    }
     
    //Abre el documento PDF
    public void abrirPDF()
    {
        /* Abrir el archivo PDF */
        try
        {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + strNombreDelPDF);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }   
    }   
}/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.novedades;

/**
 *
 * @author usuario
 */
public class GenerarPDFEmpleados {
    
}
