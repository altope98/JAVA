package Controlador;
import java.sql.*;
public class SeleccionBasesBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public SeleccionBasesBD(String url){
        try{
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url);
        } catch(SQLException e){
            System.out.println("No se pudo realizar la conexion realizada");
        }
        if(conexion!=null)
            System.out.println("Conexion realizada correctamente");
    }
    public ResultSet obtenerDatos(String sentenciaSQL){
        //String sentenciaSQL="SELECT * FROM Coches,multas,infracciones WHERE Coches.codigo=multas.codigoCoche AND infracciones.codigoInfraccion=multas.codigoInfraccion AND Coches.matricula='"+matr+"'";
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
