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
public class Director extends Empleados{
    //Variables de instancia
    private double viaticos;
    
    //Constructor
    public Director(String unNombre,int unDni,int anioIngreso,double unViatico){
        super(unNombre,unDni,anioIngreso);
        viaticos=unViatico;
    }
    
    //Getters y Setters
    public double getViaticos() {
        return viaticos;
    }
    
    //Metodos
    public double sueldoCobrar(){   //(2) sueldo a cobrar 10% mas con mas de 20 anios de ant
        double aux = this.getSueldoBasico();
        if (2023-this.getAnioIng()>20)
            aux += aux/10;
        aux += this.getViaticos();  //Director: monto de los viaticos
        return aux;
    }
    
}
