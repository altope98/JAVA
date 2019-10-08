package Modelo;
public class Infraccion {
    private String codigoInfraccion, infraccion;
    private int penalizacion;
    public Infraccion(String cod, String inf, int penal){
        codigoInfraccion=cod;
        infraccion=inf;
        penalizacion=penal;
    }
    public String getInfrccion() {return infraccion;}
    public int getPenalizacion() {return penalizacion;}
    public String getCodigo() {return codigoInfraccion;}
}
