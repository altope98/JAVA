/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cilindro;

/**
 *
 * @author alvar
 */
public class Cilindro extends Circulo{
    protected double altura,x,y;
    
    public Cilindro(double radio,double altura,double x, double y){
        super(radio);
        this.altura=altura;
        this.x=x;
        this.y=y;
    }
    public Cilindro(){
        this(2.0,4.0,0,0);
    }
    public double volumen(){
        return (Math.PI*(radio*radio)*altura);
    } 
    
    public double area(){
        double arealateral=2*Math.PI*radio*altura;
        double areabase=Math.PI*(radio*radio);
        return (2*areabase+arealateral);
    }
}
