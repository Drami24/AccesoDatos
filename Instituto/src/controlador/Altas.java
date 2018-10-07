/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.BaseDatos;
import modelo.Profesor;
import vistas.Insercions;

/**
 *
 * @author dalod
 */
public class Altas {
    
    public static void altaProfesor(){
        BaseDatos.insertarProfesor(Insercions.profesor());
    }
}
