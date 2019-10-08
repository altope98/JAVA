/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio417;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio417 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int actual=Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer numero: "));
		int min=actual;
		int max=actual;
                int x=1;
		do
		{
                    x=Integer.parseInt(JOptionPane.showInputDialog("Introduce el siguiente numero: "));
                    if (x!=0){
                    actual=x;
                    if (actual<min)
                        min=actual;
                    if(actual>max)
                        max=actual;}
                }while (x !=0);
		{
                    JOptionPane.showMessageDialog(null,"El minimo es "+min+" y el máximo es "+max);
		}
    }
    
}
