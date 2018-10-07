package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author a14damianld
 */
public class EntradaTeclado {

    public static BufferedReader entradaTeclado = new BufferedReader(new InputStreamReader(System.in));

    public static byte leerByteTeclado() {
        byte valorTeclado = 0;
        boolean bandeira;
        do {
            try {
                valorTeclado = Byte.parseByte(entradaTeclado.readLine());
                bandeira = false;
            } catch (IOException | NumberFormatException e) {
                System.err.println("O valor introducido non se corresponde cun número válido, volva a intentalo");
                bandeira = true;
            }
        } while (bandeira);
        return valorTeclado;
    }

    public static int leerIntTeclado() {
        int valorTeclado = 0;
        boolean bandeira;
        do {
            try {
                valorTeclado = Integer.parseInt(entradaTeclado.readLine());
                bandeira = false;
            } catch (IOException | NumberFormatException e) {
                System.err.println("O valor introducido non se corresponde con un número válido, volva a intentalo");
                bandeira = true;
            } finally {
                //cerrarEntradaTeclado(entradaTeclado);
            }
        } while (bandeira);
        return valorTeclado;
    }

    public static String leerStringTeclado() {
        String valorTeclado = "";
        boolean bandeira;
        do {
            try {
                valorTeclado = entradaTeclado.readLine();
                bandeira = false;
            } catch (IOException e) {
                System.err.println("O valor introducido non se corresponde cunha cadea de texto, volva a intentalo");
                bandeira = true;
            }
        } while (bandeira);
        return valorTeclado;
    }

    public static double leerDoubleTeclado() {
        double valorTeclado = 0;
        boolean bandeira;
        do {
            try {
                valorTeclado = Double.parseDouble(entradaTeclado.readLine());
                bandeira = false;
            } catch (IOException | NumberFormatException e) {
                System.err.println("O valor introducido non se corresponde con un número válido, volva a intentalo");
                bandeira = true;
            } finally {
                //cerrarEntradaTeclado(entradaTeclado);
            }
        } while (bandeira);
        return valorTeclado;
    }

    private static void cerrarEntradaTeclado(BufferedReader entradaTeclado) {
        if (entradaTeclado != null) {
            try {
                entradaTeclado.close();
            } catch (IOException e) {
                System.out.println("Non e posible cerrar a entrada de teclado");
                System.out.println(e.getMessage());
            }
        }
    }

}
