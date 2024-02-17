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
public class ParcialMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instancio un curso presencial y otro a distancia
        Distancia cursoDistancia = new Distancia(2020,10,"www.curso.com");
        Presencial cursoPresencial = new Presencial(2021,8,15);
        //Agrego alumnos en cada curso
        Alumno aluUno = new Alumno(12456789,"Juan");
        Alumno aluDos = new Alumno(15456789,"Maria");
        Alumno aluTres = new Alumno(23568945,"Alejo");
        Alumno aluCuatro = new Alumno(45124567,"Marta");
        cursoDistancia.agregarAlumno(aluUno);
        cursoDistancia.agregarAlumno(aluDos);
        cursoPresencial.agregarAlumno(aluTres);
        cursoPresencial.agregarAlumno(aluCuatro);
        //Incremento asistencia y evaluaciones
        cursoDistancia.incrementarAsistencia(12456789);
        cursoDistancia.incrementarAsistencia(12456789);
        cursoDistancia.incrementarAsistencia(15456789);
        cursoDistancia.aprobarEvaluacion(12456789);
        cursoDistancia.aprobarEvaluacion(12456789);
        cursoDistancia.aprobarEvaluacion(12456789);
        cursoPresencial.incrementarAsistencia(23568945);
        cursoPresencial.incrementarAsistencia(23568945);
        cursoPresencial.incrementarAsistencia(23568945);
        cursoPresencial.incrementarAsistencia(45124567);
        //Imprimo cantidad de alumnos en condiciones de rendir
        System.out.println(cursoPresencial.cantAlumnosQuePuedenRendir());
        System.out.println(cursoDistancia.cantAlumnosQuePuedenRendir());
    }
    
}
