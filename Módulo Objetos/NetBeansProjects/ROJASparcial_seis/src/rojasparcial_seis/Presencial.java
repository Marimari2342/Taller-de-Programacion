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
public class Presencial extends Curso{
    //Variables de instancia
    private int numAula;
    
    //Constructor
    public Presencial(int unAnio, int unaCantAlu, int unNumAula){
        super(unAnio,unaCantAlu);
        numAula=unNumAula;
    }
    
    //Getters
    public int getNumAula() {
        return numAula;
    }
    
    //Metodos 
    public boolean puedeRendir(Alumno unAlu){          //(d)puede rendir (3 asist)
        if (unAlu.getAsistencia()>=3)
            return true;
        else
            return false;
    }
    
}
