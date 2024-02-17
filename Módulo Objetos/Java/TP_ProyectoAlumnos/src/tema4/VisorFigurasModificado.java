/*
5-A- Modifique la clase VisorFiguras: ahora debe permitir guardar las figuras a mostrar (a
lo sumo 5) y también mostrar todas las figuras guardadas. Use la siguiente estructura.
 */
package tema4;

/**
 *
 * @author maria
 */
public class VisorFigurasModificado {
    //Variables de instancia
    private int guardadas;
    private int capacidadMaxima=5;
    private Figura [] vector;
    //Constructor
    public VisorFigurasModificado(){
        guardadas=0;
        vector = new Figura[capacidadMaxima];
    }
    
    //Metodos
    public void guardar(Figura f){
        if (guardadas<capacidadMaxima){
            vector[guardadas]=f;
            guardadas+=1;
        }
    }
    public boolean quedaEspacio(){
        if(guardadas<capacidadMaxima)
            return true;
        else
            return false;
    }
    public void mostrar(){
        int i;
        for (i=0;i<guardadas;i++)
            vector[i].toString();
    }
    public int getGuardadas() {
        return guardadas;
    }
    
}
