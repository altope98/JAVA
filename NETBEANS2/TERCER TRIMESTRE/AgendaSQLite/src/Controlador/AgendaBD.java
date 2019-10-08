package Controlador;
import Modelo.Contacto;
import java.sql.*;
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
        String sentenciaSQL="SELECT * FROM " + tabla ;
        try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
    public Contacto obtenerContacto(String valor){
        String sentenciaSQL="SELECT * FROM Contacto WHERE nombre='"+ valor +"'";
        System.out.println(sentenciaSQL);
        Contacto contacto=null;
        try{
        sentencia=conexion.createStatement();
        resultado=sentencia.executeQuery(sentenciaSQL);
        if(resultado.next()){
            String nom=resultado.getString("nombre");
            String dir=resultado.getString("direccion");
            String tlf=resultado.getString("telefonos");
            int edad=resultado.getInt("edad");
            String loc=resultado.getString("localidad");
            String correo=resultado.getString("correo");
            contacto= new Contacto(nom, dir, loc, tlf, correo, edad);
        }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            contacto=null;
        }
        return contacto;
    }
    public void nuevoContacto(Contacto contacto){
        String nom=contacto.getNombre();
        String dir=contacto.getDireccion();
        String loc=contacto.getLocalidad();
        String tlf=contacto.getTelefonos();
        String mail=contacto.getCorreo();
        int ed=contacto.getEdad();
        String sentenciaSQL="INSERT INTO Contacto (nombre, direccion, localidad, telefonos, correo, edad ) VALUES ('"+nom+"','"+dir+"','"+loc+"','"+tlf+"','"+mail+"',"+ed+")";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo grabar el registro");
        }
    }
    public void modificarContacto(Contacto contacto){
        String nom=contacto.getNombre();
        String dir=contacto.getDireccion();
        String loc=contacto.getLocalidad();
        String tlf=contacto.getTelefonos();
        String mail=contacto.getCorreo();
        int edad=contacto.getEdad();
        String sentenciaSQL="UPDATE Contacto SET direccion='"+dir+"', localidad='"+loc+"', telefonos='"+tlf+"', correo='"+mail+"', edad="+edad+" WHERE nombre='"+nom+"' ";
        System.out.println(sentenciaSQL); 
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo modificar el registro");
        }
    }
    public void borrarContacto(String valor){
        String sentenciaSQL="DELETE FROM Contacto WHERE nombre='"+valor+ "';";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo borrar el registro");
        }
    }
}
