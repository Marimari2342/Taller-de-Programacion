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
public class Concurso {
    //Variables de instancia
    private Pareja [] concurso;
    private int numParejas;
    private int dL=0;
    
    //Constructor
    public Concurso(int num){
        numParejas = num;
        concurso = new Pareja[numParejas];
    }
    
    //Getters
    public Pareja[] getConcurso() {
        return concurso;
    }

    public int getNumParejas() {
        return numParejas;
    }

    public int getdL() {
        return dL;
    }
    
    //Metodos 
    public void agregarPareja(Pareja unaPareja){    //(a)agregar una pareja al concurso
        this.getConcurso()[dL]=unaPareja;
        this.dL+=1;
    }
    
    public Pareja parejaMayorDif(){         //(c)obtener pareja con mayor diferencia de edad
        Pareja parAux=null;
        int difMax=0;
        for (int i=0;i<dL;i++)
            if (this.getConcurso()[i].diferenciaEdad()>difMax){
               difMax=this.getConcurso()[i].diferenciaEdad();
               parAux=this.getConcurso()[i];
            }
        return parAux;  
    }    
}