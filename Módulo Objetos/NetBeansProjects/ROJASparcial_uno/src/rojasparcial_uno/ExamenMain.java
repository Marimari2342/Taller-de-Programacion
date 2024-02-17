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
public class ExamenMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancio una empresa
        Director unDirector = new Director("Juan Perez",18789678,2014,100000);
        Empresa unaEmpresa = new Empresa("Georgalos","13 y 115",unDirector,20);
        
        //Cargo encargados
        Encargado encargadoUno = new Encargado("Karina Ramirez",22568954,2020,10);
        unaEmpresa.asignarEncargado(encargadoUno, 2);
        Encargado encargadoDos = new Encargado("Juana Breit",37568421,2010,15);
        unaEmpresa.asignarEncargado(encargadoDos, 4);
        Encargado encargadoTres = new Encargado("Martin Jensen",30568945,2017,14);
        unaEmpresa.asignarEncargado(encargadoTres, 15);
        
        //Representacion de la empresa
        //System.out.println(unaEmpresa.toString());
        
        /*/Testeo
                String aux="";
        boolean existeSin=false;
        for (int i=0;i<=unaEmpresa.getdF();i++){
            if(unaEmpresa.getVectorSucursales()[i].isHayEnc())
                aux += "Encargado de sucursal "+(i+1)+": "+
                        unaEmpresa.getVectorSucursales()[i].toString()+"./n";
            else
                existeSin=true;
        }
        if(existeSin)
            aux+= "Hay al menos una sucursal sin Encargado.";
        System.out.println(aux);*/
        
    }
    
}
