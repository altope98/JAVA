/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mate;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class MainMate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        int n=Integer.parseInt(JOptionPane.showInputDialog("Introduce num para saber si es primo: "));
        if(Mate.primo(n))
           JOptionPane.showMessageDialog(null,"Es primo ") ;
        else
             JOptionPane.showMessageDialog(null,"No ss primo ") ;
        
        
        
    }
    
}
