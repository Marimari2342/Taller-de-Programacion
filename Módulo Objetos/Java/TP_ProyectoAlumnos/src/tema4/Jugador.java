/*
 Los jugadores son empleados que se caracterizan por el número de partidos jugados y
el número de goles anotados.
 */
package tema4;

/**
 *
 * @author maria
 */
public class Jugador extends Empleados{
    //Variables de estado
    private int partidos;
    private int goles;
    
    //Constructor
    public Jugador (String unNombre,int unaAntiguedad,int unosPartidos,int unosGoles){
        super(unNombre,unaAntiguedad);
        partidos = unosPartidos;
        goles = unosGoles;
    }
    
    //Getters
    public int getPartidos() {
        return partidos;
    }

    public int getGoles() {
        return goles;
    }
    
    //Setters
    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

/*B- La efectividad del jugador es el promedio de goles por partido.*/
    public double calcularEfectividad(){
        return ((double)getGoles()/getPartidos());
    }
    
/*C- Cualquier empleado debe responder al mensaje calcularSueldoACobrar. El sueldo a
cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad y además:
     Para los jugadores: si el promedio de goles por partido es superior a 0,5 se adiciona un
plus de otro sueldo básico.*/
    public double calcularSueldoACobrar(){
        double aux = getSueldoBasico()*(1+0.1*getAntiguedad());
        if (calcularEfectividad()>0.5)
            aux += getSueldoBasico();
        return aux;
    }
}
