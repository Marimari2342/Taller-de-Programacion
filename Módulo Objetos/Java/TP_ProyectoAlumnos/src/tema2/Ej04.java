/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos
de casting.*/
package tema2;


import PaqueteLectura.Lector;

/**
 *
 * @author maria
 */
public class Ej04 {

    public static void main(String[] args) {
        //Creacion de matriz dia x turno
        Persona[][] casting = new Persona[5][8];
        //Creacion de vector de dias puesto en cero, indica turnos disponibles
        int[] vectorDias = new int[5];
        int i;
        for (i = 0; i < 5; i++) {
            vectorDias[i] = 0;
        }

        //Variables
        int turnos = 0;
        int auxDia;
        System.out.println("Ingrese nombre, dni y edad: ");
        String nombre = new String(Lector.leerString());
        Persona unaPersona;

        while ((turnos < 40) && (!nombre.equals("zzz"))) {
            unaPersona = new Persona(nombre,Lector.leerInt(),Lector.leerInt());
            System.out.println("Ingrese dia al que quiere concurrir (1-5): ");
            auxDia = Lector.leerInt();
            if (vectorDias[auxDia - 1] < 8) {
                casting[auxDia - 1][vectorDias[auxDia - 1]] = unaPersona;
                vectorDias[auxDia - 1] += 1;
                turnos += 1;
            } else {
                System.out.println("No hay más turnos para el dia seleccionado.");
            }
            System.out.println("Ingrese nombre, dni y edad: ");
            nombre = Lector.leerString();
        }
        /*TESTEO
        for (i = 0; i < 5; i++) {
            System.out.println("Dia: " + (i + 1) + " | Turnos dados: " + vectorDias[i]);
        }
        System.out.println(casting[0][0].toString());
        System.out.println(casting[0][1].toString());
        //------*/
        
        /*Una vez finalizada la inscripción:
b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
persona a entrevistar en cada turno asignado.*/
        for (i = 0; i < 5; i++) {
            int j;
            System.out.println("Cantidad de inscriptos en dia " + (i + 1) + ": " + (vectorDias[i]));
            for (j = 0; j < vectorDias[i]; j++) {
                System.out.println("Dia " + (i + 1) + " - Turno " + (j + 1) + ": " + casting[i][j].getNombre());
            }
        }
    }
}
