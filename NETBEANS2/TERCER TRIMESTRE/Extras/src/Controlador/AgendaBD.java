package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgendaBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public AgendaBD(){
        String url="agenda.s3db";
        try{
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url);
        } catch(SQLException e){
            System.out.println("No se pudo realizar la conexion realizada");
        }
        if(conexion!=null)
            System.out.println("Conexion realizada correctamente");
    }
    public ResultSet obtenerRegistros(String tabla){
        String sentenciaSQL="SELECT * FROM " + tabla;
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerRegistrosOrdenados(String tabla, String clave) {
        String sentenciaSQL="SELECT * FROM "+tabla+" ORDER BY "+clave;
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerRegistrosAgrupados(String tabla, String clave){
        String sentenciaSQL="SELECT * FROM "+tabla+" GROUP BY "+clave;
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerContacto(String contacto){
        String sentenciaSQL="SELECT * FROM Contacto WHERE nombre LIKE '"+contacto+"'";;
        return ejecutarQwery(sentenciaSQL);
    }
    public void actualizarContaco(String nombre,String direccion, String localidad, String telefono, String email ,String edad,String contacto){
        String sentenciaSQL="UPDATE Contacto SET nombre = '"+nombre+"', direccion= '"+direccion+"', localidad='"+localidad+"', telefonos='"+telefono+"', correo='"+email+"', edad='"+edad+"' WHERE nombre LIKE '"+contacto+"'";
        try {
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException sql) {
            System.out.println("error: " + sql.getMessage());
        }
    }
    public void grabarContaco(String contacto,String direccion, String localidad, String telefono, String email ,String edad){
        String sentenciaSQL="INSERT INTO Contacto VALUES ('"+contacto+"','"+direccion+"','"+localidad+"','"+telefono+"','"+email+"','"+edad+"')";
        try {
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException sql) {
            System.out.println("error: " + sql.getMessage());
        }
    }
    public void borrarContacto(String contacto){
        String sentenciaSQL="DELETE FROM Contacto WHERE nombre LIKE '"+contacto+"'";
        try {
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException sql) {
            System.out.println("error: " + sql.getMessage());
        }
    }
    
    
    
    
    public ResultSet ejecutarQwery(String sentenciaSQL){
        System.out.println(sentenciaSQL);
        try {
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        } catch (SQLException sql) {
            System.out.println("error: " + sql.getMessage());
            return null;
        }
        return resultado;
    }
}
