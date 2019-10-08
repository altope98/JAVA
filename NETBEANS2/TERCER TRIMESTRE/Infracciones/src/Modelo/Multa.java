package Modelo;
public class Multa {
    private String codigoInfraccion,codigoCoche,fecha;
    public Multa(String codinf, String codco, String date){
        codigoInfraccion=codinf;
        codigoCoche=codco;
        fecha=date;
    }
    
    public String getCodigoInfrccion() {return codigoInfraccion;}
    public String getFecha() {return fecha;}
    public String getCodigoCoche() {return codigoCoche;}
}
