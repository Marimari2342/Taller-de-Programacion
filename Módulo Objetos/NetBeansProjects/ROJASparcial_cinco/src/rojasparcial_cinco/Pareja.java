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
public class Pareja {
    //Variables de instancia
    private Participante [] pareja;
    
    //Constructor
    public Pareja(Participante personaUno,Participante personaDos){
        pareja = new Participante[2];
        pareja[0]=personaUno;
        pareja[1]=personaDos;
    }
    
    //Getters
    public Participante[] getPareja() {
        return pareja;
    }
    
    //Metodos
    public int diferenciaEdad(){            //(b)obtener diferencia de edad de pareja
        return Math.abs(this.getPareja()[0].getEdad()-this.getPareja()[1].getEdad());
    }
}
