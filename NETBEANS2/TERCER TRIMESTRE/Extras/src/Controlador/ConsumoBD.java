package Controlador;
import java.sql.*;
public class ConsumoBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public ConsumoBD(){
        String url="Consumo.s3db";
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
    public ResultSet obtenerConsumos(String barra, String fecha){
        String sentenciaSQL="SELECT * FROM Articulos, Barras, Consumo WHERE Articulos.codigoArticulo=Consumo.codigoArticulo AND Barras.codigoBarra=Consumo.codigoBarra AND Barras.barra LIKE '"+barra+"' AND Consumo.fecha LIKE '"+fecha+"'";
        try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
    public ResultSet obtenerConsumosEntreFechas(String desde, String hasta){
        String sentenciaSQL="SELECT * FROM Articulos,Barras,Consumo WHERE Articulos.codigoArticulo=Consumo.codigoArticulo AND Barras.codigoBarra=Consumo.codigoBarra AND Consumo.fecha BETWEEN '"+desde+"' AND '"+hasta+"'";
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
