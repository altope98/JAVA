/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio410;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio410 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n1=Integer.parseInt(JOptionPane.showInputDialog("Escribe el numero "));
        
        
       
        int suma=0;
        for(int i=0;i<n1;i++){
        if(i % 2 == 0){
            suma= suma+i;
        }
        }
        JOptionPane.showMessageDialog(null,suma+"");
    }
    
}
