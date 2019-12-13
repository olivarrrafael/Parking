
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*Heredamos de la clase Conexion para poder usar sus metodos sin necesidad
  de instanciar la clase*/

public class ConsultaVehiculos extends Conexion{


    
/*Con esta funcion registraremos los vehiculos que seran ingresados a la base de datos local */
    
   public boolean ingresarVehiculo(Vehiculo vehiculo){
       
      Connection con=getConexion();
      
      String sqlRegistro="INSERT INTO vehiculos (placa,propietario,tipo_vehiculo,hora_entrada,estado) VALUES(?,?,?,?,?)";
      
       try {
           
            PreparedStatement st=con.prepareStatement(sqlRegistro);
        
            st.setString(1,vehiculo.getPlaca());
            st.setString(2,vehiculo.getPropietario());
            st.setString(3,vehiculo.getTipoVehiculo());
            st.setTimestamp(4,vehiculo.getHoraEntrada());
            st.setString(5,vehiculo.getEstado());
            st.executeUpdate();
            

            return true;
            
       } catch (SQLException e) {
           
           System.err.println(e); 
           return false;
           
       }finally{
           try {
               con.close();
               
           } catch (SQLException e) {
               
               System.err.println(e);
           }
           
       }
       
   }
   
      //Metodo para retirar los vehiculo
      public boolean retirarVehiculo(Vehiculo vehiculo){
       
      Connection con=getConexion();
      
      String sqlRegistro="UPDATE vehiculos SET hora_salida=?,valor_pagado=?,estado=? WHERE placa=? AND estado=?";
      
       try {
           
            PreparedStatement st=con.prepareStatement(sqlRegistro);
        
            st.setTimestamp(1,vehiculo.getHoraSalida());
            st.setDouble(2,vehiculo.getValorPagado());
            st.setString(3,vehiculo.getEstado());
            st.setString(4,vehiculo.getPlaca());
            st.setString(5,"Disponible");
            st.executeUpdate();
            
            return true;
            
       } catch (SQLException e) {
           
         System.err.print(e);
           return false;
       }finally{
           try {
               con.close();
               
           } catch (SQLException e) {
               
               System.err.println(e);
           }
           
           
           
       }
       
   }
      
      public boolean buscarVehiculo(Vehiculo vehiculo){
       
      Connection con=getConexion();
      ResultSet rs=null;
      String sqlRegistro="SELECT id,propietario,tipo_vehiculo,hora_entrada FROM vehiculos WHERE placa=?";
      
       try {
           
            PreparedStatement st=con.prepareStatement(sqlRegistro);
        
            st.setString(1,vehiculo.getPlaca());
            rs=st.executeQuery();
            if(rs.next()){
                
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPropietario(rs.getString("propietario"));
                vehiculo.setTipoVehiculo(rs.getString("tipo_vehiculo"));
                vehiculo.setHoraEntrada(rs.getTimestamp("hora_entrada"));
            }
            
            
            return true;
            
       } catch (SQLException e) {
           
           System.err.print(e);
           return false;
       }finally{
           try {
               con.close();
               
           } catch (SQLException e) {
               
               System.err.println(e);
           }
    
}
      }
      
      
      public boolean listarVehiculos(Vehiculo vehiculo){
       
      Connection con=getConexion();
      ResultSet rs=null;
      String sqlRegistro="SELECT placa,propietario,tipo_vehiculo,hora_entrada,hora_salida,valor_pagado,estado FROM vehiculos "
      + "WHERE estado LIKE '"+vehiculo.getEstado()+"%' AND tipo_vehiculo LIKE '%"+vehiculo.getTipoVehiculo() +"%' AND hora_entrada LIKE '%"+vehiculo.getFechaSolicitud()+"%' AND propietario LIKE '%"+vehiculo.getPropietario() +"%' AND placa LIKE '%"+vehiculo.getPlaca() +"%'";
      
      /*
      Creamos un ArrayList de tipo Vehiculo el cual contendra toda la informacion
      extraida de la base de datos y luego sera pasada al modelo Vehiculo
      */
      ArrayList <Vehiculo> lista;
       try {
           
            PreparedStatement st=con.prepareStatement(sqlRegistro);
      
            rs=st.executeQuery();
            lista=new ArrayList<Vehiculo>();
            
            while(rs.next()){
                /*en cada iteracion se crearan objectos del tipo Auto los cuales 
                contendran la informacion de la base de datos y estos a su vez
                se almacenaran en el ArrayList creado con anterioridad.
                */
                
                Vehiculo auto=new Vehiculo();
                auto.setPlaca(rs.getString("placa"));
                auto.setPropietario(rs.getString("propietario"));
                auto.setTipoVehiculo(rs.getString("tipo_vehiculo"));;
                auto.setHoraEntrada(rs.getTimestamp("hora_entrada"));
                auto.setHoraSalida(rs.getTimestamp("hora_salida"));;
                auto.setValorPagado(rs.getDouble("valor_pagado"));;
                auto.setEstado(rs.getString("estado"));;
               
                lista.add(auto);
               
            }
            
            vehiculo.setLista(lista);
            
            
            return true;
            
       } catch (SQLException e) {
           
           System.err.print(e);
           return false;
       }finally{
           try {
               con.close();
               
           } catch (SQLException e) {
               
               System.err.println(e);
           }
    
}
      }
      
       public boolean cierreVehiculos(Vehiculo vehiculo){
       
      Connection con=getConexion();
      ResultSet rs=null;
      String sqlRegistro="SELECT SUM(valor_pagado) FROM vehiculos "
      + "WHERE estado LIKE '"+vehiculo.getEstado()+"%' AND tipo_vehiculo LIKE '%"+vehiculo.getTipoVehiculo() +"%' AND hora_entrada LIKE '%"+vehiculo.getFechaSolicitud()+"%' AND propietario LIKE '%"+vehiculo.getPropietario() +"%' AND placa LIKE '%"+vehiculo.getPlaca() +"%'";
       
            try {
                  PreparedStatement st=con.prepareStatement(sqlRegistro);
                  rs=st.executeQuery();
                  rs.first();
                  
                  vehiculo.setCierreTotal(Double.parseDouble(rs.getString(1)));
                 
                  return true;
                  
            } catch (Exception e) {
                
                System.err.print(e);
                
            return false;
            }
       }
      
    
}
