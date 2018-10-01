package empresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a14damianld
 */
public class ConexionBD {

    public static Connection conectar() {
        Connection conexion = null;
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/?user=" + usuario
                + "&password=" + password;
        try {
            conexion = DriverManager.getConnection(url);
            if (conexion != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("Non se puido conectar á base de datos");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void crearBD() {
        Statement sentencia = null;
        Connection conexion = null;
        try {
            conexion = conectar();
            sentencia = conexion.createStatement();
            sentencia.execute("CREATE DATABASE IF NOT EXISTS empresa;");
            sentencia.execute("USE empresa;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS empleados ( "
                    + "dni varchar(9) NOT NULL, "
                    + "nombre VARCHAR(10) NOT NULL, "
                    + "estudios VARCHAR(10) NOT NULL, "
                    + "direccion VARCHAR(10) NOT NULL, "
                    + "fechaAlta DATE, "
                    + "salario FLOAT NOT NULL, "
                    + "comision FLOAT, "
                    + "numDept INT(2), "
                    + "PRIMARY KEY (dni));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS departamentos ( "
                    + "numDept INT(2) NOT NULL AUTO_INCREMENT, "
                    + "nombreDept VARCHAR(10) NOT NULL, "
                    + "localidad VARCHAR(10), "
                    + "PRIMARY KEY (numDept));");
        } catch (SQLException e) {
            System.err.println("Erro nas execucións das sentencias" + e.getMessage());
        }
    }
}
