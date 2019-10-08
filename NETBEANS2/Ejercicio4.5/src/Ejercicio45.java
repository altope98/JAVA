
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
public class Ejercicio45 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num= Integer.parseInt(JOptionPane.showInputDialog("Introduce numero: "));
        
        if(num%2==0){
 
            JOptionPane.showMessageDialog(null,"Es par");
        }else{
            JOptionPane.showMessageDialog(null,"Es impar");
        }
        
        
        
        
        
    }
    
}
