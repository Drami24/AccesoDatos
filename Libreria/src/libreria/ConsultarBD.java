/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dalod
 */
public class ConsultarBD {

    public boolean existeAutor(Statement sentencia, int idAutor) {
        try {
            ResultSet consulta = sentencia.executeQuery("SELECT idAutor FROM autores WHERE autores.idAutor = " + idAutor + ";");
            return consulta.next();
        } catch (SQLException ex) {
            System.out.println("Comprobacion de existencia de autor fallida");
            System.out.println(ex.getMessage());
            return true;
        }
    }

    public boolean existeLibro(Statement sentencia, int codLibro) {
        try {
            ResultSet consulta = sentencia.executeQuery("SELECT codLibro FROM libros WHERE libros.codLibro = " + codLibro + ";");
            return consulta.next();
        } catch (SQLException ex) {
            System.out.println("Comprobacion de existencia de libro fallida");
            System.out.println(ex.getMessage());
            return true;
        }
    }
}
