/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import vistas.Menus;
import static vistas.Menus.mostrarMenuAltas;

/**
 *
 * @author dalod
 */
public class ControladorMenu {

    public static void menuAltas() {
        byte eleccionMenu;
        do {
            eleccionMenu = Menus.mostrarMenuAltas();
            switch (eleccionMenu) {
                case 0:
                    System.out.println("Volves atrás");
                    break;
                case 1:
                    Altas.altaProfesor();
                    break;
                case 2:
                    break;
                default:
                    System.err.println("Opción incorrecta");
            }
        } while (eleccionMenu != 0);
    }

    public static void mostrarMenuInicial() {
        byte eleccionMenu;
        do {
            eleccionMenu = Menus.mostrarMenuPrincipal();
            switch (eleccionMenu) {
                case 0:
                    System.out.println("O programa cerrouse con éxito");
                    break;
                case 1:
                    menuAltas();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.err.println("Opción incorrecta");
            }
        } while (eleccionMenu != 0);
    }
}
