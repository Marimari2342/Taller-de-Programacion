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
public abstract class Empleados {
    //Variables de instancia
    private String nombre;
    private int dni;
    private int anioIng;
    private double sueldoBasico=250000;
    
    //Constructor
    public Empleados(String unNombre,int unDni,int anioIngreso){
        nombre=unNombre;
        dni=unDni;
        anioIng=anioIngreso;
    }
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getAnioIng() {
        return anioIng;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }
    
    //Metodos
    public abstract double sueldoCobrar();  //punto(2)
    
    public String toString(){               //punto(3)
        return "Nombre: "+this.getNombre()+" | DNI: "+this.getDni()+" | Sueldo a cobrar"
                +this.sueldoCobrar();
    }
}
