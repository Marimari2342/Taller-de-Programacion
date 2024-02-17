
//PUNTO 1 b)
/*B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.*/

package tema3;

import PaqueteLectura.Lector;

public class Ej01 {
    
    public static void main(String[] args) {
        //Declaro variable
        Triangulo miTriangulo = new Triangulo();
        //Cargo informacion
        miTriangulo.setLadoUno(Lector.leerDouble());
        miTriangulo.setLadoDos(Lector.leerDouble());
        miTriangulo.setLadoTres(Lector.leerDouble());
        miTriangulo.setColorRelleno(Lector.leerString());
        miTriangulo.setColorLinea(Lector.leerString());
        //Calcula e informa perimetro y area
        System.out.println("Perimetro: "+miTriangulo.calcularPerimetro());
        System.out.println("Area: "+miTriangulo.calcularArea());  
    }
    
}
