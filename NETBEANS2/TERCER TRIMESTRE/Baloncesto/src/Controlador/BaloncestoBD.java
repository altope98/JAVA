package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class BaloncestoBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public BaloncestoBD(){
    String url="baloncesto.s3db";
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
    public ResultSet obtenerTabla(String tabla, String clave) {
        String sentenciaSQL="SELECT * FROM "+tabla+" ORDER BY "+clave;
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet partidosJornada(String jornada){
        String sentenciaSQL="SELECT * FROM PARTIDOS WHERE jornada='"+jornada+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerPartido(String jornada, String partido){
        String sentenciaSQL = "SELECT * FROM JORNADAS,PARTIDOS WHERE JORNADAS.jornada=PARTIDOS.jornada  AND JORNADAS.jornada='"+jornada+"' AND PARTIDOS.codigoPartido='"+partido+"'";
        return ejecutarQwery(sentenciaSQL);    
    }
    public ResultSet puntuacionesPartido(String jornada, String partido, String equipo){
        String sentenciaSQL="SELECT * FROM PUNTUACIONES WHERE codigoJornada='"+jornada+"' AND codigoPartido='"+partido+"' AND codigoEquipo='"+equipo+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet fechaJornada(String jornada){
        String sentenciaSQL="SELECT * FROM JORNADAS WHERE jornada='"+jornada+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet puntuacionesJornada(String tabla, String jornada) {
        String sentenciaSQL="SELECT * FROM "+tabla+" WHERE codigoJornada='"+jornada+"' ORDER BY codigoJornada AND codigoPartido ASC";
        return ejecutarQwery(sentenciaSQL);                
    }   
    public String nombreEquipo(String codEquipo){
        String nombreEquipo=null;
        String sentenciaSQL="SELECT * FROM EQUIPOS WHERE EQUIPOS.codigoEquipo='"+codEquipo+"'";
        ResultSet res=ejecutarQwery(sentenciaSQL);
        if(res!=null) {
            try {
                if(res.next())
                    nombreEquipo=res.getString("nombre");
            } catch (SQLException sql) {
                System.out.println(sql.getMessage());
            }
        }
        return nombreEquipo;   
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
