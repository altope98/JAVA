/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio413;

import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio413 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n1=Integer.parseInt(JOptionPane.showInputDialog("Escribe el primer numero "));
        int n2=Integer.parseInt(JOptionPane.showInputDialog("Escribe el segundo numero "));
        int suma=0;
        int cont=0;
        

        for(int i=n1;i<=n2;i+=2){
            if(n1%2==0){
                
                suma=suma+n1;
                cont++;
                System.out.println(n1);
                System.out.println(suma);
                System.out.println(cont);
            }
        }
        
        
        
    }
    
}
