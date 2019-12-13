
package Modelo;

import java.sql.Timestamp;
import java.util.ArrayList;


public class Vehiculo {
    private int id;
    private String placa;
    private String propietario;
    private String tipoVehiculo;
    private Timestamp horaEntrada;
    private Timestamp horaSalida;
    private double valorPagado;
    private String estado;
    private String FechaSolicitud;
    private double cierreTotal;
    private ArrayList <Vehiculo> lista;

    public double getCierreTotal() {
        return cierreTotal;
    }

    public void setCierreTotal(double cierreTotal) {
        this.cierreTotal = cierreTotal;
    }
    
    
     public String getFechaSolicitud() {
        return FechaSolicitud;
    }

    public void setFechaSolicitud(String FechaSolicitud) {
        this.FechaSolicitud = FechaSolicitud;
    }
    
    public ArrayList getLista() {
        
        
        return lista;
    }

    public void setLista(ArrayList lista) {
        
        this.lista = lista;
    }

  

    public Vehiculo() {
       this.placa="";
       this.tipoVehiculo="";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Timestamp getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Timestamp horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Timestamp getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Timestamp horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
