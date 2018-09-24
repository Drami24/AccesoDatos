/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author a14damianld
 */
public class XeradorMenus {

    public void mostrarMenuInicial() {
        byte eleccionMenu;
        do {
            System.out.println("Benvido á libreria de Damián\n"
                    + "1. Insertar filas\n"
                    + "2. Borrar filas\n"
                    + "3. Modificar rexistros\n"
                    + "4. Consultar rexistros");
            eleccionMenu = new EntradaTeclado().leerByteTeclado();
            switch (eleccionMenu) {
                case 1:
                    mostrarMenuInsertar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.err.println("Opción incorrecta");
            }
        } while (eleccionMenu != 0);
    }
    
    private void mostrarMenuInsertar() {
        byte eleccionMenu;
        do {
            System.out.println("Benvido á rede social CaraLibro\n"
                    + "1. Insertar libro\n"
                    + "2. Insertar autor\n"
                    + "0. Atrás");
            eleccionMenu = new EntradaTeclado().leerByteTeclado();
            switch (eleccionMenu) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.err.println("Opción incorrecta");
            }
        } while (eleccionMenu != 0);
    }

}
