
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author blanc
 */
public class AlumnosBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    
    public AlumnosBD(){
        conectar();
        
    }
    
    public void conectar() {        
        String url = "alumnos.s3db";
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
    
     public ResultSet obtenerTabla1(String tabla, String clave) {
        String sentenciaSQL="SELECT * FROM "+tabla+" GROUP BY "+clave;
        return ejecutarQwery(sentenciaSQL);
    }
     
     public ResultSet obtenerAsignaturas(String curso){
        String sentenciaSQL = "SELECT * FROM cursos C INNER JOIN asignaturas A ON c.idCurso = A.idCurso  WHERE C.curso='"+curso+"'";
        return ejecutarQwery(sentenciaSQL);    
    }
     
     public ResultSet obtenerNotas(String evaluacion, String curso, String asignatura){
         String sentenciaSQL = "SELECT * FROM asignaturas,notas,cursos WHERE notas.idAsignatura=asignaturas.idAsignatura AND cursos.idCurso=asignaturas.idCurso AND evaluacion='"+evaluacion+"' AND cursos.curso='"+curso+"' AND asignatura='"+asignatura+"' GROUP BY Nota";
         return ejecutarQwery(sentenciaSQL);    
     }
     
     public ResultSet obtenerNotas2(String evaluacion, String curso, String asignatura){
         String sentenciaSQL = "SELECT count(*) FROM asignaturas,notas,cursos WHERE notas.idAsignatura=asignaturas.idAsignatura AND cursos.idCurso=asignaturas.idCurso AND evaluacion='"+evaluacion+"' AND cursos.curso='"+curso+"' AND asignatura='"+asignatura+"' GROUP BY Nota";
         return ejecutarQwery(sentenciaSQL);    
     }
     
     
     
}


