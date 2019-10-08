/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbarr
 */

import java.sql.*;
public class AgendaBD {
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public AgendaBD(){
        String url="D:\\DAW\\Programación\\Programas NETBEANS\\ExtraInfracciones\\infracciones.s3db";
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
    public ResultSet obtenerInfracciones(String año,String mes){
        /*codigoCoche,codigoInfraccion,fecha,infraccion,penalizacion,nif,nombre,direccion,matricula,coche*/
        switch (mes) {
            case "Enero":  mes = "01";break;
            case "Febrero":  mes = "02";break;
            case "Marzo":  mes = "03";break;
            case "Abril":  mes = "04";break;
            case "Mayo":  mes = "05";break;
            case "Junio":  mes = "06";break;
            case "Julio":  mes = "07";break;
            case "Agosto":  mes = "08";break;
            case "Septiembre":  mes = "09";break;
            case "Octubre":  mes = "10";break;
            case "Noviembre":  mes = "11";break;
            case "Diciembre":  mes = "12";break;
            
            
        }
        String sentenciaSQL="SELECT * FROM Coches,multas,infracciones WHERE Coches.codigo=multas.codigoCoche AND infracciones.codigoInfraccion=multas.codigoInfraccion AND multas.fecha LIKE '%/"+mes+"/"+año+"'";
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
    
     public ResultSet obtenerInfracciones2(String año,String mes,String mes2){

        switch (mes) {
            case "Enero":  mes = "01";break;
            case "Febrero":  mes = "02";break;
            case "Marzo":  mes = "03";break;
            case "Abril":  mes = "04";break;
            case "Mayo":  mes = "05";break;
            case "Junio":  mes = "06";break;
            case "Julio":  mes = "07";break;
            case "Agosto":  mes = "08";break;
            case "Septiembre":  mes = "09";break;
            case "Octubre":  mes = "10";break;
            case "Noviembre":  mes = "11";break;
            case "Diciembre":  mes = "12";break;
            
            
        }
         switch (mes2) {
            case "Enero":  mes2 = "01";break;
            case "Febrero":  mes2 = "02";break;
            case "Marzo":  mes2 = "03";break;
            case "Abril":  mes2 = "04";break;
            case "Mayo":  mes2 = "05";break;
            case "Junio":  mes2 = "06";break;
            case "Julio":  mes2 = "07";break;
            case "Agosto":  mes2 = "08";break;
            case "Septiembre":  mes2 = "09";break;
            case "Octubre":  mes2 = "10";break;
            case "Noviembre":  mes2 = "11";break;
            case "Diciembre":  mes2 = "12";break;
            
           // 
        }
        String sentenciaSQL="SELECT infraccion,fecha,penalizacion FROM multas,infracciones WHERE infracciones.codigoInfraccion=multas.codigoInfraccion AND multas.fecha BETWEEN '10/"+mes+"/"+año+"' AND '15/"+mes2+"/"+año+"'";
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
     
    public Coche obtenerCoche(String valor){
        String sentenciaSQL="SELECT * FROM Coches WHERE nombre='"+ valor + "'";
        System.out.println(sentenciaSQL);
        Coche coche=null;
        try{
        sentencia=conexion.createStatement();
        // Mando la sentencia select con .executeQuery
        resultado=sentencia.executeQuery(sentenciaSQL);
        if(resultado.next()){
            
            String codigo=resultado.getString("codigo");
            String nif=resultado.getString("nif");
            String nombre=resultado.getString("nombre");
            String direccion=resultado.getString("direccion");
            String matricula=resultado.getString("matricula");
            String nombrecoche=resultado.getString("coche");  //cuidao con los nombres de la tabla
            
            coche= new Coche(codigo,nif,nombre,direccion,matricula,nombrecoche);
            
        }
        }catch(SQLException e){
            System.out.println("No se pudo realizar la consulta");
            coche=null;
        }
        return coche;
    }
    
    public void nuevoContacto(Coche coche){
        String codigo=coche.getCodigo();
        String nif=coche.getNif();
        String nombre=coche.getNombre();
        String direccion=coche.getDireccion();
        String matricula=coche.getMatricula();
        String nombrecoche=coche.getNombreCoche();
        String sentenciaSQL="INSERT INTO Coche (codigo, nif, nombre, direccion, matricula, nombrecoche ) VALUES ('"+codigo+"','"+nif+"','"+nombre+"','"+direccion+"','"+matricula+"',"+nombrecoche+")";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo grabar el registro");
        }
    }
    
    
    
    
    /*public void modificarContacto(Contacto contacto){
        String nom=contacto.getNombre();
        String dir=contacto.getDireccion();
        String loc=contacto.getLocalidad();
        String tlf=contacto.getTelefonos();
        String mail=contacto.getCorreo();
        int edad=contacto.getEdad();
        String sentenciaSQL="UPDATE contacto SET direccion='"+dir+"',localidad='"+loc+"', telefonos='"+tlf+"',correo='"+mail+"', edad="+edad+" WHERE nombre='"+nom+"' ";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo modificar el registro");
        }
    }*/
    /*public void borrarContacto(String valor){
        String sentenciaSQL="DELETE FROM Contacto WHERE nombre='"+valor+ "';";
        System.out.println(sentenciaSQL);
        try{
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        }catch(SQLException e){
            System.out.println("No se pudo borrar el registro");
        }
    }*/
}
