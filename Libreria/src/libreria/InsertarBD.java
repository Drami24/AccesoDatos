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

    private Autor crearAutor(int idAutor) {
        EntradaTeclado entrada = new EntradaTeclado();
        System.out.println("Inserte o nome do autor");
        String nomeAutor = entrada.leerStringTeclado();
        System.out.println("Inserte nacionalidade do autor");
        String nacionalidade = entrada.leerStringTeclado();
        return new Autor(idAutor, nomeAutor, nacionalidade);
    }

    public void insertarAutor(Statement sentencia) {
        System.out.println("Inserte o id do autor");
        int id = new EntradaTeclado().leerIntTeclado();
        boolean existeAutor = new ConsultarBD().existeAutor(sentencia, id);
        if (existeAutor) {
            System.err.println("O id do autor xa existe");
        } else {
            executarInsercionAutor(sentencia, crearAutor(id));
        }
    }

    private void executarInsercionAutor(Statement sentencia, Autor novoAutor) {
        try {
            sentencia.executeUpdate("INSERT INTO autores (idAutor,nombre,nacionalidad) "
                    + "VALUES ('" + novoAutor.getIdAutor() + "','" + novoAutor.getNombre() + "','" + novoAutor.getNacionalidad() + "')");
            System.out.println("Autor engadido satisfactoriamente");
        } catch (SQLException ex) {
            System.out.println("Error ao insertar autor");
            System.out.println(ex.getMessage());
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

    public void insertarLibro(Statement sentencia) {
        System.out.println("Inserte o codigo do libro");
        int id = new EntradaTeclado().leerIntTeclado();
        boolean existeLibro = new ConsultarBD().existeLibro(sentencia, id);
        if (existeLibro) {
            System.err.println("O codigo do libro xa existe");
        } else {
            executarInsercionLibro(sentencia, crearLibro(id));
        }
    }

    private void executarInsercionLibro(Statement sentencia, Libro novoLibro) {
        try {
            sentencia.executeUpdate("INSERT INTO libros (codLibro,titulo,precio) "
                    + "VALUES ('" + novoLibro.getCodLibro()+ "','" + novoLibro.getTitulo()+ "','" + novoLibro.getPrecio()+ "')");
            System.out.println("Libro engadido satisfactoriamente");
        } catch (SQLException ex) {
            System.out.println("Error ao insertar libro");
            System.out.println(ex.getMessage());
        }
    }

}
