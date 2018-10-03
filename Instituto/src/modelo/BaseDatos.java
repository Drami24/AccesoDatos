/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dalod
 */
public class BaseDatos {
    private static Connection conexion = null;
    private static String url = "jdbc:mysql://localhost:3306/?";
    private static String user = "root";
    private static String password = "";
    
    public static Connection getConexion() {
        if (conexion == null){
            conexion = realizarConexion(url, user, password);
        }
        return conexion;
    }
    
    private static Connection realizarConexion(String url, String user, String password) {
        try {
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar, revise os parámetros url, user, password");
            e.printStackTrace();
        }
        return conexion;
    }
    
    public static void crearBD (Connection conexion) {
        try {
            Statement sentencia = conexion.createStatement();
            sentencia = conexion.createStatement();
            sentencia.execute("CREATE DATABASE IF NOT EXISTS BDInstituto;");
            sentencia.execute("USE BDInstituto;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS Profesores ( "
                    + "dni varchar(9) NOT NULL, "
                    + "nombre VARCHAR(10) NOT NULL, "
                    + "titulacion VARCHAR(25) NOT NULL, "
                    + "PRIMARY KEY (dni));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS Alumnos ( "
                    + "idAlumno INT(5) NOT NULL AUTO_INCREMENT, "
                    + "codAlumno VARCHAR(4) NOT NULL UNIQUE, "
                    + "nombre VARCHAR(20) NOT NULL, "
                    + "UNIQUE KEY (codAlumno), " 
                    + "PRIMARY KEY (idAlumno));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS Asignaturas ( "
                    + "idAsignatura INT(9) AUTO_INCREMENT NOT NULL, "
                    + "codAsignatura VARCHAR(10) NOT NULL, "
                    + "UNIQUE KEY (codAsignatura), "
                    + "PRIMARY KEY (idAsignatura, codAsignatura));");     
            sentencia.execute("CREATE TABLE IF NOT EXISTS Profesores_Alumnos_Asignaturas ( "
                    + "dniProfesor varchar(9) NOT NULL, "
                    + "idAsignatura INT(9) NOT NULL, "
                    + "idAlumno INT(5) NOT NULL, "
                    + "FOREIGN KEY (dniProfesor) REFERENCES Profesores(dni) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "FOREIGN KEY (idAsignatura) REFERENCES Asignaturas(idAsignatura) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "FOREIGN KEY (idAlumno) REFERENCES Alumnos(idAlumno) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "PRIMARY KEY (idAsignatura, idAlumno));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS Notas ( "
                    + "idAsignatura INT(9) NOT NULL, "
                    + "idAlumno INT(5) NOT NULL, "
                    + "fecha DATE NOT NULL, "
                    + "nota FLOAT NOT NULL, "
                    + "FOREIGN KEY (idAsignatura) REFERENCES Asignaturas(idAsignatura) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "FOREIGN KEY (idAlumno) REFERENCES Alumnos(idAlumno) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "PRIMARY KEY (idAsignatura, idAlumno));");
        } catch (SQLException e) {
            System.err.println("Erro nas execucións das sentencias" + e.getMessage());
        }
    }
    
}
