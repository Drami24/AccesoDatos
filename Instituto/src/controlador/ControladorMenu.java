/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vistas.Menus;

/**
 *
 * @author a14damianld
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
                    Altas.altaAlumno();
                    break;
                default:
                    System.err.println("Opción incorrecta");
            }
        } while (eleccionMenu != 0);
    }

    public static void menuBaixas() {
        byte eleccionMenu;
        do {
            eleccionMenu = Menus.mostrarMenuBaixas();
            switch (eleccionMenu) {
                case 0:
                    System.out.println("Volves atrás");
                    break;
                case 1:
                    Baixas.baixaProfesor();
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
                    menuBaixas();
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
