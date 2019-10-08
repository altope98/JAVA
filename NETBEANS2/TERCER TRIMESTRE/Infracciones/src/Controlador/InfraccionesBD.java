package Controlador;
import Modelo.Coche;
import Modelo.Infraccion;
import Modelo.Multa;
import java.sql.*;
public class InfraccionesBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public InfraccionesBD(){
        String url="infracciones.s3db";
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
        resultado=sentencia.executeQuery(sentenciaSQL);
        if(resultado.next()){
            
            String codigo=resultado.getString("codigo");
            String nif=resultado.getString("nif");
            String nombre=resultado.getString("nombre");
            String direccion=resultado.getString("direccion");
            String matricula=resultado.getString("matricula");
            String modelo=resultado.getString("coche"); 
            
            coche= new Coche(codigo,nif,nombre,direccion,matricula,modelo);
            
        }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            coche=null;
        }
        return coche;
    }
    public ResultSet obtenerInfraccionesIntervalo(String año, String mes){
        String sentenciaSQL="SELECT * FROM Coches,multas,infracciones WHERE Coches.codigo=multas.codigoCoche AND infracciones.codigoInfraccion=multas.codigoInfraccion AND multas.fecha LIKE '%/"+mes+"/"+año+"'";
         try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
         System.out.println(sentenciaSQL);
        return resultado;
    }
    public ResultSet obtenerInfraccionesEntreFechas(String desde, String hasta){
        String sentenciaSQL="SELECT * FROM Coches,multas,infracciones WHERE Coches.codigo=multas.codigoCoche AND infracciones.codigoInfraccion=multas.codigoInfraccion AND multas.fecha BETWEEN '"+desde+"' AND '"+hasta+"'";
         try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
         System.out.println(sentenciaSQL);
        return resultado;
    }
    
}
