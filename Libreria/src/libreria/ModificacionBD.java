
package libreria;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a14damianld
 */
public class ModificacionBD {
    
    public void editarPrezoLibro (Statement sentencia, EntradaTeclado entradaTeclado) {
        System.out.println("Inserte o código do libro a modificar");
        int codLibro = entradaTeclado.leerIntTeclado();
        if (new ConsultarBD().existeLibro(sentencia, codLibro)){
            System.out.println("Inserte o novo prezo do libro");
            double novoPrezoLibro = new EntradaTeclado().leerDoubleTeclado();
            grabarPrezoLibro(sentencia, codLibro, novoPrezoLibro);
        } else {
            System.err.println("Non existe un libro con ese identificador");
        }
    }
    
    private void grabarPrezoLibro(Statement sentencia, int codLibro, double prezoLibro) {
        try {
            sentencia.executeUpdate("UPDATE libros SET precio = '" +  prezoLibro  + "'   WHERE(codLibro='" + codLibro + "');");
            System.out.println("Precio del libro actualizado correctamente");
        } catch (SQLException e) {
            System.err.println("Non é posible cambiar o prezo do libro " + e.getMessage());
        }
    }
       
}