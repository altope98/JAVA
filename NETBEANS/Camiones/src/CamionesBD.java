
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class CamionesBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    
    public CamionesBD(){
        conectar();
    }
    
    public void conectar() {        
        String url = "Camionacos.s3db";
        try{
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url);
            if (conexion!=null) {
                System.out.println("Conectado");               
            }           
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexion con la BD Alumnos");
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
    public ResultSet establecerDatosConductor(String nombre){
        String sentenciaSQL="SELECT nif,direccion FROM conductores WHERE nombre='"+nombre+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    
    public ResultSet establecerDatosTabla(String nombre,String año,String mes){
        String sentenciaSQL="SELECT portes.matricula,marca,modelo,km,fecha FROM portes,conductores,camiones WHERE portes.nif=conductores.nif AND portes.matricula=camiones.matricula AND nombre='"+nombre+"' AND portes.fecha LIKE '%/"+mes+"/"+año+"' "; 
        return ejecutarQwery(sentenciaSQL);
    }
    
     public ResultSet establecerDatosTabla2(String nombre,String fecha1,String fecha2){
        String sentenciaSQL="SELECT portes.matricula,marca,modelo,km,fecha FROM portes,conductores,camiones WHERE portes.nif=conductores.nif AND portes.matricula=camiones.matricula AND nombre='"+nombre+"' AND portes.fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"'"; 
        return ejecutarQwery(sentenciaSQL);
    }
    
}
