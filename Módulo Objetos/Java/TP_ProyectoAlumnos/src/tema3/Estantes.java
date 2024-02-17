/*
3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”.
C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
almacenen como máximo N libros? ¿Cómo instanciaría el estante?

 */
package tema3;

/**
 *
 * @author alumnos
 */
public class Estantes {
    //Variables de instancia
    private int cantidad=0;
    private final int dF=20; //Punto C 
    private final Libro[]estante = new Libro[dF];
    
   
    //Constructor
    public Estantes(){
    
}
    
    //Metodos
    public int getCantidad(){  //Punto (i)
        return cantidad;
    }
    
    public boolean estaLleno(){  //Punto(ii)
        return (dF==cantidad);
    }
    
    public void agregarLibro(Libro unLibro){ //Punto(iii)
        if (cantidad<dF){
          estante[cantidad]=unLibro;
          cantidad+=1;
        }
    }
    
    public Libro getLibro(String unTitulo){ //Punto(iv)
        int aux=0;
        while (aux<=cantidad && !unTitulo.equals(estante[aux].getTitulo()))
            aux+=1;
        if (unTitulo.equals(estante[aux].getTitulo()))
            return estante[aux];
        else 
            return null;
    }


}

