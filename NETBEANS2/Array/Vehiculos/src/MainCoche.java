
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alvaro
 */
public class MainCoche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		String modelo=JOptionPane.showInputDialog("Introduce modelo: ");	
		String matricula=JOptionPane.showInputDialog("Introduce matricula: ");
		String color=JOptionPane.showInputDialog("Introduce color: ");

		Coche coche1=new Coche(color, modelo, matricula);
		
		coche1.imprimeEstado();

    }
    
}
