/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_dos;

/**
 *
 * @author maria
 */
public class ParcialMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instanciar estación
        Estacion unaEstacion = new Estacion("Calle 4 y 21");
        //Agregar surtidores
        Surtidor surtidorUno = new Surtidor("Premium", 1500);
        unaEstacion.agregarSurtidor(surtidorUno);
        Surtidor surtidorDos = new Surtidor("Super", 1200);
        unaEstacion.agregarSurtidor(surtidorDos);
        //Realizar ventas
        Venta ventaUno = new Venta(37456132, 10, 20000, "Efectivo");
        unaEstacion.agregarVentaASurtidor(ventaUno, 1);
        Venta ventaDos = new Venta(15689452, 4, 15000, "Debito");
        unaEstacion.agregarVentaASurtidor(ventaDos, 1);
        Venta ventaTres = new Venta(23564128, 6, 14000, "Efectivo");
        unaEstacion.agregarVentaASurtidor(ventaTres, 2);
        //Imprimir
        System.out.println(unaEstacion.toString());
    }

}
