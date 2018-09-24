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
public class CrearTablas {

    public static void iniciarBD() {

        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/?user=root";
            Connection conexion = CrearTablas.conectarBaseDeDatos(driver, url);
            Statement sentencia = conexion.createStatement();
            CrearTablas.crearBD(conexion, sentencia);
        } catch (Exception e) {
            System.out.println("Fallo" + e.getMessage());
        }

    }

    public static boolean driverRexistrado(String driver) {
        try {
            Class.forName(driver);
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Non se encontrou o driver " + driver);
            return false;
        }
    }

    public static Connection conectarBaseDeDatos(String driver, String url) {
        if (driverRexistrado(driver)) {
            Connection conexion = obterConexionBD(url);
            System.out.println("Base de datos conectada");
            return conexion;
        } else {
            System.exit(1);
            return null;
        }
    }

    public static Connection obterConexionBD(String url) {
        try {
            Connection conexionBD = DriverManager.getConnection(url);
            return conexionBD;
        } catch (SQLException e) {
            System.err.println("Na url especificada non se atopa un servidor " + e.getMessage());
            System.exit(2);
            return null;
        }
    }

    public static void crearBD(Connection conexion, Statement sentencia) {
        try {
            sentencia.execute("CREATE DATABASE IF NOT EXISTS libreria;");
            sentencia.execute("USE libreria;");
            System.out.println("1");
            sentencia.execute("CREATE TABLE IF NOT EXISTS autores ( "
                    + "idAutor INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "nacionalidad VARCHAR(30) NOT NULL, "
                    + "PRIMARY KEY (idAutor));");
            System.out.println("2");
            sentencia.execute("CREATE TABLE IF NOT EXISTS libros ( "
                    + "idLibro INT(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "titulo VARCHAR(30) NOT NULL, "
                    + "precio FLOAT NOT NULL, "
                    + "PRIMARY KEY (idLibro));");
            System.out.println("3");
            sentencia.execute("CREATE TABLE IF NOT EXISTS librosautores ( "
                    + "autor INT(11) UNSIGNED ZEROFILL NOT NULL, "
                    + "libro INT(11) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY (autor, libro), "
                    + "INDEX fk_autor (autor), "
                    + "INDEX fk_libro (libro), "
                    + "CONSTRAINT fk_autor "
                    + "FOREIGN KEY (autor) "
                    + "REFERENCES autores(idAutor) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "CONSTRAINT fk_libro "
                    + "FOREIGN KEY (libro) "
                    + "REFERENCES libros(idLibro) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE );");
            System.out.println("4");
            conexion.close();
            System.out.println("5");
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        } catch (Exception e) {
            System.out.println("2Error" + e.getMessage());
        }
    }

}
