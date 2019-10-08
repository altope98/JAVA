package ejercicio419;
import javax.swing.JOptionPane;
public class Ejercicio419 {
    public static void main(String[] args) {
        int contpositivo=0;
	int contnegativo=0;
	int temp=1;
	do{
            int n= Integer.parseInt(JOptionPane.showInputDialog("Introduce el valor (0 para finalizar): "));
            temp=n;
            if (n>0)
            {
                contpositivo++;
            }
            if (n<0)
            {
                contnegativo++;
            }
        }while (temp !=0);
        {
            JOptionPane.showMessageDialog(null,"Hay "+contpositivo+" numeros positivos");
            JOptionPane.showMessageDialog(null,"Hay "+contnegativo+" numeros negativos");
        }
    }  
}
