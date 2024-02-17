/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_cuatro;

/**
 *
 * @author maria
 */
public class Estacionamiento {
    //Variables de instancia
    private String direccion;
    private double costoXhora;
    private Vehiculo [][] lugares;
    private int cantSectores;
    private int cantVehiculosXsector;
    
    //Constructor
    public Estacionamiento(String unaDireccion,double unCostoXhora,int sectores, int vehicXsector){
        direccion=unaDireccion;
        costoXhora=unCostoXhora;
        cantSectores=sectores;
        cantVehiculosXsector=vehicXsector;
        lugares = new Vehiculo [cantSectores][cantVehiculosXsector];
    }
    
    //Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public double getCostoXhora() {
        return costoXhora;
    }

    public Vehiculo[][] getLugares() {
        return lugares;
    }

    public int getCantSectores() {
        return cantSectores;
    }

    public int getCantVehiculosXsector() {
        return cantVehiculosXsector;
    }
 
    //Metodos
    public void registrarUnVehiculo(Vehiculo unVehiculo,int s, int v){  //(a)registrar un vehiculo
        this.getLugares()[s][v]=unVehiculo;
    }
    
    public String liberarLugaresXMarca(String unaMarca, int unSector){  //(b)liberar lugares dado un
        String aux="";                                                  //sector y una marca
        for (int i=0;i<this.cantVehiculosXsector;i++)
            if(this.getLugares()[unSector][i].getMarca().equals(unaMarca)){
                aux+=this.getLugares()[unSector][i].toString()+"\n";
                this.getLugares()[unSector][i]=null;
            }
        return aux;                
    }
    
    public int sectorQueMasRecaudo(){       //(c)Obtener el numero del sector que más recaudo
        int maxSec=0;
        double maxRec=0;
        double aux=0;
        for (int i=0;i<this.cantSectores;i++){
            aux=0;
            for (int j=0;j<this.cantVehiculosXsector;j++)
                aux+=((double)this.getLugares()[i][j].getHorasEstacionado())*(this.getCostoXhora());
            if(aux>maxRec){
                maxSec=i;
                maxRec=aux;
            }   
        }
        return maxSec; 
    }
    
    public String mostrarVehiculos(){           //(d)string que representa al estacionamiento
        String aux="";
        aux="Estacionamiento: direccion "+this.getDireccion()+", costo por hora "+
                this.getCostoXhora()+". \n";
        for (int i=0;i<this.cantSectores;i++){
            aux+="Sector "+i+": \n";
            for (int j=0;j<this.cantVehiculosXsector;j++)
                if(this.getLugares()[i][j]!=null)
                    aux+="Lugar "+j+": "+this.getLugares()[i][j].toString()+"\n";
        }
        return aux;        
    }
}
