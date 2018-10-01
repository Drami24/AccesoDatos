package empresa;

/**
 *
 * @author a14damianld
 */
public class Menus {

    public static void mostrarMenuInicial(EntradaTeclado entradaTeclado) {
        byte eleccionMenu;
        do {
            System.out.println("Benvido á Empresa de Damián\n"
                    + "1. Insertar filas\n"
                    + "2. Borrar filas\n"
                    + "3. Consultar rexistros\n"
                    + "4. Modificar rexistros\n"
                    + "0. Cerrar programa");
            eleccionMenu = entradaTeclado.leerByteTeclado();
            switch (eleccionMenu) {
                case 0:
                    System.out.println("O programa cerrouse con éxito");
                    break;
                case 1:
                    mostrarMenuInsertar(entradaTeclado);
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
    
    public static void mostrarMenuInsertar(EntradaTeclado entradaTeclado) {
        byte eleccionMenu;
        do {
            System.out.println("Benvido á Empresa de Damián\n"
                    + "1. Insertar un novo departamento \n"
                    + "2. Insertar un novo empregado\n"
                    + "0. Atrás");
            eleccionMenu = entradaTeclado.leerByteTeclado();
            switch (eleccionMenu) {
                case 0:
                    System.out.println("Volves atrás");
                    break;
                case 1:
                    InsertarBD.insertarDepartamento(entradaTeclado);
                    break;
                case 2:

                    break;
                default:
                    System.err.println("Opción incorrecta");
            }
        } while (eleccionMenu != 0);
    }
    
    
}