package empresa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a14damianld
 */
public class InsertarBD {

    public static void insertarDepartamento(EntradaTeclado entradaTeclado) {
        Connection conexion = null;
        Statement sentencia = null;
        System.out.println("Introduzca o número do departamento");
        int numDept = entradaTeclado.leerIntTeclado();
        System.out.println("Introduzca o nome do departamento");
        String nombreDept = entradaTeclado.leerStringTeclado();
        System.out.println("Introduzca a localidade");
        String localidad = entradaTeclado.leerStringTeclado();
        try {
            conexion = ConexionBD.conectar();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO departamentos (numDept, nombreDept, localidad) "
                    + "VALUES ('" + numDept + "', '" + nombreDept + "', '" + localidad);
        } catch (SQLException e) {
            System.err.println("Erro ao insertar Departamento");
            e.printStackTrace();
        }
    }
    
    public static void insertarEmpleado(EntradaTeclado entradaTeclado) {
        Connection conexion = null;
        Statement sentencia = null;
        String sql = "";
        System.out.println("Introduzca o número do departamento");
        int numDept = entradaTeclado.leerIntTeclado();
        System.out.println("Introduzca o nome do departamento");
        String nombreDept = entradaTeclado.leerStringTeclado();
        System.out.println("Introduzca a localidade");
        String localidad = entradaTeclado.leerStringTeclado();
        try {
            conexion = ConexionBD.conectar();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate("INSERT INTO empleados (numDept, nombreDept, localidad) "
                    + "VALUES ('" + numDept + "', '" + nombreDept + "', '" + localidad);
        } catch (SQLException e) {
            System.err.println("Erro ao insertar Departamento");
            e.printStackTrace();
        }
    }

    public static void introducirDatosDepartamento(EntradaTeclado entradaTeclado) {
        System.out.println("Introduzca o número do departamento");
        int numDept = entradaTeclado.leerIntTeclado();
        System.out.println("Introduzca o nome do departamento");
        String nombreDept = entradaTeclado.leerStringTeclado();
        System.out.println("Introduzca a localidade");
        String localidad = entradaTeclado.leerStringTeclado();
    }
    
}
