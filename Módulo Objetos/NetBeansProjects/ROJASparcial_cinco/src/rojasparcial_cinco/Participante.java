/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_cinco;

/**
 *
 * @author maria
 */
public class Participante {
    //Variables de instancia
    private int dni;
    private String nombre;
    private int edad;
    
    //Constructor
    public Participante (int unDNI,String unNombre,int unaEdad){
        dni=unDNI;
        nombre=unNombre;
        edad=unaEdad;
    }
    
    //Getters
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    
}
