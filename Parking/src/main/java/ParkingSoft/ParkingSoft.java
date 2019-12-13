
package ParkingSoft;

import Contolador.ControladorParking;
import Modelo.ConsultaVehiculos;
import Modelo.Vehiculo;
import Vista.Principal;


public class ParkingSoft {

    public static void main(String[] args) {
   
        
        Principal view=new Principal();
        Vehiculo modelo1=new Vehiculo();
        ConsultaVehiculos modelo2=new ConsultaVehiculos();
        ControladorParking controlador=new ControladorParking(view,modelo1,modelo2);
        
        controlador.iniciar();
     
        
    }
    
}
