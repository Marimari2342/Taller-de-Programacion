/*
B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”.
 */
package tema3;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class Ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancio un estante
        Estantes unEstante = new Estantes();
        
        Libro unLibro;
        Autor unAutor;
        System.out.println("Ingrese un nombre de Autor: ");
        String nombre=Lector.leerString();
        int aux=0;
        while ((aux<20) && (!nombre.equals("ZZZ"))){
          System.out.println("Ingrese datos de autor (bio/or)");
          unAutor = new Autor(nombre,Lector.leerString(),Lector.leerString());
          System.out.println("Ingrese datos del libro del autor (tit/edit/anio");
          unLibro = new Libro(Lector.leerString(),Lector.leerString(),Lector.leerInt(),unAutor,
                  GeneradorAleatorio.generarString(10),GeneradorAleatorio.generarDouble(5000));
          unEstante.agregarLibro(unLibro);
          aux+=1;
          System.out.println("Ingrese un nombre de Autor: ");
          nombre=Lector.leerString();
        }
        System.out.println("Autor: "+unEstante.getLibro("Mujercitas").getPrimerAutor().getNombre());
    }
    
}
