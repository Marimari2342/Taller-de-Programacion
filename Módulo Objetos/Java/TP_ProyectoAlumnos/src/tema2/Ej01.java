/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema2;


import PaqueteLectura.Lector;


/**
 *
 * @author maria
 */
public class Ej01 {
    
    public static void main(String[] args) {

            Persona personaUno = new Persona("Marianela",37679461,29);
            System.out.println(personaUno.toString());  
            Persona personaDos = new Persona();
            personaDos.setNombre(Lector.leerString());
            personaDos.setEdad(Lector.leerInt());
            personaDos.setDNI(Lector.leerInt());
            System.out.println(personaDos.toString());  
}

}
