/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:

getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate()retorna un boolean que indica si hubo (true) o no hubo (false) empate

Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:*/
package tema2;


import PaqueteLectura.Lector;
/**
 *
 * @author maria
 */
public class Ej05 {
    public static void main(String[] argn){
        Partido [] vectorPartidos = new Partido[20];
        String visitante = Lector.leerString();
        int dF=0;
        while ((dF<20)&&(!visitante.equals("ZZZ"))){
            Partido nuevoPartido = new Partido (Lector.leerString(),visitante,Lector.leerInt(),Lector.leerInt());
            vectorPartidos[dF]= nuevoPartido;
            dF+=1;
            visitante = (Lector.leerString());
        }
/*- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
  - Calcular e informar la cantidad de partidos que ganó River.
  - Calcular e informar el total de goles que realizó Boca jugando de local.*/        
        int i;
        int cantGanadosRiver=0;
        int cantGolesBoca=0;
        for(i=0;i<dF;i++){
            System.out.println(vectorPartidos[i].getLocal()+" "+vectorPartidos[i].getGolesLocal()+" VS "+vectorPartidos[i].getVisitante()+" "+vectorPartidos[i].getGolesVisitante());
            if((vectorPartidos[i].getLocal().equals("River"))&&(vectorPartidos[i].getGolesLocal()>vectorPartidos[i].getGolesVisitante())){
              cantGanadosRiver+=1;
            }else if (vectorPartidos[i].getLocal().equals("Boca")){
              cantGolesBoca+=vectorPartidos[i].getGolesLocal();  
            }  
            if((vectorPartidos[i].getVisitante().equals("River"))&&(vectorPartidos[i].getGolesLocal()<vectorPartidos[i].getGolesVisitante())){
              cantGanadosRiver+=1;
            }
        }
        System.out.println("Cantidad de partidos ganados por River: "+cantGanadosRiver);
        System.out.println("Cantidad de goles de Boca: "+cantGolesBoca);
        
    }
}
