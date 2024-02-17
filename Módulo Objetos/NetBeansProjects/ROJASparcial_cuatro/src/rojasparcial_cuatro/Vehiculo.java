/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_cuatro;

/**
 *
 * @author maria
 */
public class Vehiculo {
    //Variables de instancia
    private String patente;
    private int horasEstacionado;
    private String marca;
    private String modelo;
    
    //Constructor
    public Vehiculo(String unaPatente, int cantHoras, String unaMarca, String unModelo){
        patente=unaPatente;
        horasEstacionado=cantHoras;
        marca=unaMarca;
        modelo=unModelo;
    }
    
    //Getters y Setters
    public String getPatente() {
        return patente;
    }

    public int getHorasEstacionado() {
        return horasEstacionado;
    }

    public void setHorasEstacionado(int horasEstacionado) {     //podría variar las horas....?
        this.horasEstacionado = horasEstacionado;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    //Metodos
    public String toString(){
        return "Patente: "+this.getPatente()+", Marca: "+this.getMarca()+", Modelo: "+
                this.getModelo()+", Cantidad de horas estacionado: "+this.getHorasEstacionado();
    }
}
