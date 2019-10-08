
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
public class Ejercicio49 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int n1=Integer.parseInt(JOptionPane.showInputDialog("Escribe el primer numero "));
        int n2=Integer.parseInt(JOptionPane.showInputDialog("Escribe el segundo numero  "));
        int suma=0;
        for(int i=n1;i<=n2;i++){
        
            suma= suma+i;
        }
        JOptionPane.showMessageDialog(null,suma+"");
    }
    
}
