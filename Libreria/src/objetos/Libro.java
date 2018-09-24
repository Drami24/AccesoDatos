/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author dalod
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

    public int getCodLibro() {
        return codLibro;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTitulo() {
        return titulo;
    }
    
    
    
}
