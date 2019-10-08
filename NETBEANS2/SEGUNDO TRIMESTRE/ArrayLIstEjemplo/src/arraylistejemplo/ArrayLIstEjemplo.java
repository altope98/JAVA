package arraylistejemplo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ArrayLIstEjemplo {
    public static void main(String[] args) {
        Rectangulo rec[]=new Rectangulo[5];
        ArrayList array=new ArrayList(5);
        for(int i=0;i<5;i++){
            double ancho=Double.parseDouble(JOptionPane.showInputDialog("Introduce el ancho del rectangulo: "));
            double largo= Double.parseDouble(JOptionPane.showInputDialog("Introduce el largo del rectangulo: "));
            rec[i]=new Rectangulo(ancho,largo);
            array.add(rec[i]);
        }
        for(int i=0;i<5;i++){
            System.out.println("Rectangulo "+(i+1));
            System.out.println("Area:  "+rec[i].area());
            System.out.println("Perimetro:  "+rec[i].perimetro());
            System.out.println(" ");
            
        }
    }
}
