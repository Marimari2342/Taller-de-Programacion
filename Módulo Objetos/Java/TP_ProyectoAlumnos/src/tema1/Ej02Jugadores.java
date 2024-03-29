/*2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio
NOTA: Dispone de un esqueleto para este programa en Ej02Jugadores.java*/
package tema1;

//Paso 1: Importar la funcionalidad para lectura de dato
import PaqueteLectura.Lector;

public class Ej02Jugadores {

  
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        //Paso 3: Crear el vector para 15 double 
        double [] alturas = new double[15];
        //Paso 4: Declarar indice y variables auxiliares a usar
        int i;
        double suma=0;
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for (i=0;i<15;i++) {
            alturas[i] = Lector.leerDouble();
            suma = suma + alturas[i];
        }
        //Paso 7: Calcular el promedio de alturas, informarlo
        double promedioAlturas = suma/15;
        System.out.println("Altura promedio: "+promedioAlturas);
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        int cant=0;
        for (i=0;i<15;i++)
            if (alturas[i]>promedioAlturas)
                cant++;
        //Paso 9: Informar la cantidad.
        System.out.println ("Alturas por encima del promedio: "+cant);
    }
    
}
