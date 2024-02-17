/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.*/
package tema2;


import PaqueteLectura.Lector;
/**
 *
 * @author maria
 */
public class Ej03 {
    public static void main(String[] args) {
      //Creacion de matriz dia x turno
      Persona [][] casting = new Persona [5][8];
      
      //Inscripcion de personas al casting
      int i=0;
      int j;
      String nombre = Lector.leerString();
      Persona unaPersona ;
      while ((i <= 4) && (nombre.equals("ZZZ")==false)){
        j=0;  
        while ((j <= 7) && (nombre.equals("ZZZ")==false)){
            unaPersona = new Persona(nombre,Lector.leerInt(),Lector.leerInt());
            casting[i][j]= unaPersona;
            System.out.println(casting[i][j].toString());
            nombre= Lector.leerString();
            j+=1;
            //System.out.println(i +" "+j);
        }        
        i+=1;
        //System.out.println(i +" "+j);
      }
/*Una vez finalizada la inscripción:
b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
Strings use el método equals.*/
      int dFDia=0;
      int dCTurno=0;
      while (casting[dFDia][dCTurno]!=null && dFDia<5){
          dCTurno=0;
          while (casting[dFDia][dCTurno]!=null && dCTurno<8) {
            System.out.println("Dia "+(dFDia+1)+"-Turno "+(dCTurno+1)+" "+casting[dFDia][dCTurno].getNombre());
            dCTurno+=1;
          }
          dFDia+=1;
      }
    }        
}
