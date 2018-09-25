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
 * @author dalod
 */
public class BorrarBD {
    
    private void borrarLibroBD(int id, Statement sentencia){
        try {
            if (new ConsultarBD().existeLibro(sentencia, id)){
                sentencia.executeUpdate(" DELETE FROM libros WHERE(codLibro=" + id + ");");
                System.out.println("Libro borrado correctamente");
            } else {
                System.err.println("Non existe un libro con ese identificador");
            }
        } catch (SQLException ex) {
            System.err.println("No es posible borrar el libro");
            System.err.println(ex.getMessage());
        }
    }
    
    public void eliminarLibro(Statement sentencia) {
        System.out.println("Inserte o código do libro a eliminar");
        borrarLibroBD(new EntradaTeclado().leerIntTeclado(), sentencia);
    }
    
    private void borrarAutorBD(int id, Statement sentencia){
        try {
            if (new ConsultarBD().existeAutor(sentencia, id)){
                sentencia.executeUpdate(" DELETE FROM autores WHERE(idAutor=" + id + ");");
                System.out.println("Autor borrado correctamente");
            } else {
                System.err.println("Non existe un autor con ese identificador");
            }
        } catch (SQLException ex) {
            System.err.println("No es posible borrar el autor");
            System.err.println(ex.getMessage());
        }
    }
    
    public void eliminarAutor(Statement sentencia){
        System.out.println("Inserte o id do autor a eliminar");
        borrarAutorBD(new EntradaTeclado().leerIntTeclado(), sentencia);
    }
}
