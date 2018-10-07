package vistas;

import controlador.EntradaTeclado;
import java.sql.Connection;

/**
 *
 * @author a14damianld
 */
public class Menus {

    public static byte mostrarMenuAltas() {
        System.out.println("Altas\n"
                + "1. Insertar un novo Profesor \n"
                + "2. Insertar un novo Alumno\n"
                + "0. Atrás");
        return EntradaTeclado.leerByteTeclado();
    }
    
    public static byte mostrarMenuBaixas() {
        System.out.println("Baixas\n"
                + "1. Eliminar Profesor \n"
                + "2. Eliminar Alumno\n"
                + "0. Atrás");
        return EntradaTeclado.leerByteTeclado();
    }

    public static byte mostrarMenuPrincipal() {
        System.out.println("Benvido ao instituto de Damián\n"
                + "1. Altas\n"
                + "2. Baixas\n"
                + "3. Consultar rexistros\n"
                + "4. Modificar rexistros\n"
                + "0. Cerrar programa");
        return EntradaTeclado.leerByteTeclado();
    }
    

}
