/*
Realizar un programa que instancie un círculo, le cargue información leída de teclado e
informe en consola el perímetro y el área.
 */
package tema3;

import PaqueteLectura.Lector;
/**
 *
 * @author maria
 */
public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancio circulo
        Circulos miCirculo = new Circulos();
        // Carga informacion
        System.out.println("Ingrese radio,color de relleno y de linea del circulo");
        miCirculo.setRadio(Lector.leerDouble());
        miCirculo.setColorRelleno(Lector.leerString());
        miCirculo.setColorLinea(Lector.leerString());
        //Calculo e informo perimetro y area
        System.out.println("Perimetro del circulo: "+miCirculo.calcularPerimetro());
        System.out.println("Area del circulo "+ miCirculo.calcularArea());
    }
    
}
