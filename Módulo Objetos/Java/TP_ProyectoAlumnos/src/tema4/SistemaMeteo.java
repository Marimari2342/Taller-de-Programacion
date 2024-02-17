/*
6- El Servicio Meteorológico Nacional necesita un sistema que permita registrar, para una
determinada estación meteorológica, la temperatura promedio mensual de N años
consecutivos a partir de un año A dado. Además, necesita dos versiones del sistema: una
que permita reportar el promedio histórico por años y otra que permita reportar el
promedio histórico por meses. Esto se detalla más adelante.
De la estación, interesa conocer: nombre, y latitud y longitud donde se encuentra.
Implemente las clases, constructores y métodos que considere necesarios para:
a) Crear el sistema de registro/reporte, que funcionará en una determinada estación,
para N años consecutivos a partir de un año A. Inicie cada temperatura en un valor
muy alto.
b) Registrar la temperatura de un mes y año recibidos por parámetro. Nota: El mes
está en rango 1..12 y el año está en rango A..A+N-1.
c) Obtener la temperatura de un mes y año recibidos por parámetro. Nota: El mes está
en rango 1..12 y el año está en rango A..A+N-1. En caso de no haberse registrado
temperatura para ese mes/año se retorna el valor muy alto.
d) Devolver un String que concatena el mes y año en que se registró la mayor
temperatura. Nota: Suponga que ya están registradas las temperaturas de todos
los meses y años.
e) Devolver un String con el nombre de la estación, su latitud y longitud, y los promedios
mensuales o anuales según corresponda:
- La versión del sistema que reporta por años deberá calcular el promedio para
cada año (el promedio del año X se calcula con los datos mensuales de ese año).
Ej: “La Plata (34,921 S - 57,955 O):
- Año 2020: 23,8 ºC;
- Año 2021: 26,1 ºC;
- Año 2022: 25,3 ºC. ”
- La versión del sistema que reporta por meses deberá calcular el promedio para
cada mes (el promedio del mes M se calcula con los datos de todos los años en ese
mes).
Ej: “La Plata (34,921 S - 57,955 O):
- Enero: 28,2 ºC;
- Febrero: 26,8 ºC;
- Marzo: 24.3 ºC
- …..”
Nota: Suponga que ya están registradas las temperaturas de todos los meses
y años. Utilice el carácter \n para concatenar un salto de línea.
f) Realice un programa principal que cree un Sistema con reporte anual para 3 años
consecutivos a partir del 2021, para la estación La Plata (latitud -34.921 y longitud -
57.955). Cargue todas las temperaturas (para todos los meses y años). Informe los
promedios anuales, y el mes y año en que se registró la mayor temperatura.
Luego cree un Sistema con informe mensual para 4 años a partir de 2020, para la
estación Mar del Plata (latitud -38.002 y longitud -57.556). Cargue todas las
temperaturas (para todos los meses y años). Informe los promedios mensuales, y el
mes y año en que se registró la mayor temperatura.
NOTA: Preste atención de no violar el encapsulamiento al resolver el ejercicio.
 */
package tema4;

/**
 *
 * @author maria
 */
public abstract class SistemaMeteo {
    //Variables de instancia
    private EstacionMeteorologica estacion;
        /*temperatura promedio mensual de N año consecutivos a partir de un año A dado.*/
    private int anio;
    private int cantAnios;
    private double [][] calendario;
    private double [] vectorPromedios;
    
    //Constructor
        /*a) Crear el sistema de registro/reporte, que funcionará en una determinada estación,
        para N años consecutivos a partir de un año A. */
    public SistemaMeteo(EstacionMeteorologica unaEstacion, int unAnio, int unaCantAnios){
        estacion = unaEstacion;
        anio = unAnio;
        cantAnios = unaCantAnios;
        calendario = new double[cantAnios][12];
        int i,j;
        for (i=0;i<cantAnios;i++)  /*Inicie cada temperatura en un valor muy alto.*/
            for (j=0;j<12;j++)
                calendario[i][j]=300;
    }
    //Getters y Setters
    public EstacionMeteorologica getEstacion() {
        return estacion;
    }

    public int getAnio() {
        return anio;
    }

    public int getCantAnios() {
        return cantAnios;
    }

    public double[][] getCalendario() {
        return calendario;
    }

    public double[] getVectorPromedios() {
        return vectorPromedios;
    }

    //------
    
        /*b) Registrar la temperatura de un mes y año recibidos por parámetro. Nota: El mes
        está en rango 1..12 y el año está en rango A..A+N-1.*/
    public void registrarTemp(double unaTemp,int unMes,int unAnio){
        calendario[unAnio-getAnio()][unMes-1]=unaTemp;
    }
    
        /*c) Obtener la temperatura de un mes y año recibidos por parámetro. Nota: El mes está
        en rango 1..12 y el año está en rango A..A+N-1. En caso de no haberse registrado
        temperatura para ese mes/año se retorna el valor muy alto.*/
    public double obtenerTemp (int unMes,int unAnio){
        return calendario [unAnio-getAnio()][unMes-1];
    }
    
        /*d) Devolver un String que concatena el mes y año en que se registró la mayor
        temperatura. Nota: Suponga que ya están registradas las temperaturas de todos
        los meses y años.*/
    public String mayorTemp(){
        double mayTemp=-50;
        int i,j;
        int mayMes=0;
        int mayAnio=0;
        for (i=getAnio();i<getAnio()+getCantAnios();i++)
            for (j=1;j<13;j++)
                if (obtenerTemp(j,i)>mayTemp){
                    mayTemp=obtenerTemp(j,i);
                    mayMes=j;
                    mayAnio=i;
                }
        return "La mayor temperatura se registro en el anio "+mayAnio+", en el mes de "+mayMes+".";
    }

        /*e) Devolver un String con el nombre de la estación, su latitud y longitud, y los promedios
mensuales o anuales según corresponda:
    Utilice el carácter \n para concatenar un salto de línea.*/
    public void iniciarVectorPromedios(int unNum){
        vectorPromedios = new double[unNum];
    }
    
    public abstract void calcularPromedio();
    public abstract String mostrarDatos();

    public String toString(){
        return getEstacion().toString()+"\n"+this.mostrarDatos();
    }
}
