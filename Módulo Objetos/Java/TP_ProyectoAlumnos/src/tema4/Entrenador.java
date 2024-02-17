/*
 Los entrenadores son empleados que se caracterizan por la cantidad de campeonatos
ganados.
 */
package tema4;

/**
 *
 * @author maria
 */
public class Entrenador extends Empleados{
    //Variables de estado
    private int campeonatosGanados;
    
    //Constructor
    public Entrenador (String unNombre,int unaAntiguedad,int unosCampeonatosGanados){
        super(unNombre,unaAntiguedad);
        campeonatosGanados = unosCampeonatosGanados;
    }
    
    //Getters
    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }
    
    //Setters
    public void setCampeonatosGanados(int campeonatosGanados) {
    this.campeonatosGanados = campeonatosGanados;
    }
/*B- La efectividad del entrenador es el promedio de campeonatos ganados por año de antigüedad.*/
    public double calcularEfectividad(){
        double efect = ((double)getCampeonatosGanados()/getAntiguedad());
        return efect;
    }
    
/*C- Cualquier empleado debe responder al mensaje calcularSueldoACobrar. El sueldo a
cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad y además:
     Para los entrenadores: se adiciona un plus por campeonatos ganados (5000$ si ha
ganado entre 1 y 4 campeonatos; $30.000 si ha ganado entre 5 y 10 campeonatos;
50.000$ si ha ganado más de 10 campeonatos).*/
    public double calcularSueldoACobrar(){
        double aux = getSueldoBasico()*(1+0.1*getAntiguedad());
        if (getCampeonatosGanados()>0)
            if (getCampeonatosGanados()<5)
                aux += 5000;
            else if (getCampeonatosGanados()<11)
                aux += 30000;
            else
                aux += 50000;
        return aux;
    }
}
