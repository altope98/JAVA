/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbarr
 */
package infracciones;
import java.sql.*;
public class AgendaBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public AgendaBD(){
        String url="D:\\DAW\\Programación\\Programas NETBEANS\\Infracciones\\infracciones.s3db";
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
        try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
    public ResultSet obtenerInfracciones(String matr){
        String sentenciaSQL="SELECT * FROM Coches,multas,infracciones WHERE Coches.codigo=multas.codigoCoche AND infracciones.codigoInfraccion=multas.codigoInfraccion AND Coches.matricula='"+matr+"'";
         try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
    
    public Coche obtenerCoche(String valor){
        String sentenciaSQL="SELECT * FROM Coches WHERE nombre='"+ valor + "'";
        System.out.println(sentenciaSQL);
        Coche coche=null;
        try{
        sentencia=conexion.createStatement();
        // Mando la sentencia select con .executeQuery
        resultado=sentencia.executeQuery(sentenciaSQL);
        if(resultado.next()){
            
            String codigo=resultado.getString("codigo");
            String nif=resultado.getString("nif");
            String nombre=resultado.getString("nombre");
            String direccion=resultado.getString("direccion");
            String matricula=resultado.getString("matricula");
            String nombrecoche=resultado.getString("coche");  //cuidao con los nombres de la tabla
            
            coche= new Coche(codigo,nif,nombre,direccion,matricula,nombrecoche);
            
        }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            coche=null;
        }
        return coche;
    }
    
    public void nuevoContacto(Coche coche){
        String codigo=coche.getCodigo();
        String nif=coche.getNif();
        String nombre=coche.getNombre();
        String direccion=coche.getDireccion();
        String matricula=coche.getMatricula();
        String nombrecoche=coche.getNombreCoche();
        String sentenciaSQL="INSERT INTO Coche (codigo, nif, nombre, direccion, matricula, nombrecoche ) VALUES ('"+codigo+"','"+nif+"','"+nombre+"','"+direccion+"','"+matricula+"',"+nombrecoche+")";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo grabar el registro");
        }
    }
    
    
    
    
    /*public void modificarContacto(Contacto contacto){
        String nom=contacto.getNombre();
        String dir=contacto.getDireccion();
        String loc=contacto.getLocalidad();
        String tlf=contacto.getTelefonos();
        String mail=contacto.getCorreo();
        int edad=contacto.getEdad();
        String sentenciaSQL="UPDATE contacto SET direccion='"+dir+"',localidad='"+loc+"', telefonos='"+tlf+"',correo='"+mail+"', edad="+edad+" WHERE nombre='"+nom+"' ";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo modificar el registro");
        }
    }*/
    /*public void borrarContacto(String valor){
        String sentenciaSQL="DELETE FROM Contacto WHERE nombre='"+valor+ "';";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo borrar el registro");
        }
    }*/
}
