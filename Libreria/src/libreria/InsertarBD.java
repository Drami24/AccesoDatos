/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.sql.SQLException;
import java.sql.Statement;
import objetos.Autor;
import objetos.Libro;

/**
 *
 * @author dalod
 */
public class InsertarBD {

    private Autor crearAutor(EntradaTeclado entradaTeclado, int idAutor) {
        return new Autor(entradaTeclado, idAutor);
    }
    
        private Autor crearAutor(EntradaTeclado entradaTeclado, Autor autor) {
        System.out.println("Inserte o nome do autor");
        autor.setNombre(entradaTeclado.leerStringTeclado());
        System.out.println("Inserte nacionalidade do autor");
        autor.setNacionalidad(entradaTeclado.leerStringTeclado());
        return autor;
    }

    public void insertarAutor(Statement sentencia, EntradaTeclado entradaTeclado) {
        System.out.println("Inserte o id do autor");
        int id = new EntradaTeclado().leerIntTeclado();
        boolean existeAutor = new ConsultarBD().existeAutor(sentencia, id);
        if (existeAutor) {
            System.err.println("O id do autor xa existe");
        } else {
            crearAutor(entradaTeclado, id).insertarEnBD(sentencia);
        }
    }

    public void insertarAutor(Statement sentencia, EntradaTeclado entradaTeclado, int id) {
        boolean existeAutor = new ConsultarBD().existeAutor(sentencia, id);
        if (existeAutor) {
            System.err.println("O id do autor xa existe");
        } else {
            crearAutor(entradaTeclado, id).insertarEnBD(sentencia);
        }
    }



    private Libro crearLibro(int codLibro) {
        EntradaTeclado entrada = new EntradaTeclado();
        System.out.println("Inserte titulo do libro");
        String titulo = entrada.leerStringTeclado();
        System.out.println("Inserte precio do libro");
        double precio = entrada.leerDoubleTeclado();
        return new Libro(codLibro, titulo, precio);
    }

    public void insertarLibro(Statement sentencia, EntradaTeclado entradaTeclado) {
        System.out.println("Inserte o codigo do libro");
        int codLibro = entradaTeclado.leerIntTeclado();
        boolean existeLibro = new ConsultarBD().existeLibro(sentencia, codLibro);
        if (existeLibro) {
            System.err.println("O codigo do libro xa existe");
        } else {
            crearLibro(codLibro).insertarEnBD(sentencia);
            boolean bandeira = false;
            do{
                bandeira = añadirAutorLibro(entradaTeclado, sentencia, codLibro);
            }while(bandeira);
            
        }
    }
    
    
    private boolean añadirAutorLibro(EntradaTeclado entradaTeclado, Statement sentencia, int codLibro){
        System.out.println("Inserte o id do autor");
        Autor autor = new Autor(entradaTeclado.leerIntTeclado());
        if (autor.existeEnBD(sentencia)){
            relacionarAutorLibroBD(sentencia, autor.getIdAutor(), codLibro);
        } else {
            System.out.println("O autor non existe na BD, desexa crealo?:  \n"
                    + "Pulse numero 1 en caso afirmativo");
            if(entradaTeclado.leerByteTeclado() == 1){
                Autor novoAutor = crearAutor(entradaTeclado, autor.getIdAutor());
                novoAutor.insertarEnBD(sentencia);
                relacionarAutorLibroBD(sentencia, novoAutor.getIdAutor(), codLibro);
            }
        }
        System.out.println("Desexa engadir outro autor: \n"
                + "Pulse 1 para engadir mais");
        return entradaTeclado.leerByteTeclado() == 1;
        
    }



    private void relacionarAutorLibroBD(Statement sentencia, int idAutor, int codLibro) {
        try {
            sentencia.executeUpdate("INSERT INTO autores_libros (autor,libro) "
                    + "VALUES ('" + idAutor + "','" + codLibro + "')");
            System.out.println("Autores asociados a libro en BD");
        } catch (SQLException ex) {
            System.err.println("Error ao relacionar libro e autor");
        }
    }

}
