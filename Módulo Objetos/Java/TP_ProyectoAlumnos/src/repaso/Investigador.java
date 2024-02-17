/*
1- La UNLP desea administrar sus proyectos, investigadores y subsidios. Un proyecto
tiene: nombre, código, nombre completo del director y los investigadores que participan
en el proyecto (50 como máximo). De cada investigador se tiene: nombre completo,
categoría (1 a 5) y especialidad. Además, cualquier investigador puede pedir hasta un
máximo de 5 subsidios. De cada subsidio se conoce: el monto pedido, el motivo y si fue
otorgado o no.
i) Implemente el modelo de clases teniendo en cuenta:
b. Un investigador sólo debería poder construirse con nombre, categoría y
especialidad.
 */
package repaso;

/**
 *
 * @author maria
 */
public class Investigador {
    //Variables de instancia
    private String nombre;
    private int categoria;
    private String especialidad;
    private int cantSub=0;
    private int maxSub=5;
    private Subsidio [] subsidios; 
    
    //Constructor
    public Investigador(String unNombre,int unaCategoria,String unaEspecialidad){
        nombre = unNombre;
        categoria = unaCategoria;
        especialidad = unaEspecialidad;
        subsidios = new Subsidio [maxSub];
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCantSub() {
        return cantSub;
    }

    public int getMaxSub() {
        return maxSub;
    }

    public Subsidio[] getSubsidios() {
        return subsidios;
    }

    //Metodos 
    public void agregarSubsidio(Subsidio unSubsidio){
        if(getCantSub()<getMaxSub()){
            subsidios[getCantSub()]=unSubsidio;
            cantSub+=1;
        }
    }

    public double dineroOtorgado(){
        int total=0;
        int i;
        for (i=0;i<getCantSub();i++)
            if(this.subsidios[i].isOtorgado())
                total+=this.subsidios[i].getMonto();
        return total;
    }
    
    public void otorgarSubsidios(){
        int pos;
        for (pos=0;pos<cantSub;pos++)
            if (!this.subsidios[pos].isOtorgado())
                this.subsidios[pos].setOtorgado(true);            
    }
/*la siguiente información de cada
investigador: nombre, categoría, especialidad, y el total de dinero de sus
subsidios otorgados.*/   
    public String toString(){
        return "Investigador: "+this.nombre+" | Categoria: "+this.categoria+
               " | Especialidad: "+this.especialidad+" | Dinero otorgado: $"+this.dineroOtorgado()+"/n";
    }
}
