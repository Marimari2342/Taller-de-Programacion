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
public class Digital extends Banco{
    //Variables de instancia
    private String direccionWeb;
    
    //Constructor
    public Digital (String unNombre,int unaCantEmpleados,int unaCantCuentas,String unaDirWeb){
        super(unNombre,unaCantEmpleados,unaCantCuentas);
        direccionWeb=unaDirWeb;
    }    
    
    //Getters
    public String getDireccionWeb() {
        return direccionWeb;
    }
    
    //Metodos   
    public void agregarCuenta(Cuenta unaCuenta){        //(a)agregar cuenta
        if (this.getdF()>this.getdL()){
            this.getInfoCuentas()[this.getdL()]=unaCuenta;
            this.incrementarDL(1);
        }
    }
    
    public boolean verificar(Cuenta unaCuenta){      //(d)pesos+100000
        if (unaCuenta.getMoneda().equals("Pesos")&&unaCuenta.getMonto()>100000)
            return true;
        else
            return false;
    }
}
