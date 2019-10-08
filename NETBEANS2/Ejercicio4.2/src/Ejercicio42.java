
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
public class Ejercicio42 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                int u=Integer.parseInt(JOptionPane.showInputDialog("Introduce las unidades vendidas: "));
		double v=Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio de la unidad: "));
		
		JOptionPane.showMessageDialog(null,"El diseñador cobra: "+ 2*v*u/5);
		JOptionPane.showMessageDialog(null,"Cada fabricante cobra: "+ v*u/5);
    }
    
}
