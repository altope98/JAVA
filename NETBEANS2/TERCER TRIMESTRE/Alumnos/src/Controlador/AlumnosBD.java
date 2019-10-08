package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class AlumnosBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public AlumnosBD(){
        String url="alumnos.s3db";
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
    public ResultSet obtenerRegistrosOrdenados(String tabla, String clave) {
        String sentenciaSQL="SELECT * FROM "+tabla+" ORDER BY "+clave;
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerRegistrosAgrupados(String tabla, String clave){
        String sentenciaSQL="SELECT * FROM "+tabla+" GROUP BY "+clave;
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerAsignaturas(String curso){
        String sentenciaSQL="SELECT * FROM asignaturas, cursos WHERE asignaturas.idCurso=cursos.idCurso AND cursos.curso LIKE '"+curso+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerAlumnosCandidatos(String curso){
        String sentenciaSQL="SELECT * FROM alumnos, cursos WHERE alumnos.idCurso=cursos.idCurso AND cursos.curso LIKE '"+curso+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerNotas(String curso, String evaluacion, String asignatura, String alumno){
        String sentenciaSQL="SELECT nota FROM alumnos, cursos, notas, asignaturas WHERE alumnos.idCurso=cursos.idCurso AND notas.idAlumno=alumnos.idAlumno AND notas.idAsignatura=asignaturas.idAsignatura AND cursos.curso LIKE '"+curso+"' AND asignaturas.asignatura LIKE '"+asignatura+"' AND alumnos.alumno LIKE '"+alumno+"' AND notas.evaluacion LIKE '"+evaluacion+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerNotasV32(String idcurso, String evaluacion, String idasignatura, String idalumno){
        String sentenciaSQL="SELECT nota FROM alumnos,  notas, asignaturas WHERE   notas.idAlumno=alumnos.idAlumno AND notas.idAsignatura=asignaturas.idAsignatura  AND asignaturas.asignatura=(SELECT asignatura FROM notas,asignaturas WHERE notas.idAsignatura=asignaturas.idAsignatura AND notas.idAsignatura LIKE '"+idasignatura+"') AND alumnos.alumno=(SELECT alumno FROM alumnos,notas WHERE notas.idAlumno=alumnos.idAlumno AND notas.idAlumno LIKE '"+idalumno+"') AND notas.evaluacion LIKE '"+evaluacion+"'";
        return ejecutarQwery(sentenciaSQL);             //cursos,  alumnos.idCurso=cursos.idCurso AND                                                             AND cursos.curso=(SELECT curso FROM cursos WHERE idCurso LIKE '"+idcurso+"')
    }
    public ResultSet obtenerNotas2(String curso, String evaluacion, String asignatura){
        String sentenciaSQL="SELECT nota FROM alumnos, cursos, notas, asignaturas WHERE alumnos.idCurso=cursos.idCurso AND notas.idAlumno=alumnos.idAlumno AND notas.idAsignatura=asignaturas.idAsignatura AND cursos.curso LIKE '"+curso+"' AND asignaturas.asignatura LIKE '"+asignatura+"' AND notas.evaluacion LIKE '"+evaluacion+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerNotas3(String curso){
        String sentenciaSQL="SELECT nota FROM alumnos, cursos, notas WHERE alumnos.idCurso=cursos.idCurso AND notas.idAlumno=alumnos.idAlumno AND cursos.curso LIKE '"+curso+"' GROUP BY evaluacion";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerNotas4(String curso, String evaluacion){
        String sentenciaSQL="SELECT nota FROM alumnos, cursos, notas WHERE alumnos.idCurso=cursos.idCurso AND notas.idAlumno=alumnos.idAlumno AND cursos.curso LIKE '"+curso+"' AND evaluacion LIKE '"+evaluacion+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public int numeroAsignaturas(String curso){
        int numeroasignaturas=0;
        String sentenciaSQL="SELECT count(asignatura) FROM asignaturas, cursos WHERE cursos.idCurso=asignaturas.idCurso AND cursos.curso LIKE '"+curso+"'";
        ResultSet res=ejecutarQwery(sentenciaSQL);
        if(res!=null) {
            try {
                if(res.next())
                    numeroasignaturas=res.getInt("count(asignatura)");
            } catch (SQLException sql) {
                System.out.println(sql.getMessage());
            }
        }
        return numeroasignaturas;   
    }
    public void actualizarNotas(String alumno, String nota, String evaluacion, String asignatura){
        String sentenciaSQL="UPDATE notas SET nota='"+nota+"' WHERE idAlumno=(SELECT idalumno from alumnos where alumnos.alumno='"+alumno+"') AND evaluacion LIKE '"+evaluacion+"' AND idAsignatura=(SELECT idAsignatura from asignaturas where asignaturas.asignatura='"+asignatura+"')";
        try {
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException sql) {
            System.out.println("error: " + sql.getMessage());
        }
    }
    public void insertarNotas(String evaluacion, String idasignatura,String idalumno,String nota, String alumno, String idCurso){
        //String sentenciaSQL2="INSERT INTO alumnos VALUES ('"+idalumno+"','"+alumno+"','"+idCurso+"')";
        String sentenciaSQL="INSERT INTO notas VALUES ('"+idalumno+"','"+idasignatura+"','"+evaluacion+"','"+nota+"')";
        try {
            /**sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL2);*/
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException sql) {
            System.out.println("error: " + sql.getMessage());
        }
    }
    public ResultSet obtenerID(String curso, String asignatura,String alumno){
        String sentenciaSQL="SELECT * FROM alumnos, cursos, asignaturas WHERE cursos.curso LIKE '"+curso+"' AND asignaturas.asignatura LIKE '"+asignatura+"' AND alumnos.alumno LIKE '"+alumno+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerIDAlumno(String alumno){
        String sentenciaSQL="SELECT idAlumno FROM alumnos WHERE alumnos.alumno LIKE '"+alumno+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerCondicion(String alumno, String curso){
        String sentenciaSQL="SELECT * FROM alumnos, cursos WHERE cursos.idCurso=alumnos.idCurso AND cursos.curso LIKE '"+curso+"'  ";  //AND alumnos.alumno LIKE '"+alumno+"'
        return ejecutarQwery(sentenciaSQL);
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
