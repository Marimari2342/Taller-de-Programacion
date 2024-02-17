/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_tres;

/**
 *
 * @author maria
 */
public class pruebaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancio un banco tradicional y otro digital
        Tradicional unBancoTradicional = new Tradicional("Banco Rio",20,150,"13 uy 50","La Plata");
        Digital unBancoDigital = new Digital("Banco Santander",30,200,"www.bancosantander.com");
        
        //agrego cuentas bancarias
        Cuenta cuentaUno = new Cuenta(123456789,"miCuenta",15465789,"Dolares");
        Cuenta cuentaDos = new Cuenta(456798135,"miCuentaDos",45123789,"Pesos");
        Cuenta cuentaTres = new Cuenta(789564512,"miCuentaTres",32654987,"Dolares");
        unBancoTradicional.agregarCuenta(cuentaDos);
        unBancoTradicional.agregarCuenta(cuentaUno);
        unBancoDigital.agregarCuenta(cuentaTres);
        
        //depositar dinero
        unBancoDigital.depositarDinero(789564512, 600);
        unBancoTradicional.depositarDinero(456798135, 40000);
        unBancoTradicional.depositarDinero(123456789, 650);
        //puede recibir tarjeta
        System.out.println(unBancoDigital.puedeRecibirTarjeta(789564512));
        System.out.println(unBancoTradicional.puedeRecibirTarjeta(456798135));
        System.out.println(unBancoTradicional.puedeRecibirTarjeta(123456789));
        
    }
    
}
