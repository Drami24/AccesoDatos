/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.EntradaTeclado;
import modelo.Alumno;
import modelo.Profesor;

/**
 *
 * @author dalod
 */
public class Insercions {
    
    public static Profesor profesor(){
        System.out.println("Inserte o dni do profesor");
        String dni = EntradaTeclado.leerStringTeclado();
        System.out.println("Inserte o nome do profesor");
        String nome = EntradaTeclado.leerStringTeclado();
        System.out.println("Inserte a titulacion do profesor");
        String titulacion = EntradaTeclado.leerStringTeclado();
        return new Profesor(dni, nome, titulacion);
    }
    
    public static Alumno alumno(){
        System.out.println("Inserte o id do alumno");
        int idAlumno = EntradaTeclado.leerIntTeclado();
        System.out.println("Inserte o codigo do alumno");
        String codigo = EntradaTeclado.leerStringTeclado();
        System.out.println("Inserte a nome do alumno");
        String nome = EntradaTeclado.leerStringTeclado();
        return new Alumno(idAlumno, codigo, nome);
    }
    
}
