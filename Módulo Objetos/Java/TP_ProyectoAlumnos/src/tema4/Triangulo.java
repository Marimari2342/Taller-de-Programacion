/*
1-A- Incluya la clase Triángulo a la jerarquía de figuras vista (carpeta tema4). Triángulo
debe heredar de Figura todo lo que es común y definir su constructor y sus atributos y
métodos propios. Además debe redefinir el método toString.
 */
package tema4;

/**
 *
 * @author maria
 */
public class Triangulo extends Figura{
    //Variables de instancias
    private double ladoUno;
    private double ladoDos;
    private double ladoTres;

    //Constructor
    public Triangulo(double miLadoUno,double miLadoDos,double miLadoTres,String unColorR,String unColorL){
        super(unColorR,unColorL);
        ladoUno=miLadoUno;
        ladoDos=miLadoDos;
        ladoTres=miLadoTres;
    }
    
    //Getters
    public double getLadoUno() {
        return ladoUno;
    }

    public double getLadoDos() {
        return ladoDos;
    }

    public double getLadoTres() {
        return ladoTres;
    }
    
    //Setters
    public void setLadoUno(double ladoUno) {
        this.ladoUno = ladoUno;
    }

    public void setLadoDos(double ladoDos) {
        this.ladoDos = ladoDos;
    }

    public void setLadoTres(double ladoTres) {
        this.ladoTres = ladoTres;
    }
    
    //Otros metodos
    public double calcularArea() {
        double p = (getLadoUno()+getLadoDos()+getLadoTres())/2;
        return Math.sqrt(p*(p-getLadoUno())*(p-getLadoDos())*(p-getLadoTres()));
    }

    public double calcularPerimetro() {
        double perimetro = getLadoUno()+getLadoDos()+getLadoTres();
        return perimetro;
    }
    
    public String toString(){
        String descrip = super.toString()+" Lados: "+getLadoUno()+" | "+getLadoDos()+" | "+getLadoTres();
        return descrip;
    }
    
}
