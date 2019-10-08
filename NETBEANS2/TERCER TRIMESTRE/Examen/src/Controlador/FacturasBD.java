package Controlador;
import java.sql.*;
public class FacturasBD { 
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    public FacturasBD(){
        conectar();
    }
    public void conectar() {        
        String url = "Facturas.s3db";
        try{
            conexion=DriverManager.getConnection("jdbc:sqlite:"+url);
            if (conexion!=null) {
                System.out.println("Conectado");               
            }           
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexion con la BD Alumnos");
        }       
    }
    public ResultSet obtenerTabla(String tabla, String clave) {
        String sentenciaSQL="SELECT * FROM "+tabla+" ORDER BY "+clave+" ASC" ;
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerCliente(String nombre){
        String sentenciaSQL="SELECT cliente,nif,telefono,codCliente FROM clientes WHERE cliente LIKE '"+nombre+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet rellenarLista(String factura){
        String sentenciaSQL="SELECT cliente,fecha FROM clientes,facturas WHERE clientes.codCliente=facturas.codCliente AND nFactura LIKE '"+factura+"' ORDER BY cliente ASC";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet rellenarTabla(String factura,String codigo){
        String sentenciaSQL="SELECT nLinea,articulo,lineasFacturas.pvp,lineasFacturas.unidades,lineasFacturas.importe FROM lineasFacturas,clientes,facturas WHERE clientes.codCliente=facturas.codCliente AND lineasFacturas.nFactura=facturas.nFactura AND facturas.nFactura LIKE '"+factura+"' AND clientes.codCliente LIKE '"+codigo+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet rellenarTotales(String factura,String codigo){
        String sentenciaSQL="SELECT importe,iva,total FROM clientes,facturas WHERE clientes.codCliente=facturas.codCliente AND facturas.nFactura LIKE '"+factura+"' AND clientes.codCliente LIKE '"+codigo+"'";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet rellenarLista(){
        String sentenciaSQL="SELECT cliente FROM clientes ORDER BY cliente ASC";
        return ejecutarQwery(sentenciaSQL);
    }
    public ResultSet obtenerFactura(){
        String sentenciaSQL="SELECT nFactura FROM facturas";
        return ejecutarQwery(sentenciaSQL);
    }
    public void insertarLineasFactura(String factura,String linea,String articulo,String unidades,String pvp,String importe1){
        String sentenciaSQL="INSERT INTO lineasFacturas values('"+factura+"','"+linea+"','"+articulo+"','"+unidades+"','"+pvp+"','"+importe1+"')";
        try {
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException sql) {
            System.out.println("error: " + sql.getMessage());
        }
    }    
    public void insertarFactura(String factura,String fecha,String codigo,String importe2,String iva,String total){
        String sentenciaSQL="INSERT INTO facturas values('"+factura+"','"+fecha+"','"+codigo+"','"+importe2+"','"+iva+"','"+total+"')";
        try {
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
        } catch (SQLException sql) {
            System.out.println("error: " + sql.getMessage());
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
}
