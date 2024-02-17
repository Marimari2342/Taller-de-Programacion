/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author maria
 */
public class SistemaMes extends SistemaMeteo {
    
    //Constructor
    public SistemaMes(EstacionMeteorologica unaEstacion, int unAnio, int unaCantAnios){
        super(unaEstacion,unAnio,unaCantAnios);
        this.iniciarVectorPromedios(12);
    }
    
    //Metodos
    public void calcularPromedio(){
        double aux;
        for(int i=0;i<12;i++){
            aux=0;
            for(int j=0;j<getCantAnios();j++)
                aux+=getCalendario()[j][i];
            this.getVectorPromedios()[i]=aux/12;
        }
    }
    
    public String mostrarDatos(){
        String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre",
            "Octubre","Noviembre","Diciembre"};
        String aux="";
        for (int i=0;i<12;i++)
            aux+= "- "+meses[i]+" :"+this.getVectorPromedios()[i]+" °C \n";
        return aux;
    }
    

/*- La versión del sistema que reporta por meses deberá calcular el promedio para
cada mes (el promedio del mes M se calcula con los datos de todos los años en ese
mes).
Ej: “La Plata (34,921 S - 57,955 O):
- Enero: 28,2 ºC;
- Febrero: 26,8 ºC;
- Marzo: 24.3 ºC
- …..”
Nota: Suponga que ya están registradas las temperaturas de todos los meses
y años. Utilice el carácter \n para concatenar un salto de línea.*/
   
    
}
