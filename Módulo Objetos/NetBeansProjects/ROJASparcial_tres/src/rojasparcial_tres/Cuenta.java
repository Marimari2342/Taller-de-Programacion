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
public class Cuenta {
    //Variables de instancia
    private int cbu;
    private String alias;
    private int dni;
    private String moneda;
    private double monto;
    
    //Constructor
    public Cuenta (int unCBU,String unAlias,int unDNI,String unaMoneda){
        cbu=unCBU;
        alias=unAlias;
        dni=unDNI;
        moneda=unaMoneda;
        monto=0;
    }
    
    //Getters
    public int getCbu() {
        return cbu;
    }

    public String getAlias() {
        return alias;
    }

    public int getDni() {
        return dni;
    }

    public String getMoneda() {
        return moneda;
    }

    public double getMonto() {
        return monto;
    }
    
    //Metodos
    public void agregarMonto(double unMonto){       //(c)depositar un monto en una cuenta
        this.monto+=unMonto;
    }
}
