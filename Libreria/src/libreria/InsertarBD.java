/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import objetos.Autor;
import objetos.Libro;

/**
 *
 * @author dalod
 */
public class InsertarBD {
    
    public static Autor crearAutor() {
        EntradaTeclado entrada = new EntradaTeclado();
        System.out.println("Inserte o id do autor");
        int idAutor = entrada.leerIntTeclado();
        System.out.println("Inserte o nome do autor");
        String nomeAutor = entrada.leerStringTeclado();
        System.out.println("Inserte nacionalidade do autor");
        String nacionalidade = entrada.leerStringTeclado();
        return new Autor(idAutor, nomeAutor, nacionalidade);
    }
    
    public static Libro crearLibro() {
        EntradaTeclado entrada = new EntradaTeclado();
        System.out.println("Inserte codigo do libro");
        int codLibro = entrada.leerIntTeclado();
        System.out.println("Inserte titulo do libro");
        String titulo = entrada.leerStringTeclado();
        System.out.println("Inserte precio do libro");
        double precio = entrada.leerDoubleTeclado();
        return new Libro(codLibro, titulo, precio);
    }
    
}
