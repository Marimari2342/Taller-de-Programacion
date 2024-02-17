/*
4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.

(ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/
2000 y 8000.
 */
package tema3;

import tema2.Persona;

/**
 *
 * @author maria
 */
public class Hotel {
    //Variables de instancia
    private int numHab=0;
    private final Habitacion [] cuartosHotel = new Habitacion[numHab];
    
    //Constructor
    public Hotel(int unNumHab){   //Hotel para N habitaciones (cada una desocupada y con 
       numHab=unNumHab;           //costo aleatorio e/ 2000 y 8000 LO CONFIGURO EN Habitacion)
       Habitacion nueva;
       for(int i=0;i<unNumHab;i++){
          nueva = new Habitacion();
          cuartosHotel[i]=nueva;
       }
    }

    public int getNumHab() {
        return numHab;
    }
    
    /*- Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
    en el rango 1..N) y que la habitación está libre.*/
    public void ingresarCliente(Persona unaPersona, int numH){
        cuartosHotel[numH].setCliente(unaPersona);
    }
    
    /*- Aumentar el precio de todas las habitaciones en un monto recibido.*/
    public void aumentarPrecios(double monto){
        for (int j=0;j<numHab;j++)
            cuartosHotel[j].aumentarPrecioHabitacion(monto);
    }
    
    /*- Obtener la representación String del hotel, siguiendo el formato:
    {Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}*/
    public String toString(int num){
        String rep;
        if (cuartosHotel[num].isOcupada()==true)
            rep = ("Habitacion "+(num+1)+", costo: "+cuartosHotel[num].getCostoNoche()+
                ", Ocupada por: "+cuartosHotel[num].getCliente().toStringB());
        else
            rep = ("Habitacion "+(num+1)+", costo: "+cuartosHotel[num].getCostoNoche()+", Libre.");
        return rep;
    }
}