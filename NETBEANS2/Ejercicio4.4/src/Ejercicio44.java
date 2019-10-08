
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
public class Ejercicio44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num=1;
        // TODO code application logic here
        do{
            num= Integer.parseInt(JOptionPane.showInputDialog("Introduce numero (0 para finalizar): "));
        
            if (num>0){
                JOptionPane.showMessageDialog(null,"Es positivo");
            
            
            }else{
                if (num<0){
                JOptionPane.showMessageDialog(null,"Es negativo");
                }
                
            }
        
        }while(num!=0);
    }
    
}
