
package Contolador;

import Modelo.ConsultaVehiculos;
import Modelo.Vehiculo;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class ControladorParking implements ActionListener {
    
    //agregamos la vista y los modelos a ser empleados por el controlador;
    
    Principal view;
    Vehiculo modelo1;
    ConsultaVehiculos modelo2;
    
    public ControladorParking (Principal view,Vehiculo modelo1,ConsultaVehiculos modelo2){
        
        this.view=view;
        this.modelo1=modelo1;
        this.modelo2=modelo2;
        this.view.getPanelIngresarVehiculo().btnRegistrar.addActionListener(this);
        this.view.getPanelRetirarVehiculo().btnBuscar.addActionListener(this);
        this.view.getPanelRetirarVehiculo().btnRetirar.addActionListener(this);
        this.view.getPanelRetirarVehiculo().btnLimpiar.addActionListener(this);
        this.view.getPanelListarVehiculos().btnBuscar.addActionListener(this);
        this.view.getPanelListarVehiculos().btnCerrar.addActionListener(this);
        this.view.getPanelListarVehiculos().btnLimpiar.addActionListener(this);
    }
    
    public void iniciar(){
        
        this.view.setTitle("ParkingSoft");
        this.view.setVisible(true);
    }
    
    
    /*este metodo es el encargado de "escuchar los botones de la vista", se declararon condicionales "if" para determinar cual boton a sido presionado
      lo que se realiza dentro de este metodo es que los valores que se encuentran dentro de la caja de texto son asignadas al modelo y estas a su vez
      realiza la consulta correspondiente a la base de datos.  
    */

    @Override
    public void actionPerformed(ActionEvent e) {
        String tipoAuto="";
        
        // Al cumplirse esta condicional se realizara el registro de un nuevo auto
        
        if(e.getSource()==view.getPanelIngresarVehiculo().btnRegistrar){
            
            //Usamos la clase Date y Timestamp para generar la hora de entrar del vehiculo.
            
            Date date=new Date();
            Timestamp horaEntrada=new Timestamp(date.getTime());
            
            if(view.getPanelIngresarVehiculo().rdAutoIngreso.isSelected()){
                tipoAuto="Automovil";
            }else{
                tipoAuto="Motocicleta";
            }
            //Asigno los valores de las cajas de texto a las variables correspondientes
            
            String placa=view.getPanelIngresarVehiculo().txtPlacaIngreso.getText();
            String propietario=view.getPanelIngresarVehiculo().txtNombreIngreso.getText();
            
            //le pasamos las variables generadas posteriormente para luego pasarlas al modelo
            
            modelo1.setPlaca(placa);
            modelo1.setPropietario(propietario);
            modelo1.setTipoVehiculo(tipoAuto);
            modelo1.setHoraEntrada(horaEntrada);
            modelo1.setEstado("Disponible");
     
            
            if(modelo2.ingresarVehiculo(modelo1)){
                
                JOptionPane.showMessageDialog(null,"Vehiculo registrado con exito");
                
            }else{
                
                JOptionPane.showMessageDialog(null,"Error al registrar vehiculo");
                
            }
            
            
        }
        //Al cumplirse esta condicional se realizara la busquedad del vehiculo.
       
        if(e.getSource()==view.getPanelRetirarVehiculo().btnBuscar){
         
            //Obtenemos la placa de la caja de texto la cual sera usada por el modelo para realizar el update.
            
            String placa=view.getPanelRetirarVehiculo().txtPlacaRetirar.getText();
            
            modelo1.setPlaca(placa);
            
            
            if(modelo2.buscarVehiculo(modelo1)){
              
              view.getPanelRetirarVehiculo().txtIdRetira.setText(String.valueOf(modelo1.getId()));
              view.getPanelRetirarVehiculo().txtPropietario.setText(modelo1.getPropietario());
              view.getPanelRetirarVehiculo().txtTipoVehiculo.setText(modelo1.getTipoVehiculo());
              view.getPanelRetirarVehiculo().txtHoraEntrada.setText(String.valueOf(modelo1.getHoraEntrada()));
                
            }else{
                JOptionPane.showMessageDialog(null,"No se encontraron resultados");
            }
            
        }
        
             //Al cumplirse esta condicional se realizara el retiro del vehiculo.
       
       if(e.getSource()==view.getPanelRetirarVehiculo().btnRetirar){
           
          //Asignamos el valor por minuto de estadia tanto del automovil como motocicleta.
          
          
           
          /*Para evitar una consulta a la base de datos, se tomo el valor de la hora de entrada
           y se realiza un convert para usar el formato Timestamp y asi calcular los minutos de estadia*/
          try{
           
            Date date=new Date();
            Timestamp horaSalida=new Timestamp(date.getTime());
            modelo1.setHoraSalida(horaSalida);
            String formato=view.getPanelRetirarVehiculo().txtHoraEntrada.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(formato);
            Timestamp horaEntrada=new java.sql.Timestamp(parsedDate.getTime());
            
            /*restamos los milisegundos de la hora de salida menos los de la hora de entrada y
              los dividimos entre 60000 para obtener los minutos totales de estadia.  
            */
            int minutos= ((int)(horaSalida.getTime()-(int)horaEntrada.getTime()))/60000;
            
            String tipoVehiculo=view.getPanelRetirarVehiculo().txtTipoVehiculo.getText();
            
            //se verifica que tipo de vehiculo es para realizar el calculo del valor a pagar.
             double valorPorMinuto;
            if(tipoVehiculo.equals("Automovil")){
                
                modelo1.setValorPagado(valorPorMinuto=minutos*5);
                JOptionPane.showMessageDialog(null,"El total a pagar es de "+ valorPorMinuto) ;
            }
            if(tipoVehiculo.equals("Motocicleta")){
                modelo1.setValorPagado(valorPorMinuto=minutos*3);
                JOptionPane.showMessageDialog(null,"El total a pagar es de "+ valorPorMinuto) ;
            }
            
    
            
          }catch(Exception a){
              System.err.print(a);
          }
      
         
          
            //Obtenemos la placa de la caja de texto la cual sera usada por el modelo para realizar el update.
            
            String placa=view.getPanelRetirarVehiculo().txtPlacaRetirar.getText();
            
            modelo1.setPlaca(placa);
            modelo1.setEstado("No Disponible");
            
            
            if(modelo2.retirarVehiculo(modelo1)){
              
              view.getPanelRetirarVehiculo().txtTotalPagar.setText(String.valueOf(modelo1.getValorPagado()));
              
              JOptionPane.showMessageDialog(null,"Vehiculo retirado");
                
            }else{
                JOptionPane.showMessageDialog(null,"Error Inesperado");
            }
            
        }
       
        //Al cumplirse esta condicional se realizara la limpieza de los campos de texto del panel retirar vehiculo.
        
       if(e.getSource()==view.getPanelRetirarVehiculo().btnLimpiar){
       
           view.getPanelRetirarVehiculo().txtHoraEntrada.setText(null);
           view.getPanelRetirarVehiculo().txtIdRetira.setText(null);
           view.getPanelRetirarVehiculo().txtPlacaRetirar.setText(null);
           view.getPanelRetirarVehiculo().txtPropietario.setText(null);
           view.getPanelRetirarVehiculo().txtTipoVehiculo.setText(null);
           view.getPanelRetirarVehiculo().txtTotalPagar.setText(null);
         
       }
       
       
       //Al cumplirse esta condicional se deplegara la lista de los vehiculos de la base de datos.
       
        if(e.getSource()==view.getPanelListarVehiculos().btnBuscar){
         
            /*Le asignamos los valores de las busquedas al modelo Vehiculo para realizar la busqueda en la BD.
            */
            
            modelo1.setPlaca(view.getPanelListarVehiculos().txtPlacaLista.getText());
            modelo1.setPropietario(view.getPanelListarVehiculos().txtPropietarioLista.getText());
            modelo1.setTipoVehiculo(view.getPanelListarVehiculos().comboTipoVehiculo.getSelectedItem().toString());
            modelo1.setEstado(view.getPanelListarVehiculos().comboEstado.getSelectedItem().toString());
            modelo1.setFechaSolicitud(view.getPanelListarVehiculos().jCalendario.getText());
            
            if(modelo2.listarVehiculos(modelo1)){
                
                /*Usamos un arraylist de tipo Vehiculo junto con un array de tipo objeto
                para asignar los valores a la tabla por medio de un bucle "for",
                */
             ArrayList <Vehiculo>lista=modelo1.getLista();
             Object[]filas=new Object[7];
             
             
                for (int i = 0; i <modelo1.getLista().size(); i++) {
                    
                    filas[0]=lista.get(i).getPlaca();
                    filas[1]=lista.get(i).getPropietario();
                    filas[2]=lista.get(i).getTipoVehiculo();
                    filas[3]=lista.get(i).getHoraEntrada();              
                    filas[4]=lista.get(i).getHoraSalida();
                    filas[5]=lista.get(i).getValorPagado();
                    filas[6]=lista.get(i).getEstado();
                    
              
                    
                    view.getPanelListarVehiculos().modelo.addRow(filas);
                }
                
                JOptionPane.showMessageDialog(null,"Vehiculos listados");
                
              
            }else{
                JOptionPane.showMessageDialog(null,"No se encontraron resultados");
            }
            
        }
        
        
         //Al cumplirse esta condicional se realizara la limpieza de la tabla.
        
         if(e.getSource()==view.getPanelListarVehiculos().btnLimpiar){
             
             view.getPanelListarVehiculos().modelo.setRowCount(0);
             view.getPanelListarVehiculos().jCalendario.setText(null);
             view.getPanelListarVehiculos().txtPlacaLista.setText(null);
             view.getPanelListarVehiculos().txtPropietarioLista.setText(null);
         }
        
        
    }
    
    
    
    
}
