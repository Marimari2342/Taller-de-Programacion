/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;
import PaqueteLectura.Lector;

public class DemoFiguras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuadrado cuad = new Cuadrado(10,"Rojo", "Negro");
        System.out.println("Color linea: " + cuad.getColorLinea()); 
        System.out.println("Area: " + cuad.calcularArea()); 
        System.out.println("Representacion del cuadrado: " + cuad.toString()); 

/*E- Realizar un programa que instancie un triángulo y un círculo. Muestre en consola la
representación String de cada uno. Pruebe el funcionamiento del método despintar.*/
    System.out.println("Ingrese lados,color de relleno y linea del triangulo");
    Triangulo miTriangulo = new Triangulo(Lector.leerDouble(),Lector.leerDouble(),Lector.leerDouble(),
            Lector.leerString(), Lector.leerString());
    System.out.println("Ingrese radio,color de relleno y linea del circulo");
    Circulo miCirculo = new Circulo (Lector.leerDouble(),Lector.leerString(),Lector.leerString());
    System.out.println("Representacion del triangulo: " + miTriangulo.toString());
    System.out.println("Representacion del circulo: " + miCirculo.toString());
    miTriangulo.despintar();
    miCirculo.despintar();
    System.out.println("Representacion del triangulo: " + miTriangulo.toString());
    System.out.println("Representacion del circulo: " + miCirculo.toString());
    }
    
    
    
}
