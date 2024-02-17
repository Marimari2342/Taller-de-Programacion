/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_uno;

/**
 *
 * @author maria
 */
public class Empresa {
    //Variables de instancia
    private String nombre;
    private String direccion;
    private Director director;
    private Encargado [] vectorSucursales;
    private int dF;

    //Constructor
    public Empresa (String unNombre,String unaDireccion,Director unDirector,int sucurMax){
        nombre=unNombre;
        direccion=unaDireccion;
        director=unDirector;
        dF=sucurMax;
        vectorSucursales = new Encargado[sucurMax];
    }
    
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Director getDirector() {
        return director;
    }

    public Encargado[] getVectorSucursales() {
        return vectorSucursales;
    }

    public int getdF() {
        return dF;
    }

    //Metodos
    public void asignarEncargado(Encargado unEncargado,int x){ //(1)Asignar encargado a sucursal x
        vectorSucursales[x-1]=unEncargado;
    }
    
    public String mostrarEncargados(){
        String aux="";
        boolean existeSin=false;
        for (int i=0;i<=dF;i++){
            if(vectorSucursales[i]!=null)
                aux += "Encargado de sucursal "+(i+1)+": "+vectorSucursales[i].toString()+"./n";
            else
                existeSin=true;
        }
        if(existeSin)
            aux+= "Hay al menos una sucursal sin Encargado.";
        return aux;
    }
    
    public String toString(){
        return "Nombre empresa: "+this.getNombre()+" | Direccion: "+this.getDireccion()+
               "Director: "+this.getDirector().toString()+this.mostrarEncargados();
    }
}

