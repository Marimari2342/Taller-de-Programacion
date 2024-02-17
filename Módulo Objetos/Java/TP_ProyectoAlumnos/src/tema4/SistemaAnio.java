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
public class SistemaAnio extends SistemaMeteo {
    
    //Constructor
    public SistemaAnio(EstacionMeteorologica unaEstacion, int unAnio, int unaCantAnios){
        super(unaEstacion,unAnio,unaCantAnios);
        this.iniciarVectorPromedios(unaCantAnios);
    }
    
    //Metodos
    public void calcularPromedio(){
        double aux;
        for(int i=0;i<getCantAnios();i++){
            aux=0;
            for(int j=0;j<12;j++)
                aux+=getCalendario()[i][j];
            this.getVectorPromedios()[i]=aux/this.getCantAnios();
        }
    }
    
    public String mostrarDatos(){
        String aux="";
        for (int i=0;i<this.getCantAnios();i++)
            aux+= "- Año "+this.getAnio()+" :"+this.getVectorPromedios()[i]+" °C \n";
        return aux;
    }
/*- La versión del sistema que reporta por años deberá calcular el promedio para
cada año (el promedio del año X se calcula con los datos mensuales de ese año).
Ej: “La Plata (34,921 S - 57,955 O):
- Año 2020: 23,8 ºC;
- Año 2021: 26,1 ºC;
- Año 2022: 25,3 ºC. ”
Nota: Suponga que ya están registradas las temperaturas de todos los meses
y años. Utilice el carácter \n para concatenar un salto de línea.*/
   
    
}
