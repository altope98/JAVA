package camara;
import javax.swing.JOptionPane;
public class MainCamara {
    public static void main(String[] args) {
               int c=Integer.parseInt(JOptionPane.showInputDialog("Introduce espacio de carrete (12/24/36): "));
		Carrete carrete=new Carrete(c);
		CamaraFotografica camara= new CamaraFotografica();
		camara.ponerCarrete(carrete);
                for(int i=1;i<=5;i++){
                    camara.nuevaFotografia();
                }
                camara.quitarCarrete();
                JOptionPane.showMessageDialog(null,carrete.numeroFotosValidas()+" "+carrete.numeroFotosVeladas());
    }
}
