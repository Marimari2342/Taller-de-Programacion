/*
1- La UNLP desea administrar sus proyectos, investigadores y subsidios. Un proyecto
tiene: nombre, código, nombre completo del director y los investigadores que participan
en el proyecto (50 como máximo). De cada investigador se tiene: nombre completo,
categoría (1 a 5) y especialidad. Además, cualquier investigador puede pedir hasta un
máximo de 5 subsidios. De cada subsidio se conoce: el monto pedido, el motivo y si fue
otorgado o no.
i) Implemente el modelo de clases teniendo en cuenta:
c. Un subsidio sólo debería poder construirse con el monto pedido y el motivo.
Un subsidio siempre se crea en estado no-otorgado.
 */
package repaso;

/**
 *
 * @author maria
 */
public class Subsidio {
    //Variables de instancia
    private double monto;
    private String motivo;
    private boolean otorgado;
    
    //Constructor
    public Subsidio (double unMonto, String unMotivo){
        monto = unMonto;
        motivo = unMotivo;
        otorgado = false;
    }
    
    //Getters y Setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
    
}
