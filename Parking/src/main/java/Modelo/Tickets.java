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

import javax.swing.JOptionPane;

public class Tickets {
    
    private String placa;
    private String propietario;
    private String vehiculo;
    private Timestamp horaEntrada;
 
    public Tickets(){
        
        
    }
    
    //Metodo para generar los tickets del ingreso de los vehiculos.
    
     public void ticketEntrada()throws FileNotFoundException, DocumentException{
        
       
       Timestamp horaEntrada=this.horaEntrada;
       
        //Creamos el documento
        
        Document documento=new Document();
      
        //Este sera el Ouput para el fichero donde creamos el pdf por defecto se generara en la carpeta del proyecto;
        FileOutputStream ficheroPdf=new FileOutputStream(this.propietario+".pdf");
        
        //Asociamos el documento del ouput
        
        PdfWriter.getInstance(documento, ficheroPdf);
        
        //Abrimos el documento para editarlo
        
        documento.open();
        
        
        //Creamos el titulo principal
        Paragraph titulo=new Paragraph("Recibo de entrada\n\n",
           
               FontFactory.getFont("arial",22,Font.BOLD,BaseColor.BLUE)
        );
        
        //creamos parrafos con los datos necesarios.
        
        Paragraph placa1=new Paragraph("Placa del vehiculo= "+ this.placa);
        Paragraph propietario1=new Paragraph("Nombre del propietario= "+ this.propietario);
        Paragraph vehiculo1=new Paragraph("Tipo de vehiculo= "+ this.vehiculo);
        Paragraph horaEntrada1=new Paragraph("Hora de entrada= "+ this.horaEntrada);
        
        //añadimos el titulo y los parrafos al 
        
        documento.add(titulo);
        documento.add(placa1);
        documento.add(propietario1);
        documento.add(vehiculo1);
        documento.add(horaEntrada1);
            
        //por ultimo cerramos el documento al finalizar la edicion.
        
            documento.close();
       
     
    }




    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }


    public void setHoraEntrada(Timestamp horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    
    
    
}
