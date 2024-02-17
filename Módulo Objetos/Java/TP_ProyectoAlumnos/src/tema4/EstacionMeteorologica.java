/*
De la estación, interesa conocer: nombre, y latitud y longitud donde se encuentra.
 */
package tema4;

/**
 *
 * @author maria
 */
public class EstacionMeteorologica {
    //Variables de instancia
    private String nombre;
    private String latitud;
    private String longitud;
    
    //Constructor
    public EstacionMeteorologica(String unNombre, String unaLatitud, String unaLongitud){
        nombre=unNombre;
        latitud=unaLatitud;
        longitud=unaLongitud;
    }
    
    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }
    
    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
    //Metodos [La Plata (34,921 S - 57,955 O):]
    public String toString(){
        return getNombre()+" ("+getLatitud()+" - "+getLongitud()+"): ";
    }
}
