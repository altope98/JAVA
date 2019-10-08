package ejercicio427;
import javax.swing.JOptionPane;
public class Ejercicio427 {
    public static void main(String[] args) {
      int contador=0;
      for(int i=1;i<=100;i++){
          int dado=(int)(Math.random()*6)+1;
          if(dado==6){
              contador++;
          }
      }
        JOptionPane.showMessageDialog(null, "Han salido "+contador+" veces el numero 6");
    }  
}
