/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.
*/
package tema1;
	import PaqueteLectura.Lector;
/**
 *
 * @author maria
 */
public class Ej05Restaurante {
	public static void main(String[] args) {
		int restoMatriz[][]=new int[5][4];
		double vectorProm[]=new double[4];int i,j;
		for(i=0;i<5;i++)
			for(j=0;j<4;j++){
				System.out.println("Ingrese puntación de "+j+": ");
				restoMatriz[i][j]=Lector.leerInt();
			}
		for(i=0;i<4;i++)
			vectorProm[i]=0;
		for(i=0;i<5;i++)
			for(j=0;j<4;j++)
				vectorProm[j]+=restoMatriz[i][j];
		for(i=0;i<4;i++)
			System.out.println("Promedio de califiación de categoría "+i+": "+vectorProm[i]/5);
	}
    
}
