package ejercicio426;
import javax.swing.JOptionPane;
public class Ejercicio426 {
    public static void main(String[] args) { 
        int respuesta=1;
        do{
            int moneda;
            moneda=(int)(Math.random()*2)+1;
            System.out.print(moneda);
            if(moneda==1){
                JOptionPane.showMessageDialog(null, "La moneda es cruz");
            }
            if(moneda==2){
                JOptionPane.showMessageDialog(null, "La moneda es cara");
            }
            respuesta= Integer.parseInt(JOptionPane.showInputDialog("Quieres continuar (0/1): "));
        }while(respuesta==1);    
    }
}
