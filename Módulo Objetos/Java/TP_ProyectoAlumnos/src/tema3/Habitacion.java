/*
4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import tema2.Persona;
/**
 *
 * @author maria
 */
public class Habitacion {
    //Variables de instancia
    private double costoNoche;
    private final boolean ocupada;       //cada una desocupada y con costo 
    private Persona cliente = new Persona();   //aleatorio e/ 2000 y 8000.

    //Constructor
    public Habitacion(){
       costoNoche=GeneradorAleatorio.generarDouble(6000)+2000;  
       ocupada=false; 
    }
    
    //Getters
    public double getCostoNoche() {
        return costoNoche;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Persona getCliente() {
        return cliente;
    }

    //Setters
    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    
    //Aumentar precio por habitacion (lo llama Hotel)
    public void aumentarPrecioHabitacion(double monto){
        costoNoche+=monto;
    }
    
    
    
}
