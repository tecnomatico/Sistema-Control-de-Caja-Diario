import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
 
public class prueba extends JFrame
{
    String strTituloPDF = "INSTItuTO TEcnologico de zacatepec";
    String strNombrePDF = "pdf_tabla_Empleados.pdf";
    JTextField jtfNombrePDF;
     
    //Constructor
    prueba(String titulo, int ancho, int alto)
    {
        //Establecer titulo, tamanio y posicion en la pantalla
        super(titulo);
        setSize(ancho,alto);
        setLocationRelativeTo(null);    //centrado
        //Rotulo principal de la ventana
        JLabel lblTitulo = new JLabel("Generar un PDF desde Java");
        JPanel panTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panTitulo.add(lblTitulo);
         
        //Crea campo de texto para especificar el nombre del PDF
        JLabel lblNombrePDF = new JLabel("Nombre del documento PDF");
        jtfNombrePDF = new JTextField(30);
        jtfNombrePDF.setText(strNombrePDF);
        jtfNombrePDF.setHorizontalAlignment (JTextField.CENTER);
        JPanel panNombrePDF = new JPanel(new FlowLayout(FlowLayout.CENTER));
      panNombrePDF.add(Box.createHorizontalStrut(15));
        panNombrePDF.add(lblNombrePDF);
        panNombrePDF.add(jtfNombrePDF);
         
        //Crear el boton nuevo
        JButton btnGenerarPDF = new JButton("Generar PDF");
        JPanel panGenerarPDF = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panGenerarPDF.add(btnGenerarPDF);
 
        //Todos los componentes estan en un Box Vertical
        //la clase Box se usa para alinear los controles
        Box boxVertical = Box.createVerticalBox();
        boxVertical.add(Box.createVerticalStrut(50));
        boxVertical.add(panTitulo);
        boxVertical.add(panNombrePDF);
        boxVertical.add(Box.createVerticalStrut(10));
        boxVertical.add(panGenerarPDF);
 
        //Agregar el Box a la ventana
        add(boxVertical);
        setResizable(false);    //No maximizar ni cambiar tamanio
        //Al dar en la X terminar todo el programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // ########### ESCUCHADOR BOTON NUEVO   ##########
        ActionListener escuchadorGenerarPDF = new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                strNombrePDF = jtfNombrePDF.getText();
            GenerarPDFEmpleados ejemplo = new GenerarPDFEmpleados(strTituloPDF,strNombrePDF);
            //Preguntar al usuario si desea abrir el documento PDF
            int respuesta = JOptionPane.showConfirmDialog(null,"Se ha generado el documento "+strNombrePDF+", ¿Desea abrirlo?","Pregunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            //Si la respuesta es SI, abrirlo
                if(respuesta == JOptionPane.YES_OPTION)
                    ejemplo.abrirPDF ();
           
            }
    };
        btnGenerarPDF.addActionListener(escuchadorGenerarPDF);
 
         
    }   //Fin del constructor
 
    //hace visible la ventana   
    public void mostrar()
    {
        setVisible(true);
    }
 
    public static void main(String[] args) 
   {
        prueba ejemplo = new prueba("Ventana principal de Usuario",400,400);
        ejemplo.mostrar();
   }
}