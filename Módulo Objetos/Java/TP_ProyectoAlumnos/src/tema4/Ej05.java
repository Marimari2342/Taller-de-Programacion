/*
B- Realice un programa que instancie el visor, guarde dos cuadrados y un rectángulo en el
visor y por último haga que el visor muestre sus figuras almacenadas.
 */
package tema4;

/**
 *
 * @author maria
 */
public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancio figuras
        VisorFigurasModificado unVisor = new VisorFigurasModificado();
        Cuadrado cuadradoUno = new Cuadrado (5,"Azul","Verde");
        Cuadrado cuadradoDos = new Cuadrado (8,"Rosa","Rojo");
        Rectangulo unRectangulo = new Rectangulo (4,7,"Amarillo","Naranja");
        unVisor.guardar(cuadradoUno);
        unVisor.guardar(cuadradoDos);
        unVisor.guardar(unRectangulo);
        unVisor.mostrar();
    }
    
}
