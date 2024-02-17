/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_cuatro;

/**
 *
 * @author maria
 */
public class ParcialMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancio un estacionamiento
        Estacionamiento unEstacionamiento= new Estacionamiento("Calle 115",300,5,4);
        //Registro vehiculos
        Vehiculo autoUno = new Vehiculo("1234",10,"Fiat","Palio");
        unEstacionamiento.registrarUnVehiculo(autoUno, 0, 0);
        Vehiculo autoDos = new Vehiculo("1589",2,"Ford","Fiesta");
        unEstacionamiento.registrarUnVehiculo(autoDos, 0, 3);
        Vehiculo autoTres = new Vehiculo("4512",4,"Ford","Ka");
        unEstacionamiento.registrarUnVehiculo(autoTres, 2, 2);
        //Compruebo funcionamiento
        System.out.println(unEstacionamiento.mostrarVehiculos());
        System.out.println("Sector que más recaudo: "+unEstacionamiento.sectorQueMasRecaudo());
        System.out.println(unEstacionamiento.liberarLugaresXMarca("Ford", 0));
        System.out.println(unEstacionamiento.mostrarVehiculos());
    }
    
}
