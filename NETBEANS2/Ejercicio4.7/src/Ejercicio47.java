
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
public class Ejercicio47 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double n1=Double.parseDouble(JOptionPane.showInputDialog("Introduce el primer valor: "));
	double n2=Double.parseDouble(JOptionPane.showInputDialog("Introduce el segundo valor: "));
        double n3=Double.parseDouble(JOptionPane.showInputDialog("Introduce el tercer valor: "));
		
		if (n1>n2)
			{if (n1>n3)
				{if (n2>n3)
                                    
					{
                                            JOptionPane.showMessageDialog(null,n1+""+n2+""+n3);
                                            
                                            }
					else
					{
                                            JOptionPane.showMessageDialog(null,n1+""+n3+""+n2);
                                        }}
			else
				{
                                    JOptionPane.showMessageDialog(null,n3+""+n2+""+n1);}}
             
		else
		{if (n2>n3)
			{if (n1>n3)
				{
                                    
                                    JOptionPane.showMessageDialog(null,n2+""+n1+""+n3);
                                   }
			else
				{
                                    JOptionPane.showMessageDialog(null,n2+""+n3+""+n1);
                                    }}
			else
			{
                            JOptionPane.showMessageDialog(null,n3+""+n2+""+n1);
                            }}

		}
    
    
}
