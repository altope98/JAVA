
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class AlumnosBD {
    
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    
    public AlumnosBD() {
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
        String sentenciaSQL="SELECT * FROM "+tabla+" GROUP BY "+clave;
        return ejecutarQwery(sentenciaSQL);
    }
    
    public ResultSet obetnerCodigoCurso(String curso){
        String sentenciaSQL="SELECT idCurso FROM cursos WHERE cursos.curso='"+curso+"'";
        System.out.println(sentenciaSQL);
        return ejecutarQwery(sentenciaSQL);
        
    }
     public ResultSet obtenerAsignaturas(String curso) {
        String sentenciaSQL="SELECT * FROM cursos INNER JOIN asignaturas ON cursos.idCurso=asignaturas.idCurso WHERE cursos.curso='"+curso+"'";
        System.out.println(sentenciaSQL);
        return ejecutarQwery(sentenciaSQL);
        
    }
     public ResultSet obtenerAlumnosCandidatos(String curso){
          String sentenciaSQL="SELECT * FROM cursos INNER JOIN alumnos ON cursos.idCurso=alumnos.idCurso WHERE cursos.curso='"+curso+"'";
        System.out.println(sentenciaSQL);
        return ejecutarQwery(sentenciaSQL);
     }
     
     public ResultSet obtenerNotas(String curso,String evaluacion,String asignatura){
         String sentenciaSQL="SELECT * FROM asignaturas,alumnos,notas,cursos WHERE notas.idAlumno=alumnos.idAlumno AND notas.idAsignatura=asignaturas.idAsignatura AND cursos.idCurso=alumnos.idCurso AND cursos.idCurso=asignaturas.idCurso AND evaluacion='"+evaluacion+"' AND cursos.curso='"+curso+"' AND asignatura='"+asignatura+"'";
         return ejecutarQwery(sentenciaSQL);
     }
     
     
     public void actualizarNotas(String alumno, String nota){
        
        String sentenciaSQL="UPDATE notas SET nota='"+nota+"' WHERE idAlumno=(SELECT idalumno from alumnos where alumnos.nombre='"+alumno+"')";
        ejecutarQwery(sentenciaSQL);
        }
     public ResultSet obtenerIDalumnos(String alumno){
         String sentenciaSQL="SELECT idAlumno from alumnos where alumnos.nombre='"+alumno+"'";
        return ejecutarQwery(sentenciaSQL);
     }
     public ResultSet obtenerIDAsignatura(String asignatura){
         String sentenciaSQL="SELECT idAsignatura from asignatura where asignatura.asignatura='"+asignatura+"'";
        return ejecutarQwery(sentenciaSQL);
     }
      public void insertarNotas(String alumno, String nota,String asignatura,String evaluacion){
        
        String sentenciaSQL="INSERT INTO notas VALUES('"+alumno+"','"+asignatura+"','"+evaluacion+"','"+nota+"')";
        ejecutarQwery(sentenciaSQL);
        }
     
     
    }
     
    
    
    
    
    
     
   


