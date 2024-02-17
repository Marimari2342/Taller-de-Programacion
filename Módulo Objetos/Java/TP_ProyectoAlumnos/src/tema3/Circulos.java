/*
5-A- Definir una clase para representar círculos. Los círculos se caracterizan por su radio
(double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
 */
package tema3;

/**
 *
 * @author maria
 */
public class Circulos {
    //Variables de instancia
    private double radio;
    private String colorRelleno;
    private String colorLinea;
    //Constructores
    public Circulos(double unRadio,String unColorRelleno,String unColorLinea){
        radio=unRadio;
        colorRelleno=unColorRelleno;
        colorLinea=unColorLinea;
    }   
    public Circulos(){       
    }    

    public double getRadio() {
        return radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    public double calcularPerimetro(){
        double perimetro = 2*Math.PI*radio;
        return perimetro;
    }
    public double calcularArea(){
        double area = Math.PI*radio*radio;
        return area;
    }
}
