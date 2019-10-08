package urna;
import javax.swing.JOptionPane;
public class MainUrna {
    public static void main(String[] args) {
        int bola1=0,bola2=0;
		int bolasNegras=Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de bolas negras: "));
		int bolasBlancas=Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de bolas blancas: "));
		Urna urna=new Urna (bolasNegras,bolasBlancas);
                System.out.println("Se ha generado una urna con "+urna.totalBolas());   
		while (urna.quedaMasDeUnaBola()==true)
		{
                    bola1= urna.sacaBola();
                    System.out.print("La primera bola sacada es "+urna.colorBola(bola1)+"    ");
                    bola2=urna.sacaBola();
                    System.out.println("La segunda bola sacada es "+urna.colorBola(bola2));
                    if (bola1==bola2)
                    {
                        urna.meteBola(1);
                    }else
                    {
                        urna.meteBola(0);
                    }
		}
                System.out.println("La bola que queda es "+urna.colorBola(urna.sacaBola()));         
    }   
}
