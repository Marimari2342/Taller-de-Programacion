/*
F- Realizar un programa que instancie un jugador y un entrenador. Informe la
representación String de cada uno.
 */
package tema4;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author maria
 */
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancio jugador y entrenador
        System.out.println("Ingrese nombre,antiguedad,partidos y goles del jugador");
        Jugador unJugador = new Jugador(Lector.leerString(),GeneradorAleatorio.generarInt(20),
        GeneradorAleatorio.generarInt(300)+1,GeneradorAleatorio.generarInt(100));
        System.out.println("Ingrese nombre,antiguedad y campeonatos ganados");
        Entrenador unEntrenador = new Entrenador(Lector.leerString(),GeneradorAleatorio.generarInt(20)+1,
        GeneradorAleatorio.generarInt(15));
        //Testing
        System.out.println(unJugador.getNombre());
        System.out.println(unJugador.getAntiguedad());
        System.out.println(unJugador.getPartidos());
        System.out.println(unJugador.getGoles());
        System.out.println(unEntrenador.getNombre());
        System.out.println(unEntrenador.getAntiguedad());
        System.out.println(unEntrenador.getCampeonatosGanados());
        //------
        System.out.println("Jugador: "+unJugador.toString());
        System.out.println("Entrenador: "+unEntrenador.toString());
    }
    
}
