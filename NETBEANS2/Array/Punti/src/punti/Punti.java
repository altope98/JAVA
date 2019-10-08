/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punti;

/**
 *
 * @author Alvaro
 */
public class Punti{
    protected int x,y,px,py;
	protected double d;
	protected Punti p;
	public Punti(int x,int y)
	{
		this.x=x;
		this.y=y;
		
	}
	public double distancia(int px,int py)
	{   
            d=0;
            d=Math.sqrt((px-x)*(px-x)+(py-y)*(py-y));  //Raiz cuadrada
            return d;            
          /*double dx=Math.abs(x-px);
            double dy=Math.abs(y-py);
            return dx+dy;*/
	}
	public double distancia(Punti punto2)
	{   
            d=0;
            double dx=x-punto2.x;
            double dy=y-punto2.y;
            d=Math.sqrt(dx*dx+dy*dy);
            return d;
            //return distancia(px,py);
	}

    
}
