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
public class ParcialMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instancio un concurso
        Concurso unConcurso = new Concurso(5);
        //Cargo dos parejas
        Participante partUno = new Participante(12456789,"Juan",45);
        Participante partDos = new Participante(22456784,"Maria",20);
        Pareja parejaUno = new Pareja(partUno,partDos);
        Participante partTres = new Participante(32456122,"Martina",23);
        Participante partCuatro = new Participante(36453123,"Lucio",25);
        Pareja parejaDos = new Pareja(partTres,partCuatro);
        unConcurso.agregarPareja(parejaUno);
        unConcurso.agregarPareja(parejaDos);
        //Muestro los nombres de las parejas con mas diferencia de edad
        Pareja parejaMay = unConcurso.parejaMayorDif();
        System.out.println(parejaMay.getPareja()[0].getNombre()+" y "+
                parejaMay.getPareja()[1].getNombre());
    }
    
}
