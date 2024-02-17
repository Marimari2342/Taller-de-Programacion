/*
2- Queremos representar a los empleados de un club: jugadores y entrenadores.
 Cualquier empleado se caracteriza por su nombre, sueldo básico y antigüedad.
A- Implemente la jerarquía de clases declarando atributos, métodos para
obtener/modificar su valor y constructores que reciban los datos necesarios.
 */
package tema4;

/**
 *
 * @author maria
 */
public abstract class Empleados {
    //Variables de estado
    private String nombre;
    private double sueldoBasico=30000;
    private int antiguedad;
    
    //Constructor
    public Empleados(String unNombre,int unaAntiguedad){
        nombre = unNombre;
        antiguedad = unaAntiguedad;
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    //Otros metodos
/*B- Cualquier empleado debe responder al mensaje calcularEfectividad. La efectividad
del entrenador es el promedio de campeonatos ganados por año de antigüedad, mientras
que la del jugador es el promedio de goles por partido.*/
    public abstract double calcularEfectividad();
    
/*C- Cualquier empleado debe responder al mensaje calcularSueldoACobrar. El sueldo a
cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad y además:*/
    public abstract double calcularSueldoACobrar();

/*D- Cualquier empleado debe responder al mensaje toString, que devuelve un String que
lo representa, compuesto por nombre, sueldo a cobrar y efectividad.*/
    public String toString(){
        return "Nombre: "+ getNombre()+"| Sueldo: "+ this.calcularSueldoACobrar()+
                "| Efectividad: "+this.calcularEfectividad();
    }
}


