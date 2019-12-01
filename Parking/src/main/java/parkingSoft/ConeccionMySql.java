/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingSoft;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;
import java.sql.Timestamp;
/**
 *
 * @author dell
 */
public class ConeccionMySql {
    
   private Connection conexion=null;
   private final String url="jdbc:mysql://localhost:3306/bd_parking";
   private final String user="root";
   private final String pass="rafaelrey2";
   private final String registro=" INSERT INTO vehiculos (placa,propietario,tipo_vehiculo,hora_entrada,estado) VALUES (?,?,?,?,?)";
   private String estado="";
   
   
   public ConeccionMySql(){
       
       try {
           
          conexion=DriverManager.getConnection(url,user,pass);
          
                  
       } catch (SQLException e) {
           
          JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
           
       }
       
       
   }
   /*Con esta funcion registraremos los vehiculos que seran ingresados a la base de datos local,
   usaremos el metodo Timestamp de la clase SQL la cual nos da el formato exigido. */
   public boolean ingresarVehiculo(String matricula,String propietario,String tipoAuto){
       estado="Disponible";
       Date hora=new Date();
       Timestamp horaEntrada=new Timestamp(hora.getTime());
       try {
            PreparedStatement st=conexion.prepareStatement(registro);
        
            st.setString(1,matricula);
            st.setString(2,propietario);
            st.setString(3,tipoAuto);
            st.setTimestamp(4,horaEntrada);
            st.setString(5,estado);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Vehiculo Registrado");

            
       } catch (SQLException e) {
           
          JOptionPane.showMessageDialog(null, "Error al insertar los datos");
           
       }
      
       
       return true;
     
       
   }
   
       
   } 

