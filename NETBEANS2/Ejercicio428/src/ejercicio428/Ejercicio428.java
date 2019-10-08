package ejercicio428;
import javax.swing.JOptionPane;
public class Ejercicio428 {
    public static void main(String[] args) {
        int suma;
        int contador=0;
        for(int i=1;i<=100;i++){
            int dado1=(int)(Math.random()*6)+1;
            int dado2=(int)(Math.random()*6)+1;
            suma=dado1+dado2;
            if(suma==10){
                contador++;
            }     
        }  
        JOptionPane.showMessageDialog(null, "Han sumado "+contador+" veces el numero 10");
    }  
}
