
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */
public class Ejercicio43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int lado1= Integer.parseInt(JOptionPane.showInputDialog("Introduce lado 1: "));
        int lado2= Integer.parseInt(JOptionPane.showInputDialog("Introduce lado 2: "));
        int lado3= Integer.parseInt(JOptionPane.showInputDialog("Introduce lado 3: "));
        
        double t= (lado1+lado2+lado3)/2;
        double area= Math.sqrt(t*(t-lado1)*(t-lado2)*(t-lado3));
        
        JOptionPane.showMessageDialog(null,"El area es: "+area);
        
        
    }
    
}
