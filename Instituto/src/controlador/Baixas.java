/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.BaseDatos;
import vistas.Insercions;

/**
 *
 * @author a14damianld
 */
public class Baixas {

    public static void baixaProfesor() {
        BaseDatos.baixaProfesor(Insercions.dniProfesor());
    }

}
