
import javax.swing.JOptionPane;

public class MainCoche 
{
	public static void main(String[] args) 
	{
		String modelo=JOptionPane.showInputDialog("Introduce modelo: ");
		String matricula=JOptionPane.showInputDialog("Introduce matricula: ");
                String color=JOptionPane.showInputDialog("Introduce color: ");
                
		Coche coche1=new Coche(color, modelo, matricula);
		
		coche1.imprimeEstado();

	}
}
