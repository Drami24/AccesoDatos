
package libreria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a14damianld
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

    public static void verMedicosAsociados(int nuss, Statement sentencia) {
        ResultSet consulta;
        try {
            consulta = sentencia.executeQuery("SELECT * FROM MEDICOS WHERE codigo IN (SELECT medico FROM MEDICOS_ENFERMOS WHERE enfermo='" + nuss + "');");
            while (consulta.next()) {
                System.out.println("consulta.getString(1), consulta.getString(2), consulta.getString(3), consulta.getString(4)");
            }
            consulta.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void visualizarLibros(Statement sentencia) {
        try {
            ResultSet consulta; 
            consulta = sentencia.executeQuery("select codLibro,titulo,precio from libros;");
            System.out.println("Codigo\tTitulo\tPrecio");
            while (consulta.next()) {
                System.out.printf(String.format("%1$-23s %2$-23s %3$s", consulta.getString("codLibro"), consulta.getString("titulo"), consulta.getString("precio")) + "€");
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error ao visualizar libros" + e);
        }
    }

}
