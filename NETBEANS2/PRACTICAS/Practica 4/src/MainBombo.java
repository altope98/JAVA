import javax.swing.JOptionPane;
public class MainBombo {
    public static void main(String[] args) {
       
     int n=Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de bolas en el bombo: "));
     //int v[];
     Bombo boleto=new Bombo(n);
     boleto.crearVector(n);
     for(int i=0;i<=6;i++){
         boleto.sacaBola();
     }
     boleto.visualizar();
    }
    
}
