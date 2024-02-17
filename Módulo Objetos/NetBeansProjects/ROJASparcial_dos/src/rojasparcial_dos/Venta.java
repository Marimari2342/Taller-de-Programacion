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
public class Venta {
    //Variables de instancia
    private int clienteDNI;
    private int cantLitros;
    private double montoAbonado;
    private String medioPago;
    
    //Constructor
    public Venta(int unDNIcliente,int unaCantLitros,double unMonto,String unMedioPago){
        clienteDNI=unDNIcliente;
        cantLitros=unaCantLitros;
        montoAbonado=unMonto;
        medioPago=unMedioPago;
    }
    
    //Getters y Setters
    public int getClienteDNI() {
        return clienteDNI;
    }

    public int getCantLitros() {
        return cantLitros;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public String getMedioPago() {
        return medioPago;
    }
     
    //Metodos   
    public String toString(){
        return "    DNI cliente: "+this.getClienteDNI()+", cantidad de litros cargados: "+
                this.cantLitros+", monto abonado: "+this.montoAbonado+", medio de pago: "+
                this.medioPago+"\n";
    }
}
