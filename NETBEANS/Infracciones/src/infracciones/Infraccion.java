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
public class Infraccion {
    private String infraccion,codigoinfraccion;
    private int penalizacion;
    public Infraccion(String codigoinfraccion,String infraccion,int penalizacion){
    
        
        this.codigoinfraccion=codigoinfraccion;
        this.infraccion=infraccion;
        this.penalizacion=penalizacion;
    }
    
    public String getCodigoInfraccion() {return codigoinfraccion;}
    public String getInfraccion() {return infraccion;}
    public int getPenalizacion() {return penalizacion;}
}
