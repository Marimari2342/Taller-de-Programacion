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
public class Surtidor {
    //Variables de instancia
    private String combustible;
    private double precioLitro;
    private Venta [] infoVentas;
    private int dL=0;
    private int dF=5;
    
    //Constructor
    public Surtidor (String unCombustible,double unPrecioLitro){
        combustible=unCombustible;
        precioLitro=unPrecioLitro;
        infoVentas= new Venta[5];
    }
    
    //Getters y Setters
    public String getCombustible() {
        return combustible;
    }

    public double getPrecioLitro() {
        return precioLitro;
    }

    public Venta[] getInfoVentas() {
        return infoVentas;
    }

    public int getdL() {
        return dL;
    }

    public int getdF() {
        return dF;
    }
        
    //Metodos  
    public void agregarVenta(Venta unaVenta){       //(b)agregar una venta a un surtidor
        if (dL<dF){
            this.getInfoVentas()[dL]=unaVenta;
            dL+=1;
        }
    }
    
    public double calcularMonto(){      //(c)Surtidor con ayor monto total en efectivo
        double aux=0;
        for (int i=0;i<dF;i++)
            if (this.getInfoVentas()[i].getMedioPago().equals("Efectivo"))
                aux=this.getInfoVentas()[i].getCantLitros()*this.getPrecioLitro();
        return aux;
    }
    
    public String mostrarVentas(){
        String aux="";
        for (int i=0;i<dL;i++)
            aux+= this.infoVentas[i].toString();
        return aux;
    }
    
    public String toString(){
        return "Combustible dispensado: "+this.getCombustible()+". Precio por litro: "
                +this.getPrecioLitro()+". Ventas: \n"+this.mostrarVentas();
    }
    
}
