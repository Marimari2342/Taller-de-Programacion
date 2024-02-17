/*
2-A- Modifique la clase Libro.java (carpeta tema3) para ahora considerar que el primer
autor es un objeto instancia de la clase Autor.
Implemente la clase Autor, sabiendo que se caracterizan por nombre, biografía y origen
y que deben permitir devolver/modificar el valor de sus atributos y devolver una
representación String formada por nombre, biografía y origen.
Luego realice las modificaciones necesarias en la clase Libro.
 */
package tema3;


public class Autor {
    //Variable de instancia
    private String nombre;
    private String biografia;
    private String origen;
    
    //Constructores
    public Autor(String unNombre, String unaBiografia, String unOrigen){
        nombre=unNombre;
        biografia=unaBiografia;
        origen=unOrigen;
    }
    public Autor(){
    }
    
    //Metodos get
    public String getNombre(){
        return nombre;
    }
    
    public String getBiografia(){
        return biografia;
    }
    
    public String getOrigen(){
        return origen;
    }
    
    //Metodos set
    public void setNombre(String unNombre){
        nombre=unNombre;
    }
    
    public void setBiografia(String unaBiografia){
        biografia=unaBiografia;
    }
    
    public void setOrigen(String unOrigen){
        origen=unOrigen;
    }
    
    //Representacion en String
    public String toString(){
        String aux = ("Biografia del autor "+nombre+" de origen "+origen+": "+biografia);
        return aux;        
    }
}
