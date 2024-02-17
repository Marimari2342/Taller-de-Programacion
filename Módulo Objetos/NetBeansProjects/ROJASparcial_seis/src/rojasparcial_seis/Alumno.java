/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_seis;

/**
 *
 * @author maria
 */
public class Alumno {
    //Variables de instancia
    private int dni;
    private String nombre;
    private int asistencia;
    private int evalAprobadas;
    
    //Constructor
    public Alumno (int unDni,String unNombre){
        dni=unDni;
        nombre=unNombre;
        asistencia=0;
        evalAprobadas=0;
    }
    
    //Getters
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public int getEvalAprobadas() {
        return evalAprobadas;
    }
    
    //Metodos
    public void asistio(){              //(b)dado un dni, incrementar la asistencia
        this.asistencia+=1;
    }
    
    public void aprobo(){               //(c)dado un dni, sumar evaluacion aprobada
        this.evalAprobadas+=1;
    }
}
