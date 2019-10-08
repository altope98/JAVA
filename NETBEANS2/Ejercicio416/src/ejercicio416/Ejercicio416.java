/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio416;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio416 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
		int n=Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de numeros de la lista: "));		
		int actual=Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer numero: "));
		int min=actual;
		int max=actual;
		for (int i=1;i<=n ; i++)
		{
                    int x=Integer.parseInt(JOptionPane.showInputDialog("Introduce el siguiente numero ["+i+"-"+n+"]: "));
                    actual=x;
                    if (actual<min)
                    {
                        min=actual;
                    }
                    else 
                        max=actual;
                }
		JOptionPane.showMessageDialog(null,"El minimo es "+min+" y el máximo es "+max);
        
    }
    
}
