/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio412;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio412 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int n1=Integer.parseInt(JOptionPane.showInputDialog("Escribe el numero "));
        int fact=1;
        
        if(n1>0){
            for(int i=1;i<=n1;i++){
                fact=fact*i;
                
            }
            JOptionPane.showMessageDialog(null, "El factorial de "+n1+" es "+fact);
        }else{
            JOptionPane.showMessageDialog(null, "El numero introducido es negativa por lo que no tiene factorial");
        }
    }
    
}
