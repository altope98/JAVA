package ejercicio420;

import javax.swing.JOptionPane;

public class Ejercicio420 {
    public static void main(String[] args) {
        int cont=0;
        int suma=0;
        int n=1;
        double media=0;
        do{
            n=Integer.parseInt(JOptionPane.showInputDialog("Introduce numero: "));
            if(n!=0){
                cont++;
                suma=suma+n;
            }
        } while(n!=0);
        JOptionPane.showMessageDialog(null,media=suma/cont);
        
    
        
    } 
}
