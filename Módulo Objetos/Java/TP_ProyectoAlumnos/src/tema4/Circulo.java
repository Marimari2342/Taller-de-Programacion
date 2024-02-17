/*
B- De igual manera, incluya la clase Círculo a la jerarquía de figuras.
 */
package tema4;

/**
 *
 * @author maria
 */
public class Circulo extends Figura{
    //Variables de instancia
    private double radio;
    
    //Constructor
    public Circulo (double unRadio,String unColorRelleno,String unColorLinea){
        super(unColorRelleno,unColorLinea);
        radio=unRadio;
    }    
    
    //Getters
    public double getRadio(){    
        return radio;
    }
    
    //Setters
    public void setRadio(double radio) {    
        this.radio = radio;
    }
    
    //Metodos
    public double calcularArea() {
        return (Math.PI*getRadio()*getRadio());
    }
    public double calcularPerimetro(){
        return (2*Math.PI*getRadio());
    }
    
    //ToString
    public String toString(){
        return super.toString()+" Radio: "+getRadio();
    }
    
}
