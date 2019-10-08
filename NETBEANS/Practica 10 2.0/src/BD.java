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
        String url="D:\\DAW\\Programación\\Programas NETBEANS\\Practica 10 2.0\\baloncesto.s3db";
        try{
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url);
        } catch(SQLException e){
            System.out.println("No se pudo realizar la conexion realizada");
        }
        if(conexion!=null)
            System.out.println("Conexion realizada correctamente");
    }
    
    public ResultSet obtenerTabla(String tabla,String seccion){
        String sentenciaSQL="SELECT DISTINCT * FROM " + tabla+" ORDER BY "+seccion+"";
        try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
    
    public ResultSet obtenerRegistros(String tabla){
        String sentenciaSQL="SELECT DISTINCT * FROM " + tabla+"";
        try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
        return resultado;
    }
    public ResultSet obtenerResultados(String jornada,String partido,String equipo){
       
        String sentenciaSQL="SELECT * FROM PUNTUACIONES WHERE codigoPartido='"+partido+"' AND codigoJornada='"+jornada+"'";
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
    
     public ResultSet obtenerPartidosLocal(String jornada){
        String sentenciaSQL="SELECT * FROM PARTIDOS,PUNTUACIONES WHERE PUNTUACIONES.codigoEquipo=PARTIDOS.codigoEquipo1 AND jornada='"+jornada+"' GROUP BY PUNTUACIONES.codigoEquipo";
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
     public ResultSet obtenerPartidosVisitante(String jornada){
        String sentenciaSQL="SELECT * FROM PARTIDOS,PUNTUACIONES WHERE PUNTUACIONES.codigoEquipo=PARTIDOS.codigoEquipo2 AND jornada='"+jornada+"' GROUP BY PUNTUACIONES.codigoEquipo";
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
     
    public ResultSet obtenerFecha(String jornada){
        String sentenciaSQL="SELECT * FROM JORNADAS WHERE jornada='"+jornada+"'";
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
     public ResultSet obtenerCodigoEquipo(String jornada, String partido){
         String sentenciaSQL="SELECT codigoEquipo1, codigoEquipo2 FROM PARTIDOS WHERE jornada= '"+jornada+"' AND codigoPartido= '"+partido+"'";
        try{
        sentencia = conexion.createStatement();
       resultado=sentencia.executeQuery(sentenciaSQL);
        System.out.println(sentenciaSQL);
        }catch(SQLException e) {
           System.out.println("Error obtenerCodigoEquipo()");
           return null;
        }
        return resultado;
    }
    public ResultSet obtenerLocal(String jornada,String codigopartido){
        String sentenciaSQL="SELECT nombre FROM PARTIDOS,EQUIPOS WHERE PARTIDOS.codigoEquipo1=EQUIPOS.codigoEquipo AND PARTIDOS.jornada='"+jornada+"' AND PARTIDOS.codigoPartido='"+codigopartido+"'";
         try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
            //System.out.println(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
         System.out.println(resultado);
        return resultado;
    }
     public ResultSet obtenerVisitante(String jornada,String partido){
        String sentenciaSQL="SELECT nombre FROM PARTIDOS,EQUIPOS WHERE PARTIDOS.codigoEquipo2=EQUIPOS.codigoEquipo AND PARTIDOS.jornada='"+jornada+"' AND PARTIDOS.codigoPartido='"+partido+"'";
         try{
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sentenciaSQL);
            //System.out.println(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            return null;
        }
         System.out.println(resultado);
        return resultado;
    }
    
}