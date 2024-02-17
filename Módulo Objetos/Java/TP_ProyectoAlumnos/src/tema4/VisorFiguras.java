/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author maria
 */
public class VisorFiguras {
    //Variable de instancia
    private int mostradas;
    //Constructor
    public VisorFiguras(){
    mostradas=0;
    }
    //recibe una figura y devuelve el toString de la misma también suma +1 a las figuras mostradas
    public void mostrar(Figura f){
        System.out.println(f.toString());
        mostradas++;
    }
    //Devuelve el contador de figuras mostradas
    public int getMostradas() {
        return mostradas;
    }
}
