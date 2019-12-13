/*Esta clase la usaremos para la creacion de nuestros documentos PDF usando la libreria Itext en su version 5.4.0, usaremos las instancias de esta clase para dich
proposito y de esa forma tener un codigo mejor organizado*/

package Modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

public class CrearPdf {
    
    public CrearPdf(){
        
        
    }
    
    
    public void crearDocumento(String placa,String propietario,String vehiculo)throws FileNotFoundException, DocumentException{
        
         Date hora=new Date();
       Timestamp horaEntrada=new Timestamp(hora.getTime());
        //Creamos el documento
        Document documento=new Document();
      
        //Este sera el Ouput para el fichero donde creamos el pdf;
        FileOutputStream ficheroPdf=new FileOutputStream("tickets.pdf");
        
        //Asociamos el documento del ouput
        PdfWriter.getInstance(documento, ficheroPdf);
        //Abrimos el documento para editarlo
        documento.open();
        
        //Creamos el parrafo
        Paragraph titulo=new Paragraph("Recibo de entrada\n\n",
           
               FontFactory.getFont("arial",22,Font.BOLD,BaseColor.BLUE)
        );
        Paragraph placa1=new Paragraph("Placa del vehiculo= "+ placa);
        Paragraph propietario1=new Paragraph("Nombre del propietario= "+ propietario);
        Paragraph vehiculo1=new Paragraph("Tipo de vehiculo= "+ vehiculo);
        Paragraph horaEntrada1=new Paragraph("Hora de entrada= "+ horaEntrada);
        
        documento.add(titulo);
         documento.add(placa1);
          documento.add(propietario1);
           documento.add(vehiculo1);
            documento.add(horaEntrada1);
            documento.close();
         JOptionPane.showMessageDialog(null, "El docuento a sido creado");
        
    }
    
}
