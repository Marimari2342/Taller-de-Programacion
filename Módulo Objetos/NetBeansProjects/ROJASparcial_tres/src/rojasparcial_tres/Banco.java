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
public abstract class Banco {
    //Variables de instancia
    private String nombre;
    private int cantEmpl;
    private Cuenta [] infoCuentas;
    private int dF;    
    private int dL=0;

    //Constructor
    public Banco (String unNombre,int unaCantEmpleados,int unaCantCuentas){
        nombre=unNombre;
        cantEmpl=unaCantEmpleados;
        dF=unaCantCuentas;
        infoCuentas = new Cuenta[dF];
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getCantEmpl() {
        return cantEmpl;
    }

    public Cuenta[] getInfoCuentas() {
        return infoCuentas;
    }

    public int getdF() {
        return dF;
    }
    
    public int getdL() {
        return dL;
    }

    void incrementarDL(int num) {
        this.dL += num;
    }
    
    //Metodos
    public abstract void agregarCuenta(Cuenta unaCuenta);   //(a)agregar cuenta
    
    public Cuenta obtenerCuenta(int unCBU){     //(b)obtener cuenta de un CBU dado
        int i=0;
        while (i<dL && this.getInfoCuentas()[i].getCbu()!=unCBU)
            i+=1;
        if (this.getInfoCuentas()[i].getCbu()==unCBU)
            return this.getInfoCuentas()[i];
        else
            return null;
    }
    
    public void depositarDinero(int unCBU,double unMonto){     //(c)depositar un monto en una cuenta
        int i=0;
        while (i<dL && this.getInfoCuentas()[i].getCbu()!=unCBU)
            i+=1;
        if (this.getInfoCuentas()[i].getCbu()==unCBU)
             this.getInfoCuentas()[i].agregarMonto(unMonto);
    }    
    
    public abstract boolean verificar(Cuenta unaCuenta);    //punto(d)
    
    public boolean puedeRecibirTarjeta(int unCBU){     
        int i=0;
        while (i<dL && this.getInfoCuentas()[i].getCbu()!=unCBU)
            i+=1;
        if (this.getInfoCuentas()[i].getCbu()==unCBU)
            return this.verificar(this.getInfoCuentas()[i]);
        else
            return false;
    }
    
}