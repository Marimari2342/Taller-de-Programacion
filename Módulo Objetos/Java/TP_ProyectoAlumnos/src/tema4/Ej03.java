/*
B- Realice un programa que instancie una persona y un trabajador y muestre la
representación de cada uno en consola.
 */
package tema4;

import tema2.Persona;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author maria
 */
public class Ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancio una persona y un trabajador
        System.out.println("Ingrese nombre, DNI y edad de la persona");
        Persona unaPersona = new Persona (Lector.leerString(),GeneradorAleatorio.generarInt(49999999)+5000000,
                GeneradorAleatorio.generarInt(99)+1);
        System.out.println("Ingrese nombre, DNI, edad y ocupacion del trabajador");
        Trabajadores unTrabajador = new Trabajadores (Lector.leerString(),
                GeneradorAleatorio.generarInt(49999999)+5000000, GeneradorAleatorio.generarInt(99)+1,
                Lector.leerString());
        System.out.println(unaPersona.toString());
        System.out.println(unTrabajador.toString());
    }
    
}
