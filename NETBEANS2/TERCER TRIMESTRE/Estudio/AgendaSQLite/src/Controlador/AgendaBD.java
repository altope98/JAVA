package Controlador;
import java.sql.*;
import java.util.*;
import Modelo.Contacto;

public class AgendaBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public AgendaBD(){
        String url="C:\\proyectos\\AgendaSQLite\\agenda.s3db";
        try{
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            if(conexion!=null)
                System.out.println("Conexion realizada correctamente");
        }catch(SQLException e){
            System.out.println("No se pudo establecer conexion con Agenda DB");
        }
    }
    /*public ResultSet obtenerContactos(){
      // Usando ResultSet
        String sentenciaSQL = "SELECT * FROM guia ORDER BY nombre";
        System.out.println(sentenciaSQL);
        try{
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);
        } catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }*/
    public ArrayList <Contacto> obtenerContactos() {
        // Usando un ArrayList(colección) de objetos Contacto
        String sentenciaSQL = "SELECT * FROM guia ORDER BY nombre ASC";
        Contacto contacto;
        ArrayList <Contacto> contactos = new ArrayList <Contacto>();
        System.out.println(sentenciaSQL);
        try{
            sentencia = conexion.createStatement();     
            resultado = sentencia.executeQuery(sentenciaSQL);
            while(resultado.next()){
                String nom = resultado.getString("nombre");
                String dir = resultado.getString("direccion");
                String tlf = resultado.getString("telefonos");
                int edad = resultado.getInt("edad");
                String email = resultado.getString("email");
                contacto = new Contacto(nom, dir, tlf, edad);
                contactos.add(contacto);
            }
        } catch(SQLException e){
            System.out.println("No se pudieron obtener los contactos");
            return null;
        }
        return contactos;
    }
    public Contacto obtenerContacto(String valor) {
        String sentenciaSQL="SELECT * FROM guia WHERE nombre='"+valor+"'";
        System.out.println(sentenciaSQL);
        Contacto contacto=null;
        try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
            if(resultado.next()){
                String nom=resultado.getString("nombre");
                String dir=resultado.getString("direccion");
                String tel=resultado.getString("telefonos");
                int edad=resultado.getInt("edad");
                contacto=new Contacto(nom, dir, tel, edad);
            }
       }catch(SQLException e){
           System.out.println("No se pudo obtener el contacto");
           return null;}
        return contacto;
    }
    public void nuevoContacto(Contacto contacto) {
        String nom=contacto.getNombre();
        String dir=contacto.getDireccion();
        String tel=contacto.getTelefonos();
        int edad=contacto.getEdad();
        String sentenciaSQL="INSERT INTO guia (nombre, direccion, telefonos, edad) VALUES ('"+nom+"','"+dir+"','"+tel+"',"+edad+")";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e) {
            System.out.println("No se pudo grabar el contacto");
        }
    }
    public void guardarContacto(Contacto contacto){
        String nom=contacto.getNombre();
        String dir=contacto.getDireccion();
        int edad=contacto.getEdad();
        String tel=contacto.getTelefonos();
        String sentenciaSQL="UPDATE guia SET direccion='"+dir+"', telefonos='"+tel+"', edad="+edad+" WHERE nombre='"+nom+"'";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){System.out.println("No se pudo modificar el contacto");}
    }
    public void borrarContacto(String nombre){
        String sentenciaSQL="DELETE FROM guia WHERE nombre='"+nombre+"'";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){System.out.println("No se pudo borrar el registro");}
    }
    public ResultSet ejecutarQuery(String sentenciaSQL){
        ResultSet res=null;
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        } catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return res;
    }
    public Contacto primerContacto() {
        String sentenciaSQL="SELECT * FROM guia WHERE nombre>=' ' ORDER BY nombre ASC";        
        Contacto contacto=null;
        ResultSet res=ejecutarQuery(sentenciaSQL);
        try{
            if(resultado.next()){
                String nom = resultado.getString("nombre");
                String dir = resultado.getString("direccion");
                int edad = resultado.getInt("edad");
                String tlf = resultado.getString("telefonos");
                contacto = new Contacto(nom, dir, tlf, edad);
            }
        }catch(SQLException e){
            System.out.println("No se pudo obtener el primer contacto");
            return null;
        }
        return contacto;
    }
    public Contacto ultimoContacto() {
        String sentenciaSQL="SELECT * FROM guia WHERE nombre>=' ' ORDER BY nombre DESC";
        Contacto contacto=null;
        ResultSet res=ejecutarQuery(sentenciaSQL);
        try{
            if(resultado.next()){
                String nom = resultado.getString("nombre");
                String dir = resultado.getString("direccion");
                int edad = resultado.getInt("edad");
                String tlf = resultado.getString("telefonos");
                contacto = new Contacto(nom, dir, tlf, edad);
            }
        }catch(SQLException e){
            System.out.println("No se pudo obtener el ultimo contacto");
            return null;
        }
        return contacto;
    }
    public Contacto siguienteContacto(String nombre) {
        String sentenciaSQL="SELECT * FROM guia WHERE nombre>'"+nombre+"' ORDER BY nombre ASC";
        Contacto contacto=null;
        ResultSet res=ejecutarQuery(sentenciaSQL);
        try{
            if(resultado.next()){
                String nom = resultado.getString("nombre");
                String dir = resultado.getString("direccion");
                int edad = resultado.getInt("edad");
                String tlf = resultado.getString("telefonos");
                contacto = new Contacto(nom, dir, tlf, edad);
            }
        }catch(SQLException e){
            System.out.println("No se pudo obtener el ultimo contacto");
            return null;
        }
        return contacto;
    }
    public Contacto anteriorContacto(String nombre) {
        String sentenciaSQL="SELECT * FROM guia WHERE nombre<'"+nombre+"' ORDER BY nombre ASC";
        Contacto contacto=null;
        ResultSet res=ejecutarQuery(sentenciaSQL);
        try{
            while(resultado.next()){
                String nom = resultado.getString("nombre");
                String dir = resultado.getString("direccion");
                int edad = resultado.getInt("edad");
                String tlf = resultado.getString("telefonos");
                contacto = new Contacto(nom, dir, tlf, edad);
            }
        }catch(SQLException e){
            System.out.println("No se pudo obtener el ultimo contacto");
            return null;
        }
        return contacto;
    }
}
