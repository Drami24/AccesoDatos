
package objetos;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a14damianld
 */
public class Libro {
    private int codLibro;
    private String titulo;
    private double precio;

    public Libro(int codLibro, String titulo, double precio) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.precio = precio;
    }
    
    public void insertarEnBD(Statement sentencia) {
        try {
            sentencia.executeUpdate("INSERT INTO libros (codLibro,titulo,precio) "
                    + "VALUES ('" + this.codLibro + "','" + this.titulo + "','" + this.precio + "')");
            System.out.println("Libro engadido satisfactoriamente");
        } catch (SQLException ex) {
            System.out.println("Error ao insertar libro");
            System.out.println(ex.getMessage());
        }
    }
       
}