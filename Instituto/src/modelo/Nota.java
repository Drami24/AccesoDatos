/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dalod
 */
public class Nota {
    private int idAsignatura;
    private int idAlumno;
    private String fecha;
    private float nota;

    public Nota(int idAsignatura, int idAlumno, String fecha, float nota) {
        this.idAsignatura = idAsignatura;
        this.idAlumno = idAlumno;
        this.fecha = fecha;
        this.nota = nota;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getFecha() {
        return fecha;
    }

    public float getNota() {
        return nota;
    }
    
    
}


