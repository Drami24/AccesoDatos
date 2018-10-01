
package empresa;

/**
 *
 * @author a14damianld
 */
public class Empresa {

    public static void main(String[] args) {
        EntradaTeclado entradaTeclado = new EntradaTeclado();
        ConexionBD.crearBD();
        Menus.mostrarMenuInicial(entradaTeclado);
    }

}