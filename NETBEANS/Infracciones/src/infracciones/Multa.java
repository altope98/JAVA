/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infracciones;

/**
 *
 * @author alvar
 */
public class Multa {
    private String codigocoche,codigoinfraccion,fecha;
    public Multa(String codigocoche,String codigoinfraccion,String fecha){
    
        this.codigocoche=codigocoche;
        this.codigoinfraccion=codigoinfraccion;
        this.fecha=fecha;
    }
    public String getCodigoCoche() {return codigocoche;}
    public String getCodigoInfraccion() {return codigoinfraccion;}
    public String getFecha() {return fecha;}
}
