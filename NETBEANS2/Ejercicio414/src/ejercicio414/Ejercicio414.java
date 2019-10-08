/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio414;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio414 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        boolean condicion=true;
        
        for(int i=1;i<=100;i++){
            
            if(condicion==true){
                System.out.println("Hola");
                condicion=false;
            }else{
                System.out.println("Adios");
                condicion=true;
            }
            
                
            
        }
    }
    
}
