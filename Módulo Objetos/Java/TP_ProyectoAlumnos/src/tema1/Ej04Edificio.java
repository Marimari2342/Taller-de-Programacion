/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). Realice un programa que permita informar la cantidad de personas que
concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
de piso 9. Al finalizar la llegada de personas, informe lo pedido.
*/
package tema1;
import PaqueteLectura.Lector;
/**
 *
 * @author maria
 */
public class Ej04Edificio {
	public static void main(String[] args) {
		int pisos=8;
		int oficinas=4;
        int [][] edificio = new int[pisos][oficinas];
	    int i,j;
		//pongo edificio en 0
        for (i=0;i<8;i++)
	       for (j=0;j<4;j++)
	          edificio[i][j]=0;	
		
		System.out.println("Ingrese piso");
		i = Lector.leerInt();
		i--;
		while (i<8) {
			System.out.println("Ingrese oficina");
			j = Lector.leerInt();
			j--;
			edificio[i][j]+=1;
			System.out.println("Ingrese piso");
		        i = Lector.leerInt();
			i--;
		}
		
		for(i=0;i<pisos;i++)
			for(j=0;j<oficinas;j++)
			  System.out.println("Piso "+(i+1)+", Oficina "+(j+1)+ " = "+edificio[i][j]);
	}

}
