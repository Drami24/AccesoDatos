/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dalod
 */
public class BaseDatos {
    private static Connection conexion = null;
    private static final String URL = "jdbc:mysql://localhost:3306/?";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConexion() {
        if (conexion == null){
            conexion = realizarConexion();
        }
        return conexion;
    }
    
    private static Connection realizarConexion() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar, revise os parámetros url, user, password");
            e.printStackTrace();
        }
        return conexion;
    }
    
    public static void crearBD () {
        try {
            Statement sentencia = getConexion().createStatement();
            sentencia.execute("CREATE DATABASE IF NOT EXISTS BDInstituto;");
            sentencia.execute("USE BDInstituto;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS profesores ( "
                    + "dni varchar(9) NOT NULL, "
                    + "nombre VARCHAR(10) NOT NULL, "
                    + "titulacion VARCHAR(25) NOT NULL, "
                    + "PRIMARY KEY (dni));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS alumnos ( "
                    + "idAlumno INT(5) NOT NULL AUTO_INCREMENT, "
                    + "codAlumno VARCHAR(4) NOT NULL UNIQUE, "
                    + "nombre VARCHAR(20) NOT NULL, "
                    + "UNIQUE KEY (codAlumno), " 
                    + "PRIMARY KEY (idAlumno));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS asignaturas ( "
                    + "idAsignatura INT(9) AUTO_INCREMENT NOT NULL, "
                    + "codAsignatura VARCHAR(10) NOT NULL, "
                    + "UNIQUE KEY (codAsignatura), "
                    + "PRIMARY KEY (idAsignatura, codAsignatura));");     
            sentencia.execute("CREATE TABLE IF NOT EXISTS profesores_alumnos_asignaturas ( "
                    + "dniProfesor varchar(9) NOT NULL, "
                    + "idAsignatura INT(9) NOT NULL, "
                    + "idAlumno INT(5) NOT NULL, "
                    + "FOREIGN KEY (dniProfesor) REFERENCES profesores(dni) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "FOREIGN KEY (idAsignatura) REFERENCES asignaturas(idAsignatura) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "FOREIGN KEY (idAlumno) REFERENCES alumnos(idAlumno) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "PRIMARY KEY (idAsignatura, idAlumno));");
            sentencia.execute("CREATE TABLE IF NOT EXISTS Notas ( "
                    + "idAsignatura INT(9) NOT NULL, "
                    + "idAlumno INT(5) NOT NULL, "
                    + "fecha DATE NOT NULL, "
                    + "nota FLOAT NOT NULL, "
                    + "FOREIGN KEY (idAsignatura) REFERENCES asignaturas(idAsignatura) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "FOREIGN KEY (idAlumno) REFERENCES alumnos(idAlumno) "
                    + "ON DELETE CASCADE "
                    + "ON UPDATE CASCADE, "
                    + "PRIMARY KEY (idAsignatura, idAlumno));");
            System.out.println("Base de datos creada correctamente");
        } catch (SQLException e) {
            System.err.println("Erro nas execucións das sentencias" + e.getMessage());
        }
    }
    
    public static void insertarProfesor(Profesor novoProfesor){
        String sql = "INSERT INTO profesores (dni, nombre, titulacion) VALUES (?, ?, ?)";
        try{
            PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sql);
            sentenciaPreparada.setString(1, novoProfesor.getDni());
            sentenciaPreparada.setString(2, novoProfesor.getNombre());
            sentenciaPreparada.setString(3, novoProfesor.getTitulacion());
            sentenciaPreparada.executeUpdate();
            System.out.println("Profesor " +novoProfesor.getNombre()+ " engadido correctamente");
        } catch(SQLException e){
            System.err.println("Insercion de profe incorrecta");
        } 
    }
    
    public static void insertarAlumno(Alumno novoAlumno) {
        String sql = "INSERT INTO alumnos (idAlumno, codAlumno, nombre) VALUES (?, ?, ?)";
        try {
            PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sql);
            sentenciaPreparada.setInt(1, novoAlumno.getIdAlumno());
            sentenciaPreparada.setString(2, novoAlumno.getCodAlumno());
            sentenciaPreparada.setString(3, novoAlumno.getNombre());
            sentenciaPreparada.executeUpdate();
            System.out.println("Alumno " + novoAlumno.getNombre() + " engadido correctamente");
        } catch (SQLException e) {
            System.err.println("Insercion de alumno incorrecta");
            e.printStackTrace();
        }
    }
    
    public static void baixaProfesor(String dniProfesor) {
        String sql = "DELETE FROM profesores WHERE dni = ?";
        try {
            PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sql);
            sentenciaPreparada.setString(1, dniProfesor);
            sentenciaPreparada.executeUpdate();
            System.out.println("Profesor co dni "+dniProfesor+ "eliminado correctamente");
        } catch (SQLException e) {
            System.err.println("Eliminacion de profe incorrecta ");
            System.err.println(e.getMessage());
        }
    }
    
    
}
