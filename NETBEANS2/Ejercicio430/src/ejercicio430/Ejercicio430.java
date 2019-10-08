package ejercicio430;
import javax.swing.JOptionPane;
public class Ejercicio430 {
    public static void main(String[] args) {
       int random,max,min,num=-1;
       char respuesta=' ';      
        do{
            int intentos=5;
            min=0;
            max=100;
            random=(int)(Math.random()*100)+1;
            for(int i=intentos;i>0;i--){
                num=Integer.parseInt(JOptionPane.showInputDialog(null, "JUEGA [Quedan "+intentos+" intentos]"));
                if(num==random){
                    JOptionPane.showMessageDialog(null,"ENHORABUENA HAS GANADO, EL NUMERO ES: "+random);
                    break;    
                }else if(random<num){    
                    intentos--;
                    max=num;
                    JOptionPane.showMessageDialog(null,"EL NUMERO ES MENOR, ESTA ENTRE "+min+" Y "+max);                    
                }else if(random>num){
                    intentos--;
                    min=num;
                    JOptionPane.showMessageDialog(null,"EL NUMERO ES MAYOR, ESTA ENTRE "+min+" Y "+max);
                }    
                if(intentos==0){
                   respuesta=JOptionPane.showInputDialog(null, "HAS PERDIDIO EL NUMERO ES: "+random+" QUIERES SEGUIR JUGANDO [S/N]:").charAt(0);
                }
            }
        }while(respuesta=='S' || respuesta=='s');
    } 
}
