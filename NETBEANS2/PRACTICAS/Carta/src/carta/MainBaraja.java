package carta;
import javax.swing.JOptionPane;
public class MainBaraja {
    public static void main(String[] args){
        Carta carta[]=new Carta[40];
        int palo=1;
        int numero=1; 
        for(int i=0;i<40;i++){
            if(numero==11){
                palo++;
                numero=1;  
            }
            carta[i]=new Carta(numero,palo);
            numero++;
        }
        int n=(int)(Math.random()*40+1);
        carta[n].visualizaCarta();
        System.out.println("Valor de la carta "+carta[n].valorCarta());
    } 
}
