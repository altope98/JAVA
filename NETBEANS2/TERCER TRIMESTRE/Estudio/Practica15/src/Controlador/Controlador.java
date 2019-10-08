/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Partido;
import Modelo.DatosPartido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmp_p
 */
public class Controlador {
    Connection conexion;
    Statement statement;
    ResultSet resultado;
    
    public Controlador(){
        conectar();
    }
    
    private void conectar(){
        String url = "jdbc:sqlite:baloncesto.s3db";
        try {
            conexion = DriverManager.getConnection(url);
            System.out.println("Conexión establecida correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al conectar con la base de datos.");
        }
    }
    
    public ArrayList<String> obtenerJornadas(){
        ArrayList<String> jornadas = new <String> ArrayList();
        String sentenciaSQL = "SELECT JORNADA FROM JORNADAS";
        try {
            statement = conexion.createStatement();
            resultado = statement.executeQuery(sentenciaSQL);
            while (resultado.next()){
                jornadas.add(resultado.getString("jornada"));
                System.out.println(resultado.getString("jornada"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener jornadas");
        }
        return jornadas;        
    }
    
    public String obtenerFecha(String jornada){
        String fecha = null;
        String sentenciaSQL = "SELECT fecha FROM JORNADAS where jornada = '"+jornada+"'";
        try {
            statement = conexion.createStatement();
            resultado = statement.executeQuery(sentenciaSQL);
            while (resultado.next()){
                fecha = resultado.getString("fecha");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener fecha");
        }
        return fecha;        
    }
    
    public ArrayList<String> obtenerPartidos(String jornada){
        ArrayList<String> partidos = new <String> ArrayList();
        String sentenciaSQL = "SELECT * FROM PARTIDOS WHERE JORNADA = '"+jornada+"'";
        try {
            statement = conexion.createStatement();
            resultado = statement.executeQuery(sentenciaSQL);
            while (resultado.next()){                
                partidos.add(resultado.getString("codigoPartido"));               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener partidos");
        }
        return partidos;    
    }
    
    public Partido obtenerPartido(String j, String p){
        Partido partido = null;
        String sentenciaSQL = "select l.codigoEquipo as codigoLocal, l.nombre as nombreLocal, v.codigoEquipo as codigoVisitante, v.nombre as nombreVisitante "
                + "from equipos l, equipos v, partidos p "
                + "where p.jornada = '"+j+"' "
                + "and p.codigoPartido = '"+p+"' "
                + "and p.codigoEquipoLocal = l.codigoEquipo "
                + "and p.codigoEquipoVisitante = v.codigoEquipo";
        try {
            statement = conexion.createStatement();
            resultado = statement.executeQuery(sentenciaSQL);
            while (resultado.next()){
                String codigoLocal = resultado.getString("codigoLocal");
                String codigoVisitante = resultado.getString("codigoVisitante");
                String nombreLocal = resultado.getString("nombreLocal");
                String nombreVisitante = resultado.getString("nombreVisitante");
                partido = new Partido(codigoLocal, codigoVisitante, nombreLocal, nombreVisitante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo al obtener nombre de equipos");
        }
        return partido;        
    }
    
    public DatosPartido obtenerDatos(String j, String p, String e){
        DatosPartido datos = null;
        String sentenciaSQL = "Select * "
                + "from puntuaciones "
                + "WHERE codigoJornada = '"+j+"'"
                + "and codigoPartido = '"+p+"'"
                + "and codigoEquipo = '"+e+"'";
        System.out.println(sentenciaSQL);
        try {
            statement = conexion.createStatement();    
            resultado = statement.executeQuery(sentenciaSQL);
            while(resultado.next()){
                double porcentajes1 = resultado.getDouble("canastas1")/resultado.getDouble("intentos1")*100;
                double porcentajes2 = resultado.getDouble("canastas2")/resultado.getDouble("intentos2")*100;
                double porcentajes3 = resultado.getDouble("canastas3")/resultado.getDouble("intentos3")*100;
                datos = new DatosPartido(porcentajes1, porcentajes2, porcentajes3);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
}
