
import javax.swing.JOptionPane;

public class MainCocheAcuatico
{
	public static void main(String[] args) 
	{
		String modelo=JOptionPane.showInputDialog("Introduce modelo: ");
		String matricula=JOptionPane.showInputDialog("Introduce matricula: ");
                String color=JOptionPane.showInputDialog("Introduce color: ");
                
		CocheAcuatico coche1=new CocheAcuatico(color,modelo,matricula);
                
		coche1.imprimeEstado();
	}
}
