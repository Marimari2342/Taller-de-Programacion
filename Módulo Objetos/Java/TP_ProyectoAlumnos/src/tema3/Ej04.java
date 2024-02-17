/*
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
 */
package tema3;

import tema2.Persona;
import PaqueteLectura.Lector;
/**
 *
 * @author maria
 */
public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instancio un Hotel
        System.out.println("Ingrese cantidad de habitaciones de su hotel");
        Hotel miHotel = new Hotel(Lector.leerInt());
        
        //Muestro hotel Cero vez
        miHotel.toString(0);
        int mi;
        for (mi=0;mi<miHotel.getNumHab();mi++)
            miHotel.toString(mi);
        
        //Ingreso Clientes
        Persona unCLiente;
        System.out.println("Ingrese nombre de cliente");
        String unNombre = Lector.leerString();
        int i=0;
        while (i<miHotel.getNumHab() && !unNombre.equals("ZZZ")){
            System.out.println("Ingrese DNI y edad");
            unCLiente = new Persona(unNombre,Lector.leerInt(),Lector.leerInt());
            System.out.println("Ingrese numero de habitacion del cliente");
            miHotel.ingresarCliente(unCLiente, Lector.leerInt());
            i+=1;
            System.out.println("Ingrese nombre de cliente");
            unNombre = Lector.leerString();
        }
        //Muestro hotel Primera vez
        i=0;
        for (i=0;i<miHotel.getNumHab();i++)
            miHotel.toString(i);
        //Aumento Precio
        i=0;
        System.out.println("Ingrese el monto a aumentar");
        for (i=0;i<miHotel.getNumHab();i++)
            miHotel.aumentarPrecios(Lector.leerDouble());
        //Muestro hotel Segunda vez
        i=0;
        for (i=0;i<miHotel.getNumHab();i++)
            miHotel.toString(i);
    }
    
}
