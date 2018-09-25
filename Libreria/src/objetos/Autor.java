/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import libreria.EntradaTeclado;

/**
 *
 * @author dalod
 */
public class Autor {
    private int idAutor;
    private String nombre;
    private String nacionalidad;

    public Autor(int idAutor, String nombre, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public Autor(EntradaTeclado entradaTeclado, int idAutor) {
        this.idAutor = idAutor;
        System.out.println("Inserte o nome do autor");
        this.nombre = entradaTeclado.leerStringTeclado();
        System.out.println("Inserte nacionalidade do autor");
        this.nacionalidad = entradaTeclado.leerStringTeclado();
    }    

    public Autor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public void insertarEnBD(Statement sentencia) {
        try {
            sentencia.executeUpdate("INSERT INTO autores (idAutor,nombre,nacionalidad) "
                    + "VALUES ('" + this.idAutor + "','" + this.nombre+ "','" + this.nacionalidad + "')");
            System.out.println("Autor engadido satisfactoriamente");
        } catch (SQLException ex) {
            System.out.println("Error ao insertar autor");
            System.out.println(ex.getMessage());
        }
    }
    
        public boolean existeEnBD(Statement sentencia) {
        try {
            ResultSet consulta = sentencia.executeQuery("SELECT idAutor FROM autores WHERE autores.idAutor = " + this.idAutor + ";");
            return consulta.next();
        } catch (SQLException ex) {
            System.out.println("Comprobacion de existencia de autor fallida");
            System.out.println(ex.getMessage());
            return true;
        }
    }
    
}
