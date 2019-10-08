/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class Ejercicio41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola Mundo"); //JOptionPane.showInputDIalog(");
        
        
        
        int cateto1=Integer.parseInt(JOptionPane.showInputDialog("Introduce cateto1"));
        int cateto2=Integer.parseInt(JOptionPane.showInputDialog("Introduce cateto2"));
        double hipotenusa= Math.sqrt(cateto1*cateto1+cateto2*cateto2);
        JOptionPane.showMessageDialog(null, "La hipotenusa es "+hipotenusa);
        
    }
    
}
