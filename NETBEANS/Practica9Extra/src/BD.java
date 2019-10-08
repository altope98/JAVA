/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
import java.sql.*;
public class BD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public BD(){
        String url="D:\\DAW\\Programación\\Programas NETBEANS\\Practica9Extra\\Consumo.s3db";
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
    public ResultSet obtenerConsumos(String barra,String fecha){
        /*codigoCoche,codigoInfraccion,fecha,infraccion,penalizacion,nif,nombre,direccion,matricula,coche*/
        
        String sentenciaSQL="SELECT * FROM Consumo,Articulos,Barras WHERE Consumo.codigoArticulo=Articulos.codigoArticulo AND Consumo.codigoBarra=Barras.codigoBarra AND Consumo.fecha LIKE '"+fecha+"' AND Barras.barra LIKE '"+barra+"'";
         try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
            System.out.println(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
         System.out.println(resultado);
        return resultado;
    }
    public ResultSet obtenerImportes(String barra,String fecha){
        /*codigoCoche,codigoInfraccion,fecha,infraccion,penalizacion,nif,nombre,direccion,matricula,coche*/
        
        String sentenciaSQL="SELECT Consumo.unidades*Articulos.pvp AS Importe FROM Consumo,Articulos,Barras WHERE Consumo.codigoArticulo=Articulos.codigoArticulo AND Consumo.codigoBarra=Barras.codigoBarra AND Consumo.fecha LIKE '"+fecha+"' AND Barras.barra LIKE '"+barra+"'";
         try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
            System.out.println(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
         System.out.println(resultado);
        return resultado;
    }
}