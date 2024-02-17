/*
1- La UNLP desea administrar sus proyectos, investigadores y subsidios. Un proyecto
tiene: nombre, código, nombre completo del director y los investigadores que participan
en el proyecto (50 como máximo). De cada investigador se tiene: nombre completo,
categoría (1 a 5) y especialidad. Además, cualquier investigador puede pedir hasta un
máximo de 5 subsidios. De cada subsidio se conoce: el monto pedido, el motivo y si fue
otorgado o no.
i) Implemente el modelo de clases teniendo en cuenta:
a. Un proyecto sólo debería poder construirse con el nombre, código, nombre del
director.
 */
package repaso;

/**
 *
 * @author maria
 */
public class Proyecto {
    //Variables de instancia
    private String nombreProyecto;
    private int codigoProyecto;
    private String nombreDirector;
    private int cantInv=0;
    private int maxInv=50;
    private Investigador [] investigadores;
    
    //Constructor
    public Proyecto(String unNombreProy, int unCodigo, String unNombreDirector){
        nombreProyecto = unNombreProy;
        codigoProyecto = unCodigo;
        nombreDirector = unNombreDirector;
        investigadores = new Investigador[maxInv];
    }
    
    //Getters y Setters

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public int getCantInv() {
        return cantInv;
    }

    public int getMaxInv() {
        return maxInv;
    }

    //Metodos
    public void agregarInvestigador(Investigador unInvestigador){
        if(getCantInv()<getMaxInv()){
            investigadores[getCantInv()]=unInvestigador;
            cantInv+=1;
        }
    }   

/*devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
todos los subsidios otorgados de todos los investigadores)*/    
    public double dineroTotalOtorgado(){
        int total=0;
        int i;
        for (i=0;i<cantInv;i++)
            total+=this.investigadores[i].dineroOtorgado();
        return total;
    }

/*otorgar todos los subsidios no-otorgados del investigador llamado nombre_completo*/    
    public void otorgarTodos(String nombre_completo){
        int pos=0;
        while (pos<this.cantInv && !this.investigadores[pos].getNombre().equals(nombre_completo))
            pos+=1;
        if(this.investigadores[pos].getNombre().equals(nombre_completo))
           this.investigadores[pos].otorgarSubsidios(); 
    }
    
/*e. devolver un string con: nombre del proyecto, código, nombre del director, el
total de dinero otorgado del proyecto y la siguiente información de cada
investigador: nombre, categoría, especialidad, y el total de dinero de sus
subsidios otorgados.*/
    public String mostrarInvestigadores(){
        String aux="";
        for (int i=0;i<cantInv;i++)
            aux+=this.investigadores[i].toString();
        return aux;
    }
    
    public String toString(){
        return "Nombre del proyecto: "+this.nombreProyecto+" | Codigo del proyecto: "
                +this.codigoProyecto+" | Nombre del director: "+this.nombreDirector
                +" | Total del dinero otorgado al proyecto: $"+this.dineroTotalOtorgado()
                +this.mostrarInvestigadores();
    }
}
