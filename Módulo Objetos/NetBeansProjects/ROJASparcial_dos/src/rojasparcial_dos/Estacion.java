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
public class Estacion {
    //Variables de instancia
    private String direccion;
    private Surtidor [] vectorSurtidores;
    private int dL=0;
    private int dF=6;
    
    //Constructor
    public Estacion(String unaDireccion){
        direccion=unaDireccion;
        vectorSurtidores = new Surtidor[dF];
    }
    
    //Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public Surtidor[] getVectorSurtidores() {
        return vectorSurtidores;
    }

    public int getdL() {
        return dL;
    }

    public int getdF() {
        return dF;
    }
        
    //Metodos
    public void agregarSurtidor(Surtidor unSurtidor){   //(a)agregar un surtidor dado a la estacion
        if(dL<dF){
            this.getVectorSurtidores()[dL]=unSurtidor;
            dL+=1;
        }
    }
    
    public void agregarVentaASurtidor(Venta unaVenta,int n){     //(b)agregar una venta a un surtidor
        this.getVectorSurtidores()[n-1].agregarVenta(unaVenta);
    }
    
    public int numSurtidorMayorVenta(){     //(c)Surtidor con ayor monto total en efectivo
        int numMay=0;
        double montoMay=0;
        for (int i=0;i<dL;i++)
            if(montoMay<this.getVectorSurtidores()[i].calcularMonto()){
                numMay=i;
                montoMay=this.getVectorSurtidores()[i].calcularMonto();
            }
        return numMay;
    }
    
    public String mostrarSurtidores(){
        String aux="";
        for (int i=0;i<dL;i++)
            aux+= "Surtidor "+(i+1)+" : "+this.getVectorSurtidores()[i].toString()+"\n";
        return aux;
    }
    
    public String toString(){
        return "Estacion de servicio: Direccion "+this.getDireccion()+" | Cantidad de surtidores "
                +this.getdL()+"\n"+this.mostrarSurtidores();
    }
}
