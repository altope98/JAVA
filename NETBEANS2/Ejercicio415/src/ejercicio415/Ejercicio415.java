/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio415;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio415 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n1=Integer.parseInt(JOptionPane.showInputDialog("Introduce numero:"));
        int n2=Integer.parseInt(JOptionPane.showInputDialog("Introduce numero:"));
        
        
        for(int i=n1;i<=n2;i++){
            if(i%3==0){
                System.out.println(i);
            }
            
            
        }
        
        
    }
    
}
