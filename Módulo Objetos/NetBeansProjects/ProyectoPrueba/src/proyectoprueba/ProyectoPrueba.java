/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

EN JAVA EL CODIGO FUENTE POR LO GENERAL SE ORGANIZA DENTRO DE PAQUETES
 */
package proyectoprueba;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author maria
 */
public class ProyectoPrueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //PROBANDO LECTOR
        System.out.println("Ingrese su nombre");
        String nombre = Lector.leerString();
        System.out.println("Ingrese su ocupacion");
        String ocupacion = Lector.leerString();
        System.out.println("Ingrese su edad");
        int edad = Lector.leerInt();
        
        System.out.println(nombre+" de "+edad+" anios es "+ocupacion);
        
        //PROBANDO GENERADOR ALEATORIO
        GeneradorAleatorio.iniciar();
        edad = GeneradorAleatorio.generarInt(80);
        System.out.println(nombre+" de "+edad+" anios es "+ocupacion);
    }
    
}
