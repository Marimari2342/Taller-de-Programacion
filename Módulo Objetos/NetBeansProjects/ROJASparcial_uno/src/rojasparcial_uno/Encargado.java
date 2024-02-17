/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_uno;

/**
 *
 * @author maria
 */
public class Encargado extends Empleados{
    //Variables de instancia
    private int cantEmpleados;
    private boolean hayEnc=false;   //testing
    
    //Constructor
    public Encargado(String unNombre,int unDni,int anioIngreso,int unaCant){
        super(unNombre,unDni,anioIngreso);
        cantEmpleados=unaCant;
        hayEnc=true;                //testing
    }
    
    //Getters y Setters
    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public boolean isHayEnc() {
        return hayEnc;
    }

    //Metodos
    public double sueldoCobrar(){   //(2) sueldo a cobrar 10% mas con mas de 20 anios de ant
        double aux = this.getSueldoBasico();
        if (2023-this.getAnioIng()>20)
            aux += aux/10;
        aux += this.getCantEmpleados()*1000;  //Encargado: +1000 por empleado a cargo
        return aux;
    }
    

}
