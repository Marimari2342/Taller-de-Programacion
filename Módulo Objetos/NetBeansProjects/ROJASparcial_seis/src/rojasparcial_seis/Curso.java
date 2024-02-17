/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rojasparcial_seis;

/**
 *
 * @author maria
 */
public abstract class Curso {
    //Variables de instancia
    private int anioCursada;
    private int cantAlumnos;
    private int dL=0;
    private Alumno [] infoAlumnos;
    
    //Constructor
    public Curso(int unAnio, int unaCantAlu){
        anioCursada=unAnio;
        cantAlumnos=unaCantAlu;
        infoAlumnos = new Alumno[cantAlumnos];
    }
    
    //Getters
    public int getAnioCursada() {
        return anioCursada;
    }

    public int getCantAlumnos() {
        return cantAlumnos;
    }

    public int getdL() {
        return dL;
    }

    public Alumno[] getInfoAlumnos() {
        return infoAlumnos;
    }
    
    //Metodos
    public boolean agregarAlumno(Alumno unAlumno){      //(a)agregar un alumno
        if (this.getdL()<this.getCantAlumnos()){
            this.getInfoAlumnos()[dL]=unAlumno;
            this.dL+=1;
            return true;
        }
        else 
            return false;
    }
    
    public void incrementarAsistencia(int unDni){        //(b)dado un dni, incrementar la asistencia
        int aux=0;
        while(aux<this.getdL()&&this.getInfoAlumnos()[aux].getDni()!=unDni)
            aux+=1;
        if(this.getInfoAlumnos()[aux].getDni()==unDni)
            this.getInfoAlumnos()[aux].asistio();
    }       
    
    public void aprobarEvaluacion(int unDni){        //(c)dado un dni, sumar evaluacion aprobada
        int aux=0;
        while(aux<this.getdL()&&this.getInfoAlumnos()[aux].getDni()!=unDni)
            aux+=1;
        if(this.getInfoAlumnos()[aux].getDni()==unDni)
            this.getInfoAlumnos()[aux].aprobo();
    }    
    
    public abstract boolean puedeRendir(Alumno unAlu);          //(d)puede rendir
    
    public int cantAlumnosQuePuedenRendir(){            //(e)cantidad alumnos que pueden rendir
        int cant=0;
        for (int i=0;i<dL;i++)
            if (this.puedeRendir(this.getInfoAlumnos()[i]))
                cant+=1;
        return cant;
    }
}
