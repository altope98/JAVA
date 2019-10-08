/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author medina
 */
import java.sql.*;

public class BaloncestoBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    
    public BaloncestoBD() {
        conectar();
    }
    public void conectar() {        
        String url = "baloncesto.s3db";
        try{
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url);
            if (conexion!=null) {
                System.out.println("Conectado");               
            }           
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexion con la BD Baloncesto");
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
    public ResultSet obtenerTabla(String tabla, String clave) {
        String sentenciaSQL="SELECT * FROM "+tabla+" ORDER BY "+clave;
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet partidosJornada(String jornada){
        String sentenciaSQL="SELECT * FROM Partidos WHERE jornada='"+jornada+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerPartido(String jornada, String partido){
        String sentenciaSQL = "SELECT * FROM Jornadas J,Partidos P,Equipos E WHERE J.jornada = P.jornada  AND AND J.jornada='"+jornada+"' AND P.codigoPartido='"+partido+"'";
        return ejecutarQwery(sentenciaSQL);    
    }
    public String nombreEquipo(String codEquipo){
        String nombreEquipo=null;
        String sentenciaSQL="SELECT * FROM Equipos WHERE Equipos.codigoEquipo='"+codEquipo+"'";
        ResultSet resultado=ejecutarQwery(sentenciaSQL);
        if(resultado!=null) {
            try {
                if(resultado.next())
                    nombreEquipo=resultado.getString("nombre");
            } catch (SQLException sql) {
                System.out.println(sql.getMessage());
            }
        }
        return nombreEquipo;   
    }
    public ResultSet listarRegistros(String tabla, String clave) {
        String sentenciaSQL="SELECT * FROM "+tabla+" WHERE "+clave+" >' ' ORDER BY "+clave+" ASC";
        return ejecutarQwery(sentenciaSQL);      
    } 
    public ResultSet puntuacionesPartido(String jornada, String partido, String equipo){
        String sentenciaSQL="SELECT * FROM puntuaciones WHERE codigoJornada='"+jornada+"' AND codigoPartido='"+partido+"' AND codigoEquipo='"+equipo+"'";
        return ejecutarQwery(sentenciaSQL);
    }
     
    public ResultSet puntuacionesJornada(String tabla, String clave, String valor,String partido) {
        String sentenciaSQL="SELECT * FROM "+tabla+" WHERE "+clave+"='"+valor+"' AND codigoPartido='"+partido+"' ORDER BY codigoJornada AND codigoPartido ASC";
        return ejecutarQwery(sentenciaSQL);                
    }    
    
    public ResultSet puntuacionesJornadas(String partido) {
        String sentenciaSQL="SELECT * FROM PUNTUACIONES WHERE codigoPartido='"+partido+"' ORDER BY codigoJornada AND codigoPartido ASC";
        return ejecutarQwery(sentenciaSQL);                
    }    
    public ResultSet obtenerRegistro(String tabla, String clave, String valor){      
   	String sentenciaSQL="SELECT * FROM "+tabla+" WHERE "+clave+"='"+valor+"' ORDER BY "+clave+" ASC";
        return ejecutarQwery(sentenciaSQL);             
   }
   
    public ResultSet obtenerFecha(String jornada){      
   	String sentenciaSQL="SELECT fecha FROM JORNADAS WHERE jornada LIKE '"+jornada+"'";
        return ejecutarQwery(sentenciaSQL);             
   }
    
     public ResultSet obtenerPartidosLocal(String jornada){
       String sentenciaSQL="SELECT * FROM PARTIDOS,PUNTUACIONES WHERE PUNTUACIONES.codigoEquipo=PARTIDOS.codigoEquipo1 AND jornada='"+jornada+"' GROUP BY PUNTUACIONES.codigoEquipo";
       return ejecutarQwery(sentenciaSQL); 
     }
     
     public ResultSet obtenerPartidosVisitante(String jornada){
        String sentenciaSQL="SELECT * FROM PARTIDOS,PUNTUACIONES WHERE PUNTUACIONES.codigoEquipo=PARTIDOS.codigoEquipo2 AND jornada='"+jornada+"' GROUP BY PUNTUACIONES.codigoEquipo";
        return ejecutarQwery(sentenciaSQL); 
     }
      public ResultSet obtenerLocal(String jornada,String codigopartido){
        String sentenciaSQL="SELECT codigoEquipo1 FROM PARTIDOS,EQUIPOS WHERE PARTIDOS.codigoEquipo1=EQUIPOS.codigoEquipo AND PARTIDOS.jornada='"+jornada+"' AND PARTIDOS.codigoPartido='"+codigopartido+"'";
        return ejecutarQwery(sentenciaSQL); 
      }
       public ResultSet obtenerVisitante(String jornada,String partido){
        String sentenciaSQL="SELECT codigoEquipo2 FROM PARTIDOS,EQUIPOS WHERE PARTIDOS.codigoEquipo2=EQUIPOS.codigoEquipo AND PARTIDOS.jornada='"+jornada+"' AND PARTIDOS.codigoPartido='"+partido+"'";
        return ejecutarQwery(sentenciaSQL); 
       }
       
       
      
       public ResultSet obtenerResultados(String jornada,String partido,String codigoEquipo1){
       
        String sentenciaSQL="SELECT PUNTUACIONES.codigoJornada,PUNTUACIONES.codigoPartido,nombre,canastas1,canastas2,canastas3 FROM PUNTUACIONES,EQUIPOS,PARTIDOS WHERE EQUIPOS.codigoEquipo='"+codigoEquipo1+"' AND PUNTUACIONES.codigoPartido='"+partido+"' AND PUNTUACIONES.codigoJornada='"+jornada+"' GROUP BY nombre";
        return ejecutarQwery(sentenciaSQL); 
       }
       /*public ResultSet obtenerResultadosVisitante(String jornada,String partido,String codigoEquipo2){
       
        String sentenciaSQL="SELECT PUNTUACIONES.codigoJornada,PUNTUACIONES.codigoPartido,nombre,canastas1,canastas2,canastas3 FROM PUNTUACIONES,EQUIPOS,PARTIDOS WHERE  EQUIPOS.codigoEquipo='"+codigoEquipo2+"' AND PUNTUACIONES.codigoPartido='"+partido+"' AND PUNTUACIONES.codigoJornada='"+jornada+"' GROUP BY nombre";
        return ejecutarQwery(sentenciaSQL); 
       }*/
        
}    

