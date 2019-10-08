/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carta;

import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro
 */
public class MainBaraja2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Carta carta[][]=new Carta[4][10];	
	for(int i=1; i<=4; i++)
	{	
		for(int j=1; j<=10; j++)
		{
                    carta[i-1][j-1]=new Carta(j,i);
		}
	}
        int palo=(int)(Math.random()*4);
        int numero=(int)(Math.random()*10);
        carta[palo][numero].visualizaCarta();
        

        
    }  
}
