/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dalod
 */
public class EntradaTeclado {

    public byte leerByteTeclado() {
        byte valorTeclado = 0;
        boolean bandeira;
        do {
            BufferedReader entradaTeclado;
            try {
                entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
                valorTeclado = Byte.parseByte(entradaTeclado.readLine());
                bandeira = false;
            } catch (IOException | NumberFormatException e) {
                System.err.println("O valor introducido non se corresponde cun número válido, volva a intentalo");
                bandeira = true;
            }
        } while (bandeira);
        return valorTeclado;
    }

    public int leerIntTeclado() {
        int valorTeclado = 0;
        boolean bandeira;
        do {
            BufferedReader entradaTeclado;
            entradaTeclado = null;
            try {
                entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
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

    public String leerStringTeclado() {
        String valorTeclado = "";
        boolean bandeira;
        do {
            BufferedReader entradaTeclado;
            try {
                entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
                valorTeclado = entradaTeclado.readLine();
                bandeira = false;
            } catch (IOException e) {
                System.err.println("O valor introducido non se corresponde cunha cadea de texto, volva a intentalo");
                bandeira = true;
            }
        } while (bandeira);
        return valorTeclado;
    }
    
    public double leerDoubleTeclado() {
        double valorTeclado = 0;
        boolean bandeira;
        do {
            BufferedReader entradaTeclado;
            entradaTeclado = null;
            try {
                entradaTeclado = new BufferedReader(new InputStreamReader(System.in));
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

    private void cerrarEntradaTeclado(BufferedReader entradaTeclado) {
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
