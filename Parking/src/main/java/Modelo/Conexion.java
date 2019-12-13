

package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;
import java.sql.Timestamp;

public class Conexion {
    
   private Connection conexion=null;
   private final String url="jdbc:mysql://localhost:3306/bd_parking";
   private final String user="root";
   private final String pass="123";
   private final String registro=" INSERT INTO vehiculos (placa,propietario,tipo_vehiculo,hora_entrada,estado) VALUES (?,?,?,?,?)";
   
   
   
   public Connection getConexion(){
       
       try {
           
          conexion=DriverManager.getConnection(url,user,pass);
          
                  
       } catch (SQLException e) {
           
           System.err.println(e);
           
       }
       return conexion;
       
       
   }
   
   
   public void RetirarVehiculo(){
       
       
   }
   
   
       
   } 

