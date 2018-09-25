/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a14damianld
 */
public class ConexionBD {

    public static Statement iniciarBD() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3307/?user=root";
            Connection conexion = ConexionBD.conectarBaseDeDatos(driver, url);
            Statement sentencia = conexion.createStatement();
            ConexionBD.crearBD(sentencia);
            return sentencia;
        } catch (SQLException e) {
            System.err.println("Fallo ao conectar BD" + e.getMessage());
            return null;
        }
    }

    private static boolean driverRexistrado(String driver) {
        try {
            Class.forName(driver);
            return true;
        } catch (ClassNotFoundException e) {
            System.err.println("Non se atopou o driver " + e.getMessage());
            return false;
        }
    }

    private static Connection conectarBaseDeDatos(String driver, String url) {
        boolean driverCargado = driverRexistrado(driver);
        if (driverCargado) {
            Connection conexion = obterConexionBD(url);
            return conexion;
        } else {
            System.err.println("Non se puido realizar a conexión coa BD");
            return null;
        }
    }

    private static Connection obterConexionBD(String url) {
        try {
            Connection conexionBD = DriverManager.getConnection(url);
            return conexionBD;
        } catch (SQLException e) {
            System.err.println("Na url especificada non se atopa un servidor " + e.getMessage());
            return null;
        }
    }

    private static void crearBD(Statement sentencia) {
        try {
            System.out.println("");
            sentencia.execute("CREATE DATABASE IF NOT EXISTS libreria;");
            sentencia.execute("USE libreria;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS autores ( "
                    + "idAutor INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "nacionalidad VARCHAR(30) NOT NULL, "
                    + "PRIMARY KEY (idAutor));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS libros ( "
                    + "codLibro INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "titulo VARCHAR(30) NOT NULL, "
                    + "precio FLOAT NOT NULL, "
                    + "PRIMARY KEY (codLibro));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS autores_libros ( "
                    + "autor INT(11) UNSIGNED ZEROFILL NOT NULL, "
                    + "libro INT(11) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY (autor, libro), "
                    + "INDEX fk_autor (autor), "
                    + "INDEX fk_libro (libro), "
                    + "CONSTRAINT fk_autor "
                    + " FOREIGN KEY (autor) "
                    + "     REFERENCES autores(idAutor) "
                    + "         ON DELETE CASCADE "
                    + "         ON UPDATE CASCADE, "
                    + "CONSTRAINT fk_libro "
                    + " FOREIGN KEY (libro) "
                    + "     REFERENCES libros(codLibro) "
                    + "         ON DELETE CASCADE "
                    + "         ON UPDATE CASCADE );");
        } catch (SQLException e) {
            System.err.println("Erro nas execucións das sentencias" + e.getMessage());
        } catch (Exception e) {
            System.err.println("2 Erro nas sentencias" + e.getMessage());
        }
    }

}