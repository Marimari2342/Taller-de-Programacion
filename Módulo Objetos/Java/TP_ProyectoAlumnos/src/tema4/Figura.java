/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;


public abstract class Figura {
    private String colorRelleno;
    private String colorLinea;
   
    public Figura(String unCR, String unCL){
        setColorRelleno(unCR);
        setColorLinea(unCL);
    }
/*C- Añada a la representación String el valor del perímetro. Piense ¿qué método toString
debe modificar: el de cada subclase o el de Figura?*/
    public String toString(){
        String aux = "Area: " + this.calcularArea() + ", Perimetro: " + this.calcularPerimetro() + 
                     " CR: "  + getColorRelleno() + 
                      " CL: " + getColorLinea();             
             return aux;
       }

/*D- Añada el método despintar que establece los colores de la figura a línea “negra” y
relleno “blanco”. Piense ¿dónde debe definir el método: en cada subclase o en Figura?*/    
    public void despintar(){
        colorRelleno="Blanco";
        colorLinea="Negro";
    }
    
    
    public String getColorRelleno(){
        return colorRelleno;       
    }
    public void setColorRelleno(String unColor){
        colorRelleno = unColor;       
    }
    public String getColorLinea(){
        return colorLinea;       
    }
    public void setColorLinea(String unColor){
        colorLinea = unColor;       
    }
    
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
     
}
