/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:*/
package tema2;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author maria
 */
public class Ej02 {
    public static void main(String[] args){
        //Creacion del vector
      Persona [] vectorPersonas = new Persona [15]; 
        //Inicio GeneradorAleatorio
      GeneradorAleatorio.iniciar();
        //Variables  
      int dF=0;  
      int edad=GeneradorAleatorio.generarInt(100);
        //Cargar Vector
      while (dF!=15 && edad != 0){
          Persona unaPersona = new Persona(GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarInt(3000)+1,edad);
          vectorPersonas[dF]=unaPersona;
          dF++;
          edad=GeneradorAleatorio.generarInt(100);
          //TESTEO
          System.out.println(dF);
          System.out.println(unaPersona.toString());
          //......
      }
    /*- Informe la cantidad de personas mayores de 65 años.*/
    /*- Muestre la representación de la persona con menor DNI.*/
    int cant=0;
    int i;
    Persona menorDNIPersona = new Persona("",3000,0);
    for (i=0;i<dF;i++){
        if (vectorPersonas[i].getEdad()>65)
            cant+=1;
        if (vectorPersonas[i].getDNI()<menorDNIPersona.getDNI())
            menorDNIPersona=vectorPersonas[i];
        //TESTEO            
        System.out.println(i +" "+cant);
        //......
      }
    System.out.println("Personas mayores de 65 anios: "+cant);
    System.out.println(menorDNIPersona.toString());
        
    }
    
}
