/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//PUNTO 1

/*1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)*/

package tema3;

/**
 *
 * @author maria
 */

//Variable de instancia
public class Triangulo {
    private double ladoUno;
    private double ladoDos;
    private double ladoTres;
    private String colorRelleno;
    private String colorLinea;
    
//Constructor
    public Triangulo(double unLadoUno,double unLadoDos,double unLadoTres, String relleno, String linea){
        ladoUno=unLadoUno;
        ladoDos=unLadoDos;
        ladoTres=unLadoTres;
        colorRelleno=relleno;
        colorLinea=linea;
    }    
//Constructor vacio    
    public Triangulo(){
    }
    
//Metodos GET
    public double getLadoUno(){
        return ladoUno;
    }

    public double getLadoDos(){
        return ladoDos;
    }

    public double getLadoTres(){
        return ladoTres;
    }    
    
    public String getcolorRelleno(){
        return colorRelleno;
    }

    public String getcolorLinea(){
        return colorLinea;
    }
    
//Metodos SET   
    
    public void setLadoUno(double unLadoUno){
        ladoUno=unLadoUno;
    }

    public void setLadoDos(double unLadoDos){
        ladoDos=unLadoDos;
    }

    public void setLadoTres(double unLadoTres){
        ladoTres=unLadoTres;
    }

    public void setColorRelleno(String unColorRelleno){
        colorRelleno=unColorRelleno;
    }

    public void setColorLinea(String unColorLinea){
        colorLinea=unColorLinea;
    }
//Metodo Perimetro
    public double calcularPerimetro(){
        double per = ladoUno+ladoDos+ladoTres;
        return per;
    }
    
//Metodo Area 
    public double calcularArea(){
        double s = (ladoUno+ladoDos+ladoTres)/2;
        return Math.sqrt(s*(s-ladoUno)*(s-ladoDos)*(s-ladoTres));
    }
}
