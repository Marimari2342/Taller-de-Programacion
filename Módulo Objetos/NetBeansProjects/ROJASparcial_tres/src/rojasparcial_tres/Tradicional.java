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
public class Tradicional extends Banco{
    //Variables de instancia
    private String direccion;
    private String localidad;
    private int cantCuentasDolares;
    
    //Constructor
    public Tradicional (String unNombre,int unaCantEmpleados,int unaCantCuentas,String unaDir,
    String unaLocalidad){
        super(unNombre,unaCantEmpleados,unaCantCuentas);
        direccion=unaDir;
        localidad=unaLocalidad;
        cantCuentasDolares=0;
    }
    
    //Getters
    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getCantCuentasDolares() {
        return cantCuentasDolares;
    }
    
    //Metodos
    public void agregarCuenta(Cuenta unaCuenta){        //(a)agregar cuenta
        if (this.getdF()>this.getdL() && this.cantCuentasDolares<100){
            this.getInfoCuentas()[this.getdL()]=unaCuenta;
            this.incrementarDL(1);
            if(unaCuenta.getMoneda().equals("Dolares"))
                this.cantCuentasDolares+=1;
        }
    }
    
    public boolean verificar(Cuenta unaCuenta){      //(d)dolares+500 o pesos+70000
        if (unaCuenta.getMoneda().equals("Pesos")&&unaCuenta.getMonto()>70000)
            return true;
        else if (unaCuenta.getMoneda().equals("Dolares")&&unaCuenta.getMonto()>500)
            return true;
        else
            return false;        
    }
}
