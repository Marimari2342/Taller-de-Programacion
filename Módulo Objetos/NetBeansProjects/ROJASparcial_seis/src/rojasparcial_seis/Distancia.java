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
public class Distancia extends Curso{
    //Variables de instancia
    private String link;
    
    //Constructor
    public Distancia(int unAnio, int unaCantAlu, String unLink){
        super(unAnio,unaCantAlu);
        link=unLink;
    }
    
    //Getters
    public String getLink() {
        return link;
    }
    
    //Metodos 
    public boolean puedeRendir(Alumno unAlu){          //(d)puede rendir (3 autoev y 1 asist)
        if (unAlu.getAsistencia()>=1&&unAlu.getEvalAprobadas()>=3)
            return true;
        else
            return false;
    }
}