package ejercicio424;

import javax.swing.JOptionPane;

public class Ejercicio424 {
    public static void main(String[] args) {
                int n;
		do{
                    n=Integer.parseInt(JOptionPane.showInputDialog("Introduce nota [1-10]: "));
                    switch (n)
                    {
                        case 0:
                        case 1:
                        case 2:JOptionPane.showMessageDialog(null,"Muy deficiente");break;
                        case 3:
                        case 4:JOptionPane.showMessageDialog(null,"Insuficiente");break;
                        case 5:JOptionPane.showMessageDialog(null,"Suficiente");break;
                        case 6:JOptionPane.showMessageDialog(null,"Bien");break;
                        case 7:
                        case 8:JOptionPane.showMessageDialog(null,"Notable");break;
                        case 9:
                        case 10:JOptionPane.showMessageDialog(null,"Sobresaliente");break;
                        default:JOptionPane.showMessageDialog(null,"NO HAS INTRODUCIDO UN VALOR CORRECTO");break;
                    }
                }while(n>=0 && n<=10);//while (n!=0);  
    }
}
