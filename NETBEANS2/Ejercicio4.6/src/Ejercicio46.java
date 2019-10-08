
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
public class Ejercicio46 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       int n1=Integer.parseInt(JOptionPane.showInputDialog("Escribe el primer numero "));
        int n2=Integer.parseInt(JOptionPane.showInputDialog("Escribe el segundo numero  "));
        if(n2>n1){
            JOptionPane.showMessageDialog(null,"El numero "+n2+" es mayor que el numero "+n1+" y da decimales");
        
        }else{
            if(n1 % n2 == 0){
                
                    JOptionPane.showMessageDialog(null,"El numero es divisible de forma entera ");
            }else{
                    JOptionPane.showMessageDialog(null,"El numero no es divisible de forma entera ");
                  }
         }
    }
    
}
