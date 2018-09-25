/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a14damianld
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Statement sentencia = null;
        // IDEA PARA CREAR UN OBXECTO PARA METER DATOS DE ETNRADA DE TECLADO
        // CREANDO UN UNICO OBXECTO QUE SE CERRA AO FINALIZAR O PROGRAMA
        //EntradaTeclado entradaTeclado = new EntradaTeclado();
        try {
            sentencia = ConexionBD.iniciarBD();
            new XeradorMenus().mostrarMenuInicial(sentencia);
        } catch (Exception e) {
            System.err.println("Erro ao conectar coa base de datos" + e.getMessage());
        } finally {
            cerrarSentenciaBD(sentencia);
            //entradaTeclado.entradaTeclado.close();
        }
    }

    private static void cerrarSentenciaBD(Statement sentencia) {
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException e) {
                System.err.println("Error ao cerrar a sentencia" + e.getMessage());
            }
        }
    }

}
