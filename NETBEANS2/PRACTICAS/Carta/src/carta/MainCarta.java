package carta;
import javax.swing.JOptionPane;
public class MainCarta {
    public static void main(String[] args) {
       int numero=Integer.parseInt(JOptionPane.showInputDialog("Introduce numero de carta: "));
       int palo=Integer.parseInt(JOptionPane.showInputDialog("Introduce numero de palo: "));
       Carta carta=new Carta(numero,palo);
       carta.visualizaCarta();
       System.out.println(carta.valorCarta());
    }  
}
