package ejercicio418;
import javax.swing.JOptionPane;
public class Ejercicio418 {
    public static void main(String[] args) {
        int n1=Integer.parseInt(JOptionPane.showInputDialog("Introduce numero:"));
        int n2=Integer.parseInt(JOptionPane.showInputDialog("Introduce numero:"));
        int factn1=n1;
        int factn2=n2;
        int n3=n1-n2;
        int factn3=n3;
        for(int i=1;i<n1;i++)
        {
            factn1=factn1*i;
        }
        for(int i=1;i<n2;i++)
        {
            factn2=factn2*i;
        }
        for(int i=1;i<n3;i++)
        {
            factn3=factn3*i; 
        }
        double combinatorio=factn1/(factn2*factn3);
        JOptionPane.showMessageDialog(null, combinatorio);     
    }  
}
