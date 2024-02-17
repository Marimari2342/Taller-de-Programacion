/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
PUNTO 3 
*/
/*3- Escriba un programa que defina una matriz de enteros de tamaño 5x5. Inicialice
la matriz con números aleatorios entre 0 y 30.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de los elementos de la fila 1
- Generar un vector de 5 posiciones donde cada posición j contiene la suma
de los elementos de la columna j de la matriz. Luego, imprima el vector.
- Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento”.*/
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej03Matrices {

    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio     
	GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int [][] matriz = new int [5][5];
        int i,j;
        for (i=0;i<=4;i++)
            for (j=0;j<=4;j++)
                matriz[i][j]= GeneradorAleatorio.generarInt(30);
        //Paso 4. mostrar el contenido de la matriz en consola
        for (i=0;i<=4;i++){
            for (j=0;j<=4;j++)
                System.out.print(matriz[i][j]+" | ");
            System.out.println();
        }
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        int suma=0;
        for (j=0;j<=4;j++)
                suma=suma+matriz[0][j];
        System.out.println("La suma de los elementos de la fila 1 es: "+suma);
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de 
        //los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        int [] vector = new int[5];
        for (i=0;i<=4;i++)
            vector[i]=0;
        for (i=0;i<=4;i++){
            for(j=0;j<=4;j++)
                vector[j]=vector[j]+matriz[i][j];
        }
        for (i=0;i<=4;i++)
            System.out.print(vector[i]+" | ");
        System.out.println();
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz.
        //En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        System.out.print("Ingrese un numero menor a 30: ");
        int numero = Lector.leerInt();
        boolean esta = false;
           for (i=0;i<=4;i++)
               for (j=0;j<=4;j++)
                   if (numero == matriz[i][j]){
                       System.out.println("El elemento se encuentra en fila: "+(i+1)+", columna: "+(j+1));
                       esta=true;}
           if(!esta)
               System.out.println("No se escontro el elemento");
    }
}
